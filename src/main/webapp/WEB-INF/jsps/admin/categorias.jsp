<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="../assets/portada.css" />
    <link rel="stylesheet" href="../assets/menu.css" />
<title>Categorias</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h1>Categorias</h1>
 <div id="contenedor"></div>

    <script src="../librerias_js/jquery.js"></script>
    <script src="../librerias_js/mustache.js"></script>
     <table>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Descripcion</th>
      
        <th>&nbsp;</th>
        <th>&nbsp;</th>
      </tr>
      <c:forEach items="${categorias}" var="elemento">
        <tr>
          
          <td>${elemento.id}</td>
          <td>${elemento.nombre }</td>
          <td>${elemento.descripcion }</td>
          <td class="delete">
            <a
              href="categoria-borrar?id=${elemento.id }"
              class="delLink"
              onclick="return confirm('¿seguro?')"
              >Borrar</a
            >
          </td>
          <td class="edit">
            <a
              href="categoria-editar?id=${elemento.id }"
              class="editLink"
              >Editar</a
            >
          </td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>