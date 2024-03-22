<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCA MANAGEMENT SYSTEM</title>
<style >
.navbar{
	display:flex;
	justify-content: space-between;
	 background-color:#000080;
	 color:white;
}
.navbar_logo{
	width:100px;
	margin:1rem;
	display: flex;
	flex-direction: row;
	margin-left:40px;
	
	
}
.navbar_logo img{
	margin-top:10px;
	width:100%;
	border-radius: 50%;
	
}
.navbar_content{
	display:flex;
	justify-content: space-around;
	align-items: center;
	margin-right: 5px;
}
.navbar_links{
	display:flex;
	flex-direction: row;
}
.navbar_links .link{
	margin-right: 3rem;
	text-decoration: none;
	list-style: none;
}
.navbar_links .link a{
	text-decoration: none;
	color:white;
	font-size:1.2rem;
	
}
.link a:hover{
	opacity: 0.5;
}
.btn{
	background: white;
	color:#000080;
	padding:15px;
	border-radius:40px;
	margin-right: 1.5rem;
	border:none;
	justify-content: center;
	
}
.btn a{
	text-decoration: none;
	font-size: 1rem;
	font-weight: bold;
	
}
.btn a:visited{
	color:#000080;
}

	
	
	
	
	
	
</style>
</head>
<body>
<nav class="navbar">
<div class="navbar_logo">
<img alt="logo" src="download2.png"><br>

</div>
<div class="navbar_content">
<ul class="navbar_links">
<li class="link"><a href="/">Home</a></li>
<li class="link"><a href="/">About</a></li>
<li class="link"><a href="/">Contact</a></li>
<li class="link"><a href="login.jsp">Login</a></li>
</ul>
</div>
</nav>
</body>
</html>