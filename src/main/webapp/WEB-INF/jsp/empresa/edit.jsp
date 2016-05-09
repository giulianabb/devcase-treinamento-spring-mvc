<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${empty empresa.id ? "Criar" : "Editar" } empresa</title>
</head>
<body>

<h2>${empty empresa.id ? "Criar" : "Editar" } empresa</h2>

<form action="/empresa/save/${empresa.id}" method="POST">
	<label>Nome: <input type="text" name="nome" value="${empresa.nome}"/></label><br>
	<label>Data de criação: <input type="text" name="dataDeCriacao" value='<fmt:formatDate value="${empresa.dataDeCriacao}" pattern="dd/MM/yyyy"/>'/></label><br>
	<input type="submit" value="Salvar"/>
</form>

</body>
</html>