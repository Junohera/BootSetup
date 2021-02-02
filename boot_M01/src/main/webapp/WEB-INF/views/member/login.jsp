<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter01/header.jsp" %>
<%@ include file="../include/sub02/sub_image.html" %>
<%@ include file="../include/sub02/sub_menu.html" %>

<article>
    <h1>Login</h1>
    <form action="login" method="post">
        <fieldset><legend></legend>
            <label for="id">userId</label><input type="text" name="id" value="${rm.id}"><br>
            <label for="pwd">pwd</label><input type="password" name="pwd" value=""><br>
        </fieldset>
        <div id="buttons">
            <input type="submit" value="login" class="submit">
            <input type="button" value="sign up" class="cancel" onclick="location.href='contract'">
            <input type="button" value="find id/pw" class="submit" onclick="findIdPw();">
        </div>
        ${message}
    </form>
</article>

<%@ include file="../include/headerfooter01/footer.jsp" %>
