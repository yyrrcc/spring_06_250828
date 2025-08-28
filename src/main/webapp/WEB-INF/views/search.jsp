<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원찾기</h3>
	<form action="searchOk">
		아이디 : <input type="text" name="memberid" value="${memberDto.memberid }"><br/>
		<input type="submit" value="찾기">
	</form>
	
	<hr/>
	
	<c:if test="${not empty result }">
		<h4 style="color: blue;">
			검색된 아이디 : ${memberDto.memberid } <br/>
			검색된 이름 : ${memberDto.membername } <br/>
			검색된 나이 : ${memberDto.memberage } <br/>
		</h4>
	</c:if>
</body>
</html>