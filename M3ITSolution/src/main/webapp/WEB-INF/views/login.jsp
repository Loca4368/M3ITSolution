<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 <!--  <p><font color="red">${errorMessage}</font></p> -->
 <p><font color="red"></font><spring:message code="error.message"/></p>
 <form action="/login" method ="post" class="form-signin">
 <fieldset class ="form-group" >
 	<label>Name :</label> <input name="username" type="text" class="control" required="required"/><label>Password : </label><input name="password" type="password" class="control" required="required"/> 
 </fieldset>
 	<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
 	<input type="submit" />
 </form>
 </div>
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="common/footerbar.jspf" %>
<%@ include file="common/footer.jspf" %>