<html>
<head>
<title>M3ITSolution</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
			<ul class="nav navbar-nav">
				<li><a href="">Sign in</a></li>
				<li><a href="">Sign up</a></li>
			</ul>
		
		</div>
	</div>

</nav>
Welcome ${currentUser}
<!--Your password is: ${password}  -->
<a href="/todo">Manage Your Todos</a>
<a href="/test">Test</a>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>