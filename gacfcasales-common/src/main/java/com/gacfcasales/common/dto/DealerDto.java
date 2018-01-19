package com.gacfcasales.common.dto;

import java.io.Serializable;

public class DealerDto implements Serializable {
	private String dealerCode;
	private String dealerShortname;
	private String dealerName;
	private String bigOrg;
	private String smallOrg;
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
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
	public String getBigOrg() {
		return bigOrg;
	}
	public void setBigOrg(String bigOrg) {
		this.bigOrg = bigOrg;
	}
	public String getSmallOrg() {
		return smallOrg;
	}
	public void setSmallOrg(String smallOrg) {
		this.smallOrg = smallOrg;
	}
	
}
