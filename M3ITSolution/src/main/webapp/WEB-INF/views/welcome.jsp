<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class = "page-header">
<h4><strong>Home</strong></h4>
    <!--  
    
    -->
    <p>${welcomemessage}</p>
	<p><spring:message code="welcome.greeting"/></p>
    <!--  
    	<p><spring:message code="welcome.greeting" arguments="${startMeeting}"/></p>
    	Current Locale : ${pageContext.response.locale} / ${locale} 
    -->
<h4><a href="/todo">Manage Your Todos</a></h4>
</div>
</div>
<br>
<br>
<br>
<!-- Footer -->
<%@ include file="common/footerbar.jspf" %>
<%@ include file="common/footer.jspf" %>
