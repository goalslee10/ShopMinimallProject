<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    

<c:if test="${empty login}">
<a href="loginUI">로그인</a>&nbsp;&nbsp;
<a href="memberUI">회원가입</a>
</c:if>

<c:if test="${! empty login}">
안녕하세요.${login.userid}님<br>
<a href="logout">로그아웃</a>&nbsp;&nbsp;
<a href="mypage">mypage</a>&nbsp;&nbsp;
<a href="cartList">장바구니 목록</a>&nbsp;&nbsp;

</c:if>

