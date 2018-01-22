package com.gacfcasales.dcsweb.dao;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;

public interface SalesDcsDao {

	// 销售单信息查询
	List<Map> getSalesList(Map map);

	long getSalesRowCount(Map map);

	List<Map> getSalesListExport(Map map);

	// 明细
	Map getSalesFindBySalesId(String PRODUCT_SALES_ID);
}
