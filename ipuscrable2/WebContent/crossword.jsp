<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='pack1.*'%>
<%
if(request.getParameter("word")==null)
{
//application.setAttribute("message"," ");
//response.sendRedirect("message.jsp");
response.sendRedirect("WEB-INF/SignUp.jsp");
}
else
{
String word,correctword="no word found"
;
WordCorrectModel wcm;
word=request.getParameter("word");
wcm =new WordCorrectModel();
correctword=wcm.crosswordfx(word);
application.setAttribute("message",correctword);
response.sendRedirect("message.jsp");
}
%>