<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>
<%@page import="sat.sistemaconsultasaggc.controlador.usuarioBean"%>
<%@page import="java.util.LinkedList"%>
<%@page import="sat.sistemaconsultasaggc.modelo.model"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<%
LinkedList<usuarioBean> lista1 = (LinkedList) request.getAttribute("listaPass");
Iterator itr2 = lista1.iterator();
if(itr2.hasNext()){
	usuarioBean uB=(usuarioBean) itr2.next(); 
	
	%>
	
	<h2>Tu contraseña es: <%= uB.getContrasena()%> </h2> 
	<%
}
%>
</body>
</html>