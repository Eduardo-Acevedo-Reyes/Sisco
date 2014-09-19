<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>
<%@page import="sat.sistemaconsultasaggc.controlador.siscoBean"%>
<%@page import="java.util.LinkedList"%>
<%@page import="sat.sistemaconsultasaggc.modelo.model"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Por Nombre /Razón Social</title> 
         <%@ include file = "/WEB-INF/banner2.jsp" %>
        <script type="text/javascript" src="js/easyloader.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
        
       <link href="css/boton/bootstrap.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen">
	
	<link href="css/themes/default/easyui.css" rel="stylesheet" type="text/css" />
	<link href="css/themes/icon.css" rel="stylesheet" type="text/css" />
	<link href="css/demo/demo.css" rel="stylesheet" type="text/css" />
	<link href="css/themes/color.css" rel="stylesheet" type="text/css" />

</head>
<body>
<%
String usuario = (String) session.getAttribute("usuario");
if(usuario == null){ 
    request.getRequestDispatcher("index.jsp").forward(request, response);   
}
%>
    <CENTER>
		     <FONT COLOR = "#003366" FACE = "arial" SIZE = "4">
                       <B>USUARIO: <%= usuario.toUpperCase()%> </B>
		     </FONT>
            </CENTER>

 <form action="Resultados.rar" method="post" name="fm">
     <%
LinkedList<siscoBean> lista1 = (LinkedList) request.getAttribute("listaExcel2");
Iterator itr2 = lista1.iterator();
if(itr2.hasNext()){
	siscoBean sb=(siscoBean) itr2.next(); 
	
        
	%>
        <div id="GvistaNom">
	 <INPUT TYPE="radio" NAME="excel2"  ID="excel2" onclick="enviar_form()"  VALUE="<%=sb.getNom_razon()%> "> GENERAR REPORTE EXCEL DE ESTA VISTA <BR><BR>
       </div>
	<%
}
%>
<div id="tabla">
	<table class="easyui-datagrid" style="width:950px;height:300px" 
	data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true" id="dg">
            
    <thead>
        <tr>
            
            <th data-options="field:'orden'">Orden</th>
            <th data-options="field:'name'">Nombre/ Razon Social</th>
            <th data-options="field:'rfc'">RFC</th>
            <th data-options="field:'fecha'">Fecha</th>
            <th data-options="field:'ejerce de'">Ejerce de</th>
            <th data-options="field:'ejerce a'">Ejerce a </th>
            <th data-options="field:'ide a'">Id del Área Programadora </th>
            <th data-options="field:'sub programa'">Sub Programa de Fiscalización </th>
            <th data-options="field:'objetivo'">Objetivo </th>
            <th data-options="field:'origen'">Origen </th>
            
        </tr>
    </thead>
    
    <tbody>
<%


LinkedList<siscoBean> listaNomRazonCompleto = (LinkedList) request.getAttribute("listaNomRazonCompleto");
Iterator itr =listaNomRazonCompleto.iterator();
	while(itr.hasNext()){   
		siscoBean ub=(siscoBean) itr.next();
	 %>  
	 
	 <tr>
            
            <td>
                <% if (ub.getOrden() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getOrden());
		     %>
            </td>
            <td>
                <% if (ub.getRfc()  == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getRfc() );
		     %>
                
            </td>
            <td>
                 <% if (ub.getNom_razon()  == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getNom_razon() );
		     %>
                
            </td>
            <td> <% if (ub.getFech_emi() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getFech_emi() );
		     %>
            </td>
            <td>
                <% if (ub.getEjer_a()== null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getEjer_a() );
		     %>
            </td>
            <td>
                 <% if (ub.getId_a_prog()== null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getId_a_prog() );
		     %>  
            </td> 
            
            <td>
                 <% if (ub.getOrigen() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getOrigen()  );
		     %> 
            </td>
            <td>
                
                 <% if (ub.getObjetivo() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getObjetivo() );
		     %>  
            </td>
            <td>
                <% if (ub.getId_program() == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getId_program() );
		     %> 
            </td>
            <td>
                <% if (ub.getEjer_de()  == null) {
				 out.println ("S.I");
				 }else 
					out.println(ub.getEjer_de()  );
		     %> 
                
            </td>
              
        <tr>
	   
<%	
}

%>
    </tbody>
</table>
    <h5 id="SI">S.I= SIN INFORMACIÓN</h5>
    </div>
       <div id="botReNomRaCom">
         <input name="REGRESA" type="button" onclick="location.href = 'inicio.jsp'" class="btn btn-info " value="REGRESAR">
       </div>     
</form>

</body>
</html>
<script>
$('#dg').datagrid({
    url:'datagrid_data.json',
    columns:[[
        {field:'orden',title:'Orden',width:400},
        {field:'name',title:'Nombre/RazónSocial',width:850},
        {field:'rfc',title:'RFC',width:450},
        {field:'fecha',title:'Fecha',width:320},
        {field:'ejerde de',title:'Ejerde de',width:250},
        {field:'ejerce a',title:'Ejerce a',width:210},
        {field:'id a',title:'Id Área Programadora',width:220},
        {field:'sub programa',title:'Sub Programa de Fiscalización',width:220},
        {field:'objetivo',title:'Objetivo',width:220},
        {field:'origen',title:'Origen',width:220,align:'right'}
    ]]
});


function enviar_form(){ 
   
   if(confirm('¿Generar Reporte de Esta Vista ?')){
	   document.fm.submit();
	
   }
   
} 
</script>