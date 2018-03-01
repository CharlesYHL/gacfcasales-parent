package com.gacfcasales.dcsweb.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.dto.DealerDto;
import com.gacfcasales.common.entity.ModelPage;
import com.gacfcasales.common.exception.ServiceBizException;

public interface CommonNoService {
	public String getSystemOrderNo(String orderPrefix, String dealerCode) throws ServiceBizException;

	public String getDefalutPara(String para) throws ServiceBizException;

	public String getWSOrderNo(String orderPrefix, String entityCode) throws ServiceBizException;

	public long getTimeDiff(String type, Date t1, Date t2) throws ServiceBizException;

	public long getId(String type, String dealerCode) throws ServiceBizException;

	public String GetBillNo(String type);

	public String getDefalutPara(String para, String DealerCode) throws ServiceBizException;

	public long getIds(String type, String dealerCode) throws ServiceBizException;
	
	
	
	 //查询品牌
	 List<Map> getBrandList();
	 //查询车系
	 List<Map> getSeriesList(String groupId);
	 List<Map> getSeriesListA(Map map);
	 //查询车型
	 List<Map> getModelList(String groupId);
	 List<Map> getModelListA(Map map);
	 
	 
	 //按车型查询
	 List<ModelPage> getModelTableList(Assist assist);
	 long getModelTableRowCount(Assist assist);
	 
	 List<ModelPage> getModelTableListA(Map map);
	 long getModelTableRowCountA(Map map);
	 
	//按车系查询
	 List<ModelPage> getSeriesTableList(Assist assist);
	 long getSeriesTableRowCount(Assist assist);
	 
	 List<ModelPage> getSeriesTableListA(Map map);
	 long getSeriesTableRowCountA(Map map);
	 
	 
	 //查询所有有效的大区
	 List<Map> selectMaxDistrict();
	 
	 //查询所有有效的小区
	 List<Map> selectMinDistrict(String bigOrg);
	 
	 //查询经销商
	 List<Map> selectDealerAll(Assist assist);
	 long selectDealerArrRowCount(Assist assist);
	 
	 Map getDealerCodeAndName(String groupId);
	 List<Map> getDealerCodeAndNameA(Map map);
	
}
