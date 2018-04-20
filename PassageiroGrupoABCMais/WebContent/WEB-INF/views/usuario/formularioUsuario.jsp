<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
	<h3>Adicionar Usuario</h3>
	<form action="adicionaUsuario" method="post">
		Dados: <br />
		Nome de usuário<input type="text" name="usuario"/> <br />
		Senha: <input type="password" name="senha"/> <br />
		E-mail: <input type="text" name="email"/> <br />
		Perfil: <input type="text" name="perfil"/> <br />
		<br /> <input type="submit" value="Adicionar"> <br />
	</form>

</body>
</html>