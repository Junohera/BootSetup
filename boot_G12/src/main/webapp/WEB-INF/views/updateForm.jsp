<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm</title>
</head>
<body>
    <br>
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <form action="update" method="POST">
        	<input type="hidden" name="id" value="${b.id}">
            <tr>
                <td>작성자</td> <td><input type="text" name="writer" size="100" value="${b.writer}"></td>
            </tr>
            <tr>
                <td>제목</td> <td><input type="text" name="title" size="100" value="${b.title}"></td>
            </tr>
            <tr>
                <td>내용</td> <td><input type="text" name="content" size="100" value="${b.content}"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="modify">&nbsp;&nbsp;
                    <a href="/">list</a>
                </td>
            </tr>
            <tr>
            	<td colspan="2">${msg}</td>
            </tr>
        </form>
        <br>
    </table>    
</body>
</html>