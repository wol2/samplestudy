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

<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		searchWordKeep();
	});
	
	function searchWordKeep() {
		<c:if test="${not empty colName && not empty searchWord}">
			$("#colName").val("${colName}");
			$("#searchWord").val("${searchWord}");
		</c:if>
		
		<c:if test="${not empty dayDifference}">
			$("#dayDifference").val("${dayDifference}");
		</c:if>
	}
	
	function goSearch() {
		var searchFrm = document.searchFrm;
		searchFrm.submit();
	}

</script>

</head>
<body>
	
	<div align="center" style="margin-top: 50px;">
	
	<h2>회원명단</h2>
	<p>
		<form name="searchFrm" action="<%= request.getContextPath() %>/mybatis/selectTest6End.action" method="get"> 
			<select name="colName" id="colName">
				<option value="name">성명</option> 
				<option value="email">이메일</option>
				<option value="addr">주소</option>
			</select>
			<input type="text" name="searchWord" id="searchWord" size="20" />
			
			<select name="dayDifference" id="dayDifference">
				<option value="-1">기간선택</option> 
				<option value="0">오늘</option>
				<option value="3">최근3일이내</option>
				<option value="7">최근7일이내</option>
				<option value="10">최근10일이내</option>
				<option value="30">최근30일이내</option>
			</select>
			
			<button type="button" onClick="goSearch();">검색</button>
		</form>
	
	 <p>
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





