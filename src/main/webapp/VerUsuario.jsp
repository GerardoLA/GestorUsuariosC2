<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import= "modelo.Usuario" %>
    <%@ page import="modelo.UsuarioModelo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Esto es ver usuarioJSP
<% Usuario usuario=(Usuario)request.getAttribute("usuario");%>
<table class="table">
  
		<tr>
		      <th scope="row"><%out.println(usuario.getId()); %></th>
		      <th scope="row"><%out.println(usuario.getNombre()); %></th>
		      <th scope="row"><%out.println(usuario.getPassword()); %></th>
		</tr>
	
</table>





</body>
</html>