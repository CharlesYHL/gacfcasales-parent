package com.gacfcasales.dmsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.dmsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.dmsweb.dao.DmsProductDao;
import com.gacfcasales.dmsweb.service.DmsProductService;

@Service
public class DmsProductServiceImpl implements DmsProductService {
	
	@Autowired DmsProductDao dmsProductDao;
	
	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getDmsProductList(Assist assist) {
		// TODO Auto-generated method stub
		return dmsProductDao.getDmsProductList(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getDmsProductRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return dmsProductDao.getDmsProductRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> exportExcel(Assist assist) {
		// TODO Auto-generated method stub
		return dmsProductDao.exportExcel(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public Map getProdutByID(String productId) {
		// TODO Auto-generated method stub
		return dmsProductDao.getProdutByID(productId);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getModelByProductId(Assist assist) {
		// TODO Auto-generated method stub
		return dmsProductDao.getModelByProductId(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getModelByProductIdRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return dmsProductDao.getModelByProductIdRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public Map getDealer(String dealerCode) {
		// TODO Auto-generated method stub
		return dmsProductDao.getDealer(dealerCode);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public TiOpiExtendedDCS getProductByID(String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return dmsProductDao.getProductByID(PRODUCT_ID);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getDetailModelList(Assist assist) {
		// TODO Auto-generated method stub
		return dmsProductDao.getDetailModelList(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getDetailModelRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return dmsProductDao.getDetailModelRowCount(assist);
	}

}
