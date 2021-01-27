<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CreatePage</title>
</head>
<body>
    createDonePage.jsp 전달된 객체의 내용
    <br>
    이름 : ${c.writer} <br>
    내용 : ${c.content}
</body>
</html>