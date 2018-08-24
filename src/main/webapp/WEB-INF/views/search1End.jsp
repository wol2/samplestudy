<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 조회하기</title>
</head>
<body>
	<c:if test="${empty name}">
		조회하려는 회원이 없습니다.
	</c:if>
	
	<c:if test="${not empty name}">
		조회하신 회원명은 ${name} 님 입니다.
	</c:if>
</body>
</html>





