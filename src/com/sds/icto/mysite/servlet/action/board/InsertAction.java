package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.servlet.WebUtil;
import com.sds.icto.mysite.servlet.action.main.Action;
import com.sds.icto.mysite.vo.Board;
import com.sds.icto.mysite.vo.Member;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {

		HttpSession session = req.getSession();
		Member m = (Member) session.getAttribute("authMember");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		BoardDao dao = new BoardDao();

		Board b = new Board(title, content, m.getNo(), m.getName());
		dao.insertBoard(b);

		List<Board> list = dao.fetchList();
		req.setAttribute("list", list);

		WebUtil.forward("/views/board/list.jsp", req, res);

	}

}
