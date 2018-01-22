package com.gacfcasales.dcsweb.service;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;

public interface SalesDcsService {
	// 销售单信息查询
	List<Map> getSalesList(Map map);

	long getSalesRowCount(Map map);

	// 导出Excel
	List<Map> getSalesListExport(Map map);
	
	//明细
	Map getSalesFindBySalesId(String PRODUCT_SALES_ID);

}
