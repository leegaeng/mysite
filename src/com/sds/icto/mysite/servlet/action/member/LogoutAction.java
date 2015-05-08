package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.servlet.action.main.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		HttpSession session = req.getSession();
		session.removeAttribute("authMember");
		session.invalidate();
		
		
		res.sendRedirect("/mysite_jstl/main");
	}

}
