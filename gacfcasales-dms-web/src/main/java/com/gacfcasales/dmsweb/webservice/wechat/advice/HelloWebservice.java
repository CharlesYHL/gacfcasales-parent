package com.gacfcasales.dmsweb.webservice.wechat.advice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://advice.wechat.webservice.dmsweb.gacfcasales.com/")
public interface HelloWebservice {
	
	String helloService(@WebParam(name = "message") String message);
}
