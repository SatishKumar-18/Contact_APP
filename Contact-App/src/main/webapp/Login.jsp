<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="Component/AllCss.jsp" %>
<link rel = "stylesheet" href = "alert/dist/sweetalert.css">
</head>
<body>

	<%@ include file = "Component/Navbar.jsp" %>
	
	<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	<div class="cointainer-fluid mt-5">
		
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center fw-bold mt-3 mb-3">Login Page</h4>
						<form action="login" method="post">
  							<div class="mb-3">
    							<label for="exampleInputEmail1" class="form-label">Email address</label>
    							<input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
  							</div>
  							<div class="mb-4">
    							<label for="exampleInputPassword1" class="form-label">Password</label>
    							<input type="password" class="form-control" name="password" id="exampleInputPassword1">
  							</div>
  							<div  class="text-center">
  								<button type="submit" class="btn mb-3" style="background-color: #0000ce; color: #ffff">Login</button>
  							</div>
  							
						</form>
						<a href="Register.jsp" class="text-dark fs-6">New user? SignUp</a>
					</div>
				</div>
			</div>
		
	</div>
	
	<%@ include file = "Component/Footer.jsp" %>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js" SameSite="None"></script>
	<script>
		const status = document.getElementById("status").value;
		
		if(status == "invalid"){
			swal("Error", "Invalid email or password", "error");
		}
	</script>
	

</body>
</html>