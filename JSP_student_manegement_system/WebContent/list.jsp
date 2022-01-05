<%@page import="com.jbk.servlet.Student"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>
<jsp:include page="menu.jsp" />
<br>
<table class="table table-striped table-dark">
<thead>
<tr>
<th>ID</th>
<th>USERNAME</th>
<th>PASSWORD</th>
<th>EMAIL</th>
<th>PHONE</th>
<th>Action</th>
</tr>
</thead>

<tbody>
<% 
List<Student> list= (List<Student>)request.getAttribute("students");
for(int i=0;i<list.size();i++){
	Student student=list.get(i);
%>	

	<tr>
	<td><%out.print(student.getId()); %></td>
	<td><%out.print(student.getUsername()); %></td>
	<td><%out.print(student.getPassword()); %></td>
	<td><%out.print(student.getEmail()); %></td>
	<td><%out.print(student.getPhone()); %></td>
	<th><a href="deleteServlet?id=<%out.print(student.getId());%>">DELETE</a>|
	<a href="updateServlet?id=<%out.print(student.getId());%>">UPDATE</a></th>
	</tr>

<%	
}
%>
</tbody>
</table>
</body>
</html>