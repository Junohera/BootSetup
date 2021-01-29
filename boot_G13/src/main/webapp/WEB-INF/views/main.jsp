<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white;text-align: right;">
					<div style="float:left;">
						${loginUser.name} (${loginUser.id})님 로그인
						<input type="button" value="modify" onclick="location.href='memberEditForm'">
						<input type="button" value="logout" onclick="location.href='logout'">						
					</div>
					<div style="float:right;">
						<a href="boardwriteForm">add</a>
					</div>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
		</table>
	</div>
</body>
</html>