package com.gacfcasales.dmsweb.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.common.Assist;
import com.gacfcasales.dmsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.dmsweb.dao.SysResourceDao;
import com.gacfcasales.dmsweb.dao.SysUserDao;
import com.gacfcasales.dmsweb.service.SysResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysResourceServiceImpl implements SysResourceService{
    @Autowired
    private SysResourceDao sysResourceDao;
    @Autowired
    private SysUserDao sysUserDao;
    
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
	public List<String> getPermissions(String appKey, TmUser tmUser) {
		// TODO Auto-generated method stub
		if(tmUser == null) return new ArrayList();
		/*Map map = sysUserDao.selectTmUserByOne(tmUser.getEMPLOYEE_NO());
	     LoginInfoDto loginInfo = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
	     loginInfo.setDealerCode(map.get("DEALER_CODE").toString());
	     loginInfo.setEmployeeNo(map.get("EMPLOYEE_NO").toString());*/
		return sysResourceDao.findPermissionsByUsername(appKey, tmUser.getEMPLOYEE_NO());
	}
	@Override
	public List<Map> getMenus(String appKey, TmUser tmUser) {
		// TODO Auto-generated method stub
		if(tmUser == null) return new ArrayList();
		
		return sysResourceDao.findMenusByUsername(appKey, tmUser.getEMPLOYEE_NO());
	}

}