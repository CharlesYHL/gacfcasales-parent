package com.gacfcasales.dmsweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dmsSales")
public class DmsSalesController {
	private Logger logger = LoggerFactory.getLogger(DmsSalesController.class);
	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toSalesListPage() {
		System.out.println("========进入页面=========");
		return "sysPage/dmsSales/list";
	}
	
}
