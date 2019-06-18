<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>list</title> 
</head> 
<body> 
<table cellspacing="1" bordercolor="#990000" cellpadding="1" border="1px">
 <tr> 
  <td> 
  <form action="${pageContext.request.contextPath }/queryQuestion" method="get"> 
    <input type="submit" value="Research"> 
  </form> 
  </td> 
</tr> 

<tr> 
    <th>序号</th> 
    <th>编号</th> 
    <th>姓名</th>  
</tr> 

<c:forEach items="${questionList}" var="question" varStatus="vs"> 
    <tr> 
    	  <td>test.jsp 35</td> 
          <td>${vs.count }</td> 
          <td>${question.question_id }</td> 
          <td>${question.question_body }</td> 
    </tr> 
</c:forEach> 
</table> 
</body>
</html>
