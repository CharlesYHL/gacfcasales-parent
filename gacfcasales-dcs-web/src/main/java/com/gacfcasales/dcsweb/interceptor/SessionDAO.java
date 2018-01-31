package com.gacfcasales.dcsweb.interceptor;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionDAO extends AbstractSessionDAO {
	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	private Map<Serializable, Session> map = new HashMap<Serializable, Session>();

	public void update(Session session) throws UnknownSessionException {
		System.out.println("now update session");
		logger.debug("now update session");
		map.put(session.getId(), session);
	}

	public void delete(Session session) {
		System.out.println("now delete session");
		logger.debug("now delete session");
		map.remove(session.getId());
	}

	public Collection<Session> getActiveSessions() {
		System.out.println("now getActiveSessions session");
		logger.debug("now getActiveSessions session");
		return map.values();
	}

	protected Serializable doCreate(Session session) {
		System.out.println("now doCreate session");
		logger.debug("now doCreate session");
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		map.put(sessionId, session);

		return sessionId;
	}

	protected Session doReadSession(Serializable sessionId) {
		System.out.println("now doReadSession session");
		logger.debug("now doReadSession session");
		return map.get(sessionId);
	}
}
