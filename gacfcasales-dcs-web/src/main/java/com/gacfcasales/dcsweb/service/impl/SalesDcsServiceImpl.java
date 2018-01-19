package com.gacfcasales.dcsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.dcsweb.dao.SalesDcsDao;
import com.gacfcasales.dcsweb.service.SalesDcsService;

@Service
public class SalesDcsServiceImpl implements SalesDcsService {
	
	@Autowired SalesDcsDao salesDcsDao;
	
	@Override
	public List<Map> getSalesList(Map map) {
		// TODO Auto-generated method stub
		return salesDcsDao.getSalesList(map);
	}

	@Override
	public long getSalesRowCount(Map map) {
		// TODO Auto-generated method stub
		return salesDcsDao.getSalesRowCount(map);
	}

	@Override
	public List<Map> getSalesListExport(Assist assist) {
		// TODO Auto-generated method stub
		return salesDcsDao.getSalesListExport(assist);
	}

}
