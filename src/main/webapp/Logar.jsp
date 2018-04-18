<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0px
}

.container {
	width: 100vm;
	height: 100vh;
	background: #7093DB;
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-content: center;
}

.box {
	width: 300px;
	height: 300px;
	background: #fff;
	border-radius: 10px;
	margin-top: 100px;
}

.cent {
	align-content: center;
	margin-bottom: 20px;
	margin-left: 50px;
	margin-right: 20px;
	margin-top: 30px;
}.botton {
	align-content: center;
	margin-left: 50px;
	margin-right: 100px;
}
</style>

</head>

<body>

	<div class="container">

		<div class="box">
		
			<form id="form_cadastro" action="user" method="Get">
			
			<h2 align="center">Indra Company</h2>
			
				<label>Usuario: </label>
				<input type="text" name="usuario">
				<br>
				<label>Senha: </label>
				<input type="password"name="senha">
				<br>
				<br>
				<button id="btn_enviar" class="btn btn-primary" type="submit">Logar</button>
				
			</form>                                                                                                          
			
			
		</div>
	</div>

</body>

</html>