<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/
work/Catalina/localhost/[firstweb]/org/apache/jsp/[sum10_jsp.java] 에서 _jspService()를 보면 
jsp가 servlet으로 변경된것 확인 가능 -->

<%-- 선언문 <%! %> : 전역변수 선언 및 메소드 선언에 사용
	스크립트릿 <% %> : 프로그래밍 코드 기술에 사용 
	표현식 <%= %> : 화면에 출력할 내용 기술에 사용 
--%>


<%
	int total = 0;
	for(int i = 0; i <= 10; i++) {
		total += i;
	}
%>

1부터 10까지의 합 : <%= total %>

</body>
</html>