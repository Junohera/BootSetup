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
    <form action="create">
        작성자 : <input type="text" name="writer" value="${c.writer}"><br>
        내용 : <input type="text" name="content" value="${c.content}"><br>
        <input type="submit" value="send">
        <br>
        ${msg}
    </form>
</body>
</html>