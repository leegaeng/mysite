package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.MemberDao;
import com.sds.icto.mysite.servlet.action.main.Action;
import com.sds.icto.mysite.vo.Member;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Member m = new Member();
		m.setEmail(email);
		m.setPassword(password);

		MemberDao dao = new MemberDao();

		Member authMember = dao.getMember(email, password);
		if (authMember == null) {
			res.sendRedirect("/mysite_jstl/member?a=loginform&result=fail");
			return;
		} 
		
		HttpSession session = req.getSession(true);
		
		session.setAttribute("authMember", authMember);
		res.sendRedirect("/mysite_jstl/main");

	}

}
