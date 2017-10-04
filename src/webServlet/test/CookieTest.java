// http://localhost:8080/web8/html/myCookie.view
package webServlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describe class CookieTest here.
 *
 *
 * Created: Sat Sep 23 21:33:35 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class CookieTest extends HttpServlet {

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

	// Cookie cookie = new Cookie("rmbxz","12345");
	// cookie.setMaxAge(20*60);
	// response.addCookie(cookie);
	// out.println(" <br/> =========== <br/>");
	// out.println("cookie name  = "+ cookie.getName() +" <br/>");
	// out.println("cookie value  = "+ cookie.getValue() );
	// out.println(" <br/>  =========== <br/>");

	Cookie[] cookies = request.getCookies();
	if (cookies == null) {
	    out.println("new user");
	    Cookie cookie = new Cookie("rmbxz","12345");
	    cookie.setMaxAge(20*60);// 
	    response.addCookie(cookie);
	} else {
	    for (Cookie cookie : cookies) {
		if (cookie.getName().equals("rmbxz") && cookie.getValue().equals("12345") ) {
		    out.println("welcome back rmbxz ");
		}	    
	    }
	}
    }
}
