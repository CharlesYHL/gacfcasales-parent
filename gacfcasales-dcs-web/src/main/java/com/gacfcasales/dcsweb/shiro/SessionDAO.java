package com.gacfcasales.dcsweb.shiro;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gacfcasales.dcsweb.interceptor.SessionInterceptor;

public class SessionDAO extends AbstractSessionDAO {
	private static final Logger logger = LoggerFactory.getLogger(AbstractSessionDAO.class);
	private Map<Serializable, Session> map = new HashMap<Serializable, Session>();

	@Override
	public void update(Session session) throws UnknownSessionException {
		// TODO Auto-generated method stub
		System.out.println("now update session");
		logger.debug("now update session");
		map.put(session.getId(), session);
	}

	@Override
	public void delete(Session session) {
		// TODO Auto-generated method stub
		System.out.println("now delete session");
		logger.debug("now delete session");
		map.remove(session.getId());
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		System.out.println("now getActiveSessions session");
		logger.debug("now getActiveSessions session");
		return map.values();
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
		return map.get(sessionId);
	}

}
