<%@ page import="com.Database" %>
<%! Database db; %>
<%
int uniqueid=781;
if(request.getParameter("userid")==null)
{

	application.setAttribute("message"," ");
	response.sendRedirect("message.jsp");
}
else if(session.getAttribute("userid")==null)
{
session.invalidate();
db=new Database();
String[] s;
s=new String[5];
s[0]=request.getParameter("username");
s[1]=request.getParameter("userid");
s[2]=request.getParameter("userpassword");
//s[3]=request.getParameter("phnum");
//s[4]=request.getParameter("uniqueid");
//if(s[4]!=null)
//uniqueid=Integer.parseInt(s[4]);
String errorString=db.dataEntryNew(s);//db.dataEntry(s,uniqueid);

if(errorString=="successful")
{
application.setAttribute("message","You have created your account successfully");
response.sendRedirect("message.jsp");

}
else if(errorString=="not new")
{
application.setAttribute("message","The user-id already exists. Please try with a new one");
response.sendRedirect("message.jsp");

}
else if(errorString=="inside catch")
{
application.setAttribute("message","Sorry. The database's not working. Please try again later.");
response.sendRedirect("message.jsp");
}
else if(errorString=="error has occoured at the getData Method")
{
application.setAttribute("message","Sorry. The database's not working. Please try again later.");
response.sendRedirect("message.jsp");
}
else if(errorString=="someone's using someone's else VCode.")
{
application.setAttribute("message","Sorry. You don't have a valid VCode.");
response.sendRedirect("message.jsp");
}
else
{
application.setAttribute("message","wtf.Error.Error.Sorry.");
response.sendRedirect("message.jsp");
}
}
else
response.sendRedirect("userpage.jsp");
%>