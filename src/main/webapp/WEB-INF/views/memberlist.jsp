<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든회원목록</title>
</head>
<body>
	<c:forEach items="${memberDtos }" var="m">
		${m.memberid } <br/>
		${m.membername } <br/>
		${m.memberage } <br/>
		--------------- <br/>
	</c:forEach>
</body>
</html>