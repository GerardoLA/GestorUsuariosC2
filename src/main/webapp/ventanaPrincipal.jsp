<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
 
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
 <form action="" method="post">
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">PASSWORD</th>
      <th scope="col">FECHA LOGIN</th>
      <th scope="col">ROL</th>
     
      <th scope="col"></th>
      
    </tr>
  </thead>
   <tbody>
  <c:forEach items="${usuarios}" var="usuario">
 
    <tr>
      	<th scope="row">${usuario.id}</th>
      	<th scope="row">${usuario.nombre}</th>
    	<th scope="row">${usuario.password}</th>
    	<th scope="row">${usuario.fecha_login}</th>
    	<th scope="row">${usuario.rol.nombre}</th>
    	
    	
    	<td><a href="VerUsuario?id=${usuario.id}"; class="btn btn-primary ">Ver</a></td>
    	<td><a href="ModificarUsuarioVent?id=${usuario.id}" class="btn btn-secondary ">Modificar</a></td>
    	<td><a href="EliminarUsuario?id=${usuario.id}" class="btn btn-primary ">Eliminar</a></td>  
    </tr>
</c:forEach>
    
  </tbody>
      <tr>
    	<td><a href="CrearUsuario" class="btn btn-dark">Registrar Usuario nuevo</a></td>
    	<td><a href="BuscarUsuario" class="btn btn-dark">Buscar usuario</a></td>
    </tr>
</table>
</form>
</body>
</html>