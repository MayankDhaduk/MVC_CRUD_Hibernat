<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<span>${msg}</span>
	<form action="reg" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${udata.getId()}">
		<label>Username</label> <input type="text" name="name"
			placeholder="Enter Username" value="${udata.getName()}"> <label>Email</label>
		<input type="email" name="email" placeholder="Enter Email" value="${udata.getEmail()}"> <label>Password</label>
		<input type="password" name="pass" placeholder="Enter Password" value="${udata.getPass()}">

		<label>Image</label> <input type="file" name="file"> <input
			type="submit"> <span><a href="display">Viewalluser</a></span>
	</form>

</body>
</html>