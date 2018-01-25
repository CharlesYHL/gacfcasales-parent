package com.gacfcasales.dmsweb.webservice.wechat.advice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.gacfcasales.common.util.OemDictCodeConstants;

public class HelloWebserviceImpl implements HelloWebservice {

	@Override
	public String helloService(@WebParam(name = "message") String message) {
		// TODO Auto-generated method stub
		return returnval(OemDictCodeConstants.STATUS_ERROR,OemDictCodeConstants.EMPTYMSG_ERROR);
	}
	
	
	
	public String returnval(int k,String statusText){
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<stream>");
		sb.append("<status>"+k+"</status>");				//<!—提交状态 int   0：成功；1：失败-->
		sb.append("<statusText>"+statusText+"</statusText>");		//<!—提交状态说明 varchar(254)  成功时为空-->
		sb.append("</stream>");
		return sb.toString();
	}

}
