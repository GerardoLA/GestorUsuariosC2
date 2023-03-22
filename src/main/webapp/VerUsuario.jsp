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
<%
ArrayList<Usuario>usuarios=(ArrayList<Usuario>)request.getAttribute("usuarios");

%>
<table class="table">
<thead>
<tr></tr>
</table>
<% for (Usuario usuario : usuarios) {
	out.println(usuario);
}%>


</body>
</html>