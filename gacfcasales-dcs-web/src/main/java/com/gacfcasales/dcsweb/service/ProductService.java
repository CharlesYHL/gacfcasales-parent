package com.gacfcasales.dcsweb.service;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;

public interface ProductService {
	List<TiOpiExtendedDCS> selectSysProduct(Assist assist);
	long getSysProductRowCount(Assist assist);
	
	 List<Map> exportProduct(TiOpiExtendedDCS tiOpiExtendedDCS);
}
