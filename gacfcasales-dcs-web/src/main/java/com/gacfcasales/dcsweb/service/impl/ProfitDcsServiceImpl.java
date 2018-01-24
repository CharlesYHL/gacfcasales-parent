package com.gacfcasales.dcsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.dcsweb.dao.ProfitDcsDao;
import com.gacfcasales.dcsweb.service.ProfitDcsService;

@Service
public class ProfitDcsServiceImpl implements ProfitDcsService {

	@Autowired ProfitDcsDao profitDcsDao;
	
	@Override
	public List<Map> getProfitList(Map map) {
		// TODO Auto-generated method stub
		return profitDcsDao.getProfitList(map);
	}

	@Override
	public long getProfitRowCount(Map map) {
		// TODO Auto-generated method stub
		return profitDcsDao.getProfitRowCount(map);
	}

	@Override
	public List<Map> getProfitListExport(Map map) {
		// TODO Auto-generated method stub
		return profitDcsDao.getProfitListExport(map);
	}

	@Override
	public Map getProfitFindBySalesId(String PRODUCT_SALES_ID) {
		// TODO Auto-generated method stub
		return profitDcsDao.getProfitFindBySalesId(PRODUCT_SALES_ID);
	}

}
