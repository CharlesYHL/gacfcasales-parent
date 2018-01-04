package com.gacfcasales.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.session.Session;

public class TcUser implements Serializable {
	private Long userId;
	private Long companyId;
	private String acnt;
	private String empNum;
	private String name;
	private Integer gender;
	private String handPhone;
	private String phone;
	private String email;
	private Date birthday;
	private String addr;
	private String zipCode;
	private Integer userStatus;
	private Date lastsigninTime;
	private String password;
	private Integer createBy;
	private Date createDate;
	private Integer updateBy;
	private Date updateDate;
	private Integer isDown;
	private Integer approvalLevelCode;
	private String personCode;
	private Integer userType;
	private Integer balanceLevelCode;
	private Date loginTime;
	
	private String loginName;
	
	private Session session;
	
	
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	private Long roleId;
    public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public TcUser() {
		super();
	}

	public TcUser(Long userId, Long companyId, String acnt, String empNum, String name, Integer gender,
			String handPhone, String phone, String email, Date birthday, String addr, String zipCode,
			Integer userStatus, Date lastsigninTime, String password, Integer createBy, Date createDate,
			Integer updateBy, Date updateDate, Integer isDown, Integer approvalLevelCode, String personCode,
			Integer userType, Integer balanceLevelCode, Date loginTime,Long roleId) {
		super();
		this.userId = userId;
		this.companyId = companyId;
		this.acnt = acnt;
		this.empNum = empNum;
		this.name = name;
		this.gender = gender;
		this.handPhone = handPhone;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.addr = addr;
		this.zipCode = zipCode;
		this.userStatus = userStatus;
		this.lastsigninTime = lastsigninTime;
		this.password = password;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.isDown = isDown;
		this.approvalLevelCode = approvalLevelCode;
		this.personCode = personCode;
		this.userType = userType;
		this.balanceLevelCode = balanceLevelCode;
		this.loginTime = loginTime;
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getAcnt() {
		return acnt;
	}

	public void setAcnt(String acnt) {
		this.acnt = acnt;
	}

	public String getEmpNum() {
		return empNum;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getHandPhone() {
		return handPhone;
	}

	public void setHandPhone(String handPhone) {
		this.handPhone = handPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Date getLastsigninTime() {
		return lastsigninTime;
	}

	public void setLastsigninTime(Date lastsigninTime) {
		this.lastsigninTime = lastsigninTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDown() {
		return isDown;
	}

	public void setIsDown(Integer isDown) {
		this.isDown = isDown;
	}

	public Integer getApprovalLevelCode() {
		return approvalLevelCode;
	}

	public void setApprovalLevelCode(Integer approvalLevelCode) {
		this.approvalLevelCode = approvalLevelCode;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getBalanceLevelCode() {
		return balanceLevelCode;
	}

	public void setBalanceLevelCode(Integer balanceLevelCode) {
		this.balanceLevelCode = balanceLevelCode;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

}
