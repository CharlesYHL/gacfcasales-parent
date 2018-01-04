/**
 * 
 */
package com.gacfcasales.dcsweb.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gacfcasales.common.Result;

/**
 * @author longrui
 * 2017年5月16日
 *	
 */
public class SecurityUtils {
	
	private static Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

	public static boolean isAjax(HttpServletRequest request) {
		return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
	}
	
	public static void sendJson(HttpServletResponse response, Result result) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try{
			out = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			out.append(mapper.writeValueAsString(result));
			out.close();
		}catch(IOException e) {
			logger.error(e.getMessage());
		}finally {
			if(out != null) out = null;
 		}
	}
	
}
