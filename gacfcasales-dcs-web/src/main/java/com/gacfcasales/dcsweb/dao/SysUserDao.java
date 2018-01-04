package com.gacfcasales.dcsweb.dao;
import com.gacfcasales.common.entity.SysUser;
import com.gacfcasales.common.entity.TcUser;
import com.gacfcasales.common.entity.TmUser;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface SysUserDao{
	/**
	 * 获得SysUser数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getSysUserRowCount(Assist assist);
	/**
	 * 获得SysUser数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<SysUser> selectSysUser(Assist assist);
	/**
	 * 获得一个SysUser对象,以参数SysUser对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    SysUser selectSysUserByObj(SysUser obj);
	/**
	 * 通过SysUser的id获得SysUser对象
	 * @param id
	 * @return
	 */
    SysUser selectSysUserById(Long id);
	/**
	 * 插入SysUser到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysUser(SysUser value);
	/**
	 * 插入SysUser中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptySysUser(SysUser value);
	/**
	 * 通过SysUser的id删除SysUser
	 * @param id
	 * @return
	 */
    int deleteSysUserById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除SysUser
	 * @param assist
	 * @return
	 */
    int deleteSysUser(Assist assist);
	/**
	 * 通过SysUser的id更新SysUser中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateSysUserById(SysUser enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysUser中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateSysUser(@Param("enti") SysUser value, @Param("assist") Assist assist);
	/**
	 * 通过SysUser的id更新SysUser中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptySysUserById(SysUser enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysUser中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptySysUser(@Param("enti") SysUser value, @Param("assist") Assist assist);
    
    
    
    List<Map> getDearleCode(Map map);
    Map getEntityCode(String dealerCode);
    List<Map> logCheck(Map map);
    
    List<Map> oemLogCheck(Map map);
    
    List<Map> queryMappingAccount(Map map);
    List<Map> getDcsUser(Map map);
    List<Map> selectPose(Map map);
    
    TcUser selectTcUserObj(Map map);
    
    long getTmUserRowCount(Assist assist);
    List<Map> selectTmUser(Assist assist);
    
    TmUser selectTmUserByMap(Map map);
    
    
    long getTcUserRowCount(Assist assist);
    List<Map> selectTcUser(Assist assist);
    
    Map selectTcUserByOne(String acnt);
    
}