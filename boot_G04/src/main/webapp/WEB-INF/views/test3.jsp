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
<%
    out.println("Model : Hello World");
%>
<br>
당신의 이름은 ${member.name}입니다.

<br>
당신의 이름은 ${member.id}입니다.
<br>
<hr>
${member}
</body>
</html>