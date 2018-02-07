package com.gacfcasales.dcsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.ModelPage;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TiOpiExtendedModel;
import com.gacfcasales.common.entity.TmPartInfo;
import com.gacfcasales.common.entity.TmPartInfoPage;
import com.gacfcasales.dcsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.dcsweb.dao.ProductDao;
import com.gacfcasales.dcsweb.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired ProductDao productDao;
	
	@Override
	@DataSourceAnnotation(value="read")
	public List<TiOpiExtendedDCS> selectSysProduct(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.selectSysProduct(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getSysProductRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getSysProductRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> exportProduct(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		return productDao.exportProduct(tiOpiExtendedDCS);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<TmPartInfo> selectPartInfo(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.selectPartInfo(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getPartInfoRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getPartInfoRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getProductModelList(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getProductModelList(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getProductModelRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getProductModelRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getProductOne(TmPartInfoPage tmPartInfoPage) {
		// TODO Auto-generated method stub
		return productDao.getProductOne(tmPartInfoPage);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public Long insertAndRetuanID(TmPartInfoPage tmPartInfoPage) {
		// TODO Auto-generated method stub
		return productDao.insertAndRetuanID(tmPartInfoPage);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void updateProduct(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		productDao.updateProduct(tiOpiExtendedDCS);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void insertProductModel(TiOpiExtendedModel tiOpiExtendedModel) {
		// TODO Auto-generated method stub
		productDao.insertProductModel(tiOpiExtendedModel);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void deleteProductModel(TiOpiExtendedModel tiOpiExtendedModel) {
		// TODO Auto-generated method stub
		productDao.deleteProductModel(tiOpiExtendedModel);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public TiOpiExtendedDCS getProductByID(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return productDao.getProductByID(PRODUCT_ID);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public int getProductModel(ModelPage modelPage) {
		// TODO Auto-generated method stub
		return productDao.getProductModel(modelPage);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void updateAndAddProduct(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		productDao.updateAndAddProduct(tiOpiExtendedDCS);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void releaseProduct(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		productDao.releaseProduct(PRODUCT_ID);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void cancelProduct(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		productDao.cancelProduct(PRODUCT_ID);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getDetailModelList(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getDetailModelList(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getDetailModelRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getDetailModelRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getDealerDetailList(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return productDao.getDealerDetailList(PRODUCT_ID);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getDealerListAll(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return productDao.getDealerListAll(PRODUCT_ID);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void updateAndAddProductModel(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		productDao.updateAndAddProductModel(tiOpiExtendedDCS);
	}

	@Override
	@DataSourceAnnotation(value="write")
	public void updateReleaseStatus(Map map) {
		// TODO Auto-generated method stub
		productDao.updateReleaseStatus(map);
	}

	@Override
	public int getProductModelFromSeries(ModelPage modelPage) {
		// TODO Auto-generated method stub
		return productDao.getProductModelFromSeries(modelPage);
	}

	@Override
	public void deleteProductModelFromSeries(Map map) {
		// TODO Auto-generated method stub
		productDao.deleteProductModelFromSeries(map);
	}

	

}
