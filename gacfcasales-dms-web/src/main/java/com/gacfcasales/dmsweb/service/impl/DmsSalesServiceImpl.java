package com.gacfcasales.dmsweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TtOpiExtendedSales;
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

	@Override
	public void insertSales(TtOpiExtendedSales ttOpiExtendedSales) {
		// TODO Auto-generated method stub
		dmsSalesDao.insertSales(ttOpiExtendedSales);
	}

	@Override
	public List<Map> getSalesList(Assist assist) {
		// TODO Auto-generated method stub
		return dmsSalesDao.getSalesList(assist);
	}

	@Override
	public long getSalesRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return dmsSalesDao.getSalesRowCount(assist);
	}

	@Override
	public List<Map> exportSalesExcel(Assist assist) {
		// TODO Auto-generated method stub
		return dmsSalesDao.exportSalesExcel(assist);
	}

	@Override
	public TtOpiExtendedSales selectTtOpiExtendedSales(String PRODUCT_SALES_ID) {
		// TODO Auto-generated method stub
		return dmsSalesDao.selectTtOpiExtendedSales(PRODUCT_SALES_ID);
	}

	@Override
	public void updateSalesInvalid(Map map) {
		// TODO Auto-generated method stub
		dmsSalesDao.updateSalesInvalid(map);
	}

	@Override
	public void updateSales(TtOpiExtendedSales ttOpiExtendedSales) {
		// TODO Auto-generated method stub
		dmsSalesDao.updateSales(ttOpiExtendedSales);
	}

	@Override
	public Map selectDataToSap(String PRODUCT_SALES_ORDER) {
		// TODO Auto-generated method stub
		return dmsSalesDao.selectDataToSap(PRODUCT_SALES_ORDER);
	}

	@Override
	public void updateSapData(Map map) {
		// TODO Auto-generated method stub
		dmsSalesDao.updateSapData(map);
	}

	@Override
	public TtOpiExtendedSales selectTtOpiExtendedSalesPrint(String PRODUCT_SALES_ORDER) {
		// TODO Auto-generated method stub
		return dmsSalesDao.selectTtOpiExtendedSalesPrint(PRODUCT_SALES_ORDER);
	}

}
