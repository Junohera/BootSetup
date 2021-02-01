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
						<a href="boardWriteForm">add</a>
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
			<c:forEach var="b" items="${boardList}" varStatus="status">
				<tr class="record">
					<td align="center">${b.num}</td>
					<td>
						<a href="boardView?num=${b.num}">${b.title}</a>
						<c:if test="${b.replycnt != 0}">
							<span style="color:red; font-weight: bold;">[${b.replycnt}]</span>
						</c:if>
					</td>
					<td align="center">${b.userid}</td>
					<td align="center"><fmt:formatDate value="${b.writedate}"></fmt:formatDate></td>
					<td align="center">${b.readcount}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div id="paging">
			<c:if test="${paging.prev}">
				<a href="main?page=${paging.beginPage - 1}">prev</a>
			</c:if>
			<c:forEach var="i" begin="${paging.beginPage}" end="${paging.endPage}" step="1" varStatus="status">
				<c:choose>
					<c:when test="${paging.page == i}">
						${i}
					</c:when>
					<c:otherwise>
						<a href="main?page=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next}">
				<a href="main?page=${paging.endPage+1}">next</a>
			</c:if>
		</div>
	</div>
</body>
</html>