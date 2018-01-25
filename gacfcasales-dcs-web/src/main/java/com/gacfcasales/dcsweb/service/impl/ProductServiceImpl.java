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
import com.gacfcasales.dcsweb.dao.ProductDao;
import com.gacfcasales.dcsweb.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired ProductDao productDao;
	
	@Override
	public List<TiOpiExtendedDCS> selectSysProduct(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.selectSysProduct(assist);
	}

	@Override
	public long getSysProductRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getSysProductRowCount(assist);
	}

	@Override
	public List<Map> exportProduct(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		return productDao.exportProduct(tiOpiExtendedDCS);
	}

	@Override
	public List<TmPartInfo> selectPartInfo(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.selectPartInfo(assist);
	}

	@Override
	public long getPartInfoRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getPartInfoRowCount(assist);
	}

	@Override
	public List<Map> getProductModelList(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getProductModelList(assist);
	}

	@Override
	public long getProductModelRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getProductModelRowCount(assist);
	}

	@Override
	public List<Map> getProductOne(TmPartInfoPage tmPartInfoPage) {
		// TODO Auto-generated method stub
		return productDao.getProductOne(tmPartInfoPage);
	}

	@Override
	public Long insertAndRetuanID(TmPartInfoPage tmPartInfoPage) {
		// TODO Auto-generated method stub
		return productDao.insertAndRetuanID(tmPartInfoPage);
	}

	@Override
	public void updateProduct(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		productDao.updateProduct(tiOpiExtendedDCS);
	}

	@Override
	public void insertProductModel(TiOpiExtendedModel tiOpiExtendedModel) {
		// TODO Auto-generated method stub
		productDao.insertProductModel(tiOpiExtendedModel);
	}

	@Override
	public void deleteProductModel(TiOpiExtendedModel tiOpiExtendedModel) {
		// TODO Auto-generated method stub
		productDao.deleteProductModel(tiOpiExtendedModel);
	}

	@Override
	public TiOpiExtendedDCS getProductByID(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return productDao.getProductByID(PRODUCT_ID);
	}

	@Override
	public int getProductModel(ModelPage modelPage) {
		// TODO Auto-generated method stub
		return productDao.getProductModel(modelPage);
	}

	@Override
	public void updateAndAddProduct(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		productDao.updateAndAddProduct(tiOpiExtendedDCS);
	}

	@Override
	public void releaseProduct(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		productDao.releaseProduct(PRODUCT_ID);
	}

	@Override
	public void cancelProduct(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		productDao.cancelProduct(PRODUCT_ID);
	}

	@Override
	public List<Map> getDetailModelList(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getDetailModelList(assist);
	}

	@Override
	public long getDetailModelRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return productDao.getDetailModelRowCount(assist);
	}

	@Override
	public List<Map> getDealerDetailList(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return productDao.getDealerDetailList(PRODUCT_ID);
	}

	@Override
	public List<Map> getDealerListAll(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return productDao.getDealerListAll(PRODUCT_ID);
	}

	@Override
	public void updateAndAddProductModel(TiOpiExtendedDCS tiOpiExtendedDCS) {
		// TODO Auto-generated method stub
		productDao.updateAndAddProductModel(tiOpiExtendedDCS);
	}

	@Override
	public void updateReleaseStatus(Map map) {
		// TODO Auto-generated method stub
		productDao.updateReleaseStatus(map);
	}

	

}
