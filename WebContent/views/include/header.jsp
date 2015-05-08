<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sds.icto.mysite.vo.*"%>

<h1>MySite</h1>
<ul>
	<%
		Member authMember = (Member) session.getAttribute("authMember");

		if (authMember == null) {
	%>

	<li><a href="/mysite_jstl/member?a=loginform">로그인</a>
	<li>
	<li><a href="/mysite_jstl/member?a=joinform">회원가입</a>
	<li>
		<%
			} else {
		%>
	
	<li><a href="/mysite_jstl/member?a=uinfo">회원정보수정</a>
	<li>
	<li><a href="/mysite_jstl/member?a=logout">로그아웃</a>
	<li>
		<%
			}
		%>
	
	<li>${authMember.name}님 안녕하세요 ^^</li>
</ul>