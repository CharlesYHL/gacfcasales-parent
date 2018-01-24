package com.gacfcasales.dcsweb.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.gacfcasales.common.entity.SysUser;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.dcsweb.remote.IRemoteSecurityService;
import com.gacfcasales.dcsweb.service.SysRoleService;
import com.gacfcasales.dcsweb.service.SysUserService;

public class SecurityClientRealm  extends CasRealm {
	
	@Value("${security.appkey}")
	private String appKey;
	
	@Resource(name="remoteSecurityClient")
	private IRemoteSecurityService remoteSecurityService;
	
	@Autowired private SysUserService userService;
	@Autowired private SysRoleService sysRoleService;
	
	
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String acnt = (String)principals.getPrimaryPrincipal();
        TcUser tcUser = new TcUser();
        //user.setType(User.TYPE_ADMIN);
        tcUser.setAcnt(acnt);
        
        Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		 Map map = userService.selectTcUserByOne(acnt);
		 //tcUser.setLoginName(loginName);;
	     if(map != null) {
	        	Map roleMap = new HashMap();
	        	roleMap.put("userId", map.get("USER_ID"));
	        	roleMap.put("userCode", map.get("ACNT"));
	        	roleMap.put("appId", appKey);
	    		Long roleId = sysRoleService.selectTmUserRoleByMap(roleMap);
	    		tcUser.setRoleId(roleId);
	    		session.setAttribute("users", tcUser);
	    		session.setAttribute("userName", map.get("NAME").toString());
	     }
	     
        authorizationInfo.addStringPermission("/home");
		authorizationInfo.addStringPermissions(remoteSecurityService.getPermissions(appKey, tcUser));
        return authorizationInfo;
    }
	
	@Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
