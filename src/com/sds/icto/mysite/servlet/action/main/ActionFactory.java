package com.sds.icto.mysite.servlet.action.main;

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

	public Action getAction(String a) {
		Action action = new IndexAction();

		return action;
	}

}
