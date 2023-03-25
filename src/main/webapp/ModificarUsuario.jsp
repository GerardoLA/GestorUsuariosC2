<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<form Action ="ModificarUsuario" >

<input type = "hidden" name= "id" value="<%= usuario.getId() %>" ><%= usuario.getId() %>
	<input type="text" name="nombre"  placeholder="usuario" value="<%=usuario.getNombre()%>"/><br>
	<br>
	<input type="password" name="password" placeholder="password" value="<%=usuario.getPassword()%>"/><br>
	<br>
	<input type=submit value="Modificar"/>

</form>

	<a href="VerUsuarios" class="btn">Volver</a>

</body>
</html>