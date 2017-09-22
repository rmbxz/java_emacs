package webServlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Describe class SessionTest here.
 *
 *
 * Created: Fri Sep 22 21:33:59 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class SessionTest extends HttpServlet {

    int x=1;
    /**
     * Describe <code>doGet</code> method here.
     *
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */

    public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	
	// if false will not create new cookie
	// HttpSession session = request.getSession(false);
	// session stores in cookies or in response.encodeURL in the form action

	// context shared by application
	//	ServletContext context = getServletContext();

	//	context.log("ahmad printed your father is = "+ getName);
	// cookie in localhost name is  Cookie: (name/value)   JSESSIONID=79648B6603709388645FDF61F374469C
	// get value  from firefox or  w3m M-k
	//   http://localhost:8080/web8/html/testSession.view	

	// in tomcat/logs will view the log data 
	//context.log("ahmad session id is  = "+ session.getId());

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	HttpSession session = request.getSession();
	String name = "ali";

	if ((session.isNew())) {
	//	if ((session == null)) {
	//	if ((getName == null)) {
        //	out.println(" session is new, welcome ");
	out.println(" session == new ");
	//	out.println(" session == null ");
	}else {
	session.setAttribute("name",name);
	//	getName =(String) session.getAttribute("name");
	String getName =(String) session.getAttribute("name");
	out.println(" session scope attribute = "+ getName +" <br/>");
	out.println(" test session "+ session.getId()+" <br/>");
	out.println("============ <br/>" );
	out.println(" int x  = "+ (x++));
	}
	// work only if the cookies are disabled
	    out.println(response.encodeURL("hi"));
    }
}
