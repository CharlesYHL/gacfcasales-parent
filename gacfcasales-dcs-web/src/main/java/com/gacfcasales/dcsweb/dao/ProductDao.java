package com.gacfcasales.dcsweb.dao;

import java.util.List;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;

public interface ProductDao {
	
	 long getSysProductRowCount(Assist assist);
	 List<TiOpiExtendedDCS> selectSysProduct(Assist assist);
}
