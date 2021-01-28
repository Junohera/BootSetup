<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        out.println("JdbcTemplate: UserList");
    %>

    <br>

    <c:forEach var="u" items="${users}" varStatus="status">
        ${u.id} / ${u.name} <br>
    </c:forEach>
</body>
</html>