<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<ul>
	<c:choose>
		<c:when test="${param.type=='main'}">
			<li class="selected">안대혁</li>
			<li><a href="/mysite_jstl/guestbook">방명록</a></li>
			<li><a href="">게시판</a></li>
		</c:when>

		<c:when test="${param.type=='guestbook'}">
			<li>안대혁</li>
			<li class="selected"><a href="/mysite_jstl/guestbook">방명록</a></li>
			<li><a href="">게시판</a></li>
		</c:when>

		<c:otherwise>
			<li>안대혁</li>
			<li><a href="/mysite_jstl/guestbook">방명록</a></li>
			<li class="selected"><a href="">게시판</a></li>
		</c:otherwise>
	</c:choose>

</ul>