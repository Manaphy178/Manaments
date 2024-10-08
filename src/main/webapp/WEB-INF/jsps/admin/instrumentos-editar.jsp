<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="../assets/menu.css" />
    <title>Editar Instrumento</title>
  </head>
  <body>
    <jsp:include page="menu.jsp"></jsp:include>
   <h1>Editar datos del registro:</h1> 
   <springform:form modelAttribute="instrumentoEditar" action="instrumentos-guardar-cambios" enctype="multipart/form-data">

	Nombre: <springform:input path="nombre"/> <br>
	Tipo: <springform:input path="tipo"/> <br>
	Marca: <springform:input path="marca"/> <br>
	Gamma: <springform:input path="gamma"/> <br>
	Description: <springform:textarea path="description" rows="3" cols="12" /> <br>	
	Precio: <springform:input path="precio" /> <br>
	Foto: <br><img height="200px" src="../subidas/${libroEditar.id}.jpg?fum=${libroEditar.ultimaModificacion}"/> <br>
	<springform:input path="foto" type="file" /><br>
	<springform:hidden path="id"/>
	
	<input type="submit" value="ACTUALIZAR INSTRUMENTO">
	
</springform:form>
   
   
    
  </body>
</html>
