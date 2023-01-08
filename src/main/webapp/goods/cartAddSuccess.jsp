<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	//자바스크립트 문자열값은 반드시 '' 또는 ""로 감싸야된다.
	alert('${gCode}'+ "   Cart 저장성공");
	location.href="/shop/main";  //절대경로 상대경로 모두 가능
</script>