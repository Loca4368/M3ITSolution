<!-- Header -->
<%@ include file="common/header.jspf" %>

<!-- Body -->
<body>
<!-- <jsp:include page="common/navigationbar.jspf" flush="true"></jsp:include> -->
<%@ include file="common/navigationbar.jspf" %>
<br>
<br>
<br>
<div class ="container">
<h4>Register Form</h4>
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
<%@ include file="common/footerbar.jspf" %>
<%@ include file="common/footer.jspf" %>