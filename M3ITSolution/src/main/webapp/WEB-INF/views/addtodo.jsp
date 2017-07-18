<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>AddtoDo</title>
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
<h4>Add Todo</h4>
</div>
<form:form method ="post" commandName="todo">
	<form:hidden path="id"/>
	<form:hidden path="user"/>
	<fieldset class="form-group">
	<form:label path="desc">Description</form:label>
	<form:input path ="desc" type="text"  class="control" required ="required"></form:input>
	<form:errors path ="desc" cssClass ="text-warning"></form:errors>
	<!-- 
	<label>Number</label>
	<input type="text" name ="number" class="control" />
	<label>Complete Date</label>
	<input type="text" name ="date" class="control" pattern="\d{1,2}/\d{1,2}/\d{4}"/>
	 -->
	</fieldset>
	<input type="submit" value="Submit" class="btn btn-success">
</form:form>
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