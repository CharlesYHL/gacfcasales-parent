package com.gacfcasales.dcsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TmPartInfo;
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

}
