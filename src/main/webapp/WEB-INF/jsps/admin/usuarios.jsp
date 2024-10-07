<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
</head>
<body>
 <jsp:include page="menu.jsp"></jsp:include>
    <h1>Usuarios</h1>
    
      <div id="contenedor"></div>

    <script src="../librerias_js/jquery.js"></script>
    <script src="../librerias_js/mustache.js"></script>
    <script>
      function obtenerListadoUsuarioAdmin() {
        $.ajax("obtener-usuarios-json").done(function (respuesta) {
          let usuarios = JSON.parse(respuesta);
          let texto_html = "";
          texto_html = Mustache.render(
        		  html_listado_usuarios_admin,
            usuarios
          );
          $("#contenedor").html(texto_html);
        });
        let html_listado_usuarios_admin = "";
        $.get("../plantillas/listado-usuarios_admin.html").done(
          function (res) {
        	  html_listado_usuarios_admin = res;
          }
        );
      }
      obtenerListadoUsuarioAdmin();
      
    </script> 
</body>
</html>