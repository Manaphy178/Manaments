<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="../assets/portada.css" />
    <link rel="stylesheet" href="../assets/menu.css" />
<title>Usuarios</title>
</head>
<body>
 <jsp:include page="menu.jsp"></jsp:include>
    <h1>Usuarios</h1>
    
      <div id="contenedor"></div>

    <script src="../librerias_js/jquery.js"></script>
    <script src="../librerias_js/mustache.js"></script>
   <table>
      <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Nombre Usuario</th>
        <th>Email</th>
        <th>Contraseña</th>
        <th>Codigo Postal</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
      </tr>
      <c:forEach items="${usuarios}" var="elemento">
        <tr>
          
          <td>${elemento.nombre}</td>
          <td>${elemento.apellido }</td>
          <td>${elemento.nomUsuario }</td>
          <td>${elemento.email }</td>
          <td>${elemento.pass }</td>
          <td>${elemento.codPostal }</td>
          <td class="delete">
            <a
              href="usuario-borrar?id=${elemento.id }"
              class="delLink"
              onclick="return confirm('¿seguro?')"
              >Borrar</a
            >
          </td>
          <td class="edit">
            <a
              href="usuario-editar?id=${elemento.id }"
              class="editLink"
              >Editar</a
            >
          </td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>