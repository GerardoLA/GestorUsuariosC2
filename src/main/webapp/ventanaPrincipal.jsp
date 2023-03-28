<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<% ArrayList<Usuario>usuarios = (ArrayList<Usuario>)request.getAttribute("usuarios"); %>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">PASSWORD</th>
      <th scope="col"></th>
      
    </tr>
  </thead>
   <tbody>
  <%for(Usuario usuario : usuarios) {%>
 
    <tr>
      	<th scope="row"><%out.println(usuario.getId()); %></th>
      	<th scope="row"><%out.println(usuario.getNombre()); %></th>
    	<th scope="row"><%out.println(usuario.getPassword()); %></th>
    	<th scope="row"><%out.println(usuario.getFecha_login()); %></th>
    	<td><a href="VerUsuario?id=<%out.println(usuario.getId()); %>" class="btn btn-primary ">Ver</a></td>
    	<td><a href="ModificarUsuarioVent?id=<%out.println(usuario.getId()); %>" class="btn btn-secondary ">Modificar</a></td>
    	<td><a href="EliminarUsuario?id=<%out.println(usuario.getId()); %>" class="btn btn-primary ">Eliminar</a></td>  
    </tr>

   <%} %>
  </tbody>
      <tr>
    	<td><a href="CrearUsuario" class="btn btn-dark">Registrar Usuario nuevo</a></td>
    </tr>
</table>
</body>
</html>