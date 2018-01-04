package com.gacfcasales.dmsweb.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gacfcasales.common.dto.LoginInfoDto;
import com.gacfcasales.common.entity.SysUser;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.common.exception.ServiceBizException;
import com.gacfcasales.common.Assist;
import com.gacfcasales.dmsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.dmsweb.dao.SysUserDao;
import com.gacfcasales.dmsweb.service.SysUserService;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.common.util.Bean2Map;
import com.gacfcasales.common.util.CommonUtils;
import com.gacfcasales.common.util.MD5UtilCommon;
import com.gacfcasales.common.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserDao sysUserDao;
    
    @DataSourceAnnotation(value="read")
    public long getSysUserRowCount(Assist assist){
        return sysUserDao.getSysUserRowCount(assist);
    }
    
    @DataSourceAnnotation(value="read")
    public List<SysUser> selectSysUser(Assist assist){
        return sysUserDao.selectSysUser(assist);
    }
    
    public SysUser selectSysUserByObj(SysUser obj){
        return sysUserDao.selectSysUserByObj(obj);
    }
    @DataSourceAnnotation(value="write")
    public SysUser selectSysUserById(Long id){
        return sysUserDao.selectSysUserById(id);
    }
    
    public int insertSysUser(SysUser value){
        return sysUserDao.insertSysUser(value);
    }
    
    public int insertNonEmptySysUser(SysUser value){
        return sysUserDao.insertNonEmptySysUser(value);
    }
    
    public int deleteSysUserById(Long id){
        return sysUserDao.deleteSysUserById(id);
    }
    
    public int deleteSysUser(Assist assist){
        return sysUserDao.deleteSysUser(assist);
    }
    
    public int updateSysUserById(SysUser enti){
        return sysUserDao.updateSysUserById(enti);
    }
    
    public int updateSysUser(SysUser value, Assist assist){
        return sysUserDao.updateSysUser(value,assist);
    }
    
    public int updateNonEmptySysUserById(SysUser enti){
        return sysUserDao.updateNonEmptySysUserById(enti);
    }
    
    public int updateNonEmptySysUser(SysUser value, Assist assist){
        return sysUserDao.updateNonEmptySysUser(value,assist);
    }

    public SysUserDao getSysUserDao() {
        return this.sysUserDao;
    }

    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

	public SysUser existsUserName(String userName) {
		SysUser sysUser = new SysUser();
		sysUser.setLoginName(userName);
		return sysUserDao.selectSysUserByObj(sysUser);
	}

	@Override
	public TcUser selectTcUserObj(SysUser obj) {
		System.out.println(obj.getDearlerCode());
    	
    	Bean2Map bean2Map = new Bean2Map();
    	
    	List<Map> list = sysUserDao.getDearleCode(bean2Map.beanToMap(obj));
    	
    	if(null== list || list.size()<=0 ){
        	throw new ServiceBizException("登录域不正确，请重新输入！");
        }
    	Map mapCheck = new HashMap();
    	mapCheck.put("dealerCode", obj.getDearlerCode());
    	mapCheck.put("userCode", obj.getLoginName());
    	mapCheck.put("password", obj.getPassword());
    	List<Map> listCheck = sysUserDao.oemLogCheck(mapCheck);
    	// 如果查询通过
		if (!CommonUtils.isNullOrEmpty(listCheck)) {
			Map userInfo = listCheck.get(0);
			
			 String passwordMD5=(String) userInfo.get("PASSWORD");//密码 boolean
			 Boolean validation=MD5UtilCommon.validPassword(obj.getPassword(), passwordMD5);
			 if(validation==false){
				 throw new ServiceBizException("密码不正确");
			 }
			 LoginInfoDto loginInfo = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
			 String employeeNo = (String) userInfo.get("EMP_NUM");// 员工编号
			if (!StringUtils.isNullOrEmpty(employeeNo)) {
					loginInfo.setEmployeeNo(employeeNo);
			}
			Object companyId = (Object) userInfo.get("COMPANY_ID");// 公司ID
			if (!StringUtils.isNullOrEmpty(companyId)) {
				loginInfo.setCompanyId(Long.parseLong(companyId.toString()));
			}
			String employeeName = (String) userInfo.get("NAME");// 员工名字
			if (!StringUtils.isNullOrEmpty(employeeName)) {
				loginInfo.setUserName(employeeName);
			}
			Integer gender = (Integer) userInfo.get("GENDER");// 员工性别
			if (!StringUtils.isNullOrEmpty(gender)) {
				loginInfo.setGender(gender);
			}
			String mobile = (String) userInfo.get("PHONE");// 员工手机号
			if (!StringUtils.isNullOrEmpty(mobile)) {
				loginInfo.setMobile(mobile);
			}
			Object userType = (Object) userInfo.get("USER_TYPE");// 用户类型
			if (!StringUtils.isNullOrEmpty(userType)) {
				loginInfo.setUserType(Integer.parseInt(userType.toString()));
			}
			Object userId = userInfo.get("USER_ID");// 用户id
			if (!StringUtils.isNullOrEmpty(userId)) {
				loginInfo.setUserId(Long.parseLong(userId.toString()));
			}
			// 设置经销商信息及账号信息
			loginInfo.setDealerCode(obj.getDearlerCode());
			loginInfo.setUserAccount(obj.getLoginName());
		}
		return sysUserDao.selectTcUserObj(listCheck.get(0));
	}

	@Override
	public long getTmUserRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserDao.getTmUserRowCount(assist);
	}

	@Override
	public List<Map> selectTmUser(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserDao.selectTmUser(assist);
	}

	@Override
	public TmUser selectTmUserObj(SysUser obj) {
		// TODO Auto-generated method stub
		LoginInfoDto loginInfo = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
		System.out.println(obj.getDearlerCode());
    	
    	Bean2Map bean2Map = new Bean2Map();
    	
    	List<Map> list = sysUserDao.getDearleCode(bean2Map.beanToMap(obj));
    	
    	if(null== list || list.size()<=0 ){
        	throw new ServiceBizException("登录域不正确，请重新输入！");
        }
    	Map  map = sysUserDao.getEntityCode(obj.getDearlerCode());
    	String dealerCode = map.get("ENTITY_CODE").toString();
    	LoginInfoDto loginInfoDealer = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
    	loginInfoDealer.setDealerCode(dealerCode);
    	Map mapCheck = new HashMap();
    	mapCheck.put("dealerCode", dealerCode);
    	mapCheck.put("userCode", obj.getLoginName());
    	mapCheck.put("password", obj.getPassword());
    	List<Map> listCheck = sysUserDao.logCheck(mapCheck);
    	
    	if (!CommonUtils.isNullOrEmpty(listCheck)) {
    		Map userInfo = listCheck.get(0);
			// System.out.println("输入密码====" +password);
			 String passwordMD5=(String) userInfo.get("PASSWORD");//密码 boolean
			 loginInfo.setDealerCode(userInfo.get("DEALER_CODE").toString());
			 loginInfo.setPassword((String) userInfo.get("PASSWORD"));
			 loginInfo.setUserId((Long) userInfo.get("USER_ID"));
			 loginInfo.setUserName((String) userInfo.get("USER_NAME"));
			 loginInfo.setUserCode((String) userInfo.get("USER_CODE"));
			 Boolean validation=MD5UtilCommon.validPassword(obj.getPassword(), passwordMD5);
			 if(validation==false){
				 throw new ServiceBizException("密码不正确");
			 } 
    	}
    	
    	List<Map> mappingAccount = sysUserDao.queryMappingAccount(mapCheck);
    	Map DcsUser = new HashMap();
    	if (!CommonUtils.isNullOrEmpty(mappingAccount)) {
			Map mapping = mappingAccount.get(0);
			loginInfo.setMappingAccount((String) mapping.get("TARGET_USER"));
			// 查询出映射账号对应的user_id
			Map queryUserParam = new HashMap();
			queryUserParam.put("mappingAccount",loginInfo.getMappingAccount());
			List<Map> listUser = sysUserDao.getDcsUser(queryUserParam);
			if (!CommonUtils.isNullOrEmpty(listUser)) {
				DcsUser = listUser.get(0);
				// 查询出映射账号对应的职位
				List<Map> lisPose = sysUserDao.selectPose(DcsUser);
				if (!CommonUtils.isNullOrEmpty(lisPose)) {
					loginInfo.setDcsPoseId(lisPose);
				}
			}
		}
    	
    	TmUser tmUser = sysUserDao.selectTmUserByMap(mapCheck);
		return tmUser;
	}

	@Override
	public long getTcUserRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserDao.getTcUserRowCount(assist);
	}

	@Override
	public List<Map> selectTcUser(Assist assist) {
		// TODO Auto-generated method stub
		return sysUserDao.selectTcUser(assist);
	}

	@Override
	public Map selectTmUserByOne(String username) {
		// TODO Auto-generated method stub
		return sysUserDao.selectTmUserByOne(username);
	}

}