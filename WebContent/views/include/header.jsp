<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sds.icto.mysite.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="/mysite_jstl/main"><h1>MySite</h1></a>
<ul>

	<c:choose>
		<c:when test="${empty authMember}">
			<li><a href="/mysite_jstl/member?a=loginform">로그인</a>
			<li>
			<li><a href="/mysite_jstl/member?a=joinform">회원가입</a>
			<li>
		</c:when>
		<c:when test="${!empty authMember}">
			<li><a href="/mysite_jstl/member?a=uinfo">회원정보수정</a>
			<li>
			<li><a href="/mysite_jstl/member?a=logout">로그아웃</a>
			<li>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="${!empty authMember}">
			<li>${authMember.name}님 안녕하세요^^</li>
		</c:when>
		<c:when test="${empty authMember}">
			<li>손님 반갑습니다! </li>
		</c:when>

	</c:choose>
	
</ul>