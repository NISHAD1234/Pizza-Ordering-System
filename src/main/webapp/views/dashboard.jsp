<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="jstlc" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<center>
		<h3>Students List</h3>
		<table border="10" cellspacing="15" cellpadding="15">
			<thead>
				<th>id</th>
				<th>Name</th>
				<th>Age</th>
				<th>City</th>
				<th>Action</th>
			</thead>
			<jstlc:forEach var="student" items="${students_list}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td>${student.city}</td>
					<td>
						<a href="edit?id=${student.id}">Edit</a> | 
						<a href="delete?id=${student.id}" 
							onclick="javascript: return confirm('Are you sure you want to delete this record?');">Delete</a>
					</td>
				</tr>
			</jstlc:forEach>
		</table>
	</center>
</body>
</html>