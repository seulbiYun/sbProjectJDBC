<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${pageContext.request.contextPath }/css/common.css" type ="text/css" rel = "stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src = "${pageContext.request.contextPath }/js/common.js"></script>
<script>
	$(function(){
		$("#f1").submit(function(i,obj){
			var result = checkInputEmpty($("input[name],textarea"));
			if(result == false){
				return false;
			}
		})
		$.fn.dateInput = function(){
			this.attr("type", "date");
		};
		
		$("input[type = 'date']").dateInput();
		
		var count = 0;
		$("input[name='sbProgress']").each(function(i,obj){
			if($(obj).val() == ""){
				$(obj).next().css("display","inline");
				count++;
			}
		})
		
		if(count > 0){//에러가 있으면 전송을 막음
			return false;
		}else{
			return true;
		}
		
	})
</script>
</head>
<body>
	<form action = "insert.do" method = "post" id = "f1">
		<fieldset>
			<legend>프로젝트 등록하기</legend>
			<p>
				<label>프로젝트 이름</label>
				<input type = "text" name = "sbName">
				<span class = "error">프로젝트 이름을 입력 하세요</span>
			</p>
			<p>
				<label>프로젝트 내용</label>
				<textarea rows="10" cols="60" name = "sbContent"></textarea>
				<span class = "error"><br>프로젝트 내용을 입력 하세요</span>
			</p>
			<p>
				<label>시작 날짜</label>
				<input type = "date" name = "sbStart">
				<span class = "error">시작 날짜를 입력 하세요</span>
			</p>
			<p>
				<label>종료 날짜</label>
				<input type = "date" name = "sbStop">
				<span class = "error">종료 날짜를 입력 하세요</span>
			</p>
			<p>
				<label>진행 상태</label>
				<input type = "radio" name = "sbProgress" value = "준비중"> 준비중
				<input type = "radio" name = "sbProgress" value = "진행중"> 진행중
				<input type = "radio" name = "sbProgress" value = "종료"> 종료
				<input type = "radio" name = "sbProgress" value = "보류"> 보류
				<span class = "error">진행 상태를 선택 하세요</span>
			</p>
			<input type = "submit" value = "등록">
		</fieldset>
	</form>
</body>
</html>