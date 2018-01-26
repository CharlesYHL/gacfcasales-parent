package com.gacfcasales.dcsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.dcsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.dcsweb.dao.SalesDcsDao;
import com.gacfcasales.dcsweb.service.SalesDcsService;

@Service
public class SalesDcsServiceImpl implements SalesDcsService {
	
	@Autowired SalesDcsDao salesDcsDao;
	
	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getSalesList(Map map) {
		// TODO Auto-generated method stub
		return salesDcsDao.getSalesList(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getSalesRowCount(Map map) {
		// TODO Auto-generated method stub
		return salesDcsDao.getSalesRowCount(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getSalesListExport(Map map) {
		// TODO Auto-generated method stub
		return salesDcsDao.getSalesListExport(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public Map getSalesFindBySalesId(String PRODUCT_SALES_ID) {
		// TODO Auto-generated method stub
		return salesDcsDao.getSalesFindBySalesId(PRODUCT_SALES_ID);
	}

}
