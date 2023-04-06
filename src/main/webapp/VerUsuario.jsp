<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import= "modelo.Usuario" %>
    <%@ page import="modelo.UsuarioModelo" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Esto es ver usuarioJSP
<% Usuario usuario=(Usuario)request.getAttribute("usuario");%>
<table class="table table-dark table-sm">
		<tr>
			<th scope="row">ID</th>
			<th scope="row">NOMBRE</th>
			<th scope="row">PASSWORD</th>
			<th scope="row">FECHA_LOGIN</th>
			<th scope="row">ROL</th>
  
		<tr>
		      <th scope="row"><%out.println(usuario.getId()); %></th>
		      <th scope="row"><%out.println(usuario.getNombre()); %></th>
		      <th scope="row"><%out.println(usuario.getPassword()); %></th>
		      <th scope="row"><%out.println(usuario.getFecha_login()); %></th>
		     
		     
		</tr>
	
</table>

<a href="Principal" class="btn btn-primary">Volver</a>



</body>
</html>
