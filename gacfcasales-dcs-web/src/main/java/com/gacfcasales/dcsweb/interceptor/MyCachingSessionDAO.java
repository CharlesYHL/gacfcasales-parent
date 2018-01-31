package com.gacfcasales.dcsweb.interceptor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCachingSessionDAO extends CachingSessionDAO {
	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	private Map<Serializable, Session> map = new HashMap<Serializable, Session>();
	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub
		System.out.println("now update session");
		logger.debug("now update session");
		map.put(session.getId(), session);
	}

	@Override
	protected void doDelete(Session session) {
		// TODO Auto-generated method stub
		System.out.println("now delete session");
		logger.debug("now delete session");
		map.remove(session.getId());
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		System.out.println("now doCreate session");
		logger.debug("now doCreate session");
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		map.put(sessionId, session);

		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		System.out.println("now doReadSession session");
		logger.debug("now doReadSession session");
		System.out.println("判断Session===="+map.get(sessionId));
		return map.get(sessionId);
	}
	
}
