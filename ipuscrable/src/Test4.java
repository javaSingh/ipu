
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
	
		
		
		try 
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_test432","b49635eb3ae2d2","64701f54");
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","star");
			
			Statement st=con.createStatement();
			//PreparedStatement pst=con.prepareStatement("insert into studentnavneet values (?,?,?,null,null,null,null,null,null)");
			PreparedStatement pst=con.prepareStatement("select * from studentnavneeta where userpass=?");
			pst.setString(1,"nt");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				out.println(rs.getString(1));
				out.println(" ");
				
			}

//			Class.forName("oracle.jdbc.driver.OracleDriver");
	//		Connection conoracle=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","star");
		//	Statement storacle=conoracle.createStatement();
		//ResultSet rsoracle=storacle.executeQuery("select * from ");
			
			
			
		
		/*	int count=0;
		
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
			*/
			//pst.setString(1, "nament");

			//pst.setString(2, "hj");
		
				//pst.setString(3, "hj");
				//pst.setString(arg0, arg1)
				//pst.executeUpdate();
				
				
				
				//out.println(rs.getString(1)+" ");
				
			

			
			
			
			
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
