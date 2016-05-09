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
<title>Pessoas ${find ? "encontradas" : "cadastradas"}</title>
</head>


<body>
<div class="container-fluid"> 
	<nav class="navbar">
			<h3 align=center>Pessoas ${find ? "encontradas" : "cadastradas"}</h3>
	</nav>
	<table class="table text-center table-condensed table-responsive">
		<thead>
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">Nome</th>
				<th class="text-center">Endereço</th>
				<th class="text-center">Sexo</th>
				<th class="text-center">Data de nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="pessoa">
				<tr>
					<td><a href='/pessoa/edit/${pessoa.id}'>${pessoa.id}</a></td>
					<td>${pessoa.nome}</td>
					<td>${pessoa.endereco}</td>
					<td>
						<c:choose>
							<c:when test="${pessoa.sexo eq 'M'}">Masculino</c:when>
							<c:when test="${pessoa.sexo eq 'F'}">Feminino</c:when>
							<c:when test="${empty pessoa.sexo}">Não informado</c:when>
							<c:otherwise>Valor inválido</c:otherwise>
						</c:choose>
					</td>
					<td><fmt:formatDate value="${pessoa.dataNascimento}" pattern="dd/MM/yyyy"/> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${find}">
		<div align=center>
			<br>
			<button type="button" class="btn btn-secundary" onclick="window.location.href='/pessoa/list/'">
			<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&nbsp Voltar</button>
		</div>
	</c:if>
	<c:if test="${not find}">
		<br>
		<div class="text-center">
		<button type="button" class="btn btn-primary" onclick="window.location.href='/pessoa/create'">
		Adicionar nova pessoa  &nbsp<span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
		&nbsp
		<button type="button" class="btn btn-primary" onclick="window.location.href='/pessoa/filter'">
		Buscar pessoa  &nbsp<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
		</div>
		<br><br>
	</c:if>
</div>
</body>
</html>