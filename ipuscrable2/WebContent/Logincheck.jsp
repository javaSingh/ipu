<%@ page import='com.*'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String userid;
userid="initial value";
RequestDispatcher rd;
Database db=new Database();
if(request.getParameter("userid")==null || request.getParameter("userpassword")==null)
{
session.invalidate();
//application.setAttribute("message","why?");
response.sendRedirect("message.jsp");
//out.println("why??");
//response.sendRedirect("jackie.html");
}

else
{
userid=request.getParameter("userid");
userid.trim();
String userpassword=request.getParameter("userpassword");

if(userid.equals("iamadmin") && userpassword.equals("iamadmin"))
{

//application.setAttribute("message"," this is inside admin block");
//response.sendRedirect("message.jsp");
	//out.println("htis si inside admin block");
	//response.sendRedirect("AdminPage.jsp");
}
else
{
userid=db.dataCheck(userid,userpassword);
//out.println(userid);
session.setAttribute("userid",userid);

if((request.getParameter("userid"))!=userid)//login credintials wrong.
{
session.invalidate();
//out.println(userid);
//out.println(request.getParameter("userid"));
application.setAttribute("message","No match. Please try logging again.");
response.sendRedirect("message.jsp");
}
else
{
response.sendRedirect("userpage.jsp");
}
}
}

%>
