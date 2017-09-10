package webServlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webServlet.model.League;

/**
 * Describe class SuccessLeague here.
 *
 *
 * Created: Thu Aug 31 17:35:47 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class SuccessLeague extends HttpServlet {

    /**
     * Describe <code>doGet</code> method here.
     *
     * @param httpServletRequest a <code>HttpServletRequest</code> value
     * @param httpServletResponse a <code>HttpServletResponse</code> value
     * @exception ServletException if an error occurs
     * @exception IOException if an error occurs
     */
    public final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	League league = (League) request.getAttribute("league");
	PrintWriter out= response.getWriter();
	out.println("year "+league.getYear()+" <br/>");
	out.println("title "+league.getTitle()+" <br/>");
	out.println("season "+league.getSeason()+" <br/>");
    }
}
