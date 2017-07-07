<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Sign Up</title>
</head>
<body>
<!-- Header -->
<jsp:include page="header.jsp" flush="true"></jsp:include>
<br>
<br>
<br>
<!-- Body -->
<div class ="container">
 <p><font color="red">${errorMessage}</font></p>
 <form action="/login" method ="post">
 <fieldset class ="form-group">
 	<label>Name :</label> <input name="name" type="text" class="control" required="required"/><label>Password : </label><input name="password" type="password" class="control" required="required"/> 
 </fieldset>
 	<input type="submit" />
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