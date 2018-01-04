package com.gacfcasales.dcsweb.remote;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.SysRole;
import com.gacfcasales.common.entity.TcUser;

public interface IRemoteSecurityService {
	
	public List<String> getPermissions(String appKey, TcUser tcUser);
	
	public List<Map> getMenus(String appKey, TcUser tcUser);
	
	public Map getRole(String appKey, String username);
}
