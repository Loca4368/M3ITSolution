<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Header -->
<%@ include file="../common/header.jspf" %>

<!-- Body -->
<body>
<!-- <jsp:include page="common/navigationbar.jspf" flush="true"></jsp:include> -->
<%@ include file="../common/navigationbar.jspf" %>
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
	<!--<caption>Todo List</caption> -->
	<thead>
		<tr>
			<td><strong>Description</strong></td>
			<td><strong>Target Date</strong></td>
			<td><strong>Status</strong></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items = "${todoList}" var = "todo">
		<tr>
		<td>${todo.desc}</td>
		<td>${todo.targetDate}</td>
		<td>${todo.done}</td>
		<td><spring:url value="/todo/update/${todo.id}" var = "updateUrl"></spring:url>
		<a class ="btn btn-success" href="${updateUrl}">Update</a></td>
		<td><spring:url value="/todo/delete/${todo.id}" var = "deleteUrl"></spring:url>
		<a class ="btn btn-danger" href="${deleteUrl}">Delete</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td><spring:url value="/todo/add" var = "addUrl"></spring:url>
		<a class ="btn btn-success" href="${addUrl}">Add Todo</a></td>
		</tr>
	</tbody>
</table>
</div>
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="../common/footerbar.jspf" %>
<%@ include file="../common/footer.jspf" %>
