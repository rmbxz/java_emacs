package webServlet.control;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import webServlet.model.League;

/**
 * Describe class AddLeagueAction here.
 *
 *
 * Created: Thu Sep 14 15:10:19 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class AddLeagueAction extends Action {


    /**
     * Describe <code>execute</code> method here.
     *
     * @param actionMapping an <code>ActionMapping</code> value
     * @param actionForm an <code>ActionForm</code> value
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @return an <code>ActionForward</code> value
     * @exception Exception if an error occurs
     */
    public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	ArrayList<String> errors = new ArrayList<String>();
	request.setAttribute("errors",errors);

	try {
	    String yearString = request.getParameter("year").trim();
	    String title = request.getParameter("title").trim();
	    String season = request.getParameter("season").trim();
	    int year=-1;
	    try {
		year=Integer.parseInt(yearString);
	    } catch (NumberFormatException e) {
		errors.add("year must be a number");
	    }
	    if (year != -1 && (year>2010  || year<2005) ) {
		errors.add("year must be between 2005-2010");
	    }
	    if (title.equalsIgnoreCase("")) {
		errors.add("please enter title");
	    } 
	    if (season.equalsIgnoreCase("unknown")) {
		errors.add("please enter season");
	    }
	    if (!errors.isEmpty()) {
		return mapping.findForward("error");
	    }
	    League league = new League(year,season,title);
	    //	    LeagueService leagueService = new LeagueService();
	    //            LeagueService.addLeague(league);
 	    request.setAttribute("league",league);
	    return mapping.findForward("success");
    
	    //  // ServletContext and log is very important
	    //         ServletContext context = getServletContext();
	    // // get attribute leagueList from webServlet.util.InitializeLeagues 
	    // ArrayList<League> leagueList = (ArrayList<League>) context.getAttribute("leagueList");
	    // leagueList.add(league);
	    // //   context.log in Tomcat/log files
	    //   	context.log("adding successed league ");
	    // RequestDispatcher view =request.getRequestDispatcher("successLeague.view");
	    // view.forward(request,response);
	    // return ;

	} catch (Exception e) {
	    errors.add(e.getMessage());
	    return mapping.findForward("error");
	}

    }

}  // end of class



//
//     /**
//      * Describe <code>doGet</code> method here.
//      *
//      * @param httpServletRequest a <code>HttpServletRequest</code> value
//      * @param httpServletResponse a <code>HttpServletResponse</code> value
//      * @exception ServletException if an error occurs
//      * @exception IOException if an error occurs
//      */
//     public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
// 	ArrayList<String> errors = new ArrayList<String>();
// 	request.setAttribute("errors",errors);
//
// 	try {
// 	    String yearString = request.getParameter("year").trim();
// 	    String title = request.getParameter("title").trim();
// 	    String season = request.getParameter("season").trim();
// 	    int year =-1;
// 	    try {
// 		year= Integer.parseInt(yearString);
// 	    } catch (NumberFormatException e) {
// 		errors.add("year must be  number ");
// 	    }
// 	    if (year != -1 && (year>2010  || year<2005) ) {
// 		errors.add("year must be between 2005-2010");
// 	    }
// 	    if (title.equalsIgnoreCase("")) {
// 		errors.add("please enter title ");
// 	    }
// 	    if (season.equalsIgnoreCase("unknown")) {
// 		errors.add("please select season ");
// 	    }
// 	    if (errors.isEmpty()) {
// 		League league = new League(year,title,season);
// 		request.setAttribute("league",league);
// 		// add new league to context.getAttribute("leagueList")
// 		ServletContext context = getServletContext();
// 		ArrayList<League> leagueList = (ArrayList<League>) context.getAttribute("leagueList");
// 		leagueList.add(league);
// 		RequestDispatcher view =request.getRequestDispatcher("successLeague.view");
// 		view.forward(request,response);
// 		return ;
// 	    } else {
// 		RequestDispatcher view =request.getRequestDispatcher("failedLeague.view");
// 		view.forward(request,response);
// 		return ;
// 	    }	
// 	} catch (Exception e) {
// 	    errors.add(e.getMessage());
// 	    RequestDispatcher view =request.getRequestDispatcher("failedLeague.view");
// 	    view.forward(request,response);
// 	}
//     }
// } //end of class


