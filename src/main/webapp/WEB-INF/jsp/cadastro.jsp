<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Autor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
</head>
<body class="container">

	<table class="table table-bordered mt-2">

		<thead>
			<tr>
				<th class="table-secondary" scope="col">
					<h1 class="text-center">Cadastro de Autor</h1>
				</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>
					<form action="<c:url value="/cadastro"/>" method="post">
						<div>
							<label for="nome" class="form-label mt-1">Nome</label> <input
								id="nome" class="form-control" name="nome">
						</div>
						<div class="form-group">
							<label for="email" class="form-label">E-mail</label> <input
								id="email" class="form-control" name="email">
						</div>
						<div class="form-group">
							<label for="dataNascimento" class="form-label">Data de
								nascimento</label> <input id="dataNascimento" class="form-control"
								name="dataNascimento">
						</div>
						<div class="form-group">
							<label for="miniCurriculo" class="form-label">Mini-currículo</label>
							<textarea rows="2" cols="179"></textarea>
							
							<input type="submit" value="Cadastrar" class="mt-2 btn-primary">
						</div>
					</form>
				</td>
			</tr>
		</tbody>
	</table>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th class="table-secondary" scope="col">
					<h1 class="text-center">Cadastro de Autor</h1>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Data nascimento</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${autores}" var="autor">
								<tr class="table-secondary">
									<td>${autor.nome}</td>
									<td>${autor.email}</td>
									<td>${autor.dataNascimento}</td>
									<!--<td>${autor.miniCurriculo}</td>-->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>