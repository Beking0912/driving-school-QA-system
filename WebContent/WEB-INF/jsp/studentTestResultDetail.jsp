<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.sc.springmvc.pojo.Question" %>
<%@ page import="com.sc.springmvc.pojo.Student" %>
<%@ page import="com.sc.springmvc.pojo.Examine" %>
<%@ page import="com.sc.springmvc.pojo.Paper" %>
<!DOCTYPE html>
<html>
<% 
	List<Question> questionList = (List<Question>) session.getAttribute("questionList");
	Student student = (Student) session.getAttribute("STUDENT_SESSION");
	String stu_test_id = (String) session.getAttribute("stu_test_id");
	Examine examine = (Examine) session.getAttribute("examine");
	Paper paper = (Paper) session.getAttribute("paper");
	System.out.println(student.getName());
	
	List<String> answerList = Arrays.asList(examine.getAnswer().split(","));
	List<String> keyList = Arrays.asList(paper.getKey_seq().split(","));
	
	int questionNum = 1;
%>
<head>
<meta charset="UTF-8">
<title>开始考试</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' /> 
</head>
<body>
<table width="1600" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="1200" valign="top" >
    	<form action="${pageContext.request.contextPath }/submitExamine" method="post">
    		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
      			<tr>
        			<td><div align="center" >考生姓名：<%=student.getName() %></div></td>
        			<td><div align="center" >准考证号：<%=stu_test_id %></div></td>
      			</tr>
      			<tr>
        			<td>&nbsp;</td>
        			<td><div id="tTime"></div></td>
        			<td>&nbsp;</td>
      			</tr>
      
      		<!--题目开始-->
     
<%
			for(Question q:questionList) { 
%>
<%
			if(q.getQuestion_form() == 'C') {
%>
				<tr>
        			<td colspan="3" bgcolor="" >选择题</td>
      			</tr>
      			<tr>
					<input type="hidden" name="question_name=<%=questionNum%>" value="<%=q.getQuestion_id() %>" /> 
					<td colspan="3"><strong>第<%=questionNum %>题&nbsp;<%=q.getQuestion_body() %></strong> 
				</tr>
				<tr>
					<td colspan="3"><strong>A．</strong><%=q.getBranch_a() %></td>
				</tr>
				<tr>
					<td colspan="3"><strong>B．</strong><%=q.getBranch_b() %></td>
				</tr>
				<tr>
					<td colspan="3"><strong>C．</strong><%=q.getBranch_c() %></td>
				</tr>
				<tr>
        			<td height="32" colspan="3" bgcolor="" class="abb">所选答案：<%=answerList.get(questionNum-1) %>
          			</td>
      			</tr>
      			<tr>
        			<td height="32" colspan="3" bgcolor="" class="abb">正确答案：<%=keyList.get(questionNum-1) %>
          			</td>
      			</tr>
<%
				if(keyList.get(questionNum-1).equals(answerList.get(questionNum-1))) {
%>					
					<tr>
        				<td height="32" colspan="3" bgcolor="greenyellow"><h3>√</h3>
          				</td>
      				</tr>
<%					
				}
				else {
%>
					<tr>
        				<td height="32" colspan="3" bgcolor="red"><h3>×</h3>
          				</td>
      				</tr>
<%
				}
%>     			
<%     			
			}
			else {
%>
				<tr>
        			<td colspan="3" bgcolor="" >判断题</td>
      			</tr>
      			<tr>
					<input type="hidden" name="question_id" value="<%=q.getQuestion_id() %>" /> 
					<td colspan="3"><strong>第<%=questionNum %>题&nbsp;<%=q.getQuestion_body() %></strong> 
				</tr>
				<tr>
        			<td height="32" colspan="3" bgcolor="" class="abb">所选答案：<%=answerList.get(questionNum-1) %>
          			</td>
      			</tr>
      			<tr>
        			<td height="32" colspan="3" bgcolor="" class="abb">正确答案：<%=keyList.get(questionNum-1) %>
          			</td>
      			</tr>
<%
				if(keyList.get(questionNum-1).equals(answerList.get(questionNum-1))) {
%>					
					<tr>
        				<td height="32" colspan="3" bgcolor="greenyellow"><h3>√</h3>
          				</td>
      				</tr>
<%					
				}
				else {
%>
					<tr>
        				<td height="32" colspan="3" bgcolor="red"><h3>×</h3>
          				</td>
      				</tr>
<%
				}
%>     			
<%
			}
%>		
			<%=questionNum++ %>
<%
			}
%>     		
      			
      			
       		<!--题目结束-->
    		</table>
     	</form>
    </td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
<form action="${pageContext.request.contextPath }/toLogin" method="post">
	<div class="aa"><input type="submit" value="退出"></input></div>
</form>
</body>
</html>