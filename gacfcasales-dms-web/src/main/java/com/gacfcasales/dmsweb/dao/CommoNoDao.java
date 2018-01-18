package com.gacfcasales.dmsweb.dao;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.ModelPage;

public interface CommoNoDao {
	 List<Map> getlock (Map map);
	 void updateBillNo(Map map);
	 void insertBillNo(Map map);
	 
	 //查询品牌
	 List<Map> getBrandList();
	 //查询车系
	 List<Map> getSeriesList(String groupId);
	 //查询车型
	 List<Map> getModelList(String groupId);
	 
	 //按车型查询
	 List<ModelPage> getModelTableList(Assist assist);
	 long getModelTableRowCount(Assist assist);
	 
	//按车系查询
	 List<ModelPage> getSeriesTableList(Assist assist);
	 long getSeriesTableRowCount(Assist assist);
	 
	 //车主车辆信息查询
	 List<Map> getVehicleList(Assist assist);
	 long getVehicleRowCount(Assist assist);
	 
	 
	 //查询店端用户ID
	 Map getTmUserId(Map map);
	 //查询厂端用户ID
	 Map getTcUserId(Map map);
	 
	 Map getDealerCodeAndName(String groupId);
}
