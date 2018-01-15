package com.gacfcasales.dmsweb.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.dto.LoginInfoDto;
import com.gacfcasales.common.entity.SysUserRole;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.dmsweb.dao.SysUserRoleDao;
import com.gacfcasales.dmsweb.service.SysUserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    public long getSysUserRoleRowCount(Assist assist){
        return sysUserRoleDao.getSysUserRoleRowCount(assist);
    }
    
    public List<SysUserRole> selectSysUserRole(Assist assist){
        return sysUserRoleDao.selectSysUserRole(assist);
    }
    
    public SysUserRole selectSysUserRoleByObj(SysUserRole obj){
        return sysUserRoleDao.selectSysUserRoleByObj(obj);
    }
    
    public SysUserRole selectSysUserRoleById(String id){
        return sysUserRoleDao.selectSysUserRoleById(id);
    }
    
    public int insertSysUserRole(SysUserRole value){
        return sysUserRoleDao.insertSysUserRole(value);
    }
    
    public int insertNonEmptySysUserRole(SysUserRole value){
        return sysUserRoleDao.insertNonEmptySysUserRole(value);
    }
    
    public int deleteSysUserRoleById(String id){
        return sysUserRoleDao.deleteSysUserRoleById(id);
    }
    
    public int deleteSysUserRole(Assist assist){
        return sysUserRoleDao.deleteSysUserRole(assist);
    }
    
    public int updateSysUserRoleById(SysUserRole enti){
        return sysUserRoleDao.updateSysUserRoleById(enti);
    }
    
    public int updateSysUserRole(SysUserRole value, Assist assist){
        return sysUserRoleDao.updateSysUserRole(value,assist);
    }
    
    public int updateNonEmptySysUserRoleById(SysUserRole enti){
        return sysUserRoleDao.updateNonEmptySysUserRoleById(enti);
    }
    
    public int updateNonEmptySysUserRole(SysUserRole value, Assist assist){
        return sysUserRoleDao.updateNonEmptySysUserRole(value,assist);
    }

    public SysUserRoleDao getSysUserRoleDao() {
        return this.sysUserRoleDao;
    }

    public void setSysUserRoleDao(SysUserRoleDao sysUserRoleDao) {
        this.sysUserRoleDao = sysUserRoleDao;
    }

	@Override
	public long getTmUserRoleRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserRoleDao.getTmUserRoleRowCount(assist);
	}

	@Override
	public List selectTmUserRole(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserRoleDao.selectTmUserRole(assist);
	}

	@Override
	public Map selectTmUserRoleByObj(Long userId) {
		LoginInfoDto loginInfo = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
		String dealerCode = loginInfo.getDealerCode();
		Map map = new HashMap();
		map = sysUserRoleDao.selectTmUserRoleByObj(userId);
		/*if("999999".equals(dealerCode)) {
			
		}else {
			map = sysUserRoleDao.selectTmUserRoleByObj(userId);
		}*/
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public long getTcUserRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserRoleDao.getTcUserRowCount(assist);
	}

	@Override
	public List selectTcUser(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserRoleDao.selectTcUser(assist);
	}


}