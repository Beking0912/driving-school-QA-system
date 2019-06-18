<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试列表</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' /> 
</head>
<body>
	<div>
		<div class="aa">
			<h1>驾校考试</h1>
			<form action="${pageContext.request.contextPath }/queryQuestion" method="post" >
				<input type="submit" value="确定进入该考试，生成准考证"></input>
			</form>
		</div>
	</div>
</body>
</html>