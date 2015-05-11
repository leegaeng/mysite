<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite_jstl/assets/css/user.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post"
					action="/mysite_jstl/member?a=login">
					<label class="block-label" for="email">이메일</label> <input
						type="hidden" name="a" value="login" /> <input id="email"
						name="email" type="text" value=""> <label
						class="block-label">패스워드</label> <input name="password"
						type="password" value="">

					<c:if test="${param.result == 'fail'}">
						<p>로그인이 실패 했습니다.</p>

					</c:if>

					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
				<c:param name="type" value="main"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<jsp:include page="/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>