package com.gacfcasales.common.entity;

import java.io.Serializable;

public class SysUser  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;//主键id
    private String loginName;//登陆名
    private String name;//用户名
    private String password;//密码
    private Integer sex;//性别
    private Integer age;//年龄
    private String phone;//手机号
    private String deptId;//所属机构
    private Integer status;//用户状态
    private java.util.Date createTime;//创建时间
    private String dearlerCode;
    
    private Long roleId;
    public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public SysUser() {
        super();
    }
    public SysUser(Long id,String loginName,String name,String password,Integer sex,Integer age,String phone,String deptId,Integer status,java.util.Date createTime,String dearlerCode) {
        super();
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.deptId = deptId;
        this.status = status;
        this.createTime = createTime;
        this.dearlerCode = dearlerCode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptId() {
        return this.deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
	public String getDearlerCode() {
		return dearlerCode;
	}
	public void setDearlerCode(String dearlerCode) {
		this.dearlerCode = dearlerCode;
	}
    
    
}
