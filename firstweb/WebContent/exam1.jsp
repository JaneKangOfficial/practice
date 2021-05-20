<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 선언문 </title>
</head>
<body>
<%-- 
	선언문 <%! %> : 선언문은 JSP 페이지 내에서 필요한 멤버변수나 메소드가 필요할 때 선언해 사용하는 요소
					선언문의 문법 <%! 문장 %>
 --%>

id : <%= getId() %>

<%!
	String id = "u001"; // 멤버변수 선언
	public String getId() {	// 메소드 선언
		return id;
	}
%>

</body>
</html>