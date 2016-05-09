<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${empty pessoa.id ? "Criar" : "Editar"} pessoa</title>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/css/estilo.css"/>
</head>
<body>
<div class="container-fluid text-center">
<h2>${empty pessoa.id ? "Criar" : "Editar"} pessoa</h2>
 <br>
<form action="/pessoa/save/${pessoa.id}" method="POST" class="form-horizontal">
	<div>
		<label align=left>Nome: <input type="text" name="nome" value="${pessoa.nome}" class="form-control"/></label><br/>
	</div>
	<div>
		<label align=left>Endereço: <input type="text" name="endereco" value="${pessoa.endereco}" class="form-control"></label><br>
	</div>
	<div>
		<label align=left>Data Nascimento: <input type="text" name="dataNascimento" class="form-control" value='<fmt:formatDate value="${pessoa.dataNascimento}" pattern="dd/MM/yyyy"/>'/></label><br/>
	</div>
	<div>
		<label>Sexo:</label>
		<label class="radio-inline">
			<input type="radio" name="sexo" class="radio-inline" value="M" ${pessoa.sexo == "M" ? "checked" : ""}> Masculino 
		</label>
		<label class="radio-inline">
			<input type="radio" name="sexo" class="radio-inline" value="F" ${pessoa.sexo == "F" ? "checked" : ""}> Feminino 
		</label>
	</div>
	<br>
	<button type="submit" class="btn btn-primary" value="Salvar">
	Salvar &nbsp<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span></button>
	<c:if test="${not empty pessoa.id}">
	<button type="button" class="btn btn-danger" onclick="window.location.href='/pessoa/delete/${pessoa.id}'">
	Excluir &nbsp<span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button><br><br>
	</c:if>
	<button type="button" class="btn btn-secundary" onclick="window.location.href='/pessoa/list/'">
	<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&nbsp Voltar</button>
</form>
<br>

</div>
</body>
</html>
