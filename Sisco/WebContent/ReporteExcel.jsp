<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>
<%@page import="sat.sistemaconsultasaggc.controlador.siscoBean"%>
<%@page import="java.util.LinkedList"%>
<%@page import="sat.sistemaconsultasaggc.modelo.model"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/validacion.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Resultados por busqueda RFC</h1>
<table>
<tr>
<td>ORDEN</td>
<td>NOMBRE</td>
<td>RFC</td>
</tr>
<form action="Resultados.rar" method="post" name="fm"> 
<%
LinkedList<siscoBean> lista1 = (LinkedList) request.getAttribute("listaExcel");
Iterator itr2 = lista1.iterator();
if(itr2.hasNext()){
	siscoBean sb1=(siscoBean) itr2.next(); 
	
	%>
	<INPUT TYPE="radio" NAME="excel"  ID="excel" onclick="enviar_form()"  VALUE="<%=sb1.getNom_razon()%> "> GENERAR REPORTE DE ESTA VISTA <BR><BR>
	<%
}
%> <%
LinkedList<siscoBean> lista = (LinkedList) request.getAttribute("lista");
Iterator itr1 = lista.iterator();


//for(int i = 0 ; i < lista.size(); i++){
	while(itr1.hasNext()){   
		siscoBean sb=(siscoBean) itr1.next();
                
	 %>  
	 
	  <td> <%= sb.getOrden() %>	</td>
           <td> <%= sb.getRfc() %></td>
	   <td> <%= sb.getNom_razon() %></td> 
           
	   </tr>
	   
<%	  
}

%> 

</form>
</body>

</html>
<script> 

function enviar_form(){ 
   
   if(confirm('¿Quiere un Reporte de este registro?')){
	   document.fm.submit();
	
   }
   
} 


</script> 
