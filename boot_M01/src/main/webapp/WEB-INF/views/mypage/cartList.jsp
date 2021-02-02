<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter01/header.jsp" %>
<%@ include file="../include/sub03/sub_image.html" %>
<%@ include file="../include/sub03/sub_menu.html" %>

<article>
    <h2>Cart List</h2>
    <form name="formm" method="POST" action="orderInsert">
        <c:choose>
            <c:when test="${cartList.size() == 0}">
                <h3 style="color:red; text-align: center;">장바구니가 비었습니다.</h3>
            </c:when>
            <c:otherwise>
                <table id="cartList">
                    <tr>
                        <th>상품명</th>
                        <th>수량</th>
                        <th>가격</th>
                        <th>주문일</th>
                        <th>삭제</th>
                    </tr>
                    <c:forEach var="c" items="${cartList}" varStatus="status">
                        <tr>
                            <td>
                                <a href="productDetail?pseq=${c.pseq}">
                                    <h3>${c.pname}</h3>
                                </a>
                            </td>
                            <td>
                                ${c.quantity}
                            </td>
                            <td><fmt:formatNumber value="${c.price2*c.quantity}" type="currency"></fmt:formatNumber></td>
                            <td><fmt:formatDate value="${c.indate}" type="date"></fmt:formatDate></td>
                            <td><input type="checkbox" name="cseq" value="${c.cseq}" ></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th colspan="2">총액</th>
                        <th colspan="2">
                            <fmt:formatNumber value="${totalPrice}" type="currency"></fmt:formatNumber><br>
                        </th>
                        <th>
                            <a href="#" onclick="goCartDelete();"><h3>삭제하기</h3></a>
                        </th>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <div class="clear"></div>
        <div id="buttons" style="float: right;">
            <input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='/'">
            <c:if test="${cartList.size() > 0}">
                <input type="submit" value="주문하기" class="submit">
            </c:if>
        </div>
    </form>
</article>

<%@ include file="../include/headerfooter01/footer.jsp" %>
