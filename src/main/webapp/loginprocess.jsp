<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="servlet.LoginDao" %>
<jsp:useBean id="obj" class="servlet.LoginBean" />    
<jsp:setProperty property="*" name="obj" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%
   boolean status = LoginDao.validate(obj);
   out.println("Login Baen object status: " + status);
    
   if(status){
	   out.println("U r successfully logged in");
	   session.setAttribute("session", "TRUE");
   }else{
	   out.println("sorry, email or password error");
	   out.println();
   
     %>
     
   <jsp:include page="index.jsp"></jsp:include>
    <%
    }
    %>
    
  
</body>
</html>