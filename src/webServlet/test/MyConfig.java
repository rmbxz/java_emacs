// http://localhost:8080/web8/html/myConfig.view
package webServlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describe class MyConfig here.
 *
 *
 * Created: Sat Sep 23 22:32:49 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class MyConfig extends HttpServlet {

    /**
     * Describe <code>doGet</code> method here.
     *
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */
    String initValue2;
    public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	ServletConfig config = getServletConfig();
	String initValue= config.getInitParameter("initConfig1");
	//	    String  config = getServletConfig().getInitParameter("initConfig");
	out.println("servlet config = "+ initValue );
	out.println(" <br/> ========  <br/>");
	out.println("servlet config2 from init() = "+ initValue2 );
	out.println(" <br/> ========  <br/>");
    }

    /**
     * Describe <code>init</code> method here.
     *
     * @exception ServletException if an error occurs
     */
    public final void init() throws ServletException {
	initValue2 = getInitParameter("initConfig2");
    }

}
