<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
	<a href="formularioUsuario">Criar novo Usuario</a>
	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Usuario</th>
			<th>E-mail</th>
			<th>Perfil</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.usuario}</td>
				<td>${usuario.email}</td>
				<td>${usuario.perfil}</td>
				<td><a href="mostraUsuario?id=${usuario.id}">Alterar</a></td>
				<td><a href="removeUsuario?id=${usuario.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>