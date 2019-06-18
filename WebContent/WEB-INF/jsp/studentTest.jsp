<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sc.springmvc.pojo.Question" %>
<%@ page import="com.sc.springmvc.pojo.Student" %>
<!DOCTYPE html>
<html>
<% 
	List<Question> questionList = (List<Question>) session.getAttribute("questionList");
	Student student = (Student) session.getAttribute("STUDENT_SESSION");
	String stu_test_id = (String) session.getAttribute("stu_test_id");
	System.out.println(student.getName());
	int questionNum = 1;
%>
<head>
<meta charset="UTF-8">
<title>开始考试</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' /> 
<script type="text/javascript">
 var ksTime; //定义考试时间以分钟计算
 ksTime = 60;//设置时间
 if(readCookie("ss")==""){
  setCookie("ss",new Date(),ksTime/60);
 }
 function sT(){
  var tti = new Date();
  var lt  = parseInt((tti-new Date(readCookie("ss")))/1000)
  if((ksTime*60-lt)<0){
   setCookie("ss",new Date(),0);
   alert("考试时间到!\n即将提交试卷!");
   document.forms[0].submit();
  }else{
      lm = Math.floor(lt / 60);
    ls = lt % 60;
    allY = ksTime*60-lt;
    ym = Math.floor(allY / 60);
    ys = allY % 60;
   document.getElementById("tTime").innerHTML = "离考试结束还有："  + ym + "min" + ys + "s";
   var ttt = setTimeout("sT()",1000);
  }
 }
 function readCookie(name) { 
  var cookieValue = ""; 
  var search = name + "="; 
  if(document.cookie.length > 0) { 
   offset = document.cookie.indexOf(search); 
   if (offset != -1) { 
    offset += search.length; 
    end = document.cookie.indexOf(";", offset); 
    if (end == -1) 
     end = document.cookie.length; 
    cookieValue = document.cookie.substring(offset, end) 
   } 
  } 
  return cookieValue; 
 }  
 function setCookie(name, value, hours) { 
  var expire = ""; 
  if(hours != null) { 
   expire = new Date((new Date()).getTime() + hours * 3600000); 
   expire = "; expires=" + expire.toGMTString(); 
  } 
  document.cookie = name + "=" + value + expire; 
 }
 </script>
</head>
<body>
<table width="1600" height="485" border="0" cellpadding="0" cellspacing="0" >
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
        			<td colspan="3" bgcolor="">单选题</td>
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
        			<td height="32" colspan="3" class="abb">
          				<input type="radio" name="subjectAnswer=<%=questionNum%>" value="A" checked="checked"/>
          				A
          				<input type="radio" name="subjectAnswer=<%=questionNum%>" value="B" />
          				B
          				<input type="radio" name="subjectAnswer=<%=questionNum%>" value="C" />
          				C
          			</td>
      			</tr>
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
        			<td height="32" colspan="3" class="abb">
          				<input type="radio" name="subjectAnswer=<%=questionNum%>" value="A" checked="checked"/>
          				对
          				<input type="radio" name="subjectAnswer=<%=questionNum%>" value="B" />
          				错
          			</td>
      			</tr>
<%
			}
%>		
			<%=questionNum++ %>
			
<%
			}
%>     		
      			
      			
       		<!--题目结束-->
      			<tr>
        			<td colspan="3"><div align="center">
          				<input type="submit" value=" 提交答卷 " name="Submit" />
        			</div></td>
      			</tr>
    		</table>
     	</form>
    </td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>
</html>