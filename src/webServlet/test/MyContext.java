//  http://localhost:8080/web8/html/myContext.view
package webServlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describe class MyContext here.
 *
 *
 * Created: Sat Sep 23 22:43:07 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class MyContext extends HttpServlet {

    /**
     * Describe <code>doGet</code> method here.
     *
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */
    public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");

	// context shared by application
	ServletContext context = getServletContext();
	String leagueFile = context.getInitParameter("leagueFile");
	// getInitParameter then put it in context.setAttribues
	context.setAttribute("myFile",leagueFile);
	context.log("log to container tomcat logs files");
	out.println(" context parameter =  "+ leagueFile );
	// also store attribute over web application
	String myAge ="99";
	context.setAttribute("myAge",myAge);
	out.println(" <br/>  context attribute  =  "+ context.getAttribute("myAge"));

    }
}
