<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/headerfooter01/header.jsp" %>
    <%@ include file="../include/sub01/sub_image.html" %>
    <%@ include file="../include/sub01/sub_menu.html" %>

<article>
    <h1>Item</h1>
    <div id="itemDetail">
        <form method="POST" name="formm">
            <fieldset>
                <legend>Item detail Info</legend>
                <span style="float: left;">
                    <img src="/product_images/${p.image}" style="border-radius:20px;"></span>
                <h2>${p.name}</h2>
                <label>price</label> <p>${p.price2} 원</p>
                <label>quantity</label> <input type="text" name="quantity" size="2" value="1">
                <br>
                <input type="hidden" name="pseq" value="${p.pseq}">
                <br>
                <br>
                ${p.content}
                <br>
            </fieldset>
            <div class="clear"></div>
            <div id="buttons">
                <input type="button" value="cart" class="submit" onclick="go_cart();">
                <input type="button" value="buy" class="submit" onclick="go_buy();">
                <input type="button" value="main" class="submit" onclick="location.href='/shop/'">
            </div>
        </form>
    </div>
</article>

<%@ include file="../include/headerfooter01/footer.jsp" %>