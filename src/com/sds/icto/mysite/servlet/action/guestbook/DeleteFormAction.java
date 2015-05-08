package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.servlet.WebUtil;
import com.sds.icto.mysite.servlet.action.main.Action;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		request.setAttribute("no", no);
		WebUtil.forward("/views/guestbook/deleteform.jsp", request, response);

	}

}
