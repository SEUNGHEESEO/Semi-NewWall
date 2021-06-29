<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan=4>Person List</th>
		</tr>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CONTACT</th>
			<th>Date</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.contact}</td>
				<td>${item.reg_date}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align=center><a href="index.jsp"><button>BACK</button></a></td>
		</tr>
	</table>
</body>
</html>