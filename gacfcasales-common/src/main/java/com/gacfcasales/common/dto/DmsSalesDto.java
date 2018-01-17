package com.gacfcasales.common.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class DmsSalesDto {
	private String VIN;
	private String DEALER_CODE;
	private String DEALER_CODE_T;
	private String EMPLOYEE_NO;
	private String OWNER_NO;
	private String LICENSE;
	private String YEAR_MODEL;
	private String BRAND;
	private String SERIES;
	private String MODEL;
	private String COLOR;
	private String APACKAGE;
	private String INVOICE_DATE;
	private String OWNER_NAME;
	private String PHONE;
	private String MOBILE;
	private String BRAND_NAME;
	private String BRAND_ID;
	private String SERIES_NAME;
	private String SERIES_ID;
	private String MODEL_NAME;
	private String MODEL_ID;
	private String APACKAGE_NAME;
	private String APACKAGE_ID;
	
	private String saleOrderId;
	private String employeeName;
	private String createAt;
	private String customerName;
	private String customerContact;
	private String orderStatus;
	
	private String PRODUCT_NO;
	private String PRODUCT_ID;
	private String PRODUCT_CATEGORY;
	private String PRODUCT_NAME;
	private String PRODUCT_DATE;
	private String PRODUCT_DESCRIBTION;
	private String TERMINAL_NON_SALES_PRICE;
	private String TERMINAL_SALES_PRICE;
	private String SALES_DATE_START;
	private String SALES_DATE_END;
	
	private String PURCHASE_NUMBER;
	private String ACTUAL_NON_SALES_PRICE;
	private String TOTAL_AMOUNT;
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	public String getDEALER_CODE() {
		return DEALER_CODE;
	}
	public void setDEALER_CODE(String dEALER_CODE) {
		DEALER_CODE = dEALER_CODE;
	}
	public String getEMPLOYEE_NO() {
		return EMPLOYEE_NO;
	}
	public void setEMPLOYEE_NO(String eMPLOYEE_NO) {
		EMPLOYEE_NO = eMPLOYEE_NO;
	}
	public String getOWNER_NO() {
		return OWNER_NO;
	}
	public void setOWNER_NO(String oWNER_NO) {
		OWNER_NO = oWNER_NO;
	}
	public String getLICENSE() {
		return LICENSE;
	}
	public void setLICENSE(String lICENSE) {
		LICENSE = lICENSE;
	}
	public String getYEAR_MODEL() {
		return YEAR_MODEL;
	}
	public void setYEAR_MODEL(String yEAR_MODEL) {
		YEAR_MODEL = yEAR_MODEL;
	}
	public String getBRAND() {
		return BRAND;
	}
	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}
	public String getSERIES() {
		return SERIES;
	}
	public void setSERIES(String sERIES) {
		SERIES = sERIES;
	}
	public String getMODEL() {
		return MODEL;
	}
	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	public String getAPACKAGE() {
		return APACKAGE;
	}
	public void setAPACKAGE(String aPACKAGE) {
		APACKAGE = aPACKAGE;
	}
	public String getINVOICE_DATE() {
		return INVOICE_DATE;
	}
	public void setINVOICE_DATE(String iNVOICE_DATE) {
		INVOICE_DATE = iNVOICE_DATE;
	}
	public String getOWNER_NAME() {
		return OWNER_NAME;
	}
	public void setOWNER_NAME(String oWNER_NAME) {
		OWNER_NAME = oWNER_NAME;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
	public String getBRAND_NAME() {
		return BRAND_NAME;
	}
	public void setBRAND_NAME(String bRAND_NAME) {
		BRAND_NAME = bRAND_NAME;
	}
	public String getBRAND_ID() {
		return BRAND_ID;
	}
	public void setBRAND_ID(String bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}
	public String getSERIES_NAME() {
		return SERIES_NAME;
	}
	public void setSERIES_NAME(String sERIES_NAME) {
		SERIES_NAME = sERIES_NAME;
	}
	public String getSERIES_ID() {
		return SERIES_ID;
	}
	public void setSERIES_ID(String sERIES_ID) {
		SERIES_ID = sERIES_ID;
	}
	public String getMODEL_NAME() {
		return MODEL_NAME;
	}
	public void setMODEL_NAME(String mODEL_NAME) {
		MODEL_NAME = mODEL_NAME;
	}
	public String getMODEL_ID() {
		return MODEL_ID;
	}
	public void setMODEL_ID(String mODEL_ID) {
		MODEL_ID = mODEL_ID;
	}
	public String getAPACKAGE_NAME() {
		return APACKAGE_NAME;
	}
	public void setAPACKAGE_NAME(String aPACKAGE_NAME) {
		APACKAGE_NAME = aPACKAGE_NAME;
	}
	public String getAPACKAGE_ID() {
		return APACKAGE_ID;
	}
	public void setAPACKAGE_ID(String aPACKAGE_ID) {
		APACKAGE_ID = aPACKAGE_ID;
	}
	public String getSaleOrderId() {
		return saleOrderId;
	}
	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
	
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(String pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
	}
	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_CATEGORY() {
		return PRODUCT_CATEGORY;
	}
	public void setPRODUCT_CATEGORY(String pRODUCT_CATEGORY) {
		PRODUCT_CATEGORY = pRODUCT_CATEGORY;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getPRODUCT_DATE() {
		return PRODUCT_DATE;
	}
	public void setPRODUCT_DATE(String pRODUCT_DATE) {
		PRODUCT_DATE = pRODUCT_DATE;
	}
	public String getPRODUCT_DESCRIBTION() {
		return PRODUCT_DESCRIBTION;
	}
	public void setPRODUCT_DESCRIBTION(String pRODUCT_DESCRIBTION) {
		PRODUCT_DESCRIBTION = pRODUCT_DESCRIBTION;
	}
	public String getTERMINAL_NON_SALES_PRICE() {
		return TERMINAL_NON_SALES_PRICE;
	}
	public void setTERMINAL_NON_SALES_PRICE(String tERMINAL_NON_SALES_PRICE) {
		TERMINAL_NON_SALES_PRICE = tERMINAL_NON_SALES_PRICE;
	}
	public String getTERMINAL_SALES_PRICE() {
		return TERMINAL_SALES_PRICE;
	}
	public void setTERMINAL_SALES_PRICE(String tERMINAL_SALES_PRICE) {
		TERMINAL_SALES_PRICE = tERMINAL_SALES_PRICE;
	}
	public String getSALES_DATE_START() {
		return SALES_DATE_START;
	}
	public void setSALES_DATE_START(String sALES_DATE_START) {
		SALES_DATE_START = sALES_DATE_START;
	}
	public String getSALES_DATE_END() {
		return SALES_DATE_END;
	}
	public void setSALES_DATE_END(String sALES_DATE_END) {
		SALES_DATE_END = sALES_DATE_END;
	}
	public String getPURCHASE_NUMBER() {
		return PURCHASE_NUMBER;
	}
	public void setPURCHASE_NUMBER(String pURCHASE_NUMBER) {
		PURCHASE_NUMBER = pURCHASE_NUMBER;
	}
	public String getACTUAL_NON_SALES_PRICE() {
		return ACTUAL_NON_SALES_PRICE;
	}
	public void setACTUAL_NON_SALES_PRICE(String aCTUAL_NON_SALES_PRICE) {
		ACTUAL_NON_SALES_PRICE = aCTUAL_NON_SALES_PRICE;
	}
	public String getTOTAL_AMOUNT() {
		return TOTAL_AMOUNT;
	}
	public void setTOTAL_AMOUNT(String tOTAL_AMOUNT) {
		TOTAL_AMOUNT = tOTAL_AMOUNT;
	}
	public String getDEALER_CODE_T() {
		return DEALER_CODE_T;
	}
	public void setDEALER_CODE_T(String dEALER_CODE_T) {
		DEALER_CODE_T = dEALER_CODE_T;
	}
	
	
	
}
