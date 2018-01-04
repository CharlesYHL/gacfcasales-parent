/**
 * 
 */
package com.gacfcasales.dcsweb.shiro;

import java.security.Permissions;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Assist.WhereRequire;
import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.SysUser;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.dcsweb.service.SysResourceService;
import com.gacfcasales.dcsweb.service.SysRoleService;
import com.gacfcasales.dcsweb.service.SysUserService;

/**
 * @author longrui
 * 2016年12月5日
 *	
 */
public class UserRealm extends AuthorizingRealm {
	
	@Autowired private SysUserService userService;
	@Autowired private SysRoleService sysRoleService;
	@Autowired private SysResourceService sysResourceService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SysUser sysUser = (SysUser)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermission("/index");
		Assist assist = new Assist();
		assist.setDistinct(true);
		WhereRequire<Long> require = Assist.andEq("rr.role_id", sysUser.getRoleId());
		assist.setRequires(require);
		List<SysResource> list =  sysResourceService.selectSysResource(assist);
		List<String> urlList = new LinkedList<String>();
		for (SysResource sysResource : list) {
			if(!"".equals(sysResource.getUrl()) && sysResource.getUrl() != null){
				urlList.add(sysResource.getUrl());
			}
		}
		authorizationInfo.addStringPermissions(urlList);
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CustomAuthenticationToken custoken = (CustomAuthenticationToken) token;
		//String username = (String)token.getPrincipal();
		String username = custoken.getUsername();
		String password = new String(custoken.getPassword());
		String dealerCode = custoken.getHost();
		SysUser sysUser = new SysUser();
		sysUser.setLoginName(username);
		sysUser.setDearlerCode(dealerCode);
		sysUser.setPassword(password);
		//SysUser user = userService.selectSysUserByObj(sysUser);
		//TcUser tcUser = userService.selectTcUserObj(sysUser);
		SysUser user = new SysUser();
		Map map = new HashMap();
		
		TcUser tcUser = userService.selectTcUserObj(sysUser);
		if(tcUser == null) throw new UnknownAccountException();
		user.setId(tcUser.getUserId());
		user.setPassword(tcUser.getPassword());
		user.setLoginName(tcUser.getName());
		map.put("userId", tcUser.getUserId());
		map.put("userCode", tcUser.getAcnt());
		
		/*if("999999".equals(dealerCode)) {
			
		}else {
			TmUser tmUser = userService.selectTmUserObj(sysUser);
			if(tmUser == null) throw new UnknownAccountException();
			user.setId(tmUser.getUSER_ID());
			user.setPassword(tmUser.getPASSWORD());
			user.setLoginName(tmUser.getUSER_NAME());
			map.put("userId", tmUser.getUSER_ID());
			map.put("userCode", tmUser.getUSER_CODE());
		}*/
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user, user.getPassword(), getName());
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		//Long roleId = sysRoleService.selectSysRoleByUserId(tmUser.getUSER_ID(),tmUser.getUSER_CODE());
		Long roleId = sysRoleService.selectTmUserRoleByMap(map);
		user.setRoleId(roleId);
		session.setAttribute("users", user);
		return authenticationInfo;
	}
	
	@PostConstruct
	public void initCredentialsMatcher() {
		setCredentialsMatcher(new CustomCredentialsMatcher());
	}

}
