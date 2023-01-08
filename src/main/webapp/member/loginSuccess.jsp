<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("로그인성공>> ${sessionScope.gCode}" );
	<c:if test="${empty sessionScope.gCode}">
		location.href="/shop/main";  //절대경로 상대경로 모두 가능
	</c:if>
	<c:if test="${! empty sessionScope.gCode}">
   		location.href="/shop/goodsRetrieve?gCode=${gCode}";  //절대경로 상대경로 모두 가능
 	</c:if>
</script>