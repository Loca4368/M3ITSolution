<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>About</title>
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
<form method ="post">
	<fieldset class="form-group">
	<label>Description</label>
	<input type="text" name ="desc" class="control" required ="required"/>
	<label>Number</label>
	<input type="text" name ="number" class="control" />
	<label>Complete Date</label>
	<input type="text" name ="date" class="control" pattern="\d{1,2}/\d{1,2}/\d{4}"/>
	</fieldset>
	<input type="submit" value="Add" class="btn btn-success">
</form>
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