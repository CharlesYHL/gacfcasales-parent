package com.gacfcasales.dcsweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
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

}
