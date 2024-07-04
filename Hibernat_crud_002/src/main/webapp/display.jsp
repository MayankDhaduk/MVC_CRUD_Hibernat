<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">

		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Email</th>
			<th>Password</th>
			<th>Image</th>
			<th colspan="2">Action</th>
		</tr>


		<c:forEach var="dt" items="${data}">
			<tr>
				<td>${dt.getId()}</td>
				<td>${dt.getName()}</td>
				<td>${dt.getEmail()}</td>
				<td>${dt.getPass()}</td>
				<td><img src="img//${dt.getImg()}" alt="${dt.getImg()}"
					height="100px" width="100px"></td>
					<td><a href="update?action=edit&id=${dt.getId()}">Edit</a></td>
					<td><a href="update?action=delete&id=${dt.getId()}">Delete</a></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>