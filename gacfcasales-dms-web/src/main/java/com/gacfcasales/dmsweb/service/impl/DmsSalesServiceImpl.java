package com.gacfcasales.dmsweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.dmsweb.dao.DmsSalesDao;
import com.gacfcasales.dmsweb.service.DmsSalesService;

@Service
public class DmsSalesServiceImpl implements DmsSalesService {
	@Autowired
	DmsSalesDao dmsSalesDao;

	@Override
	public Map getEntityCode(String dealerCode) {
		// TODO Auto-generated method stub
		return dmsSalesDao.getEntityCode(dealerCode);
	}

	@Override
	public Map getUserName(String dealerCode, String employeeNo) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("dealerCode", dealerCode);
		map.put("employeeNo", employeeNo);
		return dmsSalesDao.getUserName(map);
	}

	@Override
	public List<Map> getProductList(Assist assist) {
		// TODO Auto-generated method stub
		return dmsSalesDao.getProductList(assist);
	}

	@Override
	public long getProductRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return dmsSalesDao.getProductRowCount(assist);
	}

}
