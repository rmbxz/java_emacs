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
	ArrayList<League> leagueList = new ArrayList<League>();
	ServletContext context = servletContextEvent.getServletContext();
	//	String leagueFile = context.getInitParameter("league-file");
	// String leagueFile = "//WEB-INF//data//leagues.txt";
	String leagueFile = "test1";
	
	context.setAttribute("leagueFile",leagueFile);
	InputStream is=null;
	BufferedReader reader=null;
	try {
	    is=context.getResourceAsStream(leagueFile);
	    reader = new BufferedReader(new InputStreamReader(is));
	    String record;
	    //read every record (one per line)
	    while ((record=reader.readLine()) != null) {
		String[] fields = record.split("\t");
		// extract data fields for record
		int year =Integer.parseInt(fields[0]);
		String season =fields[1];
		String title =fields[2];
		League league = new League(year,title,season);
		leagueList.add(league);
	    }
	    if (leagueList.isEmpty()) 
		context.log("cant read league file, and leagueList is empty");

	    context.setAttribute("leagueList",leagueList);
	    context.log("the league list has been loaded");

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

    /**
     * Describe <code>contextInitialized</code> method here.
     *
     * @param servletContextEvent a <code>ServletContextEvent</code> value
     */
    public final void contextInitialized(final ServletContextEvent servletContextEvent) {
	// do nothing
    }
}
