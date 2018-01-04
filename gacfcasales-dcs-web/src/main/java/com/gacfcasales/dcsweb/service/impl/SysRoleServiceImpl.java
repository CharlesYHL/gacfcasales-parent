package com.gacfcasales.dcsweb.service.impl;
import java.util.List;
import java.util.Map;

import com.gacfcasales.dcsweb.dao.SysRoleDao;
import com.gacfcasales.common.entity.SysRole;
import com.gacfcasales.common.Assist;
import com.gacfcasales.dcsweb.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysRoleServiceImpl implements SysRoleService{
    @Autowired
    private SysRoleDao sysRoleDao;
    
    public long getSysRoleRowCount(Assist assist){
        return sysRoleDao.getSysRoleRowCount(assist);
    }
    
    public List<SysRole> selectSysRole(Assist assist){
        return sysRoleDao.selectSysRole(assist);
    }
    
    public SysRole selectSysRoleByObj(SysRole obj){
        return sysRoleDao.selectSysRoleByObj(obj);
    }
    
    public SysRole selectSysRoleById(Long id){
        return sysRoleDao.selectSysRoleById(id);
    }
    
    public int insertSysRole(SysRole value){
        return sysRoleDao.insertSysRole(value);
    }
    
    public int insertNonEmptySysRole(SysRole value){
        return sysRoleDao.insertNonEmptySysRole(value);
    }
    
    public int deleteSysRoleById(Long id){
        return sysRoleDao.deleteSysRoleById(id);
    }
    
    public int deleteSysRole(Assist assist){
        return sysRoleDao.deleteSysRole(assist);
    }
    
    public int updateSysRoleById(SysRole enti){
        return sysRoleDao.updateSysRoleById(enti);
    }
    
    public int updateSysRole(SysRole value, Assist assist){
        return sysRoleDao.updateSysRole(value,assist);
    }
    
    public int updateNonEmptySysRoleById(SysRole enti){
        return sysRoleDao.updateNonEmptySysRoleById(enti);
    }
    
    public int updateNonEmptySysRole(SysRole value, Assist assist){
        return sysRoleDao.updateNonEmptySysRole(value,assist);
    }

    public SysRoleDao getSysRoleDao() {
        return this.sysRoleDao;
    }

    public void setSysRoleDao(SysRoleDao sysRoleDao) {
        this.sysRoleDao = sysRoleDao;
    }

	public Long selectSysRoleByUserId(Long userId) {
		return sysRoleDao.selectSysRoleByUserId(userId);
	}

	public int deleteResources(Long id) {
		return sysRoleDao.deleteResources(id);
	}

	public int insertResources(Map paramMap) {
		return sysRoleDao.insertResources(paramMap);
	}

	public List selectResourceByRoleId(Long roleId) {
		return sysRoleDao.selectResourceByRoleId(roleId);
	}

	@Override
	public Long selectTmUserRoleByMap(Map map) {
		// TODO Auto-generated method stub
		return sysRoleDao.selectSysRoleByUserIdAndCode(map);
	}

	@Override
	public Map findByAppIdAndUsername(String appId, String username) {
		// TODO Auto-generated method stub
		return sysRoleDao.findByAppIdAndUsername(appId, username);
	}

}