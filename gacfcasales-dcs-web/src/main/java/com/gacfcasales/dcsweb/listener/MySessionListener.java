package com.gacfcasales.dcsweb.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionListener implements SessionListener {
	private static final Logger logger = LoggerFactory.getLogger(MySessionListener.class);

	@Override
	public void onStart(Session session) {// 会话创建时触发
		System.out.println("会话创建：" + session.getId());
	}

	@Override
	public void onExpiration(Session session) {// 会话过期时触发
		System.out.println("会话过期：" + session.getId());
	}

	@Override
	public void onStop(Session session) {// 退出/会话过期时触发
		System.out.println("会话停止：" + session.getId());
	}

}
