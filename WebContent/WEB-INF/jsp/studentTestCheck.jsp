<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.sc.springmvc.pojo.Student" %>
<%
	Student student = (Student) session.getAttribute("STUDENT_SESSION");
	String stu_test_id = (String) session.getAttribute("stu_test_id");
%>
<html>
<head>
<meta charset="UTF-8">
<title>考试列表</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' /> 
</head>
<body>
	<div>
		<div class="aa">
			<h1>准考证确认</h1>
			<table>
				<tr>
					<td>考生编号：<%=student.getId() %></td>
				</tr>
				<tr>
					<td>考生姓名：<%=student.getName() %></td>
				</tr>
				<tr>
					<td>身份证号：<%=student.getPin() %></td>
				</tr>
				<tr>
					<td>电话号码：<%=student.getPhone() %></td>
				</tr>
				<tr>
					<td>准考证号：<%=stu_test_id %></td>
				</tr>
			</table>
			<br />
			<form action="${pageContext.request.contextPath }/createPaper" method="post" >
				<input type="submit" value="准考证已确认，确定进入考试"></input>
			</form>
		</div>
	</div>
</body>
</html>