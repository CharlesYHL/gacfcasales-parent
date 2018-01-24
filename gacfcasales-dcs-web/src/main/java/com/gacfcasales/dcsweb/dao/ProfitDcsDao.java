package com.gacfcasales.dcsweb.dao;

import java.util.List;
import java.util.Map;

public interface ProfitDcsDao {
	// 销售单盈利查询
	List<Map> getProfitList(Map map);

	long getProfitRowCount(Map map);
	// 销售单盈利导出
	List<Map> getProfitListExport(Map map);

	// 销售单盈利明细
	Map getProfitFindBySalesId(String PRODUCT_SALES_ID);
}
