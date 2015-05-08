<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<div id="content">
			<div id="user">
				<form id="uinfo-form" name="uinfoForm" method="post"
					action="/mysite_jstl/member">
					<input type="hidden" name="a" value="update"> <input
						type="hidden" name="no" value="${m.no}"> <label
						class="block-label" for="name">이름</label> <input id="name"
						name="name" type="text" value="${m.name}"><label
						class="block-label" for="email">이메일</label> <input id="email"
						name="email" type="text" value="${m.email}"> <input
						type="button" value="id 중복체크"> <label class="block-label">패스워드</label>
					<input name="password" type="password" value="${m.password}">

					<fieldset>
						<legend>성별</legend>

						<label>여</label> <input type="radio" name="gender" value="female"
							checked="checked">


						<c:if test="${m.gender == 'male'}">
							<label>남</label>
							<input type="radio" name="gender" value="male" checked="checked">
						</c:if>
						<c:if test="${m.gender != 'male'}">
							<label>남</label>
							<input type="radio" name="gender" value="male">
						</c:if>
					</fieldset>



					<input type="submit" value="수정하기">

				</form>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page="/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<jsp:include page="/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>