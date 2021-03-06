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

public class SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		String searchfield = req.getParameter("searchfield");
		BoardDao dao = new BoardDao();
		List<Board> list = dao.fetchBoard(searchfield);
		req.setAttribute("list", list);
		req.setAttribute("searchfield", searchfield);

		WebUtil.forward("/views/board/list.jsp", req, res);

	}

}
