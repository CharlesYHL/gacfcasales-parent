package com.gacfcasales.dcsweb.service;
import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.SysUserRole;
public interface SysUserRoleService{
	/**
	 * 获得SysUserRole数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getSysUserRoleRowCount(Assist assist);
	/**
	 * 获得SysUserRole数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<SysUserRole> selectSysUserRole(Assist assist);
	/**
	 * 获得一个SysUserRole对象,以参数SysUserRole对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    SysUserRole selectSysUserRoleByObj(SysUserRole obj);
	/**
	 * 通过SysUserRole的id获得SysUserRole对象
	 * @param id
	 * @return
	 */
    SysUserRole selectSysUserRoleById(String id);
	/**
	 * 插入SysUserRole到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysUserRole(SysUserRole value);
	/**
	 * 插入SysUserRole中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptySysUserRole(SysUserRole value);
	/**
	 * 通过SysUserRole的id删除SysUserRole
	 * @param id
	 * @return
	 */
    int deleteSysUserRoleById(String id);
	/**
	 * 通过辅助工具Assist的条件删除SysUserRole
	 * @param assist
	 * @return
	 */
    int deleteSysUserRole(Assist assist);
	/**
	 * 通过SysUserRole的id更新SysUserRole中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateSysUserRoleById(SysUserRole enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysUserRole中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateSysUserRole(SysUserRole value,  Assist assist);
	/**
	 * 通过SysUserRole的id更新SysUserRole中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptySysUserRoleById(SysUserRole enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysUserRole中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptySysUserRole(SysUserRole value, Assist assist);
    
    
    long getTmUserRoleRowCount(Assist assist);
    List selectTmUserRole(Assist assist);
    
    long getTcUserRowCount(Assist assist);
	List selectTcUser(Assist assist);
    
    
    Map selectTmUserRoleByObj(Long userId);
}