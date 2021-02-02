<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter01/header.jsp" %>
<%@ include file="../include/sub02/sub_image.html" %>
<%@ include file="../include/sub02/sub_menu.html" %>

<article>
    <h2>Edit Profile</h2>
    <form action="updateMember" method="POST" name="formm">
        <fieldset>
            <legend>Basic Info</legend>
            <label>User ID</label>
            <input type="text" name="id" size="12" value="${m.id}" readonly><br>
            <label>Password</label><input type="password" name="pwd"><br>
            <label>Retype Password</label><input type="password" name="pwdCheck"><br>
            <label>Name</label><input type="text"  name="name" value="${m.name}"><br>
            <label>E-Mail</label><input type="text"  name="email" value="${m.email}"><br>
        </fieldset>
        <fieldset>
            <legend>Optional</legend>
            <label>Zip Code</label><input type="text" name="zip_num" size="10" value="${m.zip_num}">      
            <input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
            <label>Address</label><input type="text" name="addr1" value="${addr1}" size="50"><br>
            <label>&nbsp;</label><input type="text" name="addr2" value="${addr2}" size="25"> <br>
            <label>Phone Number</label><input  type="text" name="phone" value="${m.phone}"><br>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="edit" class="submit">
            <input type="reset" value="clear" class="cancel">
        </div>
    </form>
    <p>${message}</p>
</article>

<%@ include file="../include/headerfooter01/footer.jsp" %>
