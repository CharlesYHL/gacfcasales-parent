package com.gacfcasales.dmsweb.shiro;

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

import com.gacfcasales.common.dto.LoginInfoDto;
import com.gacfcasales.common.entity.SysUser;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.dmsweb.remote.IRemoteSecurityService;
import com.gacfcasales.dmsweb.service.SysRoleService;
import com.gacfcasales.dmsweb.service.SysUserService;

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
        String dealer_name = (String)principals.getPrimaryPrincipal();
        String dealerCode = dealer_name.substring(0, dealer_name.indexOf(":"));
        String username = dealer_name.substring(dealer_name.indexOf(":")+1,dealer_name.length());
        TmUser tmUser = new TmUser();
        //user.setType(User.TYPE_ADMIN);
        tmUser.setEMPLOYEE_NO(username);
        tmUser.setDEALER_CODE(dealerCode);
        Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		 Map map = userService.selectTmUserByOne(username);
		 //tcUser.setLoginName(loginName);;
	     if(map != null) {
	        	Map roleMap = new HashMap();
	        	roleMap.put("userId", map.get("USER_ID"));
	        	roleMap.put("userCode", map.get("EMPLOYEE_NO"));
	        	roleMap.put("appId", appKey);
	    		Long roleId = sysRoleService.selectTmUserRoleByMap(roleMap);
	    		tmUser.setRoleId(roleId);
	    		session.setAttribute("users", tmUser);
	     }

        authorizationInfo.addStringPermission("/home");
		authorizationInfo.addStringPermissions(remoteSecurityService.getPermissions(appKey, tmUser));
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
