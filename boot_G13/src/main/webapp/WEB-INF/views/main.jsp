<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${loginUser.name} (${loginUser.id})님 로그인
	<input type="button" value="modify" onclick="location.href='memberEditForm'">
	<input type="button" value="logout" onclick="location.href='logout'">
</body>
</html>