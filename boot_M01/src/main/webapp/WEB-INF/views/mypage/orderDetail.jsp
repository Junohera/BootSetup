<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter01/header.jsp" %>
<%@ include file="../include/sub03/sub_image.html" %>
<%@ include file="../include/sub03/sub_menu.html" %>

<article>
    <h2>My Page(주문 상세정보)</h2>
    <form name="formm" method="POST">
        <h3>주문자 정보</h3>
        <table id="cartList">
            <tr>
                <th>주문일자</th>
                <th>주문번호</th>
                <th>주문자</th>
                <th>주문총액</th>
            </tr>
            <tr>
                <td>
                    <fmt:formatDate value="${orderDetail.indate}"></fmt:formatDate>
                </td>
                <td>${orderDetail.oseq}</td>
                <td>${orderDetail.mname}</td>
                <td><fmt:formatNumber value="${totalPrice}" type="currency"></fmt:formatNumber></td>
            </tr>
        </table>
        <h3>주문 상품 정보</h3>
        <table id="cartList">
            <tr>
                <th>상품명</th>
                <th>상품별번호</th>
                <th>수량</th>
                <th>가격</th>
                <th>처리상태</th>
            </tr>
            <c:forEach var="order" items="${orderList}" varStatus="status">
                <tr>
                    <td>${order.pname}</td>
                    <td>${order.odseq}</td>
                    <td>${order.quantity}</td>
                    <td><fmt:formatNumber value="${order.price2}" type="currency"></fmt:formatNumber></td>
                    <td>
                        <c:choose>
                            <c:when test="${order.result == '1'}">진행중</c:when>
                            <c:otherwise><span style="color:red;">처리완료</span></c:otherwise>
                        </c:choose>
                    </td>
                </tr>           
            </c:forEach>
        </table>
        <div class="clear"></div>
        <div id="buttons" style="float: right;">
            <input type="button" value="뒤로가기" class="cancel" onclick="history.go(-1)">
        </div>
    </form>
</article>

<%@ include file="../include/headerfooter01/footer.jsp" %>
