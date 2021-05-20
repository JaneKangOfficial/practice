<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 주석 </title>
</head>
<body>

<!-- 
	HTML 주석
	HTML 주석을 사용한 페이지를 웹에서 서비스할 때 화면에 주석이 내용이 표시되지는 않으나,
	[소스보기] 수행하면 HTML 주석의 내용이 화면에 표현 
 -->
 
 
<%-- 
	JSP 주석
	JSP 페이지에서만 사용
	JSP 주석은 해당 페이지를 웹 브라우저를 통해 출력 결과로서 표시하거나 웹 브라우저 상에서 소스 보기를 해도 표시 되지 않음
	또한 JSP 주석 내에 실행코드를 넣어도 그 코드는 실행되지 않음 
 --%>

<%
/*
	JAVA 주석 
	//은 한줄 주석을 작성할 때 사용 
	스크립트릿이나 선언문에서 사용되는 주석
	JAVA와 주석 처리 방법이 같음 
*/

	for(int i = 1; i <= 5; i++) {
%>

<H<%= i %>> 아름다운 한글 </H<%= i %>>		

<%
	}
%>

</body>
</html>