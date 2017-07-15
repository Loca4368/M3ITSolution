<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Header -->
<jsp:include page="header.jsp" flush="true"></jsp:include>
<br>
<br>
<br>
<!-- Body -->
<div class =container>
<div class = "page-header">
<h4>Your Todo List</h4>
</div>
</div>
<div class ="container">
<table class ="table table-striped">
	<caption>Todo List</caption>
	<thead>
		<tr>
			<td>Description</td>
			<td>Target Date</td>
			<td>Status</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items = "${todos}" var = "todo">
		<tr>
		<td>${todo.desc}</td>
		<td>${todo.targetDate}</td>
		<td>${todo.done}</td>
		<td><a class ="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
		<td><a class ="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td><a class ="btn btn-success" href="/addtodo">Add Todo</a></td>
		</tr>
	</tbody>
</table>
</div>
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="footer.jsp" %>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>