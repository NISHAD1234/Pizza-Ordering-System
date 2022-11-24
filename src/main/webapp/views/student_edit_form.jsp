<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<center>
		<fieldset>
			<legend>Edit Student Form</legend>
			<form action="${pageContext.request.contextPath}/edit_student_action" method="POST" modelAttribute="student">

				<input type="hidden" name="id" value="${student.id}"/>

				Name: <input type="text" name="name" placeholder="Student Name" value="${student.name}"/><br />
				 
				Age: <input type="text" name="age" placeholder="Age" value="${student.age}"/><br />
				
				City: <input type="text" name="city" placeholder="City" value="${student.city}"/><br/>
				 
				<input type="submit" value="Save" />
				<input type="reset" value="Clear Form"/>
			</form>
		</fieldset>

	</center>
</body>
</html>
