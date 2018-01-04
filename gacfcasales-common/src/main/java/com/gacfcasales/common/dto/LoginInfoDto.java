package com.gacfcasales.common.dto;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gacfcasales.common.entity.TmUser;

@Component
@Scope("session")
public class LoginInfoDto {
	 private String       dealerCode;
	 private String       mappingAccount;
	 private List<Map>    dcsPoseId;//一个映射账号
	 
	 private String password;
	 private String employeeName;
	 private String dealerShortname;
	 private String dealerName;
	 private Long userId;
	 private String userCode;
	 private String userName;
	 private String orgName;
	 private Long orgCode;
	 
	 private String employeeNo;
	 private Long companyId;

	 private Integer gender;
	 private String mobile;
	 private Integer userType;
	 private String userAccount;
	 
	 private TmUser tmUser;
	 
	 
	 
	 
	public TmUser getTmUser() {
		return tmUser;
	}

	public void setTmUser(TmUser tmUser) {
		this.tmUser = tmUser;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getMappingAccount() {
		return mappingAccount;
	}

	public void setMappingAccount(String mappingAccount) {
		this.mappingAccount = mappingAccount;
	}

	public List<Map> getDcsPoseId() {
		return dcsPoseId;
	}

	public void setDcsPoseId(List<Map> dcsPoseId) {
		this.dcsPoseId = dcsPoseId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDealerShortname() {
		return dealerShortname;
	}

	public void setDealerShortname(String dealerShortname) {
		this.dealerShortname = dealerShortname;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Long getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(Long orgCode) {
		this.orgCode = orgCode;
	}
	 
}
