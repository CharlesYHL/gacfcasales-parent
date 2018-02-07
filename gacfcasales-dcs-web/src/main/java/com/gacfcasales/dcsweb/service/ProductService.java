package com.gacfcasales.dcsweb.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.ModelPage;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TiOpiExtendedModel;
import com.gacfcasales.common.entity.TmPartInfo;
import com.gacfcasales.common.entity.TmPartInfoPage;
import com.gacfcasales.common.exception.ServiceBizException;

public interface ProductService {
	List<TiOpiExtendedDCS> selectSysProduct(Assist assist);

	long getSysProductRowCount(Assist assist);

	List<Map> exportProduct(TiOpiExtendedDCS tiOpiExtendedDCS);

	List<TmPartInfo> selectPartInfo(Assist assist);

	long getPartInfoRowCount(Assist assist);

	List<Map> getProductModelList(Assist assist);

	long getProductModelRowCount(Assist assist);

	// 判断产品是否存在
	List<Map> getProductOne(TmPartInfoPage tmPartInfoPage);

	// 新增产品信息
	Long insertAndRetuanID(TmPartInfoPage tmPartInfoPage);

	// 更新产品信息
	void updateProduct(TiOpiExtendedDCS tiOpiExtendedDCS);

	// 新增车型信息
	void insertProductModel(TiOpiExtendedModel tiOpiExtendedModel);

	// 删除车型
	void deleteProductModel(TiOpiExtendedModel tiOpiExtendedModel);

	// 根据PRODUCT_ID获取产品信息
	TiOpiExtendedDCS getProductByID(String PRODUCT_ID);

	// 判断产品车型信息是否存在
	int getProductModel(ModelPage modelPage);
	int getProductModelFromSeries(ModelPage modelPage);
	void deleteProductModelFromSeries(Map map);

	// 新增更新产品信息
	void updateAndAddProduct(TiOpiExtendedDCS tiOpiExtendedDCS);

	void updateAndAddProductModel(TiOpiExtendedDCS tiOpiExtendedDCS);

	// 发布动作
	void releaseProduct(String PRODUCT_ID);

	// 取消动作
	void cancelProduct(String PRODUCT_ID);

	List<Map> getDetailModelList(Assist assist);

	long getDetailModelRowCount(Assist assist);

	List<Map> getDealerDetailList(String PRODUCT_ID);

	List<Map> getDealerListAll(String PRODUCT_ID);

	// 更新到期的产品为已取消
	void updateReleaseStatus(Map map);

}
