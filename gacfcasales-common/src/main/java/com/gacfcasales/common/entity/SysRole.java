package com.gacfcasales.common.entity;

import java.io.Serializable;

public class SysRole implements Serializable {
    private Long id;//主键id
    private String name;//角色名
    private Integer seq;//排序号
    private String description;//简介
    private Integer status;//状态
    
    private String[] resourceIds;
    
    private String appId;
    
    public SysRole() {
        super();
    }
    public SysRole(Long id,String name,Integer seq,String description,Integer status,String appId) {
        super();
        this.id = id;
        this.name = name;
        this.seq = seq;
        this.description = description;
        this.status = status;
        this.appId = appId;
    }
    
    
    public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
	public String[] getResourceIds() {
		return resourceIds;
	}
	
	public void setResourceIds(String[] resourceIds) {
		this.resourceIds = resourceIds;
	}
    
}
