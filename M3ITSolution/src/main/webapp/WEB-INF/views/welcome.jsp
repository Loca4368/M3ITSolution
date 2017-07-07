<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Home</title>
</head>
<body>
<!-- Header -->
<jsp:include page="header.jsp" flush="true"></jsp:include>
<br>
<br>
<br>
<!-- Body -->
<div class ="container">
<div class = "page-header">
<h4><a href="/todo">Manage Your Todos</a></h4>
</div>
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