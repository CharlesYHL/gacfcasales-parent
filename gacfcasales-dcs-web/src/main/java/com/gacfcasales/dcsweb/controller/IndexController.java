package com.gacfcasales.dcsweb.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gacfcasales.common.Result;
import com.gacfcasales.dcsweb.shiro.CustomAuthenticationToken;
import com.gacfcasales.common.util.Md5Util;

@Controller
@RequestMapping
public class IndexController {
	
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Value("${sso.server.url}")
	private String serverUrl;
	
	@Value("${sso.client.url}")
	private String clientUrl;
	
	@RequestMapping("/")
	public String index() {
		logger.info("============");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/home")
	public String toHomePage() {
		return "home";
	}
	
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String loginPage(){
		logger.info("请求登录页面");
		return "login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public Result login(@RequestParam String userName,@RequestParam String password,@RequestParam String dealerCode){
		logger.info("AJAX请求登录");
		Result<String> result = new Result<String>();
		try{
			Subject subject = SecurityUtils.getSubject();
			/*if((System.currentTimeMillis()-subject.getSession().getStartTimestamp().getTime())>=lengthenTimeOut-1000){
				
			}*/
			
			CustomAuthenticationToken token = new CustomAuthenticationToken(userName, password,dealerCode);
			subject.login(token);
			logger.info("用户【"+userName+"】登录成功");
		}catch (LockedAccountException e) {
			result.setCode(300);
			result.setMessage("账户已锁定");
		}catch (AuthenticationException e) {
			System.out.println(e.getMessage());
			result.setCode(300);
			result.setMessage("用户名或密码错误");
		}
		return result;
	}
	
	/*@RequestMapping("/")
	public String fordPAGE(){
		logger.info("请求/");
		return "login";
	}*/
	
	/*@RequestMapping("/index")
	public String index(){
		logger.info("请求首页");
		
		return "index";
	}
	*/
	@RequestMapping("/loginout")
	public String loginout(HttpSession session){
		//Subject subject = SecurityUtils.getSubject();
		//subject.logout();
		 session.invalidate();
		 //session.
		// String url = "redirect:"+serverUrl+"/login?service="+clientUrl+"/cas";
		 String url = "redirect:"+serverUrl+"/logout";
		return url;
	}
	
}
