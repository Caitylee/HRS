<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<%--<head>
		<meta charset="utf-8">
	</head>
	<body>
		<h1>用户注册</h1>
		<hr>
		<div style="color:red; font-size: 12px;">${hint}</div>
		<form action="reg" method="post">
			<input type="text" name="username" placeholder="请输入用户名">
			<br><br>
			<input type="password" name="password" placeholder="请输入密码">
			<br><br>
			<input type="email" name="email" placeholder="请输入邮箱"> 
			<br><br>
			<input type="submit" value="注册">
		</form>
		<a href="login.jsp">返回登录</a>--%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Minimal and Clean Sign up / Login and Forgot Form by FreeHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />




	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body class="style-2">

	<<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<ul class="menu">

				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">


				<!-- Start Sign In Form -->
				<form action="reg" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInLeft">

					<div class="form-group">
						<div class="alert alert-success" role="alert">注册你的账号</div>
					</div>
					<div class="form-group">
						<label for="name" class="sr-only">用户名</label>
						<input type="text" class="form-control" id="name" name="username" placeholder="Name" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">Email</label>
						<input type="email" class="form-control" id="email" name="email" placeholder="Email" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">密码</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Password" autocomplete="off">
					</div>
					<%--<div class="form-group">
						<label for="re-password" class="sr-only">Re-type Password</label>
						<input type="password" class="form-control" id="re-password" placeholder="Re-type Password" autocomplete="off">
					</d--%>
					<div class="form-group">
						<label for="remember"><input type="checkbox" id="remember"> 记住密码</label>
					</div>
					<div class="form-group">
						<p>已经注册? <a href="login.jsp">登录</a></p>
					</div>
					<div class="form-group">
						<input type="submit" value="注册" class="btn btn-primary">
					</div>
				</form>
				<!-- END Sign In Form -->


			</div>
		</div>
		<div class="row" style="padding-top: 60px; clear: both;">
			<div class="col-md-12 text-center"><p><small>&copy; All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">HRS系统</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">HRS系统</a></small></p></div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
	</body>
</html>