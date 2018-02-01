package com.gacfcasales.dcsweb.interceptor;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.gacfcasales.common.Result;
import com.gacfcasales.dcsweb.shiro.SecurityUtils;

public class ExpiredSign extends PermissionsAuthorizationFilter {
	
	public boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		Subject subject = getSubject(request, response);

		if (subject.getPrincipal() == null) {
			if (SecurityUtils.isAjax(request)) {
				SecurityUtils.sendJson(response, new Result("您尚未登录或登录时间过长，请刷新页面或重新登录！"));
			} else {
				saveRequestAndRedirectToLogin(request, response);
			}
		} else {
			if (SecurityUtils.isAjax(request)) {
				SecurityUtils.sendJson(response, new Result("您没有足够的权限执行该操作!"));
			} else {
				String unauthorizedUrl = getUnauthorizedUrl();
				if (StringUtils.isNotEmpty(unauthorizedUrl)) {
					WebUtils.issueRedirect(request, response, unauthorizedUrl);
				} else {
					WebUtils.toHttp(response).sendError(403);
				}
			}
		}
		return false;
	}
}
