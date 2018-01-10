package com.gacfcasales.dcsweb.service;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TmPartInfo;

public interface ProductService {
	List<TiOpiExtendedDCS> selectSysProduct(Assist assist);
	long getSysProductRowCount(Assist assist);
	
	 List<Map> exportProduct(TiOpiExtendedDCS tiOpiExtendedDCS);
	 
	 List<TmPartInfo> selectPartInfo(Assist assist);
	 long getPartInfoRowCount(Assist assist);
	 
	 List<Map> getProductModelList(Assist assist);
	 long getProductModelRowCount(Assist assist);
	 
}
