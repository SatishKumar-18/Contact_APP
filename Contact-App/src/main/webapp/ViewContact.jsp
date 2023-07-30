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
<style>
	.crd-ho:hover{
		box-shadow: 10px 10px 10px rgb(230,230,230);
	}
</style>
</head>
<body>
	
	<%@ include file = "Component/Navbar.jsp" %>
	<%@ page import="com.dao.ContactDao, com.entity.Contact, com.connection.DatabaseConnect, java.util.*" %>
	
	<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	<div class="container">
		<div class="row p-3">
				<%
					
					if(session.getAttribute("email") != null){
						int id = (int)session.getAttribute("id");
						ContactDao dao = new ContactDao(DatabaseConnect.getConnection());
						List<Contact> contact = dao.getAllContact(id);
			
						for(Contact c:contact){
					%>
					<div class="col-md-3">
						<div class="card crd-ho">
							<div class="card-body">
								<h5>Name: <%= c.getName() %></h5>
								<p>Phone: <%= c.getPhone() %></p>
								<p>E-mail: <%= c.getEmail() %></p>
								<div class="text-center">
									<a href="EditContact.jsp?cid=<%= c.getId() %>" class="btn btn-primary btn-sm"><i class="fa-regular fa-pen-to-square"></i> Edit</a>
									<a href="delete?cid=<%= c.getId() %>" class="btn btn-danger btn-sm"><i class="fa-regular fa-trash-can"></i> Delete</a>
								</div>
							</div>
						</div>
					</div>
					<%
						}	
						}
					%>
				
		</div>	
	</div>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js" SameSite="None"></script>
	<script>
		const status = document.getElementById("status").value;
		
		if(status == "delete"){
			swal("Deleted","", "success");
		}
		else if(status == "Empty"){
			swal("Invalid", "Something went wrong!!!", "error");
		}
	</script>
</body>
</html>