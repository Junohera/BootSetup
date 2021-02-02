<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter01/header.jsp" %>
<%@ include file="../include/sub03/sub_image.html" %>
<%@ include file="../include/sub03/sub_menu.html" %>

<article>
    <h2>Order List</h2>
    <form name="formm" method="POST">
        <table id="cartList">
            <tr>
                <th>상품명</th>
                <th>수량</th>
                <th>가격</th>
                <th>주문일</th>
                <th>진행상태</th>
            </tr>
            <c:forEach var="o" items="${orderList}" varStatus="status">
                <tr>
                    <td>
                        <a href="productDetail?pseq=${o.pseq}">
                            <h3>${o.pname}</h3>
                        </a>
                    </td>
                    <td>${o.quantity}</td>
                    <td><fmt:formatNumber value="${o.price2 * o.quantity}" type="currency"></fmt:formatNumber></td>
                    <td><fmt:formatDate value="${o.indate}"></fmt:formatDate></td>
                    <td>처리 진행중</td>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="2">총액</th>
                <th><fmt:formatNumber value="${totalPrice}" type="currency"></fmt:formatNumber></th>
                <th colspan="2">주문 처리가 완료되었습니다.</th>
            </tr>
        </table>
        <div class="clear"></div>
        <div id="buttons" style="float: right;">
            <input type="button" value="쇼핑 계속하기" class="submit" onclick="location.href='/'">
        </div>
    </form>
</article>

<%@ include file="../include/headerfooter01/footer.jsp" %>
