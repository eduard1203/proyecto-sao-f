function eliminar(id){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el vehiculo seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminar/"+id,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El vehiculo ha sido eliminado", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/registro_vehiculos";
					}
				});
			} else {
				swal("el vehiculo no se ha eliminado!");
			}
		});
	
}


function elimin(Doc_Usuario){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el usuario seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/elimin/"+Doc_Usuario,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El usuario ha sido eliminado", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/registros_usuarios";
					}
				});
			} else {
				swal("el usuario no se ha eliminado!");
			}
		});
	
}

function elimi(Id_Egreso){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el egreso seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/elimi/"+Id_Egreso,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El egreso ha sido eliminado", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/egresos";
					}
				});
			} else {
				swal("el egreso no se ha eliminado!");
			}
		});
	
}

function elim(id_alquiler){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el alquiler seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/elim/"+id_alquiler,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El alquiler ha sido eliminado", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/alquiler";
					}
				});
			} else {
				swal("el alquiler no se ha eliminado!");
			}
		});
	
}

function eli(Id_pago){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el pago seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eli/"+Id_pago,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El pago ha sido eliminado", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/pagos";
					}
				});
			} else {
				swal("El pago no se ha eliminado!");
			}
		});
	
}

function eliminarsoli(Id_solicitud){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara la solicitud seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarsoli/"+Id_solicitud,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! La solicitud ha sido eliminado", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/solicitudes";
					}
				});
			} else {
				swal("La solicitud no se ha eliminado!");
			}
		});
	
}

function eliminarnovedad(Id_novedad){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara la novedad seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarnovedad/"+Id_novedad,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! La novedad ha sido eliminada", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/registro_novedad";
					}
				});
			} else {
				swal("La novedad no se ha eliminado!");
			}
		});
	
}

function eliminarcorrespondencia(Id_correspondencia){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara la correspondencia seleccionada!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarcorrespondencia/"+Id_correspondencia,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! La correspondencia ha sido eliminada", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/registro_correspondencia";
					}
				});
			} else {
				swal("La correspondencia no se ha eliminado!");
			}
		});
	
}

function eliminaringresovehiculo(Id_vehingreso){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el ingreso del vehiculo seleccionada!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminaringresovehiculo/"+Id_vehingreso,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El ingreso del vehiculo  ha sido eliminada", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/ingreso_vehiculo";
					}
				});
			} else {
				swal("El ingreso del vehiculo  no se ha eliminado!");
			}
		});
	
}

function eliminardetallebahia(Id_Detalle_Bahia){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el detalle de la bahia seleccionada!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminardetallebahia/"+Id_Detalle_Bahia,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El detalle de la bahia ha sido eliminada", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/registro_bahia";
					}
				});
			} else {
				swal("el detalle de la bahia no se ha eliminado!");
			}
		});
	
}

