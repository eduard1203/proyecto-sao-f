// VALIDACIÓN PARA ADD USER
//Creamos la función validar
function validate(elemento) {
	//Creamos variables
	var nombre, apellido, especialidad, email, cemail, direccion, ciudad, pais,
	codigo, celular, nacimiento, ingreso, usuario, contraseña, ccontraseña,
	descripcion, enviar;
	nombre = document.getElementById("nombre").value;
	apellido = document.getElementById("apellido").value;
	tipo = document.getElementById("tipo").value;
	email = document.getElementById("email").value;
	cemail = document.getElementById("cemail").value;
	direccion = document.getElementById("direccion").value;
	ciudad = document.getElementById("ciudad").value;
	pais = document.getElementById("pais").value;
	codigo = document.getElementById("codigo").value;
	celular = document.getElementById("celular").value;
	nacimiento = document.getElementById("nacimiento").value;
	ingreso = document.getElementById("ingreso").value;
	usuario = document.getElementById("usuario").value;
	contraseña = document.getElementById("contraseña").value;
	ccontraseña = document.getElementById("ccontraseña").value;
	descripcion = document.getElementById("descripcion").value;
	//Variable expresión para indicar cada entrada de un email
	expresion = /\w+@\w+\.+[a-z]/;
	
	//Condicionales y alertas
	if (nombre=== '' || apellido=== '' || tipo=== '' || email=== '' ||
		cemail=== '' || direccion=== '' || ciudad=== '' || pais=== '' ||
		codigo=== '' || celular=== '' || nacimiento=== '' || ingreso=== '' || 
		usuario=== '' || contraseña=== '' || ccontraseña=== '' || 
		descripcion=== '') {
		alert("Todos los campos del formulario son obligatorios!");
		return false;
	}
	//Si nombre es mayor de 40 caracteres(con espacios), se manda alerta
	else if (nombre.length>40) {
		alert("El nombre es muy largo");
		return false;
	}
	//Si apellido es mayor de 40 caracteres(con espacios), se manda alerta
	else if (apellido.length>40) {
		alert("Los apellidos son muy largos");
		return false;
	}
	//Si nombre es mayor de 40 caracteres(con espacios), se manda alerta
	else if (tipo.length>40) {
		alert("El tipo de usuario es muy largo");
		return false;
	}
	
	//Si email es mayor de 100 caracteres(con espacios), se manda alerta
	else if (email.length>100) {
		alert("El correo es muy largo");
		return false;
	}
	//Se revisa la expresión que declaramos para correo
	//Si no se cumple, se envia alerta
	else if (!expresion.test(email)) {
		alert("El correo no es valido");
		return false;
	}
	//Si la confirmación del correo es mayor de 100 caracteres(con espacios), se manda alerta
	else if (cemail.length>100) {
		alert("El correo es muy largo");
		return false;
	}
	//Se revisa la expresión que declaramos para correo
	//Si no se cumple, se envia alerta
	else if (!expresion.test(cemail)) {
		alert("El correo no es valido");
		return false;
	}
	//Si dirección es mayor de 30 caracteres(con espacios), se manda alerta
	else if (direccion.length>30) {
		alert("La dirección es muy larga");
		return false;
	}
	//Si ciudad es mayor de 30 caracteres(con espacios), se manda alerta
	else if (ciudad.length>30) {
		alert("El nombre de la ciudad es muy largo");
		return false;
	}
	//Si país es mayor de 30 caracteres(con espacios), se manda alerta
	else if (pais.length>30) {
		alert("El nombre del país es muy largo");
		return false;
	}
	//Si código es mayor de 30 caracteres(con espacios), se manda alerta
	else if (codigo.length>30) {
		alert("El código es muy largo");
		return false;
	}
	//Si celular es mayor de 30 caracteres(con espacios), se manda alerta
	else if (celular.length>30) {
		alert("El número celular es muy largo");
		return false;
	}
	//Si nacimiento es mayor de 30 caracteres(con espacios), se manda alerta
	else if (nacimiento.length>30) {
		alert("La fecha de nacimiento es muy larga");
		return false;
	}
	//Si ingreso es mayor de 30 caracteres(con espacios), se manda alerta
	else if (ingreso.length>30) {
		alert("La fecha de ingresi es larga");
		return false;
	}
	//Si usuario es mayor de 30 caracteres(con espacios), se manda alerta
	else if (usuario.length>30) {
		alert("El nombre de usuario es muy largo");
		return false;
	}
	//Si contraseña es mayor de 30 caracteres(con espacios), se manda alerta
	else if (contraseña.length>16) {
		alert("La contraseña es muy larga");
		return false;
	}else if (contraseña.length<8) {
		alert("La contraseña es muy corta");
		return false;
	}
	
	//Si la confirmación de la contraseña es mayor de 30 caracteres(con espacios), se manda alerta
	else if (ccontraseña.length!== contraseña.length) {
		alert("La confirmacion de la contraseña es errada");
	}
	else if (ccontraseña.length>16) {
		alert("La confirmación de la contraseña es muy larga");
		return false;
	}else if (ccontraseña.length<8) {
		alert("La confirmación de la contraseña es muy corta")
	}


	//Si mensaje es mayor de 1000 caracteres(con espacios), se manda alerta.
	else if (descripcion.length>1000) {
		alert("La descripción es muy larga");
		return false;
	}
	else {
		alert("Datos registrados correctamente!")
	}
}