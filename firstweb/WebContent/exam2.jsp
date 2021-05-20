<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 스크립트릿 </title>
</head>
<body>
<%-- 
	스크립트릿 <% %> : 가장 일반적으로 많이 쓰이는 스크립트 요소
					주로 프로그래밍의 로직을 기술할 때 사용
					스크립트릿에서 선언된 변수는 지역변수
					스크트릿의 문법 <% 문장 %>
 --%>

<%
	for(int i = 1; i <= 5; i++) {
%>

<H<%= i %>> 아름다운 한글 </H<%= i %>>		

<%
	}
%>

</body>
</html>