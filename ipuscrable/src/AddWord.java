import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import pack1.WordCorrectModel;

import java.sql.*;

public class AddWord extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
WordCorrectModel wcm;
wcm=new WordCorrectModel();

String word,dbword;
res.setContentType("text/html");
PrintWriter out=res.getWriter();
word=req.getParameter("newword");
dbword=wcm.correctWordfx(word);
out.println("<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><title>CSS3 Button Demo</title><link rel='stylesheet'href='css/style.css'></head><head><title>about this</title><link rel='stylesheet href='css/style.css'></head><body background='a.jpg' width='100%'height='100%'><p bgcolor='#ff0000'style='text-shadow:0px 1px 20px rgba(0,0,0,1);font-weight:bold;text-transform:uppercase;color:#FFFF00;letter-spacing:1pt;word-spacing:2pt;font-size:32px;text-align:left;font-family:comic sans, comic sans ms, cursive, verdana, arial, sans-serif;line-height:1;'><a href='index.jsp'>Home  </a><a href='about.html'>About</a></p><p align='center'><font size=100 color='#FF0000'><b><i>");
if(!dbword.equals("no such word found"))
{
		out.println("<p>Word Already Exists!!!! Ha!!!\n the words are "+dbword+"</p>");	
		out.println("</br><a href='index.jsp'><input type ='button' value='Back' name='Back'></input></a>");

}
//ServletContext ctx=getServletContext();
//word=(String)(ctx.getAttribute("wordAtt"));
else
{
try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","star");
		PreparedStatement pst=con.prepareStatement("insert into listdict values(?,?)");
		pst.setInt(1,45);
		pst.setString(2,word);
		pst.executeUpdate();
		out.println(word+" Added Successfully");	
		out.println("</br><a href='index.jsp'><input type ='button' value='Back' name='Back'></input></a>");
	}catch(Exception e)
		{
		out.println("<p>could not connect to database. there has been an error!!!!  ----"+e+"</p>");
		//System.out.println(e);
		}
out.println("</body></html>");
}
}

}