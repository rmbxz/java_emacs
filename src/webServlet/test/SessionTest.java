//   http://localhost:8080/web8/testSession.view	
package webServlet.test; // Generated package name

import java.io.IOException;
import java.io.PrintWriter;
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

	// cookie in localhost name is  Cookie: (name/value)   JSESSIONID=79648B6603709388645FDF61F374469C
	// get value  from firefox or  w3m M-k

	// in tomcat/logs will view the log data 
	//context.log("ahmad session id is  = "+ session.getId());

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	HttpSession session = request.getSession(false);// true default
	////////	HttpSession session = request.getSession(false);
	String name = "ali";

	// because the session always not null, so i need to check something is null or not
	//	String myName=(String) session.getAttribute("name");
	///////	  if (session == null) {
	  if (session==null) {
	      out.println(" session attribue  is new , so new user  ");	      
       	      session = request.getSession(true);
     	  } else {
	      out.println("old session ,so welcome back  user  ");	      
	  }
	  session.setAttribute("name",name);

	// if ((session.isNew())) {
	// //	if ((session == null)) {
	// //	if ((getName == null)) {
        // //	out.println(" session is new, welcome ");
	// out.println(" session == new ");
	// //	out.println(" session == null ");
	// }else {
	// session.setAttribute("name",name);
	// //	getName =(String) session.getAttribute("name");
	// String getName =(String) session.getAttribute("name");
	// out.println(" session scope attribute = "+ getName +" <br/>");
	// out.println(" test session "+ session.getId()+" <br/>");
	// out.println(" <br/> ============ <br/>" );
	// out.println(" int x  = "+ (x++));
	// }



	// work only if the cookies are disabled
        // out.println(response.encodeURL("hi"));
	    out.println(" <br/> ==========  <br/> ");
	    out.println(response.encodeURL("encodeURL"));  //
	    out.println(" <br/> ==========  <br/> ");
	    //	    out.println(response.encodeRedirectURL("encodeRedirectURL"));
	    out.println("<a href="+ response.encodeURL("http://www.sosox2.com") +">click me1</a>");
	    out.println("<a href="+ response.encodeRedirectURL("http://www.sosox2.com") +">click me2</a>");
	    response.sendRedirect("/aaa/bbb");
	    response.encodeRedirectURL("aaa/bbb");
    }

}
