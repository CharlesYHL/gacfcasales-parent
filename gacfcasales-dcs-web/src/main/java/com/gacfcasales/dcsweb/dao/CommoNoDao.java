package com.gacfcasales.dcsweb.dao;

import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.dto.DealerDto;
import com.gacfcasales.common.entity.ModelPage;

public interface CommoNoDao {
	List<Map> getlock(Map map);

	void updateBillNo(Map map);

	void insertBillNo(Map map);

	// 查询品牌
	List<Map> getBrandList();

	// 查询车系
	List<Map> getSeriesList(String groupId);

	List<Map> getSeriesListA(Map map);

	// 查询车型
	List<Map> getModelList(String groupId);

	List<Map> getModelListA(Map map);

	// 按车型查询
	List<ModelPage> getModelTableList(Assist assist);
	long getModelTableRowCount(Assist assist);
	List<ModelPage> getModelTableListA(Map map);
	long getModelTableRowCountA(Map map);

	// 按车系查询
	List<ModelPage> getSeriesTableList(Assist assist);
	long getSeriesTableRowCount(Assist assist);
	List<ModelPage> getSeriesTableListA(Map map);
	long getSeriesTableRowCountA(Map map);

	// 查询所有有效的大区
	List<Map> selectMaxDistrict();

	// 查询所有有效的小区
	List<Map> selectMinDistrict(String bigOrg);

	// 查询经销商
	List<Map> selectDealerAll(Assist assist);

	long selectDealerArrRowCount(Assist assist);

	Map getDealerCodeAndName(String groupId);

}
