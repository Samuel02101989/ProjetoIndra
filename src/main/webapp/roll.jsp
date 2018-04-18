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

	<h2>Distribuir seus dados cadastrais</h2>

	<form action="roll" method="POST">

		<h2 align="center">Register User - Indra</h2>

		<div>
			<!-- Cadastra Roll -->
			<label>Description Roll</label> <input type="text" name="descriptionRoll" /> 
			<br> 
			<label>Base Salary </label> <input type="text" name="base_salary" /> 
			<br> 
		</div>
		<button type="submit">Save Roll</button>
	</form>
</body>
</html>