<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
//判断用户名和密码是否为空
function check() {
	var user_name = $("user_name").val();
	var password = $("password").val();
	if(user_name=="" || password=="") {
		$("#message").text("账号和密码不能为空！");
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<div class="aa">
		<div >
			<h1>用户登陆</h1>
			<form action="${pageContext.request.contextPath }/login" method="post" onsubmit="return check()" >
				<input type="text" id="user_name" class="text" placeholder="请输入用户名..." name="user_name" ><br /><br />
				<input type="password" id="password" name="password" placeholder="请输入密码..."><br /><br />
				<div class="submit">
					<input type="submit" value="登陆">
				</div>
			</form>
			<br />
			<form action="${pageContext.request.contextPath }/toRegister" method="post">
				<input type="submit" value="注册">
			</form>
		</div>
	
	</div>

</body>
</html>