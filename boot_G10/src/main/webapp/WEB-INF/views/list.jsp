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
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td>번호</td>
            <td>작성자</td>
            <td>제목</td>
            <td>삭제</td>
        </tr>
        <c:forEach var="item" items="${list}" varStatus="status">
            <tr>
                <td>${item.id}</td>
                <td>${item.writer}</td>
                <td><a href="view?id=${item.id}"></a>${item.title}</td>
                <td><a href="delete?id=${item.id}">X</a></td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="writeForm">글작성</a>
    </p>
</body>
</html>