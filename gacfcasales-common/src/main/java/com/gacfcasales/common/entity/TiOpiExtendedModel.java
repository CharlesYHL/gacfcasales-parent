package com.gacfcasales.common.entity;

import java.io.Serializable;
import java.util.Date;

public class TiOpiExtendedModel implements Serializable {
	private Long PRODUCT_MODEL_ID;
	private Long PRODUCT_ID;
	private String PRODUCT_NO;
	private String PRODUCT_NAME;
	private Integer PRODUCT_PROPERTY;
	private String BRAND_CODE;
	private String BRAND_NAME;
	private String SERIES_CODE;
	private String SERIES_NAME;
	private String MODEL_CODE;
	private String MODEL_NAME;
	private String CREATED_BY;
	private Date CREATED_AT;
	private String UPDATED_BY;
	private Date UPDATED_AT;
	private Integer IS_VALID;
	private Integer IS_DELETE;
	private Integer PRODUCT_FAIT;
	private Integer PRODUCT_JEEP;
	private Integer PRODUCT_CJD;
	
	public TiOpiExtendedModel() {
		super();
	}
	
	public TiOpiExtendedModel(Long PRODUCT_MODEL_ID,Long PRODUCT_ID,String PRODUCT_NO,String PRODUCT_NAME,Integer PRODUCT_PROPERTY,String BRAND_CODE,String BRAND_NAME,String SERIES_CODE,String SERIES_NAME,String MODEL_CODE,String MODEL_NAME,String CREATED_BY,Date CREATED_AT,String UPDATED_BY,Date UPDATED_AT,Integer IS_VALID,Integer IS_DELETE,Integer PRODUCT_FAIT,Integer PRODUCT_JEEP,Integer PRODUCT_CJD) {
		this.PRODUCT_MODEL_ID=PRODUCT_MODEL_ID;
		this.PRODUCT_ID=PRODUCT_ID;
		this.PRODUCT_NO=PRODUCT_NO;
		this.PRODUCT_NAME=PRODUCT_NAME;
		this.PRODUCT_PROPERTY=PRODUCT_PROPERTY;
		this.BRAND_CODE=BRAND_CODE;
		this.BRAND_NAME=BRAND_NAME;
		this.SERIES_CODE=SERIES_CODE;
		this.SERIES_NAME=SERIES_NAME;
		this.MODEL_CODE=MODEL_CODE;
		this.MODEL_NAME=MODEL_NAME;
		this.CREATED_BY=CREATED_BY;
		this.CREATED_AT=CREATED_AT;
		this.UPDATED_BY=UPDATED_BY;
		this.UPDATED_AT=UPDATED_AT;
		this.IS_VALID=IS_VALID;
		this.IS_DELETE=IS_DELETE;
		this.PRODUCT_FAIT=PRODUCT_FAIT;
		this.PRODUCT_JEEP=PRODUCT_JEEP;
		this.PRODUCT_CJD=PRODUCT_CJD;
	}
	
	public Long getPRODUCT_MODEL_ID() {
		return PRODUCT_MODEL_ID;
	}
	public void setPRODUCT_MODEL_ID(Long pRODUCT_MODEL_ID) {
		PRODUCT_MODEL_ID = pRODUCT_MODEL_ID;
	}
	public Long getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(Long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(String pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public Integer getPRODUCT_PROPERTY() {
		return PRODUCT_PROPERTY;
	}
	public void setPRODUCT_PROPERTY(Integer pRODUCT_PROPERTY) {
		PRODUCT_PROPERTY = pRODUCT_PROPERTY;
	}
	public String getBRAND_CODE() {
		return BRAND_CODE;
	}
	public void setBRAND_CODE(String bRAND_CODE) {
		BRAND_CODE = bRAND_CODE;
	}
	public String getBRAND_NAME() {
		return BRAND_NAME;
	}
	public void setBRAND_NAME(String bRAND_NAME) {
		BRAND_NAME = bRAND_NAME;
	}
	public String getSERIES_CODE() {
		return SERIES_CODE;
	}
	public void setSERIES_CODE(String sERIES_CODE) {
		SERIES_CODE = sERIES_CODE;
	}
	public String getSERIES_NAME() {
		return SERIES_NAME;
	}
	public void setSERIES_NAME(String sERIES_NAME) {
		SERIES_NAME = sERIES_NAME;
	}
	public String getMODEL_CODE() {
		return MODEL_CODE;
	}
	public void setMODEL_CODE(String mODEL_CODE) {
		MODEL_CODE = mODEL_CODE;
	}
	public String getMODEL_NAME() {
		return MODEL_NAME;
	}
	public void setMODEL_NAME(String mODEL_NAME) {
		MODEL_NAME = mODEL_NAME;
	}
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public Date getCREATED_AT() {
		return CREATED_AT;
	}
	public void setCREATED_AT(Date cREATED_AT) {
		CREATED_AT = cREATED_AT;
	}
	public String getUPDATED_BY() {
		return UPDATED_BY;
	}
	public void setUPDATED_BY(String uPDATED_BY) {
		UPDATED_BY = uPDATED_BY;
	}
	public Date getUPDATED_AT() {
		return UPDATED_AT;
	}
	public void setUPDATED_AT(Date uPDATED_AT) {
		UPDATED_AT = uPDATED_AT;
	}
	public Integer getIS_VALID() {
		return IS_VALID;
	}
	public void setIS_VALID(Integer iS_VALID) {
		IS_VALID = iS_VALID;
	}
	public Integer getIS_DELETE() {
		return IS_DELETE;
	}
	public void setIS_DELETE(Integer iS_DELETE) {
		IS_DELETE = iS_DELETE;
	}
	public Integer getPRODUCT_FAIT() {
		return PRODUCT_FAIT;
	}
	public void setPRODUCT_FAIT(Integer pRODUCT_FAIT) {
		PRODUCT_FAIT = pRODUCT_FAIT;
	}
	public Integer getPRODUCT_JEEP() {
		return PRODUCT_JEEP;
	}
	public void setPRODUCT_JEEP(Integer pRODUCT_JEEP) {
		PRODUCT_JEEP = pRODUCT_JEEP;
	}
	public Integer getPRODUCT_CJD() {
		return PRODUCT_CJD;
	}
	public void setPRODUCT_CJD(Integer pRODUCT_CJD) {
		PRODUCT_CJD = pRODUCT_CJD;
	}
	

}
