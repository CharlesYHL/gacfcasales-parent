package com.gacfcasales.dcsweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.dcsweb.dao.ExcelDemoDao;
import com.gacfcasales.dcsweb.service.ExcelTOService;

@Service
public class ExcelTOServiceImpl implements ExcelTOService {
	
	@Autowired ExcelDemoDao excelDemoDao;
	
	
	
	public List<Map> findAllAction() {
		return excelDemoDao.findAllAction();
	}

}
