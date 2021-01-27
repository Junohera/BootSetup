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
        작성자 : <input type="text" name="writer"><br>
        내용 : <input type="text" name="content"><br>
        <input type="submit" value="send">
        <br>
    </form>
</body>
</html>