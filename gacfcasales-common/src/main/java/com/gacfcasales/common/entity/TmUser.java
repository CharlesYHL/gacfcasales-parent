package com.gacfcasales.common.entity;

import java.io.Serializable;
import java.util.Date;

public class TmUser implements Serializable {
	private String DEALER_CODE;
	private Long USER_ID;
	private String EMPLOYEE_NO;
	private String ORG_CODE;
	private String USER_CODE;
	private String POSITION_CODE;
	private String PASSWORD;
	private Integer USER_STATUS;
	private Integer IS_SERVICE_ADVISOR;
	private Integer IS_CONSULTANT;
	private Date LOGIN_LAST_TIME;
	private String SERIAL_NO;
	private Integer SERIAL_TAG;
	private Integer USE_INFOHERE;
	private String USER_NAME;
	private Date DDCN_UPDATE_DATE;
	private Long CREATED_BY;
	private Date CREATED_AT;
	private Long UPDATED_BY;
	private Date UPDATED_AT;
	private Date REPORT_B_I_DATETIME;
	private String PASSWORD_P;
	private Date LAST_LOG_TIME;
	private Integer LOGIN_INTERVAL;
	private Integer LOGIN_STATUS;
	private Date APPLICATION_DATE;
	private Date LOCK_DATE;
	private Integer AGREE_STATUS;
	
	private Long roleId;
	
	
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getDEALER_CODE() {
		return DEALER_CODE;
	}
	public void setDEALER_CODE(String dEALER_CODE) {
		DEALER_CODE = dEALER_CODE;
	}
	public Long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getEMPLOYEE_NO() {
		return EMPLOYEE_NO;
	}
	public void setEMPLOYEE_NO(String eMPLOYEE_NO) {
		EMPLOYEE_NO = eMPLOYEE_NO;
	}
	public String getORG_CODE() {
		return ORG_CODE;
	}
	public void setORG_CODE(String oRG_CODE) {
		ORG_CODE = oRG_CODE;
	}
	public String getUSER_CODE() {
		return USER_CODE;
	}
	public void setUSER_CODE(String uSER_CODE) {
		USER_CODE = uSER_CODE;
	}
	public String getPOSITION_CODE() {
		return POSITION_CODE;
	}
	public void setPOSITION_CODE(String pOSITION_CODE) {
		POSITION_CODE = pOSITION_CODE;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public Integer getUSER_STATUS() {
		return USER_STATUS;
	}
	public void setUSER_STATUS(Integer uSER_STATUS) {
		USER_STATUS = uSER_STATUS;
	}
	public Integer getIS_SERVICE_ADVISOR() {
		return IS_SERVICE_ADVISOR;
	}
	public void setIS_SERVICE_ADVISOR(Integer iS_SERVICE_ADVISOR) {
		IS_SERVICE_ADVISOR = iS_SERVICE_ADVISOR;
	}
	public Integer getIS_CONSULTANT() {
		return IS_CONSULTANT;
	}
	public void setIS_CONSULTANT(Integer iS_CONSULTANT) {
		IS_CONSULTANT = iS_CONSULTANT;
	}
	public Date getLOGIN_LAST_TIME() {
		return LOGIN_LAST_TIME;
	}
	public void setLOGIN_LAST_TIME(Date lOGIN_LAST_TIME) {
		LOGIN_LAST_TIME = lOGIN_LAST_TIME;
	}
	public String getSERIAL_NO() {
		return SERIAL_NO;
	}
	public void setSERIAL_NO(String sERIAL_NO) {
		SERIAL_NO = sERIAL_NO;
	}
	public Integer getSERIAL_TAG() {
		return SERIAL_TAG;
	}
	public void setSERIAL_TAG(Integer sERIAL_TAG) {
		SERIAL_TAG = sERIAL_TAG;
	}
	public Integer getUSE_INFOHERE() {
		return USE_INFOHERE;
	}
	public void setUSE_INFOHERE(Integer uSE_INFOHERE) {
		USE_INFOHERE = uSE_INFOHERE;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public Date getDDCN_UPDATE_DATE() {
		return DDCN_UPDATE_DATE;
	}
	public void setDDCN_UPDATE_DATE(Date dDCN_UPDATE_DATE) {
		DDCN_UPDATE_DATE = dDCN_UPDATE_DATE;
	}
	public Long getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(Long cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public Date getCREATED_AT() {
		return CREATED_AT;
	}
	public void setCREATED_AT(Date cREATED_AT) {
		CREATED_AT = cREATED_AT;
	}
	public Long getUPDATED_BY() {
		return UPDATED_BY;
	}
	public void setUPDATED_BY(Long uPDATED_BY) {
		UPDATED_BY = uPDATED_BY;
	}
	public Date getUPDATED_AT() {
		return UPDATED_AT;
	}
	public void setUPDATED_AT(Date uPDATED_AT) {
		UPDATED_AT = uPDATED_AT;
	}
	public Date getREPORT_B_I_DATETIME() {
		return REPORT_B_I_DATETIME;
	}
	public void setREPORT_B_I_DATETIME(Date rEPORT_B_I_DATETIME) {
		REPORT_B_I_DATETIME = rEPORT_B_I_DATETIME;
	}
	public String getPASSWORD_P() {
		return PASSWORD_P;
	}
	public void setPASSWORD_P(String pASSWORD_P) {
		PASSWORD_P = pASSWORD_P;
	}
	public Date getLAST_LOG_TIME() {
		return LAST_LOG_TIME;
	}
	public void setLAST_LOG_TIME(Date lAST_LOG_TIME) {
		LAST_LOG_TIME = lAST_LOG_TIME;
	}
	public Integer getLOGIN_INTERVAL() {
		return LOGIN_INTERVAL;
	}
	public void setLOGIN_INTERVAL(Integer lOGIN_INTERVAL) {
		LOGIN_INTERVAL = lOGIN_INTERVAL;
	}
	public Integer getLOGIN_STATUS() {
		return LOGIN_STATUS;
	}
	public void setLOGIN_STATUS(Integer lOGIN_STATUS) {
		LOGIN_STATUS = lOGIN_STATUS;
	}
	public Date getAPPLICATION_DATE() {
		return APPLICATION_DATE;
	}
	public void setAPPLICATION_DATE(Date aPPLICATION_DATE) {
		APPLICATION_DATE = aPPLICATION_DATE;
	}
	public Date getLOCK_DATE() {
		return LOCK_DATE;
	}
	public void setLOCK_DATE(Date lOCK_DATE) {
		LOCK_DATE = lOCK_DATE;
	}
	public Integer getAGREE_STATUS() {
		return AGREE_STATUS;
	}
	public void setAGREE_STATUS(Integer aGREE_STATUS) {
		AGREE_STATUS = aGREE_STATUS;
	}
	
	

}
