
// this has been delinked in the xml file.
//pLEASE CORREC IT THERE

// this will read valued from the table listdict stored in oracle localhost and store
// those words in the cloudbees database table testtable1.

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Test1
 */
public class Test4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();
		out.println("hi");
	
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/SignUp.jsp");
	rd.forward(request,response);
		//response.sendRedirect("/WEB-INF/SignUp.jsp");

		
	}

}
