<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${pageContext.request.contextPath }/css/common.css" type ="text/css" rel = "stylesheet">
</head>
<body>
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<td>${sb.sbName }</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${sb.sbContent }</td>
		</tr>
		<tr>
			<th>시작 날짜</th>
			<td>${sb.sbStart }</td>
		</tr>
		<tr>
			<th>종료 날짜</th>
			<td>${sb.sbStop }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${sb.sbProgress }</td>
		</tr>
	</table>
	<p>
		<a href = "${pageContext.request.contextPath }/update.do?sbNo=${sb.sbNo}">수정</a>
		<a href = "${pageContext.request.contextPath }/delete.do?sbNo=${sb.sbNo}">삭제</a>
		<a href = "${pageContext.request.contextPath }/list.do">목록으로 돌아가기</a>
	</p>
</body>
</html>