package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.servlet.WebUtil;
import com.sds.icto.mysite.servlet.action.main.Action;
import com.sds.icto.mysite.vo.Board;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		String no = req.getParameter("no");

		BoardDao dao = new BoardDao();
		dao.deleteBoard(Long.parseLong(no));

		List<Board> list = dao.fetchList();
		req.setAttribute("list", list);

		WebUtil.forward("/views/board/list.jsp", req, res);

	}

}
