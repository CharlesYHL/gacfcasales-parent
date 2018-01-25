package com.gacfcasales.dcsweb.scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gacfcasales.dcsweb.controller.ExceptionAdvice;
import com.gacfcasales.dcsweb.service.ProductService;

@Component
public class ProductScheduler {
	private Logger logger = LoggerFactory.getLogger(ProductScheduler.class);

	@Autowired
	ProductService productService;

	// 更新到期的产品为已取消
	@Scheduled(cron="${dls.second} ${dls.minute} ${dls.hour} ${dls.day} ${dls.month} ?")
	public void updateReleaseStatus() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String SALES_DATE_END = sdf.format(new Date());
		Map map = new HashMap();
		map.put("SALES_DATE_END", SALES_DATE_END);
		try {
			productService.updateReleaseStatus(map);
			logger.debug("***************************"+SALES_DATE_END+"任务执行成功!***************************");
		} catch (Exception e) {
			logger.debug("***************************"+SALES_DATE_END+"任务执行失败!***************************");
			logger.debug(e.getMessage());
		}
	}
}
