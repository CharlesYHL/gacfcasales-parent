package com.gacfcasales.dmsweb.remote;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.SysRole;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.common.entity.TmUser;

public interface IRemoteSecurityService {
	
	public List<String> getPermissions(String appKey, TmUser tmUser);
	
	public List<Map> getMenus(String appKey, TmUser tmUser);
	
	public Map getRole(String appKey, String username);
}
