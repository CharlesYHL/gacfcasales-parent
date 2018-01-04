package com.gacfcasales.dmsweb.dao;
import com.gacfcasales.common.entity.SysResource;
import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface SysResourceDao{
	/**
	 * 获得SysResource数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getSysResourceRowCount(Assist assist);
	/**
	 * 获得SysResource数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<SysResource> selectSysResource(Assist assist);
	/**
	 * 获得一个SysResource对象,以参数SysResource对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    SysResource selectSysResourceByObj(SysResource obj);
	/**
	 * 通过SysResource的id获得SysResource对象
	 * @param id
	 * @return
	 */
    SysResource selectSysResourceById(String id);
	/**
	 * 插入SysResource到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysResource(SysResource value);
	/**
	 * 插入SysResource中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptySysResource(SysResource value);
	/**
	 * 通过SysResource的id删除SysResource
	 * @param id
	 * @return
	 */
    int deleteSysResourceById(String id);
	/**
	 * 通过辅助工具Assist的条件删除SysResource
	 * @param assist
	 * @return
	 */
    int deleteSysResource(Assist assist);
	/**
	 * 通过SysResource的id更新SysResource中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateSysResourceById(SysResource enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysResource中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateSysResource(@Param("enti") SysResource value, @Param("assist") Assist assist);
	/**
	 * 通过SysResource的id更新SysResource中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptySysResourceById(SysResource enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysResource中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptySysResource(@Param("enti") SysResource value, @Param("assist") Assist assist);
    
    /**
	 * 获得SysResource数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
     * @param assist 
	 * @return
	 */
	List<SysResource> selectSysResourceList(Assist assist);
	
	
	List<String> findPermissionsByUsername(@Param("appId")String appId, @Param("username")String username);
	List<Map> findMenusByUsername(@Param("appId")String appId, @Param("username")String username);
    List<Map> findByAppIdAndRoleId(@Param("appId")String appId, @Param("roleId")Integer roleId);
	
}