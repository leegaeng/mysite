package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestbookDao;
import com.sds.icto.mysite.servlet.WebUtil;
import com.sds.icto.mysite.servlet.action.main.Action;
import com.sds.icto.mysite.vo.Guestbook;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {
		request.setCharacterEncoding("utf-8");

		String no = request.getParameter("no");
		String password = request.getParameter("password");
		GuestbookDao dao = new GuestbookDao();

		if (no != null || password != null) {

			dao.delete(Integer.parseInt(no), password);

		}

		List<Guestbook> list = dao.fetchList();
		request.setAttribute("list", list);

		WebUtil.forward("/views/guestbook/list.jsp", request, response);
	}

}
