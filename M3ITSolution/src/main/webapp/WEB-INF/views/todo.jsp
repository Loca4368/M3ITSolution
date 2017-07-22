<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Header -->
<%@ include file="common/header.jspf" %>

<!-- Body -->
<body>
<!-- <jsp:include page="common/navigationbar.jspf" flush="true"></jsp:include> -->
<%@ include file="common/navigationbar.jspf" %>
<br>
<br>
<br>
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
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
		<td>${todo.done}</td>
		<td><a class ="btn btn-success" href="update-todo?id=${todo.id}">Update</a></td>
		<td><a class ="btn btn-danger" href="delete-todo?id=${todo.id}">Delete</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td><a class ="btn btn-success" href="addtodo">Add Todo</a></td>
		</tr>
	</tbody>
</table>
</div>
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="common/footerbar.jspf" %>
<%@ include file="common/footer.jspf" %>
