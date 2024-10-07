<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="../assets/portada.css" />
    <link rel="stylesheet" href="../assets/menu.css" />
    <title>Gestionar Instrumentos</title>
  </head>
  <body>
    <jsp:include page="menu.jsp"></jsp:include>
    <h1>Instrumentos</h1>

    <!-- <div id="contenedor"></div>
    <div class="annadir">
      <a href="instrumentos-nuevo">Añadir nuevo instrumento</a>
    </div>
    <script src="../librerias_js/jquery.js"></script>
    <script src="../librerias_js/mustache.js"></script>
    <script>
      function obtenerListadoAdmin() {
        $.ajax("obtener-productos-json").done(function (respuesta) {
          let instrumentos = JSON.parse(respuesta);
          let texto_html = "";
          texto_html = Mustache.render(
            html_listado_productos_admin,
            instrumentos
          );
          $("#contenedor").html(texto_html);
        });
        let html_listado_productos_admin = "";
        $.get("../plantillas/listado-productos-admin.html").done(
          function (res) {
            html_listado_productos_admin = res;
          }
        );
      }
    </script> -->
    <table>
      <tr>
        <th>&nbsp;</th>
        <th>Nombre</th>
        <th>Tipo</th>
        <th>Marca</th>
        <th>Descripcion</th>
        <th>Gamma</th>
        <th>Precio</th>
        <th>Ultima modificacion</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
      </tr>
      <c:forEach items="${instrumentos}" var="elemento">
        <tr>
          <td ><img src="../subidas/${ elemento.id }.jpg?fum=${elemento.ultimaModificacion}" height="80px" /></td>
          <td>${elemento.nombre}</td>
          <td>${elemento.tipo }</td>
          <td>${elemento.marca }</td>
          <td class="description">${elemento.desc }</td>
          <td>${elemento.gamma }</td>
          <td>${elemento.precio } euros</td>
          <td>${elemento.ultimaModificacion }</td>
          <td class="delete">
            <a
              href="instrumentos-borrar?id=${elemento.id }"
              class="delLink"
              onclick="return confirm('¿seguro?')"
              >Borrar</a
            >
          </td>
          <td class="edit">
            <a
              href="instrumentos-editar?id=${elemento.id }"
              class="editLink"
              >Editar</a
            >
          </td>
        </tr>
      </c:forEach>
    </table>
    <div class="annadir">
      <a href="instrumentos-nuevo">Añadir nuevo Instrumento</a>
    </div>
  </body>
</html>
