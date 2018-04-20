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
	<h3>Alterar Usuario - ${usuario.id}</h3>
	<form action="alteraUsuario" method="post">
		
		<input type="hidden" name="id" value="${usuario.id}"/>
		Usuario: <input type="text" name="usuario" value="${usuario.usuario}"/><br/>
		Senha: <input type="text" name="senha" value="${usuario.senha}"/><br/>
		E-mail: <input type="text" name="email" value="${usuario.email}"/><br/>
		Perfil: <input type="text" name="perfil" value="${usuario.perfil}"/><br/>
				
		<br /> <input type="submit" value="Alterar" />
	</form>
</body>
</html>