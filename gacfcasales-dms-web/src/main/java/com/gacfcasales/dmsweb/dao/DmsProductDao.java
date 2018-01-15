package com.gacfcasales.dmsweb.dao;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;

public interface DmsProductDao {
	// 查询
	List<Map> getDmsProductList(Assist assist);

	long getDmsProductRowCount(Assist assist);

	// 导出Excel
	List<Map> exportExcel(Assist assist);

	// 查询明细
	Map getProdutByID(String productId);

	List<Map> getModelByProductId(Assist assist);

	long getModelByProductIdRowCount(Assist assist);

	Map getDealer(String dealerCode);

	// 根据PRODUCT_ID获取产品信息
	TiOpiExtendedDCS getProductByID(String PRODUCT_ID);

	List<Map> getDetailModelList(Assist assist);

	long getDetailModelRowCount(Assist assist);
}
