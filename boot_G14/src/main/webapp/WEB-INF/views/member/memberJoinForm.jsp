<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board.css">
<script src="/js/board.js"></script>
</head>
<body>
    <div id="wrap">
        <h1>사용자 등록</h1>
        <form action="memberJoin" method="POST" name="frm">
            <table>
                <tr>
                    <th>id</th>
                    <td>
                        <input type="text" name="id" id="id" size="20" value="${m.id}"> *
                        <input type="button" value="check" onclick="idCheck();">
                        <input type="hidden" name="re_id" value="">
                    </td>
                </tr>
                <tr>
                    <th>pw</th>
                    <td><input type="password" name="pw" size="20"> *</td>
                </tr>
                <tr>
                    <th>repw</th>
                    <td><input type="password" name="pw_check" size="20"> *</td>
                </tr>
                <tr>
                    <th>name</th>
                    <td>
                        <input type="text" name="name" id="name" size="20" value="${m.name}"> *
                    </td>
                </tr>
                <tr>
                    <th>phone</th>
                    <td>
                        <input type="text" name="phone1" id="phone1" size="5" value="${m.phone1}">-
                        <input type="text" name="phone2" id="phone2" size="7" value="${m.phone2}">-
                        <input type="text" name="phone3" id="phone3" size="7" value="${m.phone3}">
                    </td>
                </tr>
                <tr>
                    <th>email</th>
                    <td><input type="text" name="email" id="email" size="20" value="${m.email}"></td>
                </tr>
            </table>
            <br>
            <br>
            <input type="submit" value="join">
            <input type="reset" value="clear">
            <input type="button" value="go to signIn" onclick="history.go(-1);">
        </form>
        ${message }
    </div>
</body>
</html>