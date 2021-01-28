<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm</title>
</head>
<body>
    내용보기 <br>
    <hr>
    작성자: ${b.writer} <br>
    제목: ${b.title} <br>
    내용: ${b.content} <br>

    <br>
    <a href="/">list</a>
</body>
</html>