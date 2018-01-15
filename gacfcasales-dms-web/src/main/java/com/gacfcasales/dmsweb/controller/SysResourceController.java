package com.gacfcasales.dmsweb.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.Assist.WhereRequire;
import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.dmsweb.service.SysResourceService;
import com.gacfcasales.common.util.UUIDutil;

@Controller
@RequestMapping("/sysResource")
public class SysResourceController {
	
	private static Logger logger = LoggerFactory.getLogger(SysResourceController.class);
	
	@Autowired
	private SysResourceService sysResourceService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getSysResourceListPage(){
		return "sysPage/sysResource/list";
	}
	
	@RequestMapping(value="/ajax/getMenu",method=RequestMethod.POST)
	@ResponseBody
	public List<SysResource> getMenu(){
		//LoginInfoDto loginInfoDto = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
		Assist assist = new Assist();
		assist.setDistinct(true);
		Subject subject = SecurityUtils.getSubject();
		TmUser tmUser = (TmUser) subject.getSession().getAttribute("users");
		WhereRequire<Long> require = Assist.andEq("rr.role_id", tmUser.getRoleId());
		assist.setRequires(require);
		List<SysResource> list =  sysResourceService.selectSysResource(assist);
		logger.debug("查询菜单成功。。。。");
		return list;
	}
	
	@RequestMapping(value="/ajax/list",method=RequestMethod.POST)
	@ResponseBody
	public Result<SysResource> getSysResourceList(SysResource sysResource,@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize){
		Result<SysResource> result = new Result<SysResource>();
		Assist assist = new Assist();
		if(null != pageindex && null != pageSize){
			assist.setStartRow((pageindex-1) * pageSize);
			assist.setRowSize(pageSize);
		}
		if(sysResource.getName() != null && !"".equals(sysResource.getName())){
			assist.setRequires(Assist.andLike("name", "%"+sysResource.getName()+"%"));
		}
		assist.setOrder("level,pid", true);
		long count = sysResourceService.getSysResourceRowCount(assist);
		List<SysResource> list =  sysResourceService.selectSysResourceList(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}
	
	@RequestMapping(value = {"/ajax/save","/ajax/update"}, method = RequestMethod.POST)
	@ResponseBody
	public Result<SysResource> saveOrupdate(@RequestBody SysResource sysResource){
		Result<SysResource> result = new Result<SysResource>();
		try {
			if(sysResource.getId() == null || "".equals(sysResource.getId())){
				sysResource.setId(UUIDutil.getUUID());
				if(!"1".equals(sysResource.getLevel())){
					sysResource.setIsMenu(0);
				}
				sysResource.setCreateTime(new Date());
				sysResourceService.insertNonEmptySysResource(sysResource);
			}else{
				sysResource.setUpdateTime(new Date());
				sysResourceService.updateSysResourceById(sysResource);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMessage("服务器异常：原因："+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/ajax/getResourceById/{id}",method=RequestMethod.POST)
	@ResponseBody
	public SysResource getResourceById(@PathVariable(value="id") String id){
		SysResource sysResource = sysResourceService.selectSysResourceById(id);
		return sysResource;
	}
	
	@RequestMapping(value="/ajax/delete",method=RequestMethod.POST)
	@ResponseBody
	public Result<SysResource> deleteById(@RequestParam(value="id") String id){
		Result<SysResource> result = new Result<SysResource>();
		try {
			sysResourceService.deleteSysResourceById(id);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMessage("服务器异常：原因："+e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping(value="/ajax/existsSysResourceName",method=RequestMethod.POST)
	@ResponseBody
	public String getResourceById(@RequestParam(required=false) String id ,@RequestParam(required= true) String name){
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("name", name));
		List<SysResource> SysResources =  sysResourceService.selectSysResource(assist);
		if(SysResources.size() > 0){
			if(null != id && !"".equals(id)){
				for (SysResource obj : SysResources) {
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
