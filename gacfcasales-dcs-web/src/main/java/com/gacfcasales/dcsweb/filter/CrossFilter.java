package com.gacfcasales.dcsweb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

public class CrossFilter extends OncePerRequestFilter {
	@Value("${security.server.url}")
	private String securityServerUrl;
	
	@Value("${sso.client.url}")
	private String ssoClientUrl;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Max-Age", "7200"); 
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization"); 
		response.setHeader("Access-Control-Allow-Credentials", "true"); 
		response.setContentType("text/html; charset=utf-8");
		filterChain.doFilter(request, response); 
	}

}
