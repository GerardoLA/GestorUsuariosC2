<%@ page import="modelo.Rol"%>
<%@ page import="java.util.ArrayList" %>
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




<form method="post" action="CrearUsuario ">
	<input type="text" name="nombre"  placeholder="usuario"/><br>
	<br>
	<input type="text" name="password"  placeholder="password"/><br>
	<br>
	<input type="date" name="fecha_login"  placeholder="fecha_login"/><br>
	<br>
	
	<input type=submit value="Crear"/>
</form>
</body>
</html>
