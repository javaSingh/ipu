
// this has been delinked in the xml file.
//pLEASE CORREC IT THERE

// this will read valued from the table listdict stored in oracle localhost and store
// those words in the cloudbees database table testtable1.

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
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2() {
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
			PreparedStatement pst=con.prepareStatement("insert into cb_test432.testtable1 values (?,?)");
			//ResultSet rs=st.executeQuery("select * from cb_test432.testtable1");
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conoracle=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","star");
			Statement storacle=conoracle.createStatement();
		ResultSet rsoracle=storacle.executeQuery("select * from listdict");
			
			
			
		
			int count=0;
		
			while(rsoracle.next()&&count<58110)
			//while(rs.next())
		
			{
				
				count++;
				if(count<22436)
				{
					rsoracle.next();
					continue;
				}
				String id,word;
				id=rsoracle.getString(1);
				word=rsoracle.getString(2);
				pst.setString(1, id);
				pst.setString(2, word);
				pst.executeUpdate();
				
				
				
				//out.println(rs.getString(1)+" ");
				
			}

			
			
			
			
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
