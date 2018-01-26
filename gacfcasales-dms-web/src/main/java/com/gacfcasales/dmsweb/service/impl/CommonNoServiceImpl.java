package com.gacfcasales.dmsweb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.entity.ModelPage;
import com.gacfcasales.common.exception.ServiceBizException;
import com.gacfcasales.common.util.CommonConstants;
import com.gacfcasales.common.util.CommonUtils;
import com.gacfcasales.common.util.StringUtils;
import com.gacfcasales.dmsweb.aspect.DataSourceAnnotation;
import com.gacfcasales.dmsweb.dao.CommoNoDao;
import com.gacfcasales.dmsweb.service.CommonNoService;

@Service
public class CommonNoServiceImpl implements CommonNoService {
	private static final Logger logger = LoggerFactory.getLogger(CommonNoServiceImpl.class);
	
	@Autowired CommoNoDao commoNoDao;
	
	@Override
	@DataSourceAnnotation(value="write")
	public String getSystemOrderNo(String orderPrefix, String dealerCode) throws ServiceBizException {
		// TODO Auto-generated method stub
		synchronized (this) {
			try {
				String systemOrderNo = StringUtils.EMPTY_STRING;
				String yyMM = StringUtils.EMPTY_STRING;
				String yyyy = StringUtils.EMPTY_STRING;
				String MM = StringUtils.EMPTY_STRING;
				String dd = StringUtils.EMPTY_STRING;
				// 获取年月
				Date data = new Date();
				SimpleDateFormat yyyyMM = new SimpleDateFormat("yyMM");
				SimpleDateFormat yearF = new SimpleDateFormat("yy");
				SimpleDateFormat monthF = new SimpleDateFormat("MM");
				SimpleDateFormat dayF = new SimpleDateFormat("dd");
				yyMM = yyyyMM.format(data);
				yyyy = yearF.format(data);
				MM = monthF.format(data);
				dd = dayF.format(data);
				System.out.println(yyMM);
				System.out.println(yyyy);
				System.out.println(MM);
				System.out.println(dd);
				Map mapTo = new HashMap();
				mapTo.put("orderPrefix", orderPrefix);
				mapTo.put("yyyy", yyyy);
				mapTo.put("MM", MM);
				mapTo.put("dd", dd);
				mapTo.put("dealerCode", dealerCode);
				// 查询数据
				List<Map> listPo = commoNoDao.getlock(mapTo);
				if (!CommonUtils.isNullOrEmpty(listPo)) {
					// 如果存在数据 取出 序号 然后+1 并修改记录
					Map map = listPo.get(0);
					// 订单号前缀
					systemOrderNo += map.get("BILL_NO_TYPE");
					// 年
					systemOrderNo += yyMM;
					// 月

					// systemOrderNo += map.get("B_MONTH");
					// 日
					systemOrderNo += dd;
					//int radomInt=new Random().nextInt(9);
					//systemOrderNo += radomInt;
					// 序列号
					Integer sequence = Integer.parseInt(map.get("SEQ").toString()) + 1;
					systemOrderNo += CommonUtils.getFourOrderNo(sequence);
					// 更新数据库序列号
					mapTo.put("sequence", sequence);
					mapTo.put("billNoId", map.get("BILL_NO_ID"));
					commoNoDao.updateBillNo(mapTo);
					System.out.println(systemOrderNo);
					return systemOrderNo;
				} else {
					// 如果记录不存在 新增
					mapTo.put("sequence", CommonConstants.INIT_ORDER_NO);
					commoNoDao.insertBillNo(mapTo);
					//int radomInt=new Random().nextInt(9);
					System.out.println(orderPrefix);
					return orderPrefix + yyyy + MM + dd + CommonUtils.getFourOrderNo(CommonConstants.INIT_ORDER_NO);

				}
			
			} catch (Exception e) {
				throw new ServiceBizException("erro", e);
			}
			
		}
	}

	@Override
	public String getDefalutPara(String para) throws ServiceBizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DataSourceAnnotation(value="write")
	public String getWSOrderNo(String orderPrefix, String entityCode) throws ServiceBizException {
		// TODO Auto-generated method stub
		try {
			String systemOrderNo = StringUtils.EMPTY_STRING;
			String yyMM = StringUtils.EMPTY_STRING;
			String yyyy = StringUtils.EMPTY_STRING;
			String MM = StringUtils.EMPTY_STRING;
			String dd = StringUtils.EMPTY_STRING;
			String str = entityCode.substring(2, 8);
			// 获取年月
			Date data = new Date();
			SimpleDateFormat yyyyMM = new SimpleDateFormat("yyMM");
			SimpleDateFormat yearF = new SimpleDateFormat("yy");
			SimpleDateFormat monthF = new SimpleDateFormat("MM");
			SimpleDateFormat dayF = new SimpleDateFormat("dd");
			yyMM = yyyyMM.format(data);
			yyyy = yearF.format(data);
			MM = monthF.format(data);
			dd = dayF.format(data);
			System.out.println(str);
			System.out.println(yyMM);
			System.out.println(yyyy);
			System.out.println(MM);
			System.out.println(dd);
			
			Map mapTo = new HashMap();
			mapTo.put("orderPrefix", orderPrefix);
			mapTo.put("yyyy", yyyy);
			mapTo.put("MM", MM);
			mapTo.put("dd", dd);
			mapTo.put("dealerCode", entityCode);
			
			// 查询数据
			List<Map> listPo = commoNoDao.getlock(mapTo);
			if (!CommonUtils.isNullOrEmpty(listPo)) {
				// 如果存在数据 取出 序号 然后+1 并修改记录
				Map map = listPo.get(0);
				// 订单号前缀
				systemOrderNo += map.get("BILL_NO_TYPE");
				// entityCode后六位
				systemOrderNo += str;
				// 年
				systemOrderNo += map.get("B_YEAR");
				// 月
				systemOrderNo += map.get("B_MONTH");
				// 日
				systemOrderNo += map.get("B_DAY");
				// 序列号
				Integer sequence = Integer.parseInt(map.get("SEQ").toString()) + 1;
				systemOrderNo += CommonUtils.getFourOrderNo(sequence);
				// 更新数据库序列号
				mapTo.put("sequence", sequence);
				mapTo.put("billNoId", map.get("BILL_NO_ID"));
				commoNoDao.updateBillNo(mapTo);

				return systemOrderNo;
			} else {
				// 如果记录不存在 新增
				mapTo.put("sequence", CommonConstants.INIT_ORDER_NO);
				commoNoDao.insertBillNo(mapTo);

				return orderPrefix + str + yyyy + MM + dd + CommonUtils.getFourOrderNo(CommonConstants.INIT_ORDER_NO);
			}
		} catch (Exception e) {
			throw new ServiceBizException("erro", e);
		}
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getTimeDiff(String type, Date t1, Date t2) throws ServiceBizException {
		// TODO Auto-generated method stub
		long time1 = t1.getTime();
		long time2 = t2.getTime();
		long diff;
		long time = 0;
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		if ("S".equals(type)) {
			time = diff / 1000;
		}
		if ("M".equals(type)) {
			time = diff / (1000 * 60);
		}
		if ("H".equals(type)) {
			time = diff / (1000 * 60 * 60);
		}
		if ("D".equals(type)) {
			time = diff / (1000 * 60 * 60 * 24);
		}
		return time;
	}

	@Override
	@DataSourceAnnotation(value="write")
	public long getId(String type, String dealerCode) throws ServiceBizException {
		// TODO Auto-generated method stub

		try {
			String systemOrderNo = StringUtils.EMPTY_STRING;
			String yyMM = StringUtils.EMPTY_STRING;
			String yyyy = StringUtils.EMPTY_STRING;
			String MM = StringUtils.EMPTY_STRING;
			String dd = StringUtils.EMPTY_STRING;
			String str = "64";
			logger.info("========================"+str+"");
			// 获取年月
			Date data = new Date();
			SimpleDateFormat yyyyMM = new SimpleDateFormat("yyMM");
			SimpleDateFormat yearF = new SimpleDateFormat("yy");
			SimpleDateFormat monthF = new SimpleDateFormat("MM");
			SimpleDateFormat dayF = new SimpleDateFormat("dd");
			yyMM = yyyyMM.format(data);
			yyyy = yearF.format(data);
			MM = monthF.format(data);
			dd = dayF.format(data);

			System.out.println(yyMM);
			System.out.println(yyyy);
			System.out.println(MM);
			System.out.println(dd);
			
			Map mapTo = new HashMap();
			mapTo.put("orderPrefix", type);
			mapTo.put("yyyy", yyyy);
			mapTo.put("MM", MM);
			mapTo.put("dd", dd);
			mapTo.put("dealerCode", dealerCode);
			
			// 查询数据
			List<Map> listPo = commoNoDao.getlock(mapTo);
			logger.info("========================"+listPo.size()+"");
			if (!CommonUtils.isNullOrEmpty(listPo)) {
				// 如果存在数据 取出 序号 然后+1 并修改记录
				Map map = listPo.get(0);
				// 订单号前缀
				systemOrderNo += str;
				// 年
				//systemOrderNo += map.get("B_YEAR");
				logger.info("========================"+systemOrderNo+"");
				// 月
				//systemOrderNo += map.get("B_MONTH");
				// 日
				int radomInt = new Random().nextInt(999999);
				systemOrderNo += radomInt;
				logger.info("========================"+systemOrderNo+"");
				// 序列号
				Integer sequence = Integer.parseInt(map.get("SEQ").toString()) + 1;
				systemOrderNo += CommonUtils.getFiveOrderNo(sequence);
				logger.info("========================"+systemOrderNo+"");
				// 更新数据库序列号
				/*
				 * TtBillNoPo son = TtBillNoPo.findById(map.get("BILL_NO_ID"));
				 * son.set("SEQ", sequence + 1); son.setString("DEALER_CODE",
				 * dealerCode);
				 */
				mapTo.put("sequence", sequence);
				mapTo.put("billNoId", map.get("BILL_NO_ID"));
				commoNoDao.updateBillNo(mapTo);
				logger.info("========================更新结束");
				// son.saveIt();

				return Long.parseLong(systemOrderNo);
			} else {
				// 如果记录不存在 新增
				mapTo.put("sequence", CommonConstants.INIT_ORDER_NO);
				
				logger.info("========================新增开始1");
				commoNoDao.insertBillNo(mapTo);
				logger.info("========================新增结束");
				return Long.parseLong((str + yyyy + MM + dd + CommonUtils.getFiveOrderNo(CommonConstants.INIT_ORDER_NO)));
			}
		} catch (Exception e) {
			throw new ServiceBizException("erro", e);
		}
	}

	@Override
	public String GetBillNo(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefalutPara(String para, String DealerCode) throws ServiceBizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DataSourceAnnotation(value="write")
	public long getIds(String type, String dealerCode) throws ServiceBizException {
		// TODO Auto-generated method stub
		try {
			String systemOrderNo = StringUtils.EMPTY_STRING;
			String yyMM = StringUtils.EMPTY_STRING;
			String yyyy = StringUtils.EMPTY_STRING;
			String MM = StringUtils.EMPTY_STRING;
			String dd = StringUtils.EMPTY_STRING;
			String str = "64";
			// 获取年月
			Date data = new Date();
			SimpleDateFormat yyyyMM = new SimpleDateFormat("yyMM");
			SimpleDateFormat yearF = new SimpleDateFormat("yy");
			SimpleDateFormat monthF = new SimpleDateFormat("MM");
			SimpleDateFormat dayF = new SimpleDateFormat("dd");
			yyMM = yyyyMM.format(data);
			yyyy = yearF.format(data);
			MM = monthF.format(data);
			dd = dayF.format(data);

			System.out.println(yyMM);
			System.out.println(yyyy);
			System.out.println(MM);
			System.out.println(dd);
			
			Map mapTo = new HashMap();
			mapTo.put("orderPrefix", type);
			mapTo.put("yyyy", yyyy);
			mapTo.put("MM", MM);
			mapTo.put("dd", dd);
			mapTo.put("dealerCode", dealerCode);
			
			// 查询数据
			List<Map> listPo = commoNoDao.getlock(mapTo);
			if (!CommonUtils.isNullOrEmpty(listPo)) {
				// 如果存在数据 取出 序号 然后+1 并修改记录
				Map map = listPo.get(0);
				// 订单号前缀
				systemOrderNo += str;
				// 年
				//systemOrderNo += map.get("B_YEAR");
				// 月
				//systemOrderNo += map.get("B_MONTH");
				// 日
				//int radomInt = (int)(Math.random()*100);
				int radomInt = new Random().nextInt(999999);
				systemOrderNo += radomInt;
				//systemOrderNo += map.get("B_DAY");
				// 序列号
				Integer sequence = Integer.parseInt(map.get("SEQ").toString()) + 1;
				systemOrderNo += CommonUtils.getFiveOrderNo(sequence);
				// 更新数据库序列号
				/*
				 * TtBillNoPo son = TtBillNoPo.findById(map.get("BILL_NO_ID"));
				 * son.set("SEQ", sequence + 1); son.setString("DEALER_CODE",
				 * dealerCode);
				 */
				mapTo.put("sequence", sequence);
				mapTo.put("billNoId", map.get("BILL_NO_ID"));
				commoNoDao.updateBillNo(mapTo);
				// son.saveIt();

				return Long.parseLong(systemOrderNo);
			} else {
				// 如果记录不存在 新增
				mapTo.put("sequence", CommonConstants.INIT_ORDER_NO);

				logger.info("========================新增开始1");
				commoNoDao.insertBillNo(mapTo);
				logger.info("========================新增结束");

				return Long
						.parseLong((str + yyyy + MM + dd + CommonUtils.getFiveOrderNo(CommonConstants.INIT_ORDER_NO)));
			}
		} catch (Exception e) {
			throw new ServiceBizException("erro", e);
		}
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getBrandList() {
		// TODO Auto-generated method stub
		return commoNoDao.getBrandList();
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getSeriesList(String groupId) {
		// TODO Auto-generated method stub
		return commoNoDao.getSeriesList(groupId);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getModelList(String groupId) {
		// TODO Auto-generated method stub
		return commoNoDao.getModelList(groupId);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<ModelPage> getModelTableList(Assist assist) {
		// TODO Auto-generated method stub
		return commoNoDao.getModelTableList(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getModelTableRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return commoNoDao.getModelTableRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<ModelPage> getSeriesTableList(Assist assist) {
		// TODO Auto-generated method stub
		return commoNoDao.getSeriesTableList(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getSeriesTableRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return commoNoDao.getSeriesTableRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public List<Map> getVehicleList(Assist assist) {
		// TODO Auto-generated method stub
		return commoNoDao.getVehicleList(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public long getVehicleRowCount(Assist assist) {
		// TODO Auto-generated method stub
		return commoNoDao.getVehicleRowCount(assist);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public Map getTmUserId(Map map) {
		// TODO Auto-generated method stub
		return commoNoDao.getTmUserId(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public Map getTcUserId(Map map) {
		// TODO Auto-generated method stub
		return commoNoDao.getTcUserId(map);
	}

	@Override
	@DataSourceAnnotation(value="read")
	public Map getDealerCodeAndName(String groupId) {
		// TODO Auto-generated method stub
		return commoNoDao.getDealerCodeAndName(groupId);
	}

}
