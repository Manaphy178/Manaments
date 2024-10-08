<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Instrumento</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<springform:form modelAttribute="nuevoInstrumento" action="instrumentos-guardar-nuevo" enctype="multipart/form-data">

	Nombre: <springform:input path="nombre"/> <br>
	Tipo: <springform:input path="tipo"/> <br>
	Marca: <springform:input path="marca"/> <br>
	Gamma: <springform:input path="gamma"/> <br>
	Description: <springform:textarea path="description" rows="3" cols="12" /> <br>	
	Foto: <springform:input path="foto" type="file" /> <br>
	Precio: <springform:input path="precio" /> <br>
	
	<input type="submit" value="REGISTRAR INSTRUMENTO">
	
</springform:form>
</body>
</html>