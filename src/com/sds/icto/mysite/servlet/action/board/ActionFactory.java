package com.sds.icto.mysite.servlet.action.board;

import com.sds.icto.mysite.servlet.action.main.Action;

public class ActionFactory {
	private static ActionFactory instance;

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		if (instance == null) {
			instance = new ActionFactory();
		}

		return instance;
	}

	public Action getAction(String b) {
		Action action = null;

		if ("add".equals(b)) {

		} else if ("insertform".equals(b)) {
			action = new InsertFormAction();
		} else if ("insert".equals(b)) {
			action = new InsertAction();
		} else if ("boardview".equals(b)) {
			action = new BoardViewAction();
		} else if ("delete".equals(b)) {
			action = new DeleteAction();
		} else if ("update".equals(b)) {
			action = new UpdateAction();
		} else if ("search".equals(b)) {
			action = new SearchAction();
		}

		if (action == null) {

			action = new ListAction();

		}

		return action;
	}
}
