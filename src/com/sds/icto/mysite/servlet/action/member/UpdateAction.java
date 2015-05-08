package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.MemberDao;
import com.sds.icto.mysite.servlet.action.main.Action;
import com.sds.icto.mysite.vo.Member;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		Long no = (long) Integer.parseInt(req.getParameter("no"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");

		MemberDao dao = new MemberDao();
		Member m = new Member();
		m.setNo(no);
		m.setName(name);
		m.setEmail(email);
		m.setPassword(password);
		m.setGender(gender);

		dao.update(m);

		res.sendRedirect("/mysite_jstl/main");

	}

}
