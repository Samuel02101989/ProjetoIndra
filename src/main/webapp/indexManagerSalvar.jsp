
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
	<h1>Sistema de gereciamentos de RH-Jovens Profissionais</h1>


	<form action="Manager" method="POST">
	

		<h2 align="center">Registrar Gerente</h2>

			<label>Nome</label> <input type="text" name="name" />
			<br> 
			<label>Documento</label> <input type="text" name="doc" />
			<br>
			<label>Matricula</label> <input type="text" name="registration" />
			<br>
			<label>Email</label> <input type="text" name="email" />
			<br>
			<label>Cidade</label> <input type="text" name="city" />
			<br>
			<label>Genero</label> <input type="text" name="genre" />
			<br>
			<label>Senha</label> <input type="text" name="password" />
			<br>
			<label>Login</label> <input type="text" name="login" />
			<br>
			<label>Descrição</label> <input type="text" name="description" />
			<br>
			<label>Permissão</label> <input type="text" name="permission" />
			
			

		</div>
		<button type="submit">Salvar</button>
	</form>
</body>
</html>