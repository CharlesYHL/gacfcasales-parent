package com.gacfcasales.dmsweb.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.dto.LoginInfoDto;
import com.gacfcasales.common.entity.SysUser;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.common.util.Md5Util;
import com.gacfcasales.dmsweb.service.SysUserService;


@Controller
@RequestMapping("/sysUser")
public class SysUserController {
	
	@Autowired
	private SysUserService sysuserService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String  toListPage(){
		return "sysPage/sysUser/list";
	}
	
	@RequestMapping(value="/look",method=RequestMethod.GET)
	public String  toLookPage(){
		return "sysPage/sysUser/look";
	}

	@RequestMapping(value="/ajax/list",method=RequestMethod.POST)
	@ResponseBody
	public Result<SysUser> getUser(@RequestParam(required = false) String loginName, @RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize){
		LoginInfoDto loginInfo = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
		String dealerCode = loginInfo.getDealerCode();
		System.out.println(loginInfo.getDealerCode());
		Result<SysUser> result = new Result<SysUser>();
		Assist assist = new Assist();
		assist.setStartRow((pageindex-1)*pageSize);
		assist.setRowSize(pageSize);
		
		/*long count = sysuserService.getSysUserRowCount(assist);
		List<SysUser> list =  sysuserService.selectSysUser(assist);*/
		
		if(null != loginName && !"".equals(loginName)){
			assist.setRequires(Assist.andLike("USER_NAME","%"+loginName+"%"));
		}
		if(null != dealerCode && !"".equals(dealerCode)) {
			assist.setRequires(Assist.andLike("DEALER_CODE","%"+dealerCode+"%"));
		}
		long count = sysuserService.getTmUserRowCount(assist);
		List list = sysuserService.selectTmUser(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		/*if("999999".equals(dealerCode)) {
			
			
		}else {
			if(null != loginName && !"".equals(loginName)){
				assist.setRequires(Assist.andLike("USER_NAME","%"+loginName+"%"));
			}
			if(null != dealerCode && !"".equals(dealerCode)) {
				assist.setRequires(Assist.andLike("DEALER_CODE","%"+dealerCode+"%"));
			}
			long count = sysuserService.getTmUserRowCount(assist);
			List list = sysuserService.selectTmUser(assist);
			result.setTotalCount(count);
			result.setDataList(list);
		}*/
	
		return result;
	}
	
	
	@RequestMapping(value={"/ajax/save","/ajax/update"},method=RequestMethod.POST)
	@ResponseBody
	public Result<SysUser> saveOrupdate(@RequestBody SysUser sysUser){
		Result<SysUser> result = new Result<SysUser>();
		if(null == sysUser.getId()){
			sysUser.setPassword(Md5Util.generateTwoPassword(sysUser.getPassword()));
			sysUser.setCreateTime(new Date());
			sysuserService.insertNonEmptySysUser(sysUser);
		}else{
			sysuserService.updateNonEmptySysUserById(sysUser);
		}
		return result;
	}
	
	
	@RequestMapping(value="/ajax/getUserById/{userId}",method=RequestMethod.POST)
	@ResponseBody
	public Result<SysUser> getLookUser(@PathVariable("userId") Long userId){
		Result<SysUser> result = new Result<SysUser>();
		SysUser sysUser =  sysuserService.selectSysUserById(userId);
		Map<String,SysUser>  map = new HashMap<String,SysUser>();
		map.put("sysUser", sysUser);
		result.setDataMap(map);
		return result;
	}
	
	@RequestMapping(value="/ajax/delete/{userId}",method=RequestMethod.POST)
	@ResponseBody
	public Result<SysUser> deleteByUserId(@PathVariable("userId") Long userId){
		Result<SysUser> result = new Result<SysUser>();
		try {
			int k = sysuserService.deleteSysUserById(userId);
			if(k != 1){
				result.setMessage("该数据删除失败");
			}
		} catch (Exception e) {
			result.setCode(400);
			result.setMessage("删除失败,原因："+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/ajax/existsLoginName",method=RequestMethod.POST)
	@ResponseBody
	public String existsLoginName(@RequestParam(required=false) Long id ,@RequestParam(required= true) String loginName){
		SysUser sysUser = new SysUser();
		sysUser.setId(id);
		sysUser.setLoginName(loginName);
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("login_name", loginName));
		List<SysUser> sysUsers =  sysuserService.selectSysUser(assist);
		if(sysUsers.size() > 0){
			if(null != id){
				for (SysUser obj : sysUsers) {
					if(obj.getId().equals(id)){
						return "200";
					}
				}
				return "300";
			}else{
				return "300";
			}
		}
		return "200";
	}
}
