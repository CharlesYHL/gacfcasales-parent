package com.gacfcasales.dmsweb.dao;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;

public interface DmsSalesDao {
	//查询Entity_Code
	 Map getEntityCode(String dealerCode);
	 
	 //查询用户姓名
	 Map getUserName(Map map);
	 
	 
	 //查询产品信息
	 List<Map> getProductList(Assist assist);
	 long getProductRowCount(Assist assist);
	 
}
