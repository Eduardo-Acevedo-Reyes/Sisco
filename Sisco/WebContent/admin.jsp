<%@page import="java.util.Iterator"%>
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


<title>ADMIN SAT</title>
</head>
<body>
 <body>
    <div id="RegistraUsuario" align="center" >
      <input name="REGISTRAR" type="button" onclick="dialogo()" class="btn btn-primary btn-lg" value="REGISTRA / USUARIOS ">                 
     </div>
     
    
                     
    <div id="Modifica"  align="center">
     <input name="MODIFICA" type="button" onclick="dialogModif()" class="btn btn-primary btn-lg " value="&nbsp; MODIFICA / ELIMINA &nbsp;">                 
    </div>
    
    <div id="Salir" align="center">
        <input name="SALIR" type="button" onclick="location.href = 'index.jsp'" class="btn btn-danger btn-lg" value="SALIR">
    </div>
    <%
String usuario = (String) session.getAttribute("usuario");
if(usuario == null){ 
    request.getRequestDispatcher("index.jsp").forward(request, response);   
}
%>

<div id="tituloInicio">
            <CENTER> 
                <p>USUARIO: <%= usuario.toUpperCase()%> <p>     
            </CENTER>
 </div> 
    <div id="dialog" title="Registros" >
 
		<form action="Registros.sat" name="fm" method="post" onsubmit="return val()">
		Usuario: <input type="text" id="usuario" name="usuario" style="text-transform: uppercase;" placeholder="Ususario"/>
		                               
		Contraseña: <input type="password" id="pass" name="pass" style="text-transform: uppercase;" onkeypress="capLock(event)" placeholder="Contraseña" />
	
		Confima Contraseña <input type="password" id="pass2" name="pass2" style="text-transform: uppercase;"  onkeypress="capLock2(event)" placeholder="Confirma la Contraseña"/>
		<br> 
		RFC Corto: <input type="text" id="rfccorto" name="rfccorto" style="text-transform: uppercase;" placeholder="RFC Corto "/>
		
		Administración: <input type="text" id="admin" name="admin" style="text-transform: uppercase;" placeholder="Administración"/>
		
		Nombre (s): <input type="text" id="nombre" name="nombre" style="text-transform: uppercase;" placeholder="Nombre"/>
		
		Apellido Paterno: <input type="text" id="apeP" name="apeP" style="text-transform: uppercase;" placeholder="Apellido Paterno"/>
		
		Apellido Materno:  <input type="text" id="apeM" name="apeM" style="text-transform: uppercase;" placeholder="Apellido Materno"/>
		<br> <br>
		    <input type="submit" value="REGISTRAR"  onclick="return validaAdmin()" class="btn btn-success"/>
		</form>
	</div>
                     
     
    <div id="dialogModif" title="Busqueda">
         <form action="Registros.sat" name="fmE" method="post" onsubmit="">
             RFC Corto: <input type="text" id="BuscaUser" name="BuscaUser" style="text-transform: uppercase" required/>
             <br> <br>
             <input type="submit" value="Buscar"   class="btn btn-warning " />
		
         </form>
     </div>
     

</body>
</html>
<!-- capLock no tiene tanta importancia ya que de todas formas paso ha mayúsculas la contraseña
solo lo pongo como distractor -->
<script>
 function val(){
	 
	 pass1=document.fm.pass.value
	 pass2=document.fm.pass2.value
	 if(pass1 != pass2){
		 alert("NO COINCIDEN LA CONTRASEÑA");
                 document.getElementById("pass2").value = "";
		 return false;
                 
	 }
	 return true;
	 
	 
 }
 function capLock(e){
	 kc = e.keyCode?e.keyCode:e.which;
	 sk = e.shiftKey?e.shiftKey:((kc == 16)?true:false);
	 if(((kc >= 65 && kc <= 90) && !sk)||((kc >= 97 && kc <= 122) && sk)){
	  document.getElementById('pass').value
	 alert("TIENE EL BLOQ MAYÚS ACTIVADO");
         document.getElementById('pass').value= "";
	 }else
	   document.getElementById('Mayus').style.visibility = 'hidden';
	}
 
 function capLock2(e){
	 kc = e.keyCode?e.keyCode:e.which;
	 sk = e.shiftKey?e.shiftKey:((kc == 16)?true:false);
	 if(((kc >= 65 && kc <= 90) && !sk)||((kc >= 97 && kc <= 122) && sk)){
	  document.getElementById('pass2').value
	  alert("TIENE EL BLOQ MAYÚS ACTIVADO");
          document.getElementById('pass2').value= "";
		 
	 }else
	   document.getElementById('Mayus2').style.visibility = 'hidden';
	}
</script>

<script>
function dialogo(){ 
      $(function() {
    	    $( "#dialog" ).dialog({
    	      
    	      resizable: false,
    	      height:510,
    	      width: 240,
    	      modal: true,
    	      
    	      show: {
    	        effect: "bounce",
    	        duration: 1000
    	      },
    	      hide: {
    	          effect: "puff",
    	          duration: 1000
    	        }
    	    });
    	  });
}

  </script>
<script>
    function dialogElimina(){
    $(function(){
       $("#dialogElimina").dialog({
           resizable: false,
    	      height:170,
    	      width: 240,
    	      modal: true,
              show: {
    	        effect: "pulsate",
    	        duration: 1000
    	      },
    	      hide: {
    	          effect: "explode",
    	          duration: 1000
    	        }
       }); 
        
    });
}

function dialogModif(){
    $(function(){
       $("#dialogModif").dialog({
           resizable: false,
    	      height:170,
    	      width: 240,
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