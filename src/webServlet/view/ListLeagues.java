package webServlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webServlet.model.League;

/**
 * Describe class ListLeagues here.
 *
 *
 * Created: Fri Sep 15 12:06:41 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class ListLeagues extends HttpServlet {

    /**
     * Describe <code>doGet</code> method here.
     *
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */
    public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	ServletContext context = getServletContext();	
	ArrayList<League> leagueList = (ArrayList<League>)context.getAttribute("leagueList");
	String leagueFile = (String)context.getAttribute("leagueFile");

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	if (leagueList==null) {
	    out.println("leagueList = null ");
	    out.println("leagueFile =  "+ leagueFile);
	} else {
	    for (League league : leagueList) {
		out.println("year "+league.getYear()+" <br/>");
		out.println("title "+league.getSeason()+" <br/>");
		out.println("season "+league.getTitle()+" <br/>");
		out.println("===================  <br/>");
	    }
	}
    }
}
