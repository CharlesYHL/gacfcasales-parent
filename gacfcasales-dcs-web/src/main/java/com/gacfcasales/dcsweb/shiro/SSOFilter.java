/**
 * 
 */
package com.gacfcasales.dcsweb.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author longrui
 * 2017年3月1日
 *	
 */

@Deprecated
public class SSOFilter extends CasFilter {
	
	@Autowired private SecurityClientRealm realm;

	public boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		realm.clearCachedAuthorizationInfo(subject.getPrincipals());
		issueSuccessRedirect(request, response);
		return false;
	}
	
}
