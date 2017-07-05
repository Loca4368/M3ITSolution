<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Header -->
<nav class ="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#"><strong>M3ITSolution</strong></a>
		<ul class="nav navbar-nav">
			<li><a href="/todo">View</a></li>
			<li><a href="/news">News</a></li>
			<li><a href="/about">About</a></li>
			<li><a href="/contact">Contact</a></li>
		</ul>
		<div class="profile navbar-right">
		<c:choose>
			<c:when test="${currentUser==null}">
			<ul class="nav navbar-nav">
				<li><a href="/login">Sign in</a></li>
				<li><a href="/register">Sign up</a></li>
			</ul>
			</c:when>
			<c:otherwise>
			<ul class="nav navbar-nav">
				<li><a href="#"><span><strong>Welcome ${currentUser}</strong></span></a></li>
				<li><a href="/login">Log Out</a></li>
			</ul>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</nav>
<!-- End of Header -->