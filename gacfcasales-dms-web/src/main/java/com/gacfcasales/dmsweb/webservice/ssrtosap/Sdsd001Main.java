package com.gacfcasales.dmsweb.webservice.ssrtosap;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.axis2.transport.http.impl.httpclient3.HttpTransportPropertiesImpl.Authenticator;

import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Char18;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Char2;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Char20;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Char200;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Char35;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Char4;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Char7;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.Numeric4;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.ZSdSd001;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub.ZSdSd001Response;

public class Sdsd001Main {
	public static Map Sdsd001ToSap(Map params) {
		Properties pp = new Properties();
		InputStream in = Sdsd001Main.class.getClassLoader().getResourceAsStream("webservice.properties");
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pp.load(in);
			Z_SD_SD001Stub stub = new Z_SD_SD001Stub();
			Authenticator auth = new Authenticator();
			auth.setUsername(pp.getProperty("ZSDSD001.username").toString());
			auth.setPassword(pp.getProperty("ZSDSD001.password").toString());
			stub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, auth);  
			ZSdSd001 zSdSd001 = new ZSdSd001();
			if(params.get("PRODUCT_DESCRIBTION") != null && !"".equals(params.get("PRODUCT_DESCRIBTION"))) {
				zSdSd001.setINote(getChar200(params.get("PRODUCT_DESCRIBTION").toString()));
			}else {
				zSdSd001.setINote(getChar200(""));
			}
			
			zSdSd001.setIOrderType(getChar2("SS"));
			zSdSd001.setIPartNo(getChar18(params.get("PRODUCT_NO").toString()));
			zSdSd001.setIRefNumber(getChar35(params.get("PRODUCT_SALES_ORDER").toString()));
			zSdSd001.setIReqQty(getNumeric4(params.get("PURCHASE_NUMBER").toString()));
			if(params.get("LICENSE_NO") !=null && !"".equals(params.get("LICENSE_NO"))) {
				zSdSd001.setISigni(getChar20(params.get("LICENSE_NO").toString()));
			}else {
				zSdSd001.setISigni(getChar20("无牌照"));
			}
			if(params.get("OWNER_PHONE") != null && !"".equals(params.get("OWNER_PHONE"))) {
				zSdSd001.setITel(getChar20(params.get("OWNER_PHONE").toString()));
			}else {
				zSdSd001.setITel(getChar20(""));
			}
			zSdSd001.setIVinCode(getChar35(params.get("VIN").toString()));
			zSdSd001.setIWerks(getChar4("3210"));
			zSdSd001.setIZzcliente(getChar7(params.get("CTCAI_CODE").toString()));
			ZSdSd001Response response = stub.zSdSd001(zSdSd001);
			if(response != null) {
				map.put("IS_RESULT", response.getIsResult().toString().trim());
				map.put("IS_MESSAGE", response.getIsMessage().toString().trim());
				map.put("VBELN", response.getVbeln().toString().trim());
				map.put("KBETR_YJ", response.getKbetrYj().toString().trim());
				map.put("KBETR_ZK", response.getKbetrZk().toString().trim());
				map.put("KBETR_JJ", response.getKbetrJj().toString().trim());
				map.put("KBETR_HS", response.getKbetrHs().toString().trim());
			}
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Char200 getChar200(String params) {
		Char200 char200 = new Char200();
		char200.setChar200(params);
		return char200;
	}

	public static Char2 getChar2(String params) {
		Char2 char2 = new Char2();
		char2.setChar2(params);
		return char2;
	}

	public static Char4 getChar4(String params) {
		Char4 char4 = new Char4();
		char4.setChar4(params);
		return char4;
	}

	public static Char18 getChar18(String params) {
		Char18 char18 = new Char18();
		char18.setChar18(params);
		return char18;
	}

	public static Char35 getChar35(String params) {
		Char35 char35 = new Char35();
		char35.setChar35(params);
		return char35;
	}

	public static Numeric4 getNumeric4(String params) {
		Numeric4 numeric4 = new Numeric4();
		numeric4.setNumeric4(params);
		return numeric4;
	}

	public static Char20 getChar20(String params) {
		Char20 char20 = new Char20();
		char20.setChar20(params);
		return char20;
	}

	public static Char7 getChar7(String params) {
		Char7 char7 = new Char7();
		char7.setChar7(params);
		return char7;
	}
	
}
