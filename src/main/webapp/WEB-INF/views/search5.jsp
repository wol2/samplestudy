<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 페이지</title>

<script type="text/javascript">
	function goSearch() {
		var myFrm = document.myFrm;
		myFrm.submit();
	}

</script>

</head>
<body>
	<div align="center">
		<h1>회원전체조회 버튼을 클릭하면 모든회원을 조회해주는 페이지(/mybatis/selectTest5.action)</h1>
		
		<form name="myFrm"  action="<%= request.getContextPath() %>/mybatis/selectTest5End.action" method="get">  
			<button type="button" onClick="goSearch();">회원전체조회</button>
		</form>
	</div>
</body>
</html>




