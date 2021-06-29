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
	<script>
		$(function() {
			$(".btn_insert").on("click", function() {
				location.href = "inputform.msg";
			});
			$(".btn_select").on("click", function() {
				location.href = "outputproc.msg";
			});
			$(".btn_delete").on("click", function() {
				location.href = "deletelist.msg";
			});
			$(".btn_update").on("click", function() {
				location.href = "modifylist.msg";
			});
		});
	</script>
	<div class="contianer">
		<h1>PERSON INFORMATION CRUD</h1>
		<br>
		<button type="button" class="btn btn-primary btn_insert">INSERT</button>
		&nbsp;
		<button type="button" class="btn btn-secondary btn_select">SELECT</button>
		&nbsp;
		<button type="button" class="btn btn-danger btn_delete">DELETE</button>
		&nbsp;
		<button type="button" class="btn btn-success btn_update">UPDATE</button>
	</div>
</body>
</html>