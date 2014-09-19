<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="sat.sistemaconsultasaggc.controlador.siscoBean"%>
    <%@page import="sat.sistemaconsultasaggc.modelo.model"%>
    <%@page import="java.util.LinkedList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Resultados Obtenidos ...</title>
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
<div id="tabla2">
	<table class="easyui-datagrid" style="width:950px;height:300px" 
	data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true" id="dg">
            
    <thead>
        <tr>
            
            <th data-options="field:'name'">Nombre/ Razon Social</th>
         
        </tr>
    </thead>
    
    <tbody>
    
    
<%


	LinkedList<siscoBean> listaNomRazon = (LinkedList) request.getAttribute("listaNomRazon");
	Iterator itr = listaNomRazon.iterator();
	while(itr.hasNext()){   
		siscoBean sb=(siscoBean) itr.next(); 
               
                
	 %>
<tr>
            
            
            
            <td><INPUT TYPE="radio" NAME="nomRazonCompletoRFC"  ID="nomRazonCompletoRFC" onclick="enviar_formulario()" VALUE="<%=sb.getRfc()%> "> <%=sb.getNom_razon() %> </td>
          

              
        </tr>
<%         
	}
%>
</tbody>
</table>
    </div>
      <div id="botonRegresaNomRazon">    
      <input name="REGRESA" type="button" onclick="location.href = 'inicio.jsp'" class="btn btn-info " value="REGRESAR">
    </div>     

</form>

</body>
</html>

<script> 

function enviar_formulario(){ 
   
   if(confirm('¿Esta seguro de la opcion elegida?')){
	   document.fm.submit();
	
   }
   
} 
$('#dg').datagrid({
    url:'datagrid_data.json',
    columns:[[
       
        {field:'name',title:'Nombre/RazónSocial',width:850},
        
    ]]
});
</script> 
