package webServlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describe class AddLeagueFormServlet here.
 *
 *
 * Created: Thu Sep 14 16:07:02 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class AddLeagueFormServlet extends HttpServlet {

    private String[] seasonList;
    private  static final String  SEASON_LIST="unknown,Spring,Summer,Winter,Fall";
    
    /**
     * Describe <code>init</code> method here.
     *
     * @exception ServletException if an error occurs
     */
    public final void init() throws ServletException {
	// unknown,Spring,Summer,Winter,Fall
	String seasonTemp =getInitParameter("season-list");
	  if (seasonTemp==null) {
	      seasonList=SEASON_LIST.split(",");
      	  } else {
	      seasonList=seasonTemp.split(",");
	  }	
    }



    /**
     * Describe <code>doPost</code> method here.
     *
     * @param request a <code>HttpServletRequest</code> value
     * @param response a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */
    public final void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	generateView(request,response);
    }

    /**
     * Describe <code>doGet</code> method here.
     *
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */
    public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	generateView(request,response);
    }

    /**
     * Describe <code>generateView</code> method here.
     *
     * @param request a <code>HttpServletRequest</code> value
     * @param response a <code>HttpServletResponse</code> value
     */
    public void generateView(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	ArrayList<String> errors = (ArrayList<String>) request.getAttribute("errors");
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("===================  <br/>");
	for (String element : errors) {
	    out.println(element+" <br/>");
	}
	out.println("=================== <br/>");

	out.println("<form action='add_league.do' method='get'>");
	out.println("year	    <input name='year' type='text' value='"+request.getParameter("year").trim()+"'/> <br/>");
	out.println("title	    <input name='title' type='text' value='"+request.getParameter("title").trim()+"'/> <br/>");
	out.println("season	    <select name='season' id=''>");
	//	String[] seasonList={"unknown","Spring","Summer","Winter","Fall"};
	String selectedSeason =request.getParameter("season").trim();
	for (String element : seasonList) {
	    if (element.equalsIgnoreCase(selectedSeason) ) {
	      out.println("<option value='"+element+"' selected>"+element+"</option>");
      	  } else {
	      out.println("<option value='"+element+"' >"+element+"</option>");
	  }
	}
	out.println("</select> <br/>");
	out.println("<input name='' type='submit' value='add league'/> <br/>");
	out.println("</form>");
    }
}
