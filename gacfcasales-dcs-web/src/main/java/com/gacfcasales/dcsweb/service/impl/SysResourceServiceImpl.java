package com.gacfcasales.dcsweb.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.SysRole;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.dcsweb.dao.SysResourceDao;
import com.gacfcasales.dcsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.common.Assist;
import com.gacfcasales.dcsweb.service.SysResourceService;
import com.gacfcasales.common.util.UUIDutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysResourceServiceImpl implements SysResourceService{
    @Autowired
    private SysResourceDao sysResourceDao;
    
    public long getSysResourceRowCount(Assist assist){
        return sysResourceDao.getSysResourceRowCount(assist);
    }
    @DataSourceAnnotation(value="read")
    public List<SysResource> selectSysResource(Assist assist){
        return sysResourceDao.selectSysResource(assist);
    }
    
    public SysResource selectSysResourceByObj(SysResource obj){
        return sysResourceDao.selectSysResourceByObj(obj);
    }
    
    public SysResource selectSysResourceById(String id){
        return sysResourceDao.selectSysResourceById(id);
    }
    
    public int insertSysResource(SysResource value){
        return sysResourceDao.insertSysResource(value);
    }
    
    public int insertNonEmptySysResource(SysResource sysResource){
		return sysResourceDao.insertNonEmptySysResource(sysResource);
    }
    
    public int deleteSysResourceById(String id){
        return sysResourceDao.deleteSysResourceById(id);
    }
    
    public int deleteSysResource(Assist assist){
        return sysResourceDao.deleteSysResource(assist);
    }
    
    public int updateSysResourceById(SysResource enti){
        return sysResourceDao.updateSysResourceById(enti);
    }
    
    public int updateSysResource(SysResource value, Assist assist){
        return sysResourceDao.updateSysResource(value,assist);
    }
    
    public int updateNonEmptySysResourceById(SysResource enti){
        return sysResourceDao.updateNonEmptySysResourceById(enti);
    }
    
    public int updateNonEmptySysResource(SysResource value, Assist assist){
        return sysResourceDao.updateNonEmptySysResource(value,assist);
    }

    public SysResourceDao getSysResourceDao() {
        return this.sysResourceDao;
    }

    public void setSysResourceDao(SysResourceDao sysResourceDao) {
        this.sysResourceDao = sysResourceDao;
    }
	public List<SysResource> selectSysResourceList(Assist assist) {
		 return sysResourceDao.selectSysResourceList(assist);
	}
	@Override
	public List<String> getPermissions(String appKey, TcUser tcUser) {
		// TODO Auto-generated method stub
		if(tcUser == null) return new ArrayList();
		
		return sysResourceDao.findPermissionsByUsername(appKey, tcUser.getAcnt());
	}
	@Override
	public List<Map> getMenus(String appKey, TcUser tcUser) {
		// TODO Auto-generated method stub
		if(tcUser == null) return new ArrayList();
		
		return sysResourceDao.findMenusByUsername(appKey, tcUser.getAcnt());
	}

}