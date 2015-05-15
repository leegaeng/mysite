package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.servlet.WebUtil;
import com.sds.icto.mysite.servlet.action.main.Action;

public class InsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {
		WebUtil.forward("/views/board/insertform.jsp", req, res);

	}

}
