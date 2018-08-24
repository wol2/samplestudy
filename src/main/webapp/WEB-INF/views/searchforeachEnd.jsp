<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서별 직원정보 보여주기(/mybatis/searchforeachEnd.action) </title>

<style type="text/css">
	table {border:1px solid gray; border-collapse:collapse;}
	th {background-color:#d0d0d0; font-weight:bold;}
	th,td {border:1px solid gray; padding:5px; text-align:center;}
	td.total {background-color:#ffff99; font-weight:bold;}
	select.my_select {height: 25px;}
</style>	

<script type="text/javascript">
	function goSearch() {
		document.searchFrm.submit();
	}

	function searchKeep() {
		// 검색중이면 검색 폼을 계속 검색하는 상황으로 유지하기
		<c:if test="${not empty department_id_Arr}">
			<c:forEach var="val" items="${department_id_Arr}" varStatus="status">
    			var department_id = "department_id_" + ${val}; 
				document.getElementById(department_id).checked = true;
			</c:forEach>
		</c:if>
		
		<c:if test="${not empty gender}">
			document.getElementById("gender").value = "${gender}";
		</c:if>
		
		<c:if test="${not empty ageline}">
			document.getElementById("ageline").value = "${ageline}";
		</c:if>
	}
	
	window.onload = function(){
		searchKeep();
	} 
	
</script>

</head>
<body>

	<div align="center">
	<h2>부서별 전체 직원 명단</h2>
	
	<p>
	
	<!-- 검색 폼 추가 : option 의 value 를 검색대상 테이블의 컬럼명으로 해야 한다. -->
	<form name="searchFrm" action="<%=request.getContextPath() %>/mybatis/searchforeachEnd.action" method="GET">
		<input type="checkbox" name="department_id" id="department_id_10" value="10" /><label for="department_id_10">10번부서</label>&nbsp;
		<input type="checkbox" name="department_id" id="department_id_20" value="20" /><label for="department_id_20">20번부서</label>&nbsp;
		<input type="checkbox" name="department_id" id="department_id_30" value="30" /><label for="department_id_30">30번부서</label>&nbsp;
		<input type="checkbox" name="department_id" id="department_id_40" value="40" /><label for="department_id_40">40번부서</label>&nbsp;
		<input type="checkbox" name="department_id" id="department_id_50" value="50" /><label for="department_id_50">50번부서</label>&nbsp;
		
		<select id="gender" name="gender" class="my_select">
			<option value="전체">성별</option>
			<option value="남">남</option>
			<option value="여">여</option>
		</select>
		
		<select id="ageline" name="ageline" class="my_select">
			<option value="-10">연령대</option>
			<option value="0">10대미만</option>
			<option value="10">10대</option>
			<option value="20">20대</option>
			<option value="30">30대</option>
			<option value="40">40대</option>
			<option value="50">50대</option>
			<option value="60">60대</option>
			<option value="70">70대</option>
		</select>
		
		<button type="button" onClick="goSearch();">검색</button>
	</form>
	<p>
	<p>
		<table style="width: 900px;">
			<tr>
				<th>순번</th>
				<th>부서번호</th>
				<th>부서명</th>
				<th>사원번호</th>
				<th>사원명</th>
				<th>주민번호</th>
				<th>성별</th>
				<th>현재나이</th>
				<th>연봉</th>
			</tr>
			<c:if test="${empDeptList == null || empty empDeptList}">
			<tr>
				<td colspan="9">존재하지 않습니다</td>
			</tr>
			</c:if>		
			<c:if test="${empDeptList != null || not empty empDeptList}">
				<c:forEach var="map" items="${empDeptList}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${map.DEPARTMENT_ID}</td>
						<td>${map.DEPARTMENT_NAME}</td>
						<td>${map.EMPLOYEE_ID}</td>
						<td>${map.ENAME}</td>
						<td>${map.JUBUN}</td>
						<td>${map.GENDER}</td>
						<td>${map.AGE}</td>
						<td>${map.YEARPAY}</td>
					</tr>
					<c:set var="count" value="${status.count}" />
				</c:forEach>
					<tr>
						<td class="total" colspan="5">전체직원수 : </td>
					    <td class="total" colspan="4">${count}명</td>
					</tr>
			</c:if>
		</table>
	</div>
</body>
</html>



