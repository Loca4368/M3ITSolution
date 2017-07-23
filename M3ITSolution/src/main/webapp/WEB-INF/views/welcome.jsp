<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class = "page-header">
Hi ${user}, Welcome to M3ITSolution.
<h4><a href="/todo">Manage Your Todos</a></h4>
</div>
</div>
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="common/footerbar.jspf" %>
<%@ include file="common/footer.jspf" %>
