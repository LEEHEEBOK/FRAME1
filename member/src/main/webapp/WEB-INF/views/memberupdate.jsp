<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function updatefn() {
		var passwordConfirm = document.getElementById('pwd').value;
		var password = '${member.mpassword}';
		if(password == passwordConfirm){
			updateform.submit();
		} else {
			alert('비밀번호가 틀립니다!!');
		}
	}
</script>
</head>
<body>
<h2>회원정보 수정</h2>
	<form action="updateprocess" method="post" name="updateform">
		아이디: <input type="text" name="mid" value="${member123.mid}" readonly><br>
		비밀번호: <input type="text" name="mpassword" id="pwd"><br>
		이름: <input type="text" name="mname" value="${member123.mname}" readonly><br>
		이메일: <input type="text" name="memail" value="${member123.memail}"><br>
	
		<input type="button" value="수정" onclick="updatefn()">
			
		<input type="submit" value="submit버튼">
		
	</form>

</body>
</html>