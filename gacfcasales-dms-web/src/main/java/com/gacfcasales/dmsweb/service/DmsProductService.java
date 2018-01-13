package com.gacfcasales.dmsweb.service;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;

public interface DmsProductService {
	// 查询
	List<Map> getDmsProductList(Assist assist);

	long getDmsProductRowCount(Assist assist);

	// 导出Excel
	List<Map> exportExcel(Assist assist);

	// 查询明细
	Map getProdutByID(String productId);

	List<Map> getModelByProductId(Assist assist);

	long getModelByProductIdRowCount(Assist assist);
}
