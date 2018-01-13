package com.gacfcasales.common.entity;

import java.io.Serializable;
import java.util.Date;

public class TiOpiExtendedDCS implements Serializable {
	private Long PRODUCT_ID;
	private String PRODUCT_NO;
	private String PRODUCT_NAME;
	private String PRODUCT_PROPERTY;
	private String PRODUCT_CATEGORY;
	private Double DNP_PRICE;
	private Double MSRP_PRICE;
	private Double SINGLE_DISCOUNT;
	private Integer IS_VALID;
	private String CREATED_BY;
	private Date CREATED_AT;
	private String UPDATED_BY;
	private Date UPDATED_AT;
	private Integer IS_C_SALE;
	private Integer PRODUCT_DATE;
	private String PRODUCT_MODEL;
	private Date SALES_DATE_START;
	private Date SALES_DATE_END;
	private Date RELEASE_DATE;
	private Integer RELEASE_STATUS;
	private Date STOP_DATE;
	private Integer PRODUCT_FAIT;
	private Integer PRODUCT_JEEP;
	private Integer PRODUCT_CJD;
	private String PRODUCT_DESCRIBTION;
	private Double NON_TAX_COST_PRICE;
	private Double TAX_COST_PRICE;
	private Double TERMINAL_NON_SALES_PRICE;
	private Double TERMINAL_SALES_PRICE;
	
	
	private String releaseStart;
	private String releaseEnd;
	private String salesStart;
	private String salesEnd;
	

	public TiOpiExtendedDCS() {
		super();
	}

	public TiOpiExtendedDCS(Long PRODUCT_ID, String PRODUCT_NO, String PRODUCT_NAME,
			String PRODUCT_PROPERTY,String PRODUCT_CATEGORY, Double DNP_PRICE, Double MSRP_PRICE, Double SINGLE_DISCOUNT, Integer IS_VALID,
			String CREATED_BY, Date CREATED_AT, String UPDATED_BY, Date UPDATED_AT, Integer IS_C_SALE,
			Integer PRODUCT_DATE, String PRODUCT_MODEL, Date SALES_DATE_START, Date SALES_DATE_END, Date RELEASE_DATE, Integer RELEASE_STATUS,
			Date STOP_DATE, Integer PRODUCT_FAIT, Integer PRODUCT_JEEP, Integer PRODUCT_CJD, String PRODUCT_DESCRIBTION,
			Double NON_TAX_COST_PRICE, Double TAX_COST_PRICE, Double TERMINAL_NON_SALES_PRICE,
			Double TERMINAL_SALES_PRICE) {
		this.PRODUCT_ID = PRODUCT_ID;
		this.PRODUCT_NO = PRODUCT_NO;
		this.PRODUCT_NAME = PRODUCT_NAME;
		this.PRODUCT_PROPERTY = PRODUCT_PROPERTY;
		this.PRODUCT_CATEGORY = PRODUCT_CATEGORY;
		this.DNP_PRICE = DNP_PRICE;
		this.MSRP_PRICE = MSRP_PRICE;
		this.SINGLE_DISCOUNT = SINGLE_DISCOUNT;
		this.IS_VALID = IS_VALID;
		this.CREATED_BY = CREATED_BY;
		this.CREATED_AT = CREATED_AT;
		this.UPDATED_BY = UPDATED_BY;
		this.UPDATED_AT = UPDATED_AT;
		this.IS_C_SALE = IS_C_SALE;
		this.PRODUCT_DATE = PRODUCT_DATE;
		this.PRODUCT_MODEL = PRODUCT_MODEL;
		this.SALES_DATE_START = SALES_DATE_START;
		this.SALES_DATE_END = SALES_DATE_END;
		this.RELEASE_DATE = RELEASE_DATE;
		this.RELEASE_STATUS = RELEASE_STATUS;
		this.STOP_DATE = STOP_DATE;
		this.PRODUCT_FAIT = PRODUCT_FAIT;
		this.PRODUCT_JEEP = PRODUCT_JEEP;
		this.PRODUCT_CJD = PRODUCT_CJD;
		this.PRODUCT_DESCRIBTION = PRODUCT_DESCRIBTION;
		this.NON_TAX_COST_PRICE = NON_TAX_COST_PRICE;
		this.TAX_COST_PRICE = TAX_COST_PRICE;
		this.TERMINAL_NON_SALES_PRICE = TERMINAL_NON_SALES_PRICE;
		this.TERMINAL_SALES_PRICE = TERMINAL_SALES_PRICE;
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

	public String getPRODUCT_PROPERTY() {
		return PRODUCT_PROPERTY;
	}

	public void setPRODUCT_PROPERTY(String pRODUCT_PROPERTY) {
		PRODUCT_PROPERTY = pRODUCT_PROPERTY;
	}
	
	
	
	public String getPRODUCT_CATEGORY() {
		return PRODUCT_CATEGORY;
	}

	public void setPRODUCT_CATEGORY(String pRODUCT_CATEGORY) {
		PRODUCT_CATEGORY = pRODUCT_CATEGORY;
	}

	public Double getDNP_PRICE() {
		return DNP_PRICE;
	}

	public void setDNP_PRICE(Double dNP_PRICE) {
		DNP_PRICE = dNP_PRICE;
	}

	public Double getMSRP_PRICE() {
		return MSRP_PRICE;
	}

	public void setMSRP_PRICE(Double mSRP_PRICE) {
		MSRP_PRICE = mSRP_PRICE;
	}

	public Double getSINGLE_DISCOUNT() {
		return SINGLE_DISCOUNT;
	}

	public void setSINGLE_DISCOUNT(Double sINGLE_DISCOUNT) {
		SINGLE_DISCOUNT = sINGLE_DISCOUNT;
	}

	public Integer getIS_VALID() {
		return IS_VALID;
	}

	public void setIS_VALID(Integer iS_VALID) {
		IS_VALID = iS_VALID;
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

	public Integer getIS_C_SALE() {
		return IS_C_SALE;
	}

	public void setIS_C_SALE(Integer iS_C_SALE) {
		IS_C_SALE = iS_C_SALE;
	}

	public Integer getPRODUCT_DATE() {
		return PRODUCT_DATE;
	}

	public void setPRODUCT_DATE(Integer pRODUCT_DATE) {
		PRODUCT_DATE = pRODUCT_DATE;
	}

	public String getPRODUCT_MODEL() {
		return PRODUCT_MODEL;
	}

	public void setPRODUCT_MODEL(String pRODUCT_MODEL) {
		PRODUCT_MODEL = pRODUCT_MODEL;
	}
	
	
	public Date getSALES_DATE_START() {
		return SALES_DATE_START;
	}

	public void setSALES_DATE_START(Date sALES_DATE_START) {
		SALES_DATE_START = sALES_DATE_START;
	}

	public Date getSALES_DATE_END() {
		return SALES_DATE_END;
	}

	public void setSALES_DATE_END(Date sALES_DATE_END) {
		SALES_DATE_END = sALES_DATE_END;
	}

	public Date getRELEASE_DATE() {
		return RELEASE_DATE;
	}

	public void setRELEASE_DATE(Date rELEASE_DATE) {
		RELEASE_DATE = rELEASE_DATE;
	}

	public Integer getRELEASE_STATUS() {
		return RELEASE_STATUS;
	}

	public void setRELEASE_STATUS(Integer rELEASE_STATUS) {
		RELEASE_STATUS = rELEASE_STATUS;
	}

	public Date getSTOP_DATE() {
		return STOP_DATE;
	}

	public void setSTOP_DATE(Date sTOP_DATE) {
		STOP_DATE = sTOP_DATE;
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

	public String getPRODUCT_DESCRIBTION() {
		return PRODUCT_DESCRIBTION;
	}

	public void setPRODUCT_DESCRIBTION(String pRODUCT_DESCRIBTION) {
		PRODUCT_DESCRIBTION = pRODUCT_DESCRIBTION;
	}

	public Double getNON_TAX_COST_PRICE() {
		return NON_TAX_COST_PRICE;
	}

	public void setNON_TAX_COST_PRICE(Double nON_TAX_COST_PRICE) {
		NON_TAX_COST_PRICE = nON_TAX_COST_PRICE;
	}

	public Double getTAX_COST_PRICE() {
		return TAX_COST_PRICE;
	}

	public void setTAX_COST_PRICE(Double tAX_COST_PRICE) {
		TAX_COST_PRICE = tAX_COST_PRICE;
	}

	public Double getTERMINAL_NON_SALES_PRICE() {
		return TERMINAL_NON_SALES_PRICE;
	}

	public void setTERMINAL_NON_SALES_PRICE(Double tERMINAL_NON_SALES_PRICE) {
		TERMINAL_NON_SALES_PRICE = tERMINAL_NON_SALES_PRICE;
	}

	public Double getTERMINAL_SALES_PRICE() {
		return TERMINAL_SALES_PRICE;
	}

	public void setTERMINAL_SALES_PRICE(Double tERMINAL_SALES_PRICE) {
		TERMINAL_SALES_PRICE = tERMINAL_SALES_PRICE;
	}

	public String getReleaseStart() {
		return releaseStart;
	}

	public void setReleaseStart(String releaseStart) {
		this.releaseStart = releaseStart;
	}

	public String getReleaseEnd() {
		return releaseEnd;
	}

	public void setReleaseEnd(String releaseEnd) {
		this.releaseEnd = releaseEnd;
	}

	public String getSalesStart() {
		return salesStart;
	}

	public void setSalesStart(String salesStart) {
		this.salesStart = salesStart;
	}

	public String getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(String salesEnd) {
		this.salesEnd = salesEnd;
	}
	
	
}
