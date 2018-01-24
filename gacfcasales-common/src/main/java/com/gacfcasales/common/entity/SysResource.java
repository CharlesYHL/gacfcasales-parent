package com.gacfcasales.common.entity;

import java.io.Serializable;

public class SysResource implements Serializable {
    private String id;
    private String name;
    private String url;
    private String pid;
    
    private String parentName;

	private String icon;
    private Integer isMenu;
    private String level;
    private Integer orderNum;
    private java.util.Date createTime;
    private String createUser;
    private java.util.Date updateTime;
    private String status;
    
    private String appId;
    private String dmsAppId;
    
    public SysResource() {
        super();
    }
    public SysResource(String id,String name,String url,String pid,String icon,Integer isMenu,String level,Integer orderNum,java.util.Date createTime,String createUser,java.util.Date updateTime,String status,String appId) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.icon = icon;
        this.isMenu = isMenu;
        this.level = level;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.status = status;
        this.appId = appId;
    }
    
    
    public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentName() {
    	return parentName;
    }
    public void setParentName(String parentName) {
    	this.parentName = parentName;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsMenu() {
        return this.isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	public String getDmsAppId() {
		return dmsAppId;
	}
	public void setDmsAppId(String dmsAppId) {
		this.dmsAppId = dmsAppId;
	}

}
