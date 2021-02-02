<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/shopping.css">
    <script src="/js/member.js"></script>
    <script src="/js/mypage.js"></script>
</head>
<body>
    <div id="wrap">
        <header>
            <div id="logo">
                <a href="/shop/">
                    <img src="/images/logo.png" width="180" height="100">
                </a>
            </div>
            <nav id="category_menu">
                <ul>
                    <c:choose>
                        <c:when test="${empty loginUser}">
                            <li><a href="loginForm">LOGIN</a></li>
                            <li><a href="contract">JOIN</a></li>
                        </c:when>
                        <c:otherwise>
                            <li style="color:orange">${loginUser.name}(${loginUser.id})</li>
                            <li><a href="memberEditForm">modify</a></li>
                            <li><a href="logout">LOGOUT</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li><a href="cartList">CART</a></li>
                    <li><a href="mypage">mypage</a></li>
                    <li><a href="qnaList" style="border:0px;">Q&amp;A(1:1)</a></li>
                </ul>
            </nav>
            <nav id="top_menu">
                <ul>
                    <li><a href="category?kind=1">Heels</a></li>
                    <li><a href="category?kind=2">Boots</a></li>
                    <li><a href="category?kind=3">Sandals</a></li>
                    <li><a href="category?kind=4">Sneakers</a></li>
                    <li><a href="category?kind=5">Sleeper</a></li>
                    <li><a href="category?kind=6">On Sale</a></li>
                </ul>
            </nav>
            <div class="clear"></div>
        </header>