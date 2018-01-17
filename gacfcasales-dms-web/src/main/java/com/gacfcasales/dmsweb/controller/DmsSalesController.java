package com.gacfcasales.dmsweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.dto.DmsSalesDto;
import com.gacfcasales.common.dto.ListDto;
import com.gacfcasales.common.entity.DmsSalesPage;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.dmsweb.service.CommonNoService;
import com.gacfcasales.dmsweb.service.DmsSalesService;

@Controller
@RequestMapping("/dmsSales")
public class DmsSalesController {
	private Logger logger = LoggerFactory.getLogger(DmsSalesController.class);

	@Autowired
	CommonNoService commonNoService;

	@Autowired
	DmsSalesService dmsSalesService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toSalesListPage() {
		System.out.println("========进入页面=========");
		return "sysPage/dmsSales/list";
	}

	@RequestMapping(value = "/ajax/getBrandList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map> getBrandList() {
		return commonNoService.getBrandList();
	}

	@RequestMapping(value = "/ajax/getSeriesList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map> getSeriesList(@RequestParam String groupId) {
		return commonNoService.getSeriesList(groupId);
	}

	@RequestMapping(value = "/ajax/getModelList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map> getModelList(@RequestParam String groupId) {
		return commonNoService.getModelList(groupId);
	}

	// 获得销售订单编号
	@RequestMapping(value = "/ajax/toAddSales", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView toAddSales(HttpSession httpSession) {
		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/addSales");
		
		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		
		dmsSalesDto.setDEALER_CODE(tmUser.getDEALER_CODE());
		dmsSalesDto.setEMPLOYEE_NO(tmUser.getEMPLOYEE_NO());
		Map map = dmsSalesService.getEntityCode(tmUser.getDEALER_CODE());
		if (map != null) {
			Long salesOrderId = commonNoService.getId("SO", map.get("ENTITY_CODE").toString());
			// Long salesOrderId = commonNoService.getIds("ID", "999999");
			// mav.addObject("salesOrderId", salesOrderId);
			dmsSalesDto.setSaleOrderId(salesOrderId.toString());
		}
		Map mapUser = dmsSalesService.getUserName(map.get("ENTITY_CODE").toString(), tmUser.getEMPLOYEE_NO());
		if (mapUser != null) {
			// mav.addObject("employeeName", mapUser.get("EMPLOYEE_NAME"));
			dmsSalesDto.setEmployeeName(mapUser.get("EMPLOYEE_NAME").toString());
		}
		mav.addObject("dmsSalesDto", dmsSalesDto);
		return mav;

	}

	// 车主车辆信息查询
	@RequestMapping(value = "/ajax/getVehicleList", method = RequestMethod.POST)
	@ResponseBody
	public Result<DmsSalesPage> getVehicleList(DmsSalesPage dmsSalesPage, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize, HttpSession httpSession) {
		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		Result<DmsSalesPage> result = new Result<DmsSalesPage>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}
		Map map = dmsSalesService.getEntityCode(tmUser.getDEALER_CODE());
		if (map != null) {
			assist.setRequires(Assist.andEq("bsm.DEALER_CODE", map.get("ENTITY_CODE").toString()));
		}

		if (dmsSalesPage.getVIN() != null && !"".equals(dmsSalesPage.getVIN())) {
			assist.setRequires(Assist.andLike("bsm.VIN", "%" + dmsSalesPage.getVIN() + "%"));
		}
		if (dmsSalesPage.getLICENSE() != null && !"".equals(dmsSalesPage.getLICENSE())) {
			assist.setRequires(Assist.andLike("bsm.LICENSE", "%" + dmsSalesPage.getLICENSE() + "%"));
		}
		if (dmsSalesPage.getOWNER_NAME() != null && !"".equals(dmsSalesPage.getOWNER_NAME())) {
			assist.setRequires(Assist.andLike("bsm.OWNER_NAME", "%" + dmsSalesPage.getOWNER_NAME() + "%"));
		}

		assist.setOrder("bsm.VIN", true);
		long count = commonNoService.getVehicleRowCount(assist);
		List<Map> list = commonNoService.getVehicleList(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;
	}

	// 进入车主车辆查询页面
	@RequestMapping(value = "/ajax/toVehclist", method = RequestMethod.GET)
	public ModelAndView toVehclist(@RequestParam String vin) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/vehclist");
		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		dmsSalesDto.setVIN(vin);
		mav.addObject("vin", vin);
		return mav;
	}

	//

	@RequestMapping(value = "/ajax/fromVehclistToAddSales", method = RequestMethod.GET)
	public ModelAndView fromVehclistToAddSales(@RequestParam String VIN, @RequestParam String BRAND_ID,
			@RequestParam String BRAND_NAME, @RequestParam String SERIES_ID, @RequestParam String SERIES_NAME,
			@RequestParam String MODEL_ID, @RequestParam String MODEL_NAME, @RequestParam String APACKAGE_ID,
			@RequestParam String APACKAGE_NAME, @RequestParam String YEAR_MODEL, @RequestParam String INVOICE_DATE,
			@RequestParam String OWNER_NO, @RequestParam String OWNER_NAME, @RequestParam String PHONE,
			@RequestParam String MOBILE, @RequestParam String BRAND, @RequestParam String SERIES,
			@RequestParam String MODEL, @RequestParam String APACKAGE, HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/addSales");

		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		dmsSalesDto.setVIN(VIN);
		dmsSalesDto.setOWNER_NO(OWNER_NO);
		dmsSalesDto.setYEAR_MODEL(YEAR_MODEL);
		dmsSalesDto.setBRAND(BRAND);
		dmsSalesDto.setSERIES(SERIES);
		dmsSalesDto.setMODEL(MODEL);
		// dmsSalesDto.setCOLOR(COLOR);
		dmsSalesDto.setAPACKAGE(APACKAGE);
		dmsSalesDto.setINVOICE_DATE(INVOICE_DATE);
		if(INVOICE_DATE != null && !"".equals(INVOICE_DATE)) {
			
		}
		
		dmsSalesDto.setOWNER_NAME(OWNER_NAME);
		dmsSalesDto.setPHONE(PHONE);
		dmsSalesDto.setMOBILE(MOBILE);
		dmsSalesDto.setBRAND_NAME(BRAND_NAME);
		dmsSalesDto.setBRAND_ID(BRAND_ID);
		dmsSalesDto.setSERIES_NAME(SERIES_NAME);
		dmsSalesDto.setSERIES_ID(SERIES_ID);
		dmsSalesDto.setMODEL_NAME(MODEL_NAME);
		dmsSalesDto.setMODEL_ID(MODEL_ID);
		dmsSalesDto.setAPACKAGE_NAME(APACKAGE_NAME);
		dmsSalesDto.setAPACKAGE_ID(APACKAGE_ID);
		mav.addObject("dmsSalesDto", dmsSalesDto);
		return mav;
	}
	
	//进入产品选择页面
	@RequestMapping(value = "/ajax/toProductlist", method = RequestMethod.GET)
	public ModelAndView toProductlist(@RequestParam String productNo) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/productList");
		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		dmsSalesDto.setPRODUCT_NO(productNo);
		mav.addObject("productNo", productNo);
		return mav;
	}
	
	//产品查询页面
	
	@RequestMapping(value = "/ajax/getProductList", method = RequestMethod.POST)
	@ResponseBody
	public Result<DmsSalesPage> getProductList(DmsSalesPage dmsSalesPage, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize, HttpSession httpSession) {
		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		dmsSalesDto.setDEALER_CODE_T(tmUser.getDEALER_CODE());
		Result<DmsSalesPage> result = new Result<DmsSalesPage>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}
		if(tmUser.getDEALER_CODE() != null && !"".equals(tmUser.getDEALER_CODE())) {
			assist.setRequires(Assist.andEq("tmd.DEALER_CODE", tmUser.getDEALER_CODE().toString()));
		}
		
		if(dmsSalesPage.getPRODUCT_NO() != null && !"".equals(dmsSalesPage.getPRODUCT_NO())) {
			assist.setRequires(Assist.andLike("tipe.PRODUCT_NO", "%" + dmsSalesPage.getPRODUCT_NO() + "%"));
		}
		
		if(dmsSalesPage.getPRODUCT_NAME() != null && !"".equals(dmsSalesPage.getPRODUCT_NAME())) {
			assist.setRequires(Assist.andLike("tipe.PRODUCT_NAME", "%" + dmsSalesPage.getPRODUCT_NAME() + "%"));
		}
		
		assist.setOrder("tipe.PRODUCT_NO,tipe.PRODUCT_NAME", true);
		long count = dmsSalesService.getProductRowCount(assist);
		List<Map> list = dmsSalesService.getProductList(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;
		
	}
	
	
	
	@RequestMapping(value = "/ajax/fromProductToAddSales", method = RequestMethod.GET)
	public ModelAndView fromProductToAddSales(@RequestParam String PRODUCT_ID, 
			@RequestParam String PRODUCT_NO,
			@RequestParam String PRODUCT_NAME,
			@RequestParam String PRODUCT_DATE, 
			@RequestParam String PRODUCT_DESCRIBTION, 
			@RequestParam String TERMINAL_NON_SALES_PRICE,
			@RequestParam String TERMINAL_SALES_PRICE,  HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/addSales");
		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		dmsSalesDto.setPRODUCT_ID(PRODUCT_ID);
		dmsSalesDto.setPRODUCT_NAME(PRODUCT_NAME);
		dmsSalesDto.setPRODUCT_NO(PRODUCT_NO);
		dmsSalesDto.setPRODUCT_DATE(PRODUCT_DATE);
		dmsSalesDto.setPRODUCT_DESCRIBTION(PRODUCT_DESCRIBTION);
		dmsSalesDto.setTERMINAL_NON_SALES_PRICE(TERMINAL_NON_SALES_PRICE);
		dmsSalesDto.setTERMINAL_SALES_PRICE(TERMINAL_SALES_PRICE);
		mav.addObject("dmsSalesDto", dmsSalesDto);
		return mav;
	}
	
}
