<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sat.sistemaconsultasaggc.controlador.usuarioBean"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estiloAdmin.css" media="screen">
<%@ include file = "/WEB-INF/banner2.jsp" %>
<script type="text/javascript" src="js/validacion.js"></script>
<link href="css/boton/bootstrap.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen">

<link rel="stylesheet" type="text/css" href="css/jquery-ui-Temas/jquery-ui.css" media="screen">
<script type="text/javascript" src="js/jquery1.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

<title>Insert title here</title>
</head>
<body>
<div id="ModiUser" title="Busqueda">
 <form action="Registros.sat" name="fm" method="post">
 <%
LinkedList<usuarioBean> lista1 = (LinkedList) request.getAttribute("listaBusqueda");
Iterator itr = lista1.iterator();
	while(itr.hasNext()){   
		usuarioBean ub=(usuarioBean) itr.next();  
	
	 %>  
	 <table id="TablaModifica">
	  <tbody>
	  <tr>
	  <td><label>Usuario:</label><input id="user" name="user" value="<%= ub.getUsuario() %>" disabled="disabled"  class="cont" style="text-transform: uppercase;"></td>
	  <td><label>Contraseña:</label><input id="pass" name="pass" type="password" value="<%= ub.getContrasena() %>" disabled="disabled"  class="cont" style="text-transform: uppercase;"></td>
	  <td><label>RFC Corto:</label><input type="text" id="EliminaRFC1"  name="EliminaRFC1" value="<%= ub.getRfccorto() %>"  class="cont" disabled="disabled" style="text-transform: uppercase;"></td>
	  </tr>
	  <tr>
	  <td><label>Nombre:</label><input id="nombre1" name="nombre1" value="<%= ub.getNombre() %>" disabled="disabled"  class="cont" style="text-transform: uppercase;"></td>
	  <td><label>Apellido Paterno:</label><input id="apeP1" name="apeP1" value="<%= ub.getApellidop() %>" disabled="disabled"  class="cont" style="text-transform: uppercase;" ></td>
	  <td><label>Apellido Materno:</label><input id="apeM1" name="apeM1" value="<%= ub.getApellidom() %>" disabled="disabled"  class="cont" style="text-transform: uppercase;"></td>
	  </tr>
	  <tr>
	  <td><label>Administración:</label><input id="Admini" name="Admini"  value="<%= ub.getAdministracion() %>" disabled="disabled"  class="cont" style="text-transform: uppercase;"></td>
	  <td><label>Modificar <input type="checkbox" onclick="habilita()"/></label></td>
	  
	  </tr>
	 </tbody>
	</table>
	
	 <label id="EliminaCheck">Eliminar <input type="checkbox" id="EliminaRFC" name="EliminaRFC" onclick="enviar_formulario()" value="<%= ub.getRfccorto() %>"/></label>
   	   <div id="CheckModif"></div>
   		
       <div id="BtnModifica">
	   <input type="submit" id="conte" name="conte" value="Modificar Datos"  class="btn btn-success"  disabled="disabled" />
	     
       <input name="REGRESAR" type="button" onclick="location.href = 'admin.jsp'" class="btn btn-info" value="REGRESAR ">
       <%
	}
	 %> 
      </div>
    </form>
 </div>
 
  
 <div id="RConfi" align="center" style="text-align: center;" >
		
		<input name="REGRESA" type="button" onclick="location.href = 'admin.jsp'" class="btn btn-info " value="REGRESAR">
	</div> 
	<div id="MostrarBtn" align="center">  
	<input name=" Mostrar" type="button" onclick="Mostrar()" value="MOSTRAR" class="btn btn-success"/>
	</div> 
</body>
</html>

<script type="text/javascript">

    $(function(){
       $("#ModiUser").dialog({
           resizable: false,
    	      height:275,
    	      width: 700,
    	      modal: true,
              show: {
    	        effect: "clip",
    	        duration: 1000
    	      },
    	      hide: {
    	          effect: "clip",
    	          duration: 1000
    	        }
       }); 
        
    });

</script>
<<script type="text/javascript">
function Mostrar(){
	 $(function(){
	       $("#ModiUser").dialog({
	           resizable: false,
	    	      height:275,
	    	      width: 700,
	    	      modal: true,
	              show: {
	    	        effect: "clip",
	    	        duration: 1000
	    	      },
	    	      hide: {
	    	          effect: "clip",
	    	          duration: 1000
	    	        }
	       }); 
	        
	    });
}
</script>
<script language="JavaScript"> 
    function habilita(){
        elementos=document.getElementsByClassName("cont");
        
        for(var i = 0; i < elementos.length; i++)
        {
            elementos[i].disabled = false;
            document.getElementById("conte").disabled = false;
        }
    } 

    function deshabilita(){ 
        elementos=document.getElementsByClassName("cont");
        for(var i = 0; i < elementos.length; i++)
        {
            elementos[i].disabled = true;
        }
    }
 
    function enviar_formulario(){ 
    	   
    	   if(confirm('¿Esta seguro de elimina el registro?')){
    		   document.fm.submit();
    		
    	   }
    	   
    	} 
</script> 
