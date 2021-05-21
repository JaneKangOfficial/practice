<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="t"	value="<script type='text/javascript'>alert(1);</script>"/>

<%-- escapeXml이 true일 경우 태그가 아닌 문자로 인식해서 출력한다 --%>
<c:out value="${t}"	escapeXml="false"/>

</body>
</html>