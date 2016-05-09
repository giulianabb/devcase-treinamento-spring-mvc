<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ver pessoa</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="/css/estilo.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<div class="container-fluid" align=center>
	<h2>Detalhes</h2>
	<br>
	<div>
		<label>Nome:</label> ${pessoa.nome} <br>
		<label>Endereço:</label> ${pessoa.endereco} <br>
		<label>Data Nascimento:</label> <fmt:formatDate value="${pessoa.dataNascimento}" pattern="dd/MM/yyyy"/> <br>
		<label>Sexo:</label> ${pessoa.sexo}
	</div>
	<br>
	<br>
	<button type="button" class="btn btn-primary" onclick="window.location.href='/pessoa/list/'">
	<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&nbsp Voltar</button>
</div>
</body>
</html>