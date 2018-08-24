<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>

<script type="text/javascript">
	function gosubmit() {
		var myFrm = document.myFrm;
		myFrm.submit();
	}

</script>

</head>
<body>
	<div align="center">
		<h1>글쓰기(/mybatis/formtest3.action)</h1>
		
		<form name="myFrm"  action="<%= request.getContextPath() %>/mybatis/formtest3End.action" method="post">  
			이름 : <input type="text" name="irum" /><br/>
			휴대폰 : <input type="text" name="mobile" /><br/>
			주소 : <input type="text" name="address" /><br/>
			<p>
			<button type="button" onClick="gosubmit();">등록</button>
		</form>
	</div>
</body>
</html>




