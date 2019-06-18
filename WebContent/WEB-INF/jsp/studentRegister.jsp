<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考生注册</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' /> 
</head>
<body>
	<div >
		<div class="aa">
			<h1>考生注册</h1>
			<form action="${pageContext.request.contextPath }/studentRegister" method="post" >
				<input type="text" id="name" placeholder="姓名" name="name" ><br /><br />
				<input type="text" id="pin" name="pin" placeholder="身份证号码"><br /><br />
				<input type="text" id="phone" name="phone" placeholder="电话号码"><br /><br />
				<div class="submit">
					<input type="submit" value="考生注册">
				</div>
			</form>
		</div>
	
	</div>

</body>
</html>