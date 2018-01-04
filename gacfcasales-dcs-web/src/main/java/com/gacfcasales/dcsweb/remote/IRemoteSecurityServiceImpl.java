package com.gacfcasales.dcsweb.remote;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.SysRole;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.dcsweb.service.SysResourceService;
import com.gacfcasales.dcsweb.service.SysRoleService;

@Service
public class IRemoteSecurityServiceImpl implements IRemoteSecurityService {
	
	@Autowired private SysResourceService sysResourceService;
	@Autowired private SysRoleService sysRoleService;
	
	public List<String> getPermissions(String appKey, TcUser tcUser) {
		// TODO Auto-generated method stub
		System.out.println(tcUser.getAcnt());
		return sysResourceService.getPermissions(appKey, tcUser);
	}

	public List<Map> getMenus(String appKey, TcUser tcUser) {
		// TODO Auto-generated method stub
		return sysResourceService.getMenus(appKey, tcUser);
	}

	public Map getRole(String appKey, String acnt) {
		// TODO Auto-generated method stub
		return sysRoleService.findByAppIdAndUsername(appKey, acnt);
	}

}
