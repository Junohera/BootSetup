<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	if (window.name === "update") {
		window.opener.location.href="boardUpdateForm?num=${num}";
	} else if (window.name === "delete") {
		window.opener.location.href="boardDelete?num=${num}";
	} else {}
	self.close();
</script>
</head>
<body>
</body>
</html>