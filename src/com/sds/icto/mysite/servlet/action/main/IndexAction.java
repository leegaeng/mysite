package com.sds.icto.mysite.servlet.action.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.servlet.WebUtil;

public class IndexAction implements Action {

	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException, ClassNotFoundException,
			SQLException {
		WebUtil.forward("/views/main/index.jsp", req, res);

	}

}
