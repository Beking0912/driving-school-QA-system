<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
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
	<div >
		<div class="aa">
			<h1>用户注册</h1>
			<form action="${pageContext.request.contextPath }/register" method="post" onsubmit="return check()" >
				<input type="text" id="user_name" class="text" placeholder="请输入用户名..." name="user_name" ><br /><br />
				<input type="text" id="login_name" class="text" placeholder="请输入昵称..." name="login_name" ><br /><br />
				<input type="password" id="password" name="password" placeholder="请设置密码..."><br /><br />
				<div >
					<input type="submit" value="注册">
				</div>
			</form>
		</div>
	
	</div>

</body>
</html>