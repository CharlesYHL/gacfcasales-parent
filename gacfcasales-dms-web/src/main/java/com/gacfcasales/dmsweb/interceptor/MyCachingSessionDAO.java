package com.gacfcasales.dmsweb.interceptor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//ExpiredSign
		
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
		//sessionId = "d8f734b44e233417a3b510b7e29ebad7";
		
		//Session s = map.get(sessionId);
		
		//s.setAttribute("expiredSign", "d8f734b44e233417a3b510b7e29ebad7");
		return map.get(sessionId);
	}
	
}
