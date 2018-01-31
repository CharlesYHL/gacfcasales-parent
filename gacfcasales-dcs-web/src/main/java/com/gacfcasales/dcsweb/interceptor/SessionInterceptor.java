package com.gacfcasales.dcsweb.interceptor;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	// 定义日志接口
	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

	@Value("${sso.server.url}")
	private String serverUrl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("enter DMSFrameworkInterceptor preHandle");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// 获取请求的URL
		String path = httpServletRequest.getRequestURI();

		logger.debug("into LoginFilter:请求的地址：" + path + ";请求方法：" + httpServletRequest.getMethod() + "["
				+ request.getHeader("Referer") + "]");
		/*
		 * if (path.indexOf("/remote/securityService") != -1 || path.indexOf("/") != -1)
		 * { return true; }
		 */

		// 判断Session 是否失效
		HttpSession session = httpServletRequest.getSession();
		if (session != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long currentTime = session.getCreationTime();
			Date date = new Date(currentTime);
			String creatSessionTime = dateFormat.format(date);
			logger.debug("SESSIONID=" + session.getId() + "SESSIONTIMEOUT=" + creatSessionTime);
			// String = dateFormat.format(date);
			return true;
		} else {
			PrintWriter out = response.getWriter();
			StringBuffer sb = new StringBuffer("<script type=\"text/javascript\" charset=\"UTF-8\">");
			sb.append("alert(\"你的账号被挤掉，或者没有登录，或者页面已经过期，请重新登录\")");
			sb.append("window.location.href='" + serverUrl + "'/logout';");
			sb.append("</script>");
			out.print(sb.toString());
			out.close();
		}

		return false;
	}
}
