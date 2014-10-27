

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Subscribe
 */
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subscribe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//RequestDispatcher rd=request.getRequestDispatcher("http://cloudbees.us8.list-manage.com/subscribe/post?u=5a92dc0bb486854f432c87ea3&amp;id=b6a88ba2a2");
		//rd.forward(request,response);
		response.sendRedirect("http://cloudbees.us8.list-manage.com/subscribe/post?u=5a92dc0bb486854f432c87ea3&amp;id=b6a88ba2a2");
	
		
	}

}
