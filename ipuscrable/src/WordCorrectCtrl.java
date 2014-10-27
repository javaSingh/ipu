//this is checkServ
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import pack1.WordCorrectModel;

public class WordCorrectCtrl extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	ServletContext application=getServletContext();
String word,correctword;
WordCorrectModel wcm;
res.setContentType("text/html");
PrintWriter out=res.getWriter();
word=req.getParameter("word");
if(word==null || word.equals(""))
	res.sendRedirect("index.jsp");
ServletContext ctx=getServletContext();
ctx.setAttribute("wordAtt",word);
ctx.setAttribute("counter",23);
wcm =new WordCorrectModel();
correctword=wcm.correctWordfx(word.trim());

out.println("<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><title>CSS3 Button Demo</title><link rel='stylesheet'href='css/style.css'></head><head><title>about this</title><link rel='stylesheet href='css/style.css'></head><body background='a.jpg' width='100%'height='100%'><p bgcolor='#ff0000'style='text-shadow:0px 1px 20px rgba(0,0,0,1);font-weight:bold;text-transform:uppercase;color:#FFFF00;letter-spacing:1pt;word-spacing:2pt;font-size:32px;text-align:left;font-family:comic sans, comic sans ms, cursive, verdana, arial, sans-serif;line-height:1;'><a href='index.jsp'>Home  </a><a href='about.html'>About</a></p><p align='center'><font size=100 color='#FF0000'><b><i>");
if(correctword.equals("no such word found"))
{
	application.setAttribute("message", "no such word found");
	/*
out.println("<p>No such word found in the Database ! !</p> ");
out.println("<p>Do you wish to add ");
out.println(word);
out.println("?? </p>");
out.println("<form action='WordAdd'>");
out.println("New Word :<input type='text'  name='newword' placeholder='put your word here' required autofocus></input></br>");
out.println("<input type ='submit' value='Add Word' name='Add'></input>");
out.println("</form>");
out.println("<a href='index.jsp'><input type ='button' value='Back' name='Back'></input></a>");
out.println("</i></b></font></p>");
*/
}
else if(correctword.equals("error"))
{
	application.setAttribute("message", "Problem with database.");

	//out.println("Problem with database");	
}
else
{
	application.setAttribute("message", "the word is "+correctword);
//out.println("The word/s is / are  "+correctword);
//out.println("</br><a href='index.jsp'><input type ='button' value='Back' name='Back'></input></a>");
//out.println("</body></html>");
}
res.sendRedirect("message.jsp");
}
}