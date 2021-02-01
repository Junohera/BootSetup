<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board.css">
<script>
</script>
</head>
<body>
	<div id="wrap">
		<h1>게시글 수정</h1>
		<form action="boardUpdate" name="frm" method="POST">
			<input type="hidden" name="num" value="${b.num}">
			<table>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="userid" value="${loginUser.id}" size="12" >
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pass" size="12">* 필수 (게시물 수정 삭제시 필요합니다.)
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email" value="${b.email}" size="12">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" value="${b.title}" size="12">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" cols="70" rows="15">${b.content}</textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="update">
			<input type="button" value="list" onclick="location.href='main'">
		</form>
	</div>
	
</body>
</html>