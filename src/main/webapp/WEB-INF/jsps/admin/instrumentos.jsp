<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="../../../assets/portada.css" />
    <link rel="stylesheet" href="../../../assets/menu.css" />
    <title>Gestionar Instrumentos</title>
  </head>
  <body>
    <jsp:include page="menu.jsp"></jsp:include>
    <h1>Instrumentos</h1>
    <table>
      <tr>
        <th>&nbsp;</th>
        <th>Nombre</th>
        <th>Tipo</th>
        <th>Marca</th>
        <th>Descripcion</th>
        <th>Gamma</th>
        <th>Precio</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
      </tr>
      <c:forEach items="${instrumentos}" var="elemento">
        <tr>
          <td><img src="subidas/{{ elemento.id }}.jpg" height="80px" /></td>
          <td>${elemento.nombre}</td>
          <td>${elemento.tipo }</td>
          <td>${elemento.marca }</td>
          <td class="description">${elemento.desc }</td>
          <td>${elemento.gamma }</td>
          <td>${elemento.precio } euros</td>
          <td class="delete">
            <a
              href="instrumentos-borrar?id={{ id }}"
              class="delLink"
              onclick="return confirm('¿seguro?')"
              >Borrar</a
            >
          </td>
 <td class="edit">
        <a href="instrumentos-editar?id={{id}}" class="editLink" onclick="return confirm('¿seguro?')"
          >Editar</a
        >
      </td>
        </tr>
      </c:forEach>
    </table>
    <div class="annadir">
      <a href="instrumentos-nuevo">Añadir nuevo Instrumento</a>
    </div>

    <!-- <div id="contenedor"></div>
    <div class="annadir">
      <a href="nuevo-instrumento">Añadir nuevo instrumento</a>
    </div>
    <script src="../../../librerias_js/jquery.js"></script>
    <script src="../../../librerias_js/mustache.js"></script>
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
        $.get("../../../plantillas/listado-productos-admin.html").done(
          function (res) {
            html_listado_productos_admin = res;
          }
        );
      }
    </script> -->
  </body>
</html>
