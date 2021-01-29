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
<script src="/js/board.js"></script>
</head>
<body>
    <div id="wrap" align="center">
		<h1>게시글 상세</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${b.userid}</td>
				<th>이메일</th>
				<td>${b.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${b.writedate}"></fmt:formatDate></td>
				<th>조회수</th>
				<td>${b.readcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${b.title}</td>
			</tr>
			<tr>
				<th>내용</th>
                <td colspan="3"><pre>${b.content}</pre></td>
			</tr>
		</table>
		<br><br>
		<input type="button" value="list" onclick="location.href='main'">
		<input type="button" value="modify" onclick="open_win('boardEditForm?num=${b.num}', 'update');">
		<input type="button" value="delete" onclick="open_win('boardDeleteForm?num=${b.num}', 'delete');">
	</div>
	<br>
	<c:set var="now" value="<%=new java.util.Date()%>"></c:set>
	<div id="wrap" align="center">
		<form action="addReply" method="POST" name="frm2">
            <input type="hidden" name="boardnum" value="${b.num}">
            <input type="hidden" name="userid" value="${loginUser.id}">
			<table>
				<tr>
					<td width="100">${loginUser.id}</td>
					<td width="100"><fmt:formatDate value="${now}" pattern="yyyy.MM.dd HH:mm"></fmt:formatDate></td>
					<td width="670"><input type="text" name="content" size="85"></td>
					<td width="100"><input type="submit" value="add"></td>
                </tr>
                
                <c:choose>
                    <c:when test="${empty replyList}">
                        <tr>
                            <td colspan="4" align="center">첫 댓글을 남겨주세요 ㅠㅠ</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <th>작성자</th>
                            <th>작성일시</th>
                            <th>내용</th>
                            <th>&nbsp;</th>
                        </tr>
                        <c:forEach var="r" items="${replyList}" varStatus="status">
                            <tr>
                                <td align="center">${r.userid}</td>
                                <td align="center"><fmt:formatDate value="${r.writedate}" pattern="MM/dd HH:mm"></fmt:formatDate></td>
                                <td align="center">${r.content}</td>
                                <td align="center">
                                    <c:if test="${r.userid == loginUser.id}">
                                        <input type="button" value="del" onclick="location.href='deleteReply?num=${r.num}&boardnum=${r.boardnum}'">
                                    </c:if>&nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
			</table>
		</form>
	</div>
</body>
</html>