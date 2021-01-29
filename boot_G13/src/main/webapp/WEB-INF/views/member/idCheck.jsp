<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board.css">
<script src="/js/board.js"></script>
</head>
<body>
    <form action="idCheck" name="frm">
        <br><br>
        id <input type="text" name="id" id="id" value="${id}">
        <input type="submit" value="check">
        <br>
        <br><br>
        <c:if test="${result == 1}">
            <script>opner.document.frm.id.value = "";</script>
            ${id} is already.
        </c:if>
        <c:if test="${result == -1}">
            ${id} is available.
            <input type="button" value="use" class="cancle" onclick="idok('${id}');">
        </c:if>
    </form>
</body>
</html>