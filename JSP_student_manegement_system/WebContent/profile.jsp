<%@page import="com.jbk.servlet.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="style.css"/>
<link type="text/css" rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link type="text/css" rel="stylesheet" href="styles.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<% 
 Student student=(Student) request.getAttribute("student");
%>
<jsp:include page="menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<form action="register" method="post" class="box">
						<h3 style="color: red">
							<%
								String msg = (String) request.getAttribute("msg");
								if (msg != null) {
									 out.println(msg);
								}
							%>
						</h3>
						<h1>Profile</h1>
						<input type="text"  name="id" placeholder="Id=" required value="<%=student.getId() %>">
						
						<input type="text"  name="username" placeholder="Username" required value="<%=student.getUsername() %>">
						<input type="text" name="password" placeholder="Password" required value="<%=student.getPassword() %>">
						<input type="text" name="email" placeholder="Email" required value="<%=student.getEmail() %>">
						<input type="text" name="phone" placeholder="Phone" required value="<%=student.getPhone() %>">
						 <input
							type="submit" value="REGISTER">
						<div class="col-md-12">
							<ul class="social-network social-circle">
								<li><a href="#" class="icoFacebook" title="Facebook"><i
										class="fab fa-facebook-f"></i></a></li>
								<li><a href="#" class="icoTwitter" title="Twitter"><i
										class="fab fa-twitter"></i></a></li>
								<li><a href="#" class="icoGoogle" title="Google +"><i
										class="fab fa-google-plus"></i></a></li>
							</ul>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>