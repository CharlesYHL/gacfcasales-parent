package com.gacfcasales.dcsweb.scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class TestScheduler {
	//@Scheduled(cron="${dls.second} ${dls.minute} ${dls.hour} ${dls.day} ${dls.month} ?")
	//@Scheduled(cron="0/10 * *  * * ? ")   //每10秒执行一次
	public void aTask() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()) + "*********A任务每10秒执行一次进入测试");
	}
}
