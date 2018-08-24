<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 조회하기</title>

<style type="text/css">
	table {border: solid 1px gray;
	       border-collapse: collapse; }
	       
	th, td {border: solid 1px gray;}
	
	th {background-color: #d0d0d0; font-weight: bold;}
	       
    .total {background-color: #ffff99; font-weight: bold; text-align: center;}
</style>

</head>
<body>
	
	<div align="center" style="margin-top: 50px;"> 
		<table>
			<thead>
				<tr>
				    <th>번호</th>
					<th>회원번호</th>
					<th>성명</th>
					<th>이메일</th>
					<th>전화</th>
					<th>주소</th>
					<th>가입일자</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="7">
							존재하지 않습니다.
						</td>
					</tr>
				</c:if>
				
				<c:if test="${not empty list}">
					<c:forEach var="vo" items="${list}" varStatus="status">
					<tr>
					    <td>${status.count}</td>
						<td>${vo.no}</td>
						<td>${vo.name}</td>
						<td>${vo.email}</td>
						<td>${vo.tel}</td>
						<td>${vo.addr}</td>
						<td>${vo.writeday}</td>
					</tr>
						<c:set var="count" value="${status.count}" />
					</c:forEach>
					
					<tr>
						<td class="total" colspan="3">전체회원수</td>
						<td class="total" colspan="4">${count}명</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	
</body>
</html>





