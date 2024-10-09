<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Manaments</title>
<link rel="stylesheet" href="assets/portada.css" />
</head>
<body>
	<h1>Bienvenido a mi tienda de instrumentos</h1>
	<div class="adminBox">
		<a href="admin/"> Acceder a administracion </a>
	</div>
	<div style="margin: 10px">
		<a href="#" id="menu-inicio">inicio</a> <a href="#"
			id="menu-identificarme">identificarme</a> <a href="#"
			id="menu-registrarme">registrarme</a> <a href="#" id="menu-carrito">carrito</a>
		<a href="#" id="menu-mis-pedidos">mis pedidos</a> <a href="#"
			id="menu-mis-datos">mis datos personales</a>
	</div>
	<div id="contenedor"></div>
	<script src="librerias_js/jquery.js"></script>
	<script src="librerias_js/mustache.js"></script>
	<script>
		function obtenerProductos() {
			$.ajax("obtener-productos-json").done(
					function(respuesta) {
						let instrumento = JSON.parse(respuesta);

						let texto_html = "";
						texto_html = Mustache.render(html_listado_productos,
								instrumento);

						$("#contenedor").html(texto_html);
					}); //end ajax
		}

		function enviarInfoUsuarioAlServidor() {
			let nombre = $("#nombre").val();
			let apellido = $("#apellido").val();
			let nomUsuario = $("#nomUsuario").val();
			let email = $("#email").val();
			let pass = $("#pass").val();
			let codPostal = $("#codPostal").val();
			//falta validar los datos antes de mandarlos a ServicioUsuarios
			$.post("registrar-usuario-cliente", {
				nombre : nombre,
				apellido : apellido,
				nomUsuario : nomUsuario,
				email : email,
				pass : pass,
				codPostal : codPostal,
			}).done(function(res) {
				alert(res);
			});
		} //end enviarInfoUsuarioAlServidor

		//operaciones del menu:
		$("#menu-inicio").click(obtenerProductos);
		$("#menu-registrarme").click(mostrarFormularioRegistroUsuario);
		//fin operaciones del menu
		let html_formulario_registro_usuario = "";
		let html_listado_productos = "";

		// Vamos a descargar todas las plantillas
		$.get("plantillas/formulario-registro-usuario.html").done(
				function(res) {
					html_formulario_registro_usuario = res;
				});
		$.get("plantillas/listado-productos.html").done(function(res) {
			html_listado_productos = res;
		});
		//operaciones con plantillas
		function mostrarFormularioRegistroUsuario() {
			$("#contenedor").html(html_formulario_registro_usuario);
			$("#boton_registro_usuario").click(enviarInfoUsuarioAlServidor);
		}
		//fin operaciones con plantillas
		obtenerProductos();
	</script>
</body>
</html>
