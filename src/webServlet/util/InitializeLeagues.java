package webServlet.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import webServlet.model.League;

/**
 * Describe class InitializeLeagues here.
 *
 *
 * Created: Fri Sep 15 11:38:41 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class InitializeLeagues implements ServletContextListener {
    // Implementation of javax.servlet.ServletContextListener

    /**
     * Describe <code>contextDestroyed</code> method here.
     *
     * @param servletContextEvent a <code>ServletContextEvent</code> value
     */
    public final void contextDestroyed(final ServletContextEvent servletContextEvent) {
	// do nothing 
    }

    /**
     * Describe <code>contextInitialized</code> method here.
     *
     * @param servletContextEvent a <code>ServletContextEvent</code> value
     */
    public final void contextInitialized(final ServletContextEvent servletContextEvent) {
	ArrayList<League> leagueList = new ArrayList<League>();
	ServletContext context = servletContextEvent.getServletContext();
	String leagueFile = context.getInitParameter("leagueFile");
	System.out.println("ahmad printed in tomcat7/logs/catalina.out");
	System.out.println("ahmad leagueFile ="+leagueFile);
	context.setAttribute("leagueFile",leagueFile);
	InputStream is=null;
	BufferedReader reader=null;
	try {
	    is=context.getResourceAsStream(leagueFile);
	    reader = new BufferedReader(new InputStreamReader(is));
	    String record;
	    //read every record (one per line)
	    while ((record=reader.readLine()) != null) {
		context.log("ahmad printed in  tomcat7/logs/");
		context.log("ahmad read record ="+ record);
		String[] fields = record.split("\t");
		context.log("ahmad read record ="+ fields);
		context.log("ahmad read fields[0] ="+ fields[0]);
		context.log("ahmad read fields[1] ="+ fields[1]);
		context.log("ahmad read fields[2] ="+ fields[2]);
		// extract data fields for record
		int year =Integer.parseInt(fields[0]);
		String title =fields[1];
		String season =fields[2];
		League league = new League(year,title,season);
		leagueList.add(league);
		context.log("ahmad adding  record to league after split  ="+ fields);
	    }
	    if (leagueList.isEmpty()) {
		context.log("ahmad cant read league file, and leagueList is empty");
	    }
	    context.setAttribute("leagueList",leagueList);
	    context.log("the leagueList has been loaded");

	} catch (Exception e) {
	    context.log("exception occured while processing the league file", e);
	}
	finally{
	    if (is !=null) {
		try {
		    is.close();
		} catch (Exception e) {
		    context.log("can't close league file ", e);	    
		}
	    }
	    if (reader !=null) {
		try {
		    reader.close();
		} catch (Exception e) {
		    context.log("can't close reader ", e);	    
		}
	    }
	}

    }
    // head first page 175 , 
    // call context event ==> set attribue ==> call init() ==> call servie()
    // means call config and context ==> then init ==> then service();
    // bound
}
