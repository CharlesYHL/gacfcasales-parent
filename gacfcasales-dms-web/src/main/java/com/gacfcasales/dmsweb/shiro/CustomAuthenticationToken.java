/**
 * 
 */
package com.gacfcasales.dmsweb.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author longrui
 * 2016年12月7日
 *	
 */
public class CustomAuthenticationToken extends UsernamePasswordToken {
	
	private static final long serialVersionUID = -1291602401357040028L;
	
	/*public CustomAuthenticationToken(final String username, final String password) {
		super(username, password);
	}*/
	
	public CustomAuthenticationToken(final String username, final String password,final String dealerCode) {
		super(username, password,dealerCode);
	}
	

}
