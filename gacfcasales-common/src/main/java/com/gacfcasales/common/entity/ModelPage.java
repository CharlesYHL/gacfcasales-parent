package com.gacfcasales.common.entity;

import java.io.Serializable;
import java.util.List;

public class ModelPage implements Serializable {
	private String PRODUCT_ID;
	private String BRAND_ID;
	private String BRAND_CODE;
	private String BRAND_NAME;
	private String SERIES_ID;
	private String SERIES_CODE;
	private String SERIES_NAME;
	private String MODEL_ID;
	private String MODEL_CODE;
	private String MODEL_NAME;
	
	private List<Integer> BRAND_ID_A;
	private List<Integer> SERIES_ID_A;
	private List<Integer> MODEL_ID_A;
	
	
	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getBRAND_ID() {
		return BRAND_ID;
	}
	public void setBRAND_ID(String bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}
	public String getSERIES_ID() {
		return SERIES_ID;
	}
	public void setSERIES_ID(String sERIES_ID) {
		SERIES_ID = sERIES_ID;
	}
	public String getMODEL_ID() {
		return MODEL_ID;
	}
	public void setMODEL_ID(String mODEL_ID) {
		MODEL_ID = mODEL_ID;
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
	public List<Integer> getBRAND_ID_A() {
		return BRAND_ID_A;
	}
	public void setBRAND_ID_A(List<Integer> bRAND_ID_A) {
		BRAND_ID_A = bRAND_ID_A;
	}
	public List<Integer> getSERIES_ID_A() {
		return SERIES_ID_A;
	}
	public void setSERIES_ID_A(List<Integer> sERIES_ID_A) {
		SERIES_ID_A = sERIES_ID_A;
	}
	public List<Integer> getMODEL_ID_A() {
		return MODEL_ID_A;
	}
	public void setMODEL_ID_A(List<Integer> mODEL_ID_A) {
		MODEL_ID_A = mODEL_ID_A;
	}
	
	
	
}
