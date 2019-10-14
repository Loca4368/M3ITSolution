<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Header -->
<%@ include file="common/header.jspf" %>

<!-- Body -->
<body>
<!-- <jsp:include page="common/navigationbar.jspf" flush="true"></jsp:include> -->
<%@ include file="common/navigationbar.jspf" %>
<br>
<br>
<br>
<div class="container">
    <form:form method="post" modelAttribute="regForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="pwd">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="pwd" class="form-control" placeholder="Password"></form:input>
                <form:errors path="pwd"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPwd">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPwd" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="confirmPwd"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="common/footerbar.jspf" %>
<%@ include file="common/footer.jspf" %>