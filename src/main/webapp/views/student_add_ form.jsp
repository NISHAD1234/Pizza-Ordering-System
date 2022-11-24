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
			<legend>Add Student Form</legend>
			<form action="${pageContext.request.contextPath}/add_student_action" method="POST" modelAttribute="student">
				
				<input type="text" name="name" placeholder="Student Name" autocomplete="off" /><br /> 
				<input type="text" name="age" placeholder="Age" /><br />
				<input type="text" name="city" placeholder="City"/><br/> 
				<input type="submit" value="Submit" />
				<input type="reset" value="Clear Form"/>
			</form>
		</fieldset>

	</center>
</body>
</html>
