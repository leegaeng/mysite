package com.sds.icto.mysite.servlet.action.guestbook;

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

	public Action getAction(String gb) {
		Action action = null;

		if ("add".equals(gb)) {
			action = new AddAction();
		} else if ("delete".equals(gb)) {
			action = new DeleteAction();
		} else if ("deleteform".equals(gb)) {
			action = new DeleteFormAction();
		}

		if (action == null) {
			action = new IndexAction();
		}

		return action;
	}

}
