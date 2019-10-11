<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${pageContext.request.contextPath }/css/common.css" type ="text/css" rel = "stylesheet">
</head>
<body>
	<a href = "insert.do">[ 새 프로젝트 등록 ]</a>
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작 날짜</th>
			<th>종료 날짜</th>
			<th>상태</th>
		</tr>
		<c:forEach var = "l" items = "${list }">
			<tr>
				<td><a href = "read.do?sbNo=${l.sbNo }">${l.sbName }</a></td>
				<td>${l.sbStart }</td>
				<td>${l.sbStop }</td>
				<td>${l.sbProgress }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>