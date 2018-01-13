package com.gacfcasales.common.dto;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gacfcasales.common.entity.ModelPage;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TiOpiExtendedModel;
import com.gacfcasales.common.entity.TmPartInfo;

@Component
public class ListDto {
	 private List<ModelPage>   modelPageList;//一个映射账号
	 
	 private List<TiOpiExtendedModel> tiOpiExtendedModelList;
	 
	 private List<TmPartInfo> tmPartInfo;
	 
	 private List<Map> listMap;
	 
	 private List<TiOpiExtendedDCS> productList;
	 

	public List<ModelPage> getModelPageList() {
		return modelPageList;
	}

	public void setModelPageList(List<ModelPage> modelPageList) {
		this.modelPageList = modelPageList;
	}

	public List<TiOpiExtendedModel> getTiOpiExtendedModelList() {
		return tiOpiExtendedModelList;
	}

	public void setTiOpiExtendedModelList(List<TiOpiExtendedModel> tiOpiExtendedModelList) {
		this.tiOpiExtendedModelList = tiOpiExtendedModelList;
	}

	public List<TmPartInfo> getTmPartInfo() {
		return tmPartInfo;
	}

	public void setTmPartInfo(List<TmPartInfo> tmPartInfo) {
		this.tmPartInfo = tmPartInfo;
	}

	public List<Map> getListMap() {
		return listMap;
	}

	public void setListMap(List<Map> listMap) {
		this.listMap = listMap;
	}

	public List<TiOpiExtendedDCS> getProductList() {
		return productList;
	}

	public void setProductList(List<TiOpiExtendedDCS> productList) {
		this.productList = productList;
	}
	 
	 
}
