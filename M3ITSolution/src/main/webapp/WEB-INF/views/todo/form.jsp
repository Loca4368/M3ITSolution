<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<h4>Add Todo</h4>
</div>
<spring:url  value = "/todo/save" var = "saveUrl"/>
<form:form action = "${saveUrl}" method ="post"  modelAttribute = "todoForm">
	<form:hidden path="id"/>
	<fieldset class="form-group">
		<form:label path="desc">Description</form:label>
		<form:input path ="desc" type="text"  class="form-control" required ="required" />
		<form:errors path="desc" cssClass="text-warning" />
	</fieldset>
	<fieldset class="form-group">
		<form:label path="targetDate">Target Date</form:label>
		<form:input path="targetDate" type="text" class="form-control" required="required" />
		<form:errors path="targetDate" cssClass="text-warning" />
	</fieldset>
	<input type="submit" value="Submit" class="btn btn-success">
</form:form>
</div>
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="../common/footerbar.jspf" %>
<%@ include file="../common/footer.jspf" %>