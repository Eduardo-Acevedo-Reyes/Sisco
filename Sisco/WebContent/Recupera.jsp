<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen">
<script type="text/javascript" src="js/validacion.js"></script>
<link href="css/boton/bootstrap.css" rel="stylesheet" type="text/css" />
<title>Recuperar Contraseña</title>
</head>
<body>
<img id="bg" src="img/SAT.png"  alt="background" />
<!-- <input type="button" id="mostrar" name="mostrar" value="Mostrar">-->
<div id="Contenedor">
	<div id="form">
		
          <form id="mi_form" action="Login.sat" method="post"  name="mi_form" onsubmit="return validaRecupera()">  
          
                <div align="center">
               
                <label>
                   <p><input name="rfccorto" id="rfccorto" type="text" class="rfccorto" placeholder="rfccorto..." style="text-transform: uppercase;" />  </p>
                  </label>
                  <br/>
                                   
                 	<div id="boton">
                     <input type="submit" value="Buscar" class="btn btn-primary btn-lg btn-block"   onclick="return confirm('Esta seguro de que es su RFC CORTO')"> 
                    </div>
                    
                 </div> 
         </form> 
  </div> 
</div>
</body>
</html>