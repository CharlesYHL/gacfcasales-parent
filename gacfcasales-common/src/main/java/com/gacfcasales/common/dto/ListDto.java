package com.gacfcasales.common.dto;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gacfcasales.common.entity.ModelPage;

@Component
public class ListDto {
	 private List<ModelPage>   modelPageList;//一个映射账号

	public List<ModelPage> getModelPageList() {
		return modelPageList;
	}

	public void setModelPageList(List<ModelPage> modelPageList) {
		this.modelPageList = modelPageList;
	}
	 
	 
}
