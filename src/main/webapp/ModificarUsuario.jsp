<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form Action ="ModificarUsuario" >
<input type = "hidden" name= "id" value="${usuario.id}" >${usuario.id}
	<input type="text" name="nombre"  placeholder="usuario" value="${usuario.nombre}"/><br>
	<br>
	<input type="password" name="password" placeholder="password" value="${usuario.password}"/><br>
	<br>
	<input type="date" name="fecha_login" placeholder="fecha.login" value="${usuario.fecha_login}"/><br>
	<br>
	<input type=submit value="Modificar"/>

</form>
		<a href="Principal" class="btn">Volver</a>
</body>
</html>
