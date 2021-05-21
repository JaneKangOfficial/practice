<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>

<!-- import는 url에 있는 코드를 출력함  -->
<c:import url="http://localhost:8080/firstweb/jstlValue.jsp" var="urlValue"	scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${urlValue}

</body>
</html>