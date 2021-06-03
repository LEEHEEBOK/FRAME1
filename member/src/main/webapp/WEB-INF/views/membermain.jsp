<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout() {
		location.href="logout";
	}
	function update() {
		location.href="memberupdate";
	}
</script>
</head>
<body>
<h2>membermain.jsp</h2>
	
	로그인아이디: ${sessionScope.loginMember} <br>
	
	<h2>${sessionScope.loginMember} 님 반갑습니다!!</h2> 
	
	<div style="background-color:yellow;">
	<c:if test="${sessionScope.loginMember eq 'admin'}">
		<a href="memberlist">회원목록조회(관리자전용)</a>
		<h2>관리자아이디 접속중</h2>
	</c:if>
	</div>
	<button onclick="logout()">로그아웃</button> <br>	
	<button onclick="update()">회원정보수정</button> <br>
	
	<a href="./">홈으로</a>
</body>
</html>