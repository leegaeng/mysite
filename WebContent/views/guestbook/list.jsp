<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sds.icto.mysite.dao.GuestbookDao"
	import="com.sds.icto.mysite.vo.Guestbook" import="java.util.List"%>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite_jstl/guestbook" method="post">
					<input type="hidden" name="a" value="add">


					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>

				<ul>
					<li>
						<%
							List<Guestbook> list = (List<Guestbook>) request
									.getAttribute("list");
							System.out.print(list.size());
							if (list.size() > 0) {
								for (Guestbook g : list) {
						%>
						<table>
							<tr>
								<td>[<%=g.getNo()%>]
								</td>
								<td><%=g.getName()%></td>
								<td><%=g.getReg_date()%></td>
								<td><a
									href="/mysite_jstl/guestbook?a=deleteform&no=<%=g.getNo()%>">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4><%=g.getMessage()%></td>
							</tr>
						</table> <%
 		}
 	} else {
 %>

						<table width=510 border=1>
							<tr>
								<td colspan=4>등록된 방명록이 없습니다.</td>
							</tr>
						</table> <%
 	}
 %>


					</li>

				</ul>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page="/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>