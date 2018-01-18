package com.gacfcasales.dmsweb.dao;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TtOpiExtendedSales;

public interface DmsSalesDao {
	//查询Entity_Code
	 Map getEntityCode(String dealerCode);
	 
	 //查询用户姓名
	 Map getUserName(Map map);
	 
	 
	 //查询产品信息
	 List<Map> getProductList(Assist assist);
	 long getProductRowCount(Assist assist);
	 
	 //保存销售单
	 void insertSales(TtOpiExtendedSales ttOpiExtendedSales);
	 
	 //查询销售单信息
	 List<Map> getSalesList(Assist assist);
	 long getSalesRowCount(Assist assist);
	 
	 //导出销售单信息
	 List<Map> exportSalesExcel(Assist assist);
	 
}
