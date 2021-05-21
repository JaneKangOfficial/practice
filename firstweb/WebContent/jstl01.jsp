<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	jstl 사용하려면
	
	1.	http://tomcat.apache.org/download-taglibs.cgi
		위의 사이트에서 3가지 jar파일을 다운로드 한 후 WEB-INF/lib/ 폴더에 복사를 한다.
		taglibs-standard-impl-1.2.5.jar
		taglibs-standard-spec-1.2.5.jar
		taglibs-standard-jstlel-1.2.5.jar
	
	2. <%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>  를 작성한다. 
 --%>
 <!-- set과 remove 활용 -->
 <%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set var="value1"	scope="request"	value="kang"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

성 : ${value1} <br>
<c:remove var="value1"	scope="request"/>
성 : ${value1} <br>

</body>
</html>