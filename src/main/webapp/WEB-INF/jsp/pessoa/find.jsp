<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/estilo.css"/>
<title>Buscar pessoas</title>
</head>
<body>
<div class="container-fluid">
	<h2 align=center>Buscar pessoas</h2>
	<br>	
	<div class="row" align=center>
		<form action="/pessoa/find/name/">
			<label align=center>Busca por nome: <input type="text" name="nome" class="form-control"></label>
			<button type="submit" class="btn btn-secundary"> 
			Buscar &nbsp<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	<br>
	<div class="row" align=center>
		<form action="/pessoa/find/address/">
			<label align=center>Busca por endereço: <input type="text" name="endereco" class="form-control"></label>
			<button type="submit" class="btn btn-secundary">
			Buscar &nbsp<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	<br>
	<div class="row" align=center>
		<form action="/pessoa/find/birthday/">
			<label align=center>Busca por data de nascimento: <input type="text" name="nascimento" class="form-control"></label>
			<button type="submit" class="btn btn-secundary">
			Buscar &nbsp<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</button>
		</form>
	</div>
	<br>
	<div align=center>
		<button type="button" class="btn btn-secundary" onclick="window.location.href='/pessoa/list/'">
		<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&nbsp Voltar</button>
	</div>
</div>
</body>
</html>