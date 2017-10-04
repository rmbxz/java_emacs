//   http://localhost:8080/web8/cookieDisable.view
package webServlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Describe class CookieDisabled here.
 *
 *
 * Created: Mon Sep 25 01:16:31 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class CookieDisabled extends HttpServlet {
    private boolean secondRequest=false;
    /**
     * Describe <code>doGet</code> method here.
     *
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */
    public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	// if null then the browser disable the cookies
	// known only by the second request, not the first request by checking the Request Header (Cookie) nullity.
	synchronized(session){
	    secondRequest=!secondRequest;
	    if(secondRequest==false){
		// this is the second request
		if (request.getHeader("Cookie") == null) {
		    out.println("no man, your browser disable the cookies   ");
		} else {
		    out.println("yes, your browser enabled  the cookies   ");
		}
	    }
	}

    }
}
