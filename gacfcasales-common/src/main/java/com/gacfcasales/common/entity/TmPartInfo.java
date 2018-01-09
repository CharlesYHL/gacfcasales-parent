package com.gacfcasales.common.entity;

import java.io.Serializable;
import java.util.Date;

public class TmPartInfo implements Serializable {
	private String DEALER_CODE;
	private String PART_NO;
	private String PART_NAME;
	private String PART_NAME_EN;
	private String SPELL_CODE;
	private Integer PART_GROUP_CODE;
	private String UNIT_NAME;
	private String UNIT_CODE;
	private String OPTION_RELATION;
	private String OPTION_NO;
	private String BRAND;
	private String SERIES;
	private String PART_MODEL_GROUP_CODE_SET;
	private String QUANTITY_PER_CAR;
	private Double NODE_PRICE;
	private Double PLAN_PRICE;
	private Double CLAIM_PRICE;
	private Double LIMIT_PRICE;
	private Double OEM_LIMIT_PRICE;
	private Double REGULAR_PRICE;
	private Double URGENT_PRICE;
	private Double INSTRUCT_PRICE;
	private Double INSURANCE_PRICE;
	private String REMARK;
	private Double MAX_STOCK;
	private Double MIN_STOCK;
	private Integer LEAD_TIME;
	private String PROVIDER_CODE;
	private Integer PART_STATUS;
	private Integer IS_UNSAFE;
	private Double MIN_PACKAGE;
	private String ORDER_TYPE;
	private String PRODUCTING_AREA;
	private Integer MAIN_ORDER_TYPE;
	private String PART_PRODUCT_CODE;
	private Integer PART_MAIN_TYPE;
	private String FROM_ENTITY;
	private Integer IS_FREEZE;
	private Integer DOWN_TAG;
	private String ORI_PRO_CODE;
	private Integer ABC_TYPE;
	private Integer IS_THINGS;
	private Integer IS_OIL;
	private Integer IS_SPECIAL;
	private Double BASE_WARP;
	private String APPLY_YEAR;
	private Integer IS_CAL_BASE;
	private String BO_FLAG;
	private Integer IS_ACC;
	private String SUB_CATEGORY_CODE;
	private String BIG_CATEGORY_CODE;
	private String THD_CATEGORY_CODE;
	private Double SAFE_STOCK;
	private Integer IS_STORAGE_SALE;
	private Integer D_KEY;
	private String CREATED_BY;
	private Date CREATED_AT;
	private String UPDATED_BY;
	private Date UPDATED_AT;
	private Integer VER;
	private Integer OEM_TAG;
	private String QAN_RULES;
	private Date SUBMIT_TIME;
	private String ACC_MODE;
	private String PROVIDER_NAME;
	private Double MAINTAIN_PRICE;
	private Integer IS_BACK;
	private String SALE_CODE;
	private Integer IS_EXEMPT_C;
	private String GOODS_BRANDS;
	private String OEM_NO;
	private String PART_INFIX;
	private Date DDCN_UPDATE_DATE;
	private String PART_INFIX_NAME;
	private Double MIN_LIMIT_PRICE;
	private Integer PART_TYPE;
	private String LIMIT_NO;
	private Integer IS_SJV;
	private Integer IS_MOP;
	private Integer IS_C_SALE;
	private Integer IS_C_PURCHASE;
	private Integer IS_COMMON_IDENTITY;
	private Integer PART_PROPERTY;
	private String PART_VEHICLE_MODEL;
	private Integer REPORT_WAY;
	
	public TmPartInfo() {
		super();
	}
	
	public TmPartInfo(String DEALER_CODE,String PART_NO,String PART_NAME,String PART_NAME_EN,String SPELL_CODE,Integer PART_GROUP_CODE,String UNIT_NAME,String UNIT_CODE,String OPTION_RELATION,String OPTION_NO,String BRAND,String SERIES,String PART_MODEL_GROUP_CODE_SET,String QUANTITY_PER_CAR,Double NODE_PRICE,Double PLAN_PRICE,Double CLAIM_PRICE,Double LIMIT_PRICE,Double OEM_LIMIT_PRICE,Double REGULAR_PRICE,Double URGENT_PRICE,Double INSTRUCT_PRICE,Double INSURANCE_PRICE,String REMARK,Double MAX_STOCK,Double MIN_STOCK,Integer LEAD_TIME,String PROVIDER_CODE,Integer PART_STATUS,Integer IS_UNSAFE,Double MIN_PACKAGE,String ORDER_TYPE,String PRODUCTING_AREA,Integer MAIN_ORDER_TYPE,String PART_PRODUCT_CODE,Integer PART_MAIN_TYPE,String FROM_ENTITY,Integer IS_FREEZE,Integer DOWN_TAG,String ORI_PRO_CODE,Integer ABC_TYPE,Integer IS_THINGS,Integer IS_OIL,Integer IS_SPECIAL,Double BASE_WARP,String APPLY_YEAR,Integer IS_CAL_BASE,String BO_FLAG,Integer IS_ACC,String SUB_CATEGORY_CODE,String BIG_CATEGORY_CODE,String THD_CATEGORY_CODE,Double SAFE_STOCK,Integer IS_STORAGE_SALE,Integer D_KEY,String CREATED_BY,Date CREATED_AT,String UPDATED_BY,Date UPDATED_AT,Integer VER,Integer OEM_TAG,String QAN_RULES,Date SUBMIT_TIME,String ACC_MODE,String PROVIDER_NAME,Double MAINTAIN_PRICE,Integer IS_BACK,String SALE_CODE,Integer IS_EXEMPT_C,String GOODS_BRANDS,String OEM_NO,String PART_INFIX,Date DDCN_UPDATE_DATE,String PART_INFIX_NAME,Double MIN_LIMIT_PRICE,Integer PART_TYPE,String LIMIT_NO,Integer IS_SJV,Integer IS_MOP,Integer IS_C_SALE,Integer IS_C_PURCHASE,Integer IS_COMMON_IDENTITY,Integer PART_PROPERTY,String PART_VEHICLE_MODEL,Integer REPORT_WAY) {
		this.DEALER_CODE=DEALER_CODE;
		this.PART_NO=PART_NO;
		this.PART_NAME=PART_NAME;
		this.PART_NAME_EN=PART_NAME_EN;
		this.SPELL_CODE=SPELL_CODE;
		this.PART_GROUP_CODE=PART_GROUP_CODE;
		this.UNIT_NAME=UNIT_NAME;
		this.UNIT_CODE=UNIT_CODE;
		this.OPTION_RELATION=OPTION_RELATION;
		this.OPTION_NO=OPTION_NO;
		this.BRAND=BRAND;
		this.SERIES=SERIES;
		this.PART_MODEL_GROUP_CODE_SET=PART_MODEL_GROUP_CODE_SET;
		this.QUANTITY_PER_CAR=QUANTITY_PER_CAR;
		this.NODE_PRICE=NODE_PRICE;
		this.PLAN_PRICE=PLAN_PRICE;
		this.CLAIM_PRICE=CLAIM_PRICE;
		this.LIMIT_PRICE=LIMIT_PRICE;
		this.OEM_LIMIT_PRICE=OEM_LIMIT_PRICE;
		this.REGULAR_PRICE=REGULAR_PRICE;
		this.URGENT_PRICE=URGENT_PRICE;
		this.INSTRUCT_PRICE=INSTRUCT_PRICE;
		this.INSURANCE_PRICE=INSURANCE_PRICE;
		this.REMARK=REMARK;
		this.MAX_STOCK=MAX_STOCK;
		this.MIN_STOCK=MIN_STOCK;
		this.LEAD_TIME=LEAD_TIME;
		this.PROVIDER_CODE=PROVIDER_CODE;
		this.PART_STATUS=PART_STATUS;
		this.IS_UNSAFE=IS_UNSAFE;
		this.MIN_PACKAGE=MIN_PACKAGE;
		this.ORDER_TYPE=ORDER_TYPE;
		this.PRODUCTING_AREA=PRODUCTING_AREA;
		this.MAIN_ORDER_TYPE=MAIN_ORDER_TYPE;
		this.PART_PRODUCT_CODE=PART_PRODUCT_CODE;
		this.PART_MAIN_TYPE=PART_MAIN_TYPE;
		this.FROM_ENTITY=FROM_ENTITY;
		this.IS_FREEZE=IS_FREEZE;
		this.DOWN_TAG=DOWN_TAG;
		this.ORI_PRO_CODE=ORI_PRO_CODE;
		this.ABC_TYPE=ABC_TYPE;
		this.IS_THINGS=IS_THINGS;
		this.IS_OIL=IS_OIL;
		this.IS_SPECIAL=IS_SPECIAL;
		this.BASE_WARP=BASE_WARP;
		this.APPLY_YEAR=APPLY_YEAR;
		this.IS_CAL_BASE=IS_CAL_BASE;
		this.BO_FLAG=BO_FLAG;
		this.IS_ACC=IS_ACC;
		this.SUB_CATEGORY_CODE=SUB_CATEGORY_CODE;
		this.BIG_CATEGORY_CODE=BIG_CATEGORY_CODE;
		this.THD_CATEGORY_CODE=THD_CATEGORY_CODE;
		this.SAFE_STOCK=SAFE_STOCK;
		this.IS_STORAGE_SALE=IS_STORAGE_SALE;
		this.D_KEY=D_KEY;
		this.CREATED_BY=CREATED_BY;
		this.CREATED_AT=CREATED_AT;
		this.UPDATED_BY=UPDATED_BY;
		this.UPDATED_AT=UPDATED_AT;
		this.VER=VER;
		this.OEM_TAG=OEM_TAG;
		this.QAN_RULES=QAN_RULES;
		this.SUBMIT_TIME=SUBMIT_TIME;
		this.ACC_MODE=ACC_MODE;
		this.PROVIDER_NAME=PROVIDER_NAME;
		this.MAINTAIN_PRICE=MAINTAIN_PRICE;
		this.IS_BACK=IS_BACK;
		this.SALE_CODE=SALE_CODE;
		this.IS_EXEMPT_C=IS_EXEMPT_C;
		this.GOODS_BRANDS=GOODS_BRANDS;
		this.OEM_NO=OEM_NO;
		this.PART_INFIX=PART_INFIX;
		this.DDCN_UPDATE_DATE=DDCN_UPDATE_DATE;
		this.PART_INFIX_NAME=PART_INFIX_NAME;
		this.MIN_LIMIT_PRICE=MIN_LIMIT_PRICE;
		this.PART_TYPE=PART_TYPE;
		this.LIMIT_NO=LIMIT_NO;
		this.IS_SJV=IS_SJV;
		this.IS_MOP=IS_MOP;
		this.IS_C_SALE=IS_C_SALE;
		this.IS_C_PURCHASE=IS_C_PURCHASE;
		this.IS_COMMON_IDENTITY=IS_COMMON_IDENTITY;
		this.PART_PROPERTY=PART_PROPERTY;
		this.PART_VEHICLE_MODEL=PART_VEHICLE_MODEL;
		this.REPORT_WAY=REPORT_WAY;
	}
	
	public String getDEALER_CODE() {
		return DEALER_CODE;
	}
	public void setDEALER_CODE(String dEALER_CODE) {
		DEALER_CODE = dEALER_CODE;
	}
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
	public String getPART_NAME_EN() {
		return PART_NAME_EN;
	}
	public void setPART_NAME_EN(String pART_NAME_EN) {
		PART_NAME_EN = pART_NAME_EN;
	}
	public String getSPELL_CODE() {
		return SPELL_CODE;
	}
	public void setSPELL_CODE(String sPELL_CODE) {
		SPELL_CODE = sPELL_CODE;
	}
	public Integer getPART_GROUP_CODE() {
		return PART_GROUP_CODE;
	}
	public void setPART_GROUP_CODE(Integer pART_GROUP_CODE) {
		PART_GROUP_CODE = pART_GROUP_CODE;
	}
	public String getUNIT_NAME() {
		return UNIT_NAME;
	}
	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}
	public String getUNIT_CODE() {
		return UNIT_CODE;
	}
	public void setUNIT_CODE(String uNIT_CODE) {
		UNIT_CODE = uNIT_CODE;
	}
	public String getOPTION_RELATION() {
		return OPTION_RELATION;
	}
	public void setOPTION_RELATION(String oPTION_RELATION) {
		OPTION_RELATION = oPTION_RELATION;
	}
	public String getOPTION_NO() {
		return OPTION_NO;
	}
	public void setOPTION_NO(String oPTION_NO) {
		OPTION_NO = oPTION_NO;
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
	public String getPART_MODEL_GROUP_CODE_SET() {
		return PART_MODEL_GROUP_CODE_SET;
	}
	public void setPART_MODEL_GROUP_CODE_SET(String pART_MODEL_GROUP_CODE_SET) {
		PART_MODEL_GROUP_CODE_SET = pART_MODEL_GROUP_CODE_SET;
	}
	public String getQUANTITY_PER_CAR() {
		return QUANTITY_PER_CAR;
	}
	public void setQUANTITY_PER_CAR(String qUANTITY_PER_CAR) {
		QUANTITY_PER_CAR = qUANTITY_PER_CAR;
	}
	public Double getNODE_PRICE() {
		return NODE_PRICE;
	}
	public void setNODE_PRICE(Double nODE_PRICE) {
		NODE_PRICE = nODE_PRICE;
	}
	public Double getPLAN_PRICE() {
		return PLAN_PRICE;
	}
	public void setPLAN_PRICE(Double pLAN_PRICE) {
		PLAN_PRICE = pLAN_PRICE;
	}
	public Double getCLAIM_PRICE() {
		return CLAIM_PRICE;
	}
	public void setCLAIM_PRICE(Double cLAIM_PRICE) {
		CLAIM_PRICE = cLAIM_PRICE;
	}
	public Double getLIMIT_PRICE() {
		return LIMIT_PRICE;
	}
	public void setLIMIT_PRICE(Double lIMIT_PRICE) {
		LIMIT_PRICE = lIMIT_PRICE;
	}
	public Double getOEM_LIMIT_PRICE() {
		return OEM_LIMIT_PRICE;
	}
	public void setOEM_LIMIT_PRICE(Double oEM_LIMIT_PRICE) {
		OEM_LIMIT_PRICE = oEM_LIMIT_PRICE;
	}
	public Double getREGULAR_PRICE() {
		return REGULAR_PRICE;
	}
	public void setREGULAR_PRICE(Double rEGULAR_PRICE) {
		REGULAR_PRICE = rEGULAR_PRICE;
	}
	public Double getURGENT_PRICE() {
		return URGENT_PRICE;
	}
	public void setURGENT_PRICE(Double uRGENT_PRICE) {
		URGENT_PRICE = uRGENT_PRICE;
	}
	public Double getINSTRUCT_PRICE() {
		return INSTRUCT_PRICE;
	}
	public void setINSTRUCT_PRICE(Double iNSTRUCT_PRICE) {
		INSTRUCT_PRICE = iNSTRUCT_PRICE;
	}
	public Double getINSURANCE_PRICE() {
		return INSURANCE_PRICE;
	}
	public void setINSURANCE_PRICE(Double iNSURANCE_PRICE) {
		INSURANCE_PRICE = iNSURANCE_PRICE;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public Double getMAX_STOCK() {
		return MAX_STOCK;
	}
	public void setMAX_STOCK(Double mAX_STOCK) {
		MAX_STOCK = mAX_STOCK;
	}
	public Double getMIN_STOCK() {
		return MIN_STOCK;
	}
	public void setMIN_STOCK(Double mIN_STOCK) {
		MIN_STOCK = mIN_STOCK;
	}
	public Integer getLEAD_TIME() {
		return LEAD_TIME;
	}
	public void setLEAD_TIME(Integer lEAD_TIME) {
		LEAD_TIME = lEAD_TIME;
	}
	public String getPROVIDER_CODE() {
		return PROVIDER_CODE;
	}
	public void setPROVIDER_CODE(String pROVIDER_CODE) {
		PROVIDER_CODE = pROVIDER_CODE;
	}
	public Integer getPART_STATUS() {
		return PART_STATUS;
	}
	public void setPART_STATUS(Integer pART_STATUS) {
		PART_STATUS = pART_STATUS;
	}
	public Integer getIS_UNSAFE() {
		return IS_UNSAFE;
	}
	public void setIS_UNSAFE(Integer iS_UNSAFE) {
		IS_UNSAFE = iS_UNSAFE;
	}
	public Double getMIN_PACKAGE() {
		return MIN_PACKAGE;
	}
	public void setMIN_PACKAGE(Double mIN_PACKAGE) {
		MIN_PACKAGE = mIN_PACKAGE;
	}
	public String getORDER_TYPE() {
		return ORDER_TYPE;
	}
	public void setORDER_TYPE(String oRDER_TYPE) {
		ORDER_TYPE = oRDER_TYPE;
	}
	public String getPRODUCTING_AREA() {
		return PRODUCTING_AREA;
	}
	public void setPRODUCTING_AREA(String pRODUCTING_AREA) {
		PRODUCTING_AREA = pRODUCTING_AREA;
	}
	public Integer getMAIN_ORDER_TYPE() {
		return MAIN_ORDER_TYPE;
	}
	public void setMAIN_ORDER_TYPE(Integer mAIN_ORDER_TYPE) {
		MAIN_ORDER_TYPE = mAIN_ORDER_TYPE;
	}
	public String getPART_PRODUCT_CODE() {
		return PART_PRODUCT_CODE;
	}
	public void setPART_PRODUCT_CODE(String pART_PRODUCT_CODE) {
		PART_PRODUCT_CODE = pART_PRODUCT_CODE;
	}
	public Integer getPART_MAIN_TYPE() {
		return PART_MAIN_TYPE;
	}
	public void setPART_MAIN_TYPE(Integer pART_MAIN_TYPE) {
		PART_MAIN_TYPE = pART_MAIN_TYPE;
	}
	public String getFROM_ENTITY() {
		return FROM_ENTITY;
	}
	public void setFROM_ENTITY(String fROM_ENTITY) {
		FROM_ENTITY = fROM_ENTITY;
	}
	public Integer getIS_FREEZE() {
		return IS_FREEZE;
	}
	public void setIS_FREEZE(Integer iS_FREEZE) {
		IS_FREEZE = iS_FREEZE;
	}
	public Integer getDOWN_TAG() {
		return DOWN_TAG;
	}
	public void setDOWN_TAG(Integer dOWN_TAG) {
		DOWN_TAG = dOWN_TAG;
	}
	public String getORI_PRO_CODE() {
		return ORI_PRO_CODE;
	}
	public void setORI_PRO_CODE(String oRI_PRO_CODE) {
		ORI_PRO_CODE = oRI_PRO_CODE;
	}
	public Integer getABC_TYPE() {
		return ABC_TYPE;
	}
	public void setABC_TYPE(Integer aBC_TYPE) {
		ABC_TYPE = aBC_TYPE;
	}
	public Integer getIS_THINGS() {
		return IS_THINGS;
	}
	public void setIS_THINGS(Integer iS_THINGS) {
		IS_THINGS = iS_THINGS;
	}
	public Integer getIS_OIL() {
		return IS_OIL;
	}
	public void setIS_OIL(Integer iS_OIL) {
		IS_OIL = iS_OIL;
	}
	public Integer getIS_SPECIAL() {
		return IS_SPECIAL;
	}
	public void setIS_SPECIAL(Integer iS_SPECIAL) {
		IS_SPECIAL = iS_SPECIAL;
	}
	public Double getBASE_WARP() {
		return BASE_WARP;
	}
	public void setBASE_WARP(Double bASE_WARP) {
		BASE_WARP = bASE_WARP;
	}
	public String getAPPLY_YEAR() {
		return APPLY_YEAR;
	}
	public void setAPPLY_YEAR(String aPPLY_YEAR) {
		APPLY_YEAR = aPPLY_YEAR;
	}
	public Integer getIS_CAL_BASE() {
		return IS_CAL_BASE;
	}
	public void setIS_CAL_BASE(Integer iS_CAL_BASE) {
		IS_CAL_BASE = iS_CAL_BASE;
	}
	public String getBO_FLAG() {
		return BO_FLAG;
	}
	public void setBO_FLAG(String bO_FLAG) {
		BO_FLAG = bO_FLAG;
	}
	public Integer getIS_ACC() {
		return IS_ACC;
	}
	public void setIS_ACC(Integer iS_ACC) {
		IS_ACC = iS_ACC;
	}
	public String getSUB_CATEGORY_CODE() {
		return SUB_CATEGORY_CODE;
	}
	public void setSUB_CATEGORY_CODE(String sUB_CATEGORY_CODE) {
		SUB_CATEGORY_CODE = sUB_CATEGORY_CODE;
	}
	public String getBIG_CATEGORY_CODE() {
		return BIG_CATEGORY_CODE;
	}
	public void setBIG_CATEGORY_CODE(String bIG_CATEGORY_CODE) {
		BIG_CATEGORY_CODE = bIG_CATEGORY_CODE;
	}
	public String getTHD_CATEGORY_CODE() {
		return THD_CATEGORY_CODE;
	}
	public void setTHD_CATEGORY_CODE(String tHD_CATEGORY_CODE) {
		THD_CATEGORY_CODE = tHD_CATEGORY_CODE;
	}
	public Double getSAFE_STOCK() {
		return SAFE_STOCK;
	}
	public void setSAFE_STOCK(Double sAFE_STOCK) {
		SAFE_STOCK = sAFE_STOCK;
	}
	public Integer getIS_STORAGE_SALE() {
		return IS_STORAGE_SALE;
	}
	public void setIS_STORAGE_SALE(Integer iS_STORAGE_SALE) {
		IS_STORAGE_SALE = iS_STORAGE_SALE;
	}
	public Integer getD_KEY() {
		return D_KEY;
	}
	public void setD_KEY(Integer d_KEY) {
		D_KEY = d_KEY;
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
	public Integer getVER() {
		return VER;
	}
	public void setVER(Integer vER) {
		VER = vER;
	}
	public Integer getOEM_TAG() {
		return OEM_TAG;
	}
	public void setOEM_TAG(Integer oEM_TAG) {
		OEM_TAG = oEM_TAG;
	}
	public String getQAN_RULES() {
		return QAN_RULES;
	}
	public void setQAN_RULES(String qAN_RULES) {
		QAN_RULES = qAN_RULES;
	}
	public Date getSUBMIT_TIME() {
		return SUBMIT_TIME;
	}
	public void setSUBMIT_TIME(Date sUBMIT_TIME) {
		SUBMIT_TIME = sUBMIT_TIME;
	}
	public String getACC_MODE() {
		return ACC_MODE;
	}
	public void setACC_MODE(String aCC_MODE) {
		ACC_MODE = aCC_MODE;
	}
	public String getPROVIDER_NAME() {
		return PROVIDER_NAME;
	}
	public void setPROVIDER_NAME(String pROVIDER_NAME) {
		PROVIDER_NAME = pROVIDER_NAME;
	}
	public Double getMAINTAIN_PRICE() {
		return MAINTAIN_PRICE;
	}
	public void setMAINTAIN_PRICE(Double mAINTAIN_PRICE) {
		MAINTAIN_PRICE = mAINTAIN_PRICE;
	}
	public Integer getIS_BACK() {
		return IS_BACK;
	}
	public void setIS_BACK(Integer iS_BACK) {
		IS_BACK = iS_BACK;
	}
	public String getSALE_CODE() {
		return SALE_CODE;
	}
	public void setSALE_CODE(String sALE_CODE) {
		SALE_CODE = sALE_CODE;
	}
	public Integer getIS_EXEMPT_C() {
		return IS_EXEMPT_C;
	}
	public void setIS_EXEMPT_C(Integer iS_EXEMPT_C) {
		IS_EXEMPT_C = iS_EXEMPT_C;
	}
	public String getGOODS_BRANDS() {
		return GOODS_BRANDS;
	}
	public void setGOODS_BRANDS(String gOODS_BRANDS) {
		GOODS_BRANDS = gOODS_BRANDS;
	}
	public String getOEM_NO() {
		return OEM_NO;
	}
	public void setOEM_NO(String oEM_NO) {
		OEM_NO = oEM_NO;
	}
	public String getPART_INFIX() {
		return PART_INFIX;
	}
	public void setPART_INFIX(String pART_INFIX) {
		PART_INFIX = pART_INFIX;
	}
	public Date getDDCN_UPDATE_DATE() {
		return DDCN_UPDATE_DATE;
	}
	public void setDDCN_UPDATE_DATE(Date dDCN_UPDATE_DATE) {
		DDCN_UPDATE_DATE = dDCN_UPDATE_DATE;
	}
	public String getPART_INFIX_NAME() {
		return PART_INFIX_NAME;
	}
	public void setPART_INFIX_NAME(String pART_INFIX_NAME) {
		PART_INFIX_NAME = pART_INFIX_NAME;
	}
	public Double getMIN_LIMIT_PRICE() {
		return MIN_LIMIT_PRICE;
	}
	public void setMIN_LIMIT_PRICE(Double mIN_LIMIT_PRICE) {
		MIN_LIMIT_PRICE = mIN_LIMIT_PRICE;
	}
	public Integer getPART_TYPE() {
		return PART_TYPE;
	}
	public void setPART_TYPE(Integer pART_TYPE) {
		PART_TYPE = pART_TYPE;
	}
	public String getLIMIT_NO() {
		return LIMIT_NO;
	}
	public void setLIMIT_NO(String lIMIT_NO) {
		LIMIT_NO = lIMIT_NO;
	}
	public Integer getIS_SJV() {
		return IS_SJV;
	}
	public void setIS_SJV(Integer iS_SJV) {
		IS_SJV = iS_SJV;
	}
	public Integer getIS_MOP() {
		return IS_MOP;
	}
	public void setIS_MOP(Integer iS_MOP) {
		IS_MOP = iS_MOP;
	}
	public Integer getIS_C_SALE() {
		return IS_C_SALE;
	}
	public void setIS_C_SALE(Integer iS_C_SALE) {
		IS_C_SALE = iS_C_SALE;
	}
	public Integer getIS_C_PURCHASE() {
		return IS_C_PURCHASE;
	}
	public void setIS_C_PURCHASE(Integer iS_C_PURCHASE) {
		IS_C_PURCHASE = iS_C_PURCHASE;
	}
	public Integer getIS_COMMON_IDENTITY() {
		return IS_COMMON_IDENTITY;
	}
	public void setIS_COMMON_IDENTITY(Integer iS_COMMON_IDENTITY) {
		IS_COMMON_IDENTITY = iS_COMMON_IDENTITY;
	}
	public Integer getPART_PROPERTY() {
		return PART_PROPERTY;
	}
	public void setPART_PROPERTY(Integer pART_PROPERTY) {
		PART_PROPERTY = pART_PROPERTY;
	}
	public String getPART_VEHICLE_MODEL() {
		return PART_VEHICLE_MODEL;
	}
	public void setPART_VEHICLE_MODEL(String pART_VEHICLE_MODEL) {
		PART_VEHICLE_MODEL = pART_VEHICLE_MODEL;
	}
	public Integer getREPORT_WAY() {
		return REPORT_WAY;
	}
	public void setREPORT_WAY(Integer rEPORT_WAY) {
		REPORT_WAY = rEPORT_WAY;
	}
	
	
	
	

}
