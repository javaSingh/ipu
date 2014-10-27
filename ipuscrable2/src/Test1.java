// this will print all the entries in the table.
// the table stored in the cloudbees
// this has been delinked in the xml file.
//pLEASE CORREC IT THERE 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Test1
 */
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1() {
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
	
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_test432","b49635eb3ae2d2","64701f54");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from cb_test432.testtable1");
			out.println(con+" ");
			
			
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","star");
		//Statement st=con.createStatement();
		//ResultSet rs=st.executeQuery("select * from listdict");

			
			int count =0;
			while(rs.next()&&count++<50000)
				out.print(rs.getString(1)+" "+rs.getString(2)+" ");
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(e);
		}

		
	}

}
