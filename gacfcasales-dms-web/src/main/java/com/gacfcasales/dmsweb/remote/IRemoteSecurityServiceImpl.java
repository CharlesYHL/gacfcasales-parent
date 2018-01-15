package com.gacfcasales.dmsweb.remote;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.dto.LoginInfoDto;
import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.SysRole;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.dmsweb.service.SysResourceService;
import com.gacfcasales.dmsweb.service.SysRoleService;

@Service
public class IRemoteSecurityServiceImpl implements IRemoteSecurityService {
	
	@Autowired private SysResourceService sysResourceService;
	@Autowired private SysRoleService sysRoleService;
	
	public List<String> getPermissions(String appKey, TmUser tmUser) {
		// TODO Auto-generated method stub
		
		System.out.println(tmUser.getEMPLOYEE_NO());
		return sysResourceService.getPermissions(appKey, tmUser);
	}

	public List<Map> getMenus(String appKey, TmUser tmUser) {
		// TODO Auto-generated method stub
		return sysResourceService.getMenus(appKey, tmUser);
	}

	public Map getRole(String appKey, String acnt) {
		// TODO Auto-generated method stub
		return sysRoleService.findByAppIdAndUsername(appKey, acnt);
	}

}
