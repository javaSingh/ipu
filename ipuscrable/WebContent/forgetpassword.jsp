<%@ page import='com.*' %>

<%
Database db=new Database();
String name="",userid="",userpassword="";
name=request.getParameter("name");
userid=request.getParameter("userid");
if(name==null || name=="")
{
application.setAttribute("message"," ");
response.sendRedirect("message.jsp");
}
else
{
	//out.println(request.getParameter("name"));
	//out.println(request.getParameter("userid"));
	userpassword=db.getPassword(name,userid);
	if(userpassword.equals("no such user")||userpassword.equals("error with database"))
	application.setAttribute("message",userpassword);
	else
	application.setAttribute("message","the password is : "+userpassword);

	response.sendRedirect("message.jsp");
}
%>