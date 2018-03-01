package com.gacfcasales.dmsweb.service;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TtOpiExtendedSales;

public interface DmsSalesService {
	Map getEntityCode(String dealerCode);

	// 查询用户姓名
	Map getUserName(String dealerCode, String employeeNo);

	// 产品信息查询
	List<Map> getProductList(Assist assist);

	long getProductRowCount(Assist assist);

	// 保存销售单
	void insertSales(TtOpiExtendedSales ttOpiExtendedSales);

	// 查询销售单信息
	List<Map> getSalesList(Assist assist);

	long getSalesRowCount(Assist assist);
	
	 List<Map> getSalesListA(Map map);
	 long getSalesRowCountA(Map map);

	// 导出销售单信息
	List<Map> exportSalesExcel(Assist assist);
	List<Map> exportSalesExcelA(Map map);

	TtOpiExtendedSales selectTtOpiExtendedSales(String PRODUCT_SALES_ID);

	// 作废销售单
	void updateSalesInvalid(Map map);

	// 编辑销售单
	void updateSales(TtOpiExtendedSales ttOpiExtendedSales);
	Map selectDataToSap(String PRODUCT_SALES_ORDER);
	void updateSapData(Map map);
	
	
	 //销售单打印
	 TtOpiExtendedSales selectTtOpiExtendedSalesPrint(String PRODUCT_SALES_ORDER);
	
}
