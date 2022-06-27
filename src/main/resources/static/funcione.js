function elimina(id_ingreso){
	swal({
		title: "Estas seguro de eliminar?",
		text: "Se eliminara el ingreso seleccionado!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/elimina/"+id_ingreso,
					success: function(res){
						console.log(res);
					},					
				});
				swal("Poof! El ingreso ha sido eliminado", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/ingresos";
					}
				});
			} else {
				swal("el ingreso no se ha eliminado!");
			}
		});
	
}