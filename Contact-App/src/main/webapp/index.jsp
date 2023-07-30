<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="Component/AllCss.jsp" %>

<style type="text/css">
	.back-img{
		width: 70%;
		height: 70vh;
		background-size: contain;
		background-repeat: no-repeat; 
	}
</style>

</head>
<body>

	<%@ include file = "Component/Navbar.jsp" %>
	
		<div class="d-flex justify-content-evenly align-items-center flex-wrap">
			<div class="p-2">
				<h1 class="fw-bold fs-1">Welcome! to CONTACT APP</h1>
				<p class="fs-6">Do you want to connect with your Loved Ones, then use us for hassle free connection.
					<br>Bridge that gap with CONTACT APP!!
				</p>
			</div>
			<div class="p-2">
				<img src="Images/Phone.png" class="img-fluid back-img" alt="phone">
			</div>
		</div>
	
	<%@ include file = "Component/Footer.jsp" %>
	
</body>
</html>