package com.gacfcasales.dmsweb.service;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;

public interface DmsSalesService {
	Map getEntityCode(String dealerCode);

	// 查询用户姓名
	Map getUserName(String dealerCode, String employeeNo);
	
	//产品信息查询
	List<Map> getProductList(Assist assist);
	long getProductRowCount(Assist assist);
}
