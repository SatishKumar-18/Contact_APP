<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	if(session.getAttribute("email") == null){
    		response.sendRedirect("Login.jsp");
    	}
    %>
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
	<%@ page import="com.dao.ContactDao, com.entity.Contact, com.connection.DatabaseConnect, java.util.*" %>
	
	<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	<div class="cointainer-fluid mt-5">
			<div class="col-md-3 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center fw-bold mt-3">Add Contact</h4>
						<form method="post" action="update">
						<%
							int cid = Integer.parseInt(request.getParameter("cid"));
							ContactDao dao = new ContactDao(DatabaseConnect.getConnection());
							Contact c = dao.getContactById(cid);
							
						%>
						<input type="hidden" value="<%=cid%>" name="cid">
							<div class="mb-3 col-auto">
    							<label for="exampleInputName" class="form-label">Name</label>
    							<input type="text" class="form-control" name="name" id="exampleName" value="<%= c.getName() %>" aria-describedby="nameHelp">
  							</div>
  							<div class="mb-3">
    							<label for="exampleInputEmail1" class="form-label">Email address</label>
    							<input type="email" class="form-control" name="email" id="exampleInputEmail1" value="<%= c.getEmail() %>" aria-describedby="emailHelp">
  							</div>
  							<div class="mb-3 col-auto">
    							<label for="exampleInputPhone" class="form-label">Phone</label>
    							<input type="text" class="form-control" name="phone" id="examplePhone" value="<%= c.getPhone() %>" aria-describedby="phoneHelp">
  							</div>
  							<div  class="text-center">
  								<button type="submit" class="btn" style="background-color: #0000ce; color: #ffff">Save</button>
  							</div>
  							
						</form>
					</div>
				</div>
			</div>
	</div>
	
	<%@ include file = "Component/Footer.jsp" %>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js" SameSite="None"></script>
	<script>
		const status = document.getElementById("status").value;
		
		if(status == "update"){
			swal("Update", "Contact updated successfully", "success");
		}
		else if(status == "Empty"){
			swal("Invalid", "Please enter name", "error");
		}
		else if(status == "EmptyPhone"){
			swal("Invalid", "Please enter phone number", "error");
		}
		else if(status == "Invalid"){
			swal("Invalid", "Enter 10-digit phone number", "error");
		} 
	</script>

</body>
</html>