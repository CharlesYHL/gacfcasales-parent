package com.gacfcasales.common.entity;

import java.io.Serializable;

public class TmPartInfoPage implements Serializable {
	private String PART_NO;
	private String PART_NAME;
	private String PART_GROUP_CODE;
	private String PART_PROPERTY;
	private String CLAIM_PRICE;
	private String LIMIT_PRICE;
	private String IS_SJV;
	private String IS_MOP;
	private String IS_C_SALE;
	private String PART_STATUS;
	public String getPART_NO() {
		return PART_NO;
	}
	public void setPART_NO(String pART_NO) {
		PART_NO = pART_NO;
	}
	public String getPART_NAME() {
		return PART_NAME;
	}
	public void setPART_NAME(String pART_NAME) {
		PART_NAME = pART_NAME;
	}
	public String getPART_GROUP_CODE() {
		return PART_GROUP_CODE;
	}
	public void setPART_GROUP_CODE(String pART_GROUP_CODE) {
		PART_GROUP_CODE = pART_GROUP_CODE;
	}
	public String getPART_PROPERTY() {
		return PART_PROPERTY;
	}
	public void setPART_PROPERTY(String pART_PROPERTY) {
		PART_PROPERTY = pART_PROPERTY;
	}
	public String getCLAIM_PRICE() {
		return CLAIM_PRICE;
	}
	public void setCLAIM_PRICE(String cLAIM_PRICE) {
		CLAIM_PRICE = cLAIM_PRICE;
	}
	public String getLIMIT_PRICE() {
		return LIMIT_PRICE;
	}
	public void setLIMIT_PRICE(String lIMIT_PRICE) {
		LIMIT_PRICE = lIMIT_PRICE;
	}
	public String getIS_SJV() {
		return IS_SJV;
	}
	public void setIS_SJV(String iS_SJV) {
		IS_SJV = iS_SJV;
	}
	public String getIS_MOP() {
		return IS_MOP;
	}
	public void setIS_MOP(String iS_MOP) {
		IS_MOP = iS_MOP;
	}
	public String getIS_C_SALE() {
		return IS_C_SALE;
	}
	public void setIS_C_SALE(String iS_C_SALE) {
		IS_C_SALE = iS_C_SALE;
	}
	public String getPART_STATUS() {
		return PART_STATUS;
	}
	public void setPART_STATUS(String pART_STATUS) {
		PART_STATUS = pART_STATUS;
	}
	
	
	
}
