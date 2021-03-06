package com.gacfcasales.dmsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.dmsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.dmsweb.dao.ProfitDmsDao;
import com.gacfcasales.dmsweb.service.ProfitDmsService;

@Service
public class ProfitDmsServiceImpl implements ProfitDmsService {
	
	@Autowired ProfitDmsDao profitDmsDao;
	
	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getProfitList(Map map) {
		// TODO Auto-generated method stub
		return profitDmsDao.getProfitList(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getProfitRowCount(Map map) {
		// TODO Auto-generated method stub
		return profitDmsDao.getProfitRowCount(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getProfitListExport(Map map) {
		// TODO Auto-generated method stub
		return profitDmsDao.getProfitListExport(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public Map getProfitFindBySalesId(String PRODUCT_SALES_ID) {
		// TODO Auto-generated method stub
		return profitDmsDao.getProfitFindBySalesId(PRODUCT_SALES_ID);
	}

}
