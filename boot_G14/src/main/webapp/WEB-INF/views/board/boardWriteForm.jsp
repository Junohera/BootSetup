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
	<h1>write</h1>
		<form name="frm" method="post" action="boardWrite" enctype="multipart/form-data">
			<table>
				<tr>
					<th>작성자</th>
					<td>
						${loginUser.id }
						<input type="hidden" name="userid" value="${loginUser.id }">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pass"> * 필수(게시물 수정 삭제시 필요합니다.)
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email" value="${loginUser.email }"> * 필수
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" size="70" name="title"> * 필수
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea cols="70" rows="15" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>
						<input type="file" name="filename" >
					</td>
				</tr>
			</table>
			<input type="submit" value="add">
			<input type="reset" value="clear">
			<input type="button" value="list" onclick="location.href='main';">
		</form>
		${message}
	</div>
</body>
</html>