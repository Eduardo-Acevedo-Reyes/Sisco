<%@page import="sat.sistemaconsultasaggc.modelo.model"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sat.sistemaconsultasaggc.controlador.siscoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estiloR.css" media="screen">
<link href="css/boton/bootstrap.css" rel="stylesheet" type="text/css" />
 <%@ include file = "/WEB-INF/banner2.jsp" %>
<title>Resultados Obtenidos ...</title>
<%
String usuario = (String) session.getAttribute("usuario");
if(usuario == null){ 
    request.getRequestDispatcher("index.jsp").forward(request, response);   
}
%>
 <CENTER>
      <FONT COLOR = "#003366" FACE = "arial" SIZE = "3">
            USUARIO: <%= usuario.toUpperCase()%> 
      </FONT>
    </CENTER>
</head>
<form action="inicio.jsp" name="formResultados">
    <%


LinkedList<siscoBean> lista = (LinkedList) request.getAttribute("listaOrden");
Iterator itr = lista.iterator();
	while(itr.hasNext()){   
		siscoBean ub=(siscoBean) itr.next();
	 %>  

<body>
<div id="ROrden">
	<table id="b" style="width: 800px" align="center">
    <thead>
    	<tr> 
        	<td colspan="5">SAT</td>
        </tr>
    </thead>
                 
        <tfoot>
            
    	<tr>
            <td colspan="5"><em></em> <div align="left">FECHA EMISION: <%= ub.getFech_emi() %></div> <div align="right"> S.I = SIN INFORMACIÓN</div></td>
        </tr>
    </tfoot>
    <tbody>
    	<tr>
        	<td>ORDEN: <hr> <%=ub.getOrden() %></td>
            <td></td>
            <td>NOMBRE RAZON SOCIAL: <hr> <%=ub.getNom_razon() %></td>
            <td></td>
            <td>ORIGEN (INSUMO O PROGRAMA): <hr> 
                 <% if (ub.getOrigen() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getOrigen());
		     %>
                
                </td>
        </tr>
        <tr>
        	<td>RFC: <hr>
                <% if (ub.getRfc() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getRfc());
		     %>
                
                </td>
            <td></td>
            <td>OBJETIVO: <hr> 
            <% if (ub.getObjetivo() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getObjetivo());
		     %>
            </td>
            <td></td>
            <td>ID DEL ÁREA PROGRAMADORA:<hr> 
                <% if (ub.getId_a_prog() == null) {
				 out.println (" S.I");
				 }else 
					out.println(ub.getId_a_prog());
		     %>
               </td>
        </tr>
        <tr>
        	<td>SUBPROGRAMA DE FISCALIZACION :<hr> 
                    <% if (ub.getId_program() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getId_program());
		     %>
                </td>
            <td></td>
            <td>EJERCICIO DESDE: <hr><%=ub.getEjer_de() %></td>
            <td></td>
            <td>EJERCICIO HASTA:<hr> <%=ub.getEjer_a() %></td>
        </tr>
    </tbody>
    
    <%	
}

%>
</table>
</div>
<div id="botonResultadosOrden">
<input type="submit" value="REGRESAR" class="btn btn-info " />
</div>
    </form>
</body>
</html>
