function validaCheckOrden()
{
	
	
if(document.getElementById("ordenR").checked == true){
	document.getElementById("ordenR").disabled=true;
	document.getElementById("orden").disabled=false;
	document.getElementById("rfcR").disabled=true;
	document.getElementById("nomRazonR").disabled=true;
	
} if(document.getElementById("rfcR").checked == true){
	document.getElementById("rfcR").disabled=true;
	document.getElementById("orden").disabled=true;
	document.getElementById("ordenR").disabled=true;
	document.getElementById("rfc").disabled=false;	
	document.getElementById("nomRazonR").disabled=true;
	
}if(document.getElementById("nomRazonR").checked == true){
	document.getElementById("nomRazonR").disabled=true;
	document.getElementById("orden").disabled=true;
	document.getElementById("ordenR").disabled=true;
	document.getElementById("rfc").disabled=true;
	document.getElementById("rfcR").disabled=true;
	document.getElementById("nomRazon").disabled=false;
}

}


function valida()
{
	if(document.getElementById("ordenR").checked == false && document.getElementById("rfcR").checked == false && document.getElementById("nomRazonR").checked == false){
		alert("Seleccione una Opcion");
		return false;
	}

if(document.getElementById('ordenR').checked == true){
	if(document.getElementById("orden").value == ""){
		
		alert("Ingrese la Orden");
		return false;
	}
}

if(document.getElementById('rfcR').checked == true){
	if(document.getElementById("rfc").value == ""){
		
		alert("Ingrese el Rfc");
		return false;
	}
}
	if (document.getElementById("nomRazonR").checked == true) {
		if(document.getElementById("nomRazon").value == ""){
			alert("Ingrese el Nombre/Razon Social");
			return false;
		}
	}
	
	return true;
}



function validaLogin(){
	if (document.getElementById("usuario").value == "") {
		alert("Ingrese su Usuario");
		return false;
	}
	if (document.getElementById("pass").value == "") {
		alert("Ingrese la Contraseña");
		return false;
	}
	
	
	return true;
}

function validaRecupera(){
	
	if(document.getElementById("rfccorto").value == ""){
		alert("Ingrese su Rfc Corto");
		return false;
	}
	return true;
}

function validaAdmin(){
	if(document.getElementById("usuario").value == ""){
		alert("Ingrese el usuario");
		return false;
	}
	if(document.getElementById("pass").value == ""){
		alert("Ingrese la contraseña");
		return false;
	}
	if(document.getElementById("pass2").value == ""){
		alert("Confirme la contraseña");
		return false;
	}
	if(document.getElementById("rfccorto").value == ""){
		alert("Ingrese el RFC Corto");
		return false;
	}
	if(document.getElementById("admin").value == ""){
		alert("Ingrese la Administración");
		return false;
	}
	if(document.getElementById("nombre").value == ""){
		alert("Ingrese el Nombre");
		return false;
	}
	if(document.getElementById("apeP").value == ""){
		alert("Ingrese el Apellido Paterno");
		return false;
		
	}if(document.getElementById("apeM").value == ""){
		alert("Ingrese el Apellido Materno");
		return false;
	}
	return true;
	
}
function validaRfcElimina(){
    if(document.getElementById("EliminaRFC").value == ""){
        alert("Ingresa el RFC Corto");
        return false;
    }
    return true;
}
function validaRfcModif(){
    if(document.getElementById("BuscaUser").value == ""){
        alert("Ingrese el RFC Corto");
        return false;
    }
    return true;
}
