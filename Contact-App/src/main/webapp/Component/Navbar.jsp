<nav class="navbar navbar-expand-lg navbar-dark sticky-top" style="background-color: #0000ce;">
  <div class="container-fluid">
    <a class="navbar-brand ps-4 fw-bold" href="index.jsp"><i class="fa-solid fa-phone"></i> Contact</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mx-auto mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active me-4 pe-auto" aria-current="page" href="index.jsp"><i class="fa-solid fa-house"></i> Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active me-4" href="AddContact.jsp"><i class="fa-solid fa-plus"></i> Add Phone</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="ViewContact.jsp"><i class="fa-regular fa-address-book"></i> View Contact</a>
        </li>
      </ul>
      
      <%
      	if(session.getAttribute("email") == null){
      %>
      <form class="d-flex">
        <a href="Login.jsp" class = "btn btn-light me-5" style="color: #0000ce"><i class="fa-regular fa-user"></i> Login</a>
      </form>
      <%
      	}
      	else{
      %>	
      	 <span class="navbar-text me-3" style="color: #ffff">
        	<i class="fa-regular fa-user"></i> <%= session.getAttribute("email") %>
      	</span>
      	<form class="d-flex">
        	<a data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-light"
        	 style="color: #0000ce"><i class="fa-solid fa-lock"></i> Logout</a>
      	</form>
      	<%
      		}
      	%>
      
    </div>
  </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body text-center">
      	<h5>Do you want to exit? </h5>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <a href="logout" type="button" class="btn btn-primary">Logout</a>
      </div>
    </div>
  </div>
</div>