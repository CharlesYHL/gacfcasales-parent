/**
 * 
 */
package com.gacfcasales.dmsweb.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.gacfcasales.common.util.MD5UtilCommon;
import com.gacfcasales.common.util.Md5Util;

/**
 * @author longrui
 * 2016年12月7日
 *	
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
		CustomAuthenticationToken token = (CustomAuthenticationToken) authenticationToken;
		//Object tokenCredentials = Md5Util.generateTwoPassword(new String(token.getPassword()));  
        Object accountCredentials = getCredentials(authenticationInfo);  
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false  
        
        //return equals(tokenCredentials, accountCredentials);  
        return MD5UtilCommon.validPassword(new String(token.getPassword()), accountCredentials.toString());
        
	}
}
