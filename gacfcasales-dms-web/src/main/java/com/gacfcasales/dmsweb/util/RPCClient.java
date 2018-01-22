package com.gacfcasales.dmsweb.util;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.axis2.transport.http.impl.httpclient3.HttpTransportPropertiesImpl.Authenticator;

import com.gacfcasales.dmsweb.webservice.ssrtosap.Sdsd001Main;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Z_SD_SD001Stub;
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

public class RPCClient {
	public static String address = "http://10.27.207.8:8081/wsProxy/DCS_SAP_JOB00111?wsdl";

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("PRODUCT_DESCRIBTION", "1234");
		map.put("PRODUCT_NO", "ZHS00000031");
		map.put("PRODUCT_SALES_ORDER", "64405035000042");
		map.put("PURCHASE_NUMBER", "1");
		map.put("LICENSE_NO", "无车牌");
		map.put("OWNER_PHONE", "");
		map.put("VIN", "1C4BJWE50GL148297");
		map.put("CTCAI_CODE", "0733151");
		Sdsd001Main.Sdsd001ToSap(map);
	}
	
	public static void getData() {
		try {
			Z_SD_SD001Stub stub = new Z_SD_SD001Stub();
			Authenticator auth = new Authenticator();
			auth.setUsername("DCS_SAP_User");
			auth.setPassword("A41DFD4D887B2EAFDC9BDC8DE9A45ECB");
			//HttpBasicAuthentication auth = new HttpBasicAuthentication();
			stub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, auth);  
			//stub._getServiceClient().getOptions().setUserName("");
			//stub._getServiceClient().getOptions().setPassword("");
			Map<String, Object> map = new HashMap<String, Object>();
			ZSdSd001 zSdSd001 = new ZSdSd001();
			zSdSd001.setINote(getChar200("123456"));
			zSdSd001.setIOrderType(getChar2("SS"));
			zSdSd001.setIPartNo(getChar18("ZHS00000031"));
			zSdSd001.setIRefNumber(getChar35("64377952000008"));
			zSdSd001.setIReqQty(getNumeric4("1"));
			zSdSd001.setISigni(getChar20("无牌照"));
			zSdSd001.setITel(getChar20("021-54443332"));
			zSdSd001.setIVinCode(getChar35("1C4BJWE50GL148297"));
			zSdSd001.setIWerks(getChar4("3210"));
			zSdSd001.setIZzcliente(getChar7("0733151"));
			ZSdSd001Response response = stub.zSdSd001(zSdSd001);
			System.out.println(response.getIsMessage()+"=="+response.getIsResult()+"=="+response.getKbetrHs());
			System.out.println(stub.zSdSd001(zSdSd001));
			
			//return zSdSd001;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
