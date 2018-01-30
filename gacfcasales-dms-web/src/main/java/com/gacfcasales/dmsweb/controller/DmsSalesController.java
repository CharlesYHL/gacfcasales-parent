package com.gacfcasales.dmsweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.gacfcasales.common.entity.TtOpiExtendedSales;
import com.gacfcasales.common.excel.ExcelExportColumn;
import com.gacfcasales.common.excel.ExportExcel;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.common.util.CommonConstants;
import com.gacfcasales.common.util.DateTimeUtil;
import com.gacfcasales.common.util.OemDictCodeConstants;
import com.gacfcasales.dmsweb.service.CommonNoService;
import com.gacfcasales.dmsweb.service.DmsSalesService;
import com.gacfcasales.dmsweb.webservice.ssrtosap.Sdsd001Main;

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
			// Long salesOrderId = commonNoService.getId("SO",
			// map.get("ENTITY_CODE").toString());

			// Long salesOrderId = commonNoService.getIds("ID", "999999");
			// mav.addObject("salesOrderId", salesOrderId);
			dmsSalesDto.setSaleOrderId(commonNoService.getSystemOrderNo("SO", map.get("ENTITY_CODE").toString()));
		}
		Map mapUser = dmsSalesService.getUserName(map.get("ENTITY_CODE").toString(), tmUser.getEMPLOYEE_NO());
		if (mapUser != null) {
			// mav.addObject("employeeName", mapUser.get("EMPLOYEE_NAME"));
			dmsSalesDto.setEmployeeName(mapUser.get("EMPLOYEE_NAME").toString());
		}
		Date date = new Date();
		int year = DateTimeUtil.getNowYear(date);
		String month = DateTimeUtil.getNowMonth(date);
		String day = DateTimeUtil.getNowDay(date);
		dmsSalesDto.setCreateAt(year + "-" + month + "-" + day);

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
		if (INVOICE_DATE != null && !"".equals(INVOICE_DATE)) {

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

	// 进入产品选择页面
	@RequestMapping(value = "/ajax/toProductlist", method = RequestMethod.GET)
	public ModelAndView toProductlist(@RequestParam String productNo) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/productList");
		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		dmsSalesDto.setPRODUCT_NO(productNo);
		mav.addObject("productNo", productNo);
		return mav;
	}

	// 产品查询页面

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
		if (tmUser.getDEALER_CODE() != null && !"".equals(tmUser.getDEALER_CODE())) {
			assist.setRequires(Assist.andEq("tmd.DEALER_CODE", tmUser.getDEALER_CODE().toString()));
		}

		if (dmsSalesPage.getPRODUCT_NO() != null && !"".equals(dmsSalesPage.getPRODUCT_NO())) {
			assist.setRequires(Assist.andLike("tipe.PRODUCT_NO", "%" + dmsSalesPage.getPRODUCT_NO() + "%"));
		}

		if (dmsSalesPage.getPRODUCT_NAME() != null && !"".equals(dmsSalesPage.getPRODUCT_NAME())) {
			assist.setRequires(Assist.andLike("tipe.PRODUCT_NAME", "%" + dmsSalesPage.getPRODUCT_NAME() + "%"));
		}
		assist.setRequires(Assist.andEq("tipe.IS_C_SALE", CommonConstants.DICT_IS_YES));
		assist.setRequires(Assist.andEq("tipe.RELEASE_STATUS", OemDictCodeConstants.PRODUCT_RELEASE_STATUS_02));
		assist.setOrder("tipe.PRODUCT_NO,tipe.PRODUCT_NAME", true);
		long count = dmsSalesService.getProductRowCount(assist);
		List<Map> list = dmsSalesService.getProductList(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;

	}

	@RequestMapping(value = "/ajax/fromProductToAddSales", method = RequestMethod.GET)
	public ModelAndView fromProductToAddSales(@RequestParam String PRODUCT_ID, @RequestParam String PRODUCT_NO,
			@RequestParam String PRODUCT_NAME, @RequestParam String PRODUCT_DATE,
			@RequestParam String PRODUCT_DESCRIBTION, @RequestParam String TERMINAL_NON_SALES_PRICE,
			@RequestParam String TERMINAL_SALES_PRICE, HttpSession httpSession) {
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

	// 创建销售单
	@RequestMapping(value = "/ajax/createSales", method = RequestMethod.GET)
	@ResponseBody
	public String createSales(TtOpiExtendedSales ttOpiExtendedSales, HttpSession httpSession) {
		DmsSalesDto dmsSalesDto = ApplicationContextHelper.getBeanByType(DmsSalesDto.class);
		Map mapCode = dmsSalesService.getEntityCode(dmsSalesDto.getDEALER_CODE());
		if (dmsSalesDto.getDEALER_CODE() != null && !"".equals(dmsSalesDto.getDEALER_CODE())) {
			Map map = new HashMap();
			map.put("dealerCode", mapCode.get("ENTITY_CODE").toString());
			map.put("employeeNo", dmsSalesDto.getEMPLOYEE_NO());
			// commonNoService.getTmUserId(map);
			ttOpiExtendedSales.setPRODUCT_SALES_ID(commonNoService.getId("ID", mapCode.get("ENTITY_CODE").toString()));
			ttOpiExtendedSales.setDEALER_CODE(mapCode.get("ENTITY_CODE").toString());

			// if (ttOpiExtendedSales.getORDER_STATUS() != null &&
			// !"".equals(ttOpiExtendedSales.getORDER_STATUS())) {
			ttOpiExtendedSales.setORDER_STATUS_T(OemDictCodeConstants.PRODUCT_SALES_STATUS_01);
			// }

			ttOpiExtendedSales.setCREATED_BY(commonNoService.getTmUserId(map).get("USER_ID").toString());
			dmsSalesService.insertSales(ttOpiExtendedSales);
			return "0";
		}
		return "1";
	}

	// 车主车辆信息查询createSales
	@RequestMapping(value = "/ajax/getSalesList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TtOpiExtendedSales> getSalesList(TtOpiExtendedSales ttOpiExtendedSales,
			@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize,
			HttpSession httpSession) {

		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		Map map = dmsSalesService.getEntityCode(tmUser.getDEALER_CODE());
		Result<TtOpiExtendedSales> result = new Result<TtOpiExtendedSales>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (map != null) {
			assist.setRequires(Assist.andEq("bsm.DEALER_CODE", map.get("ENTITY_CODE").toString()));
		}
		if (ttOpiExtendedSales.getPRODUCT_DATE() != null && !"0".equals(ttOpiExtendedSales.getPRODUCT_DATE())) {
			assist.setRequires(Assist.andEq("bsm.PRODUCT_DATE", ttOpiExtendedSales.getPRODUCT_DATE()));
		}
		if (ttOpiExtendedSales.getPRODUCT_SALES_ORDER() != null
				&& !"".equals(ttOpiExtendedSales.getPRODUCT_SALES_ORDER())) {
			assist.setRequires(
					Assist.andLike("bsm.PRODUCT_SALES_ORDER", "%" + ttOpiExtendedSales.getPRODUCT_SALES_ORDER() + "%"));
		}
		if (ttOpiExtendedSales.getPRODUCT_NO() != null && !"".equals(ttOpiExtendedSales.getPRODUCT_NO())) {
			assist.setRequires(Assist.andLike("bsm.PRODUCT_NO", "%" + ttOpiExtendedSales.getPRODUCT_NO() + "%"));
		}
		if (ttOpiExtendedSales.getPRODUCT_NAME() != null && !"".equals(ttOpiExtendedSales.getPRODUCT_NAME())) {
			assist.setRequires(Assist.andLike("bsm.PRODUCT_NAME", "%" + ttOpiExtendedSales.getPRODUCT_NAME() + "%"));
		}
		if (ttOpiExtendedSales.getBRAND_ID() != null && !"".equals(ttOpiExtendedSales.getBRAND_ID())) {
			Map brandMap = commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getBRAND_ID());
			if (brandMap != null) {
				assist.setRequires(Assist.andEq("bsm.BRAND_CODE", brandMap.get("GROUP_CODE")));
			}
		}

		if (ttOpiExtendedSales.getSERIES_ID() != null && !"".equals(ttOpiExtendedSales.getSERIES_ID())) {
			Map seriesMap = commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getSERIES_ID());
			if (seriesMap != null) {
				assist.setRequires(Assist.andEq("bsm.SERIES_CODE", seriesMap.get("GROUP_CODE")));
			}
		}

		if (ttOpiExtendedSales.getMODEL_ID() != null && !"".equals(ttOpiExtendedSales.getMODEL_ID())) {
			Map modelMap = commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getMODEL_ID());
			if (modelMap != null) {
				assist.setRequires(Assist.andEq("bsm.MODEL_CODE", modelMap.get("GROUP_CODE")));
			}
		}

		if (ttOpiExtendedSales.getVIN() != null && !"".equals(ttOpiExtendedSales.getVIN())) {
			assist.setRequires(Assist.andLike("bsm.VIN", "%" + ttOpiExtendedSales.getVIN() + "%"));
		}

		if (ttOpiExtendedSales.getLICENSE_NO() != null && !"".equals(ttOpiExtendedSales.getLICENSE_NO())) {
			assist.setRequires(Assist.andLike("bsm.LICENSE_NO", "%" + ttOpiExtendedSales.getLICENSE_NO() + "%"));
		}
		if (ttOpiExtendedSales.getCUSTOMER_NAME() != null && !"".equals(ttOpiExtendedSales.getCUSTOMER_NAME())) {
			assist.setRequires(Assist.andLike("bsm.CUSTOMER_NAME", "%" + ttOpiExtendedSales.getCUSTOMER_NAME() + "%"));
		}

		if (ttOpiExtendedSales.getORDER_STATUS() != null && !"0".equals(ttOpiExtendedSales.getORDER_STATUS())) {
			Integer orderStatus = Integer.parseInt(ttOpiExtendedSales.getORDER_STATUS());
			if( orderStatus == OemDictCodeConstants.PRODUCT_SALES_STATUS_01) {
				assist.setRequires(Assist.andEq("bsm.ORDER_STATUS", "已保存"));
			}else if(orderStatus == OemDictCodeConstants.PRODUCT_SALES_STATUS_02) {
				assist.setRequires(Assist.andEq("bsm.ORDER_STATUS", "已结案"));
			}else if(orderStatus == OemDictCodeConstants.PRODUCT_SALES_STATUS_03) {
				assist.setRequires(Assist.andEq("bsm.ORDER_STATUS", "扣款失败"));
			}else {
				assist.setRequires(Assist.andEq("bsm.ORDER_STATUS", "已作废"));
			}
			
			/*assist.setRequires(Assist.andEq("bsm.ORDER_STATUS", ttOpiExtendedSales.getORDER_STATUS()));*/
		}

		if (ttOpiExtendedSales.getCREATED_AT_START() != null && !"".equals(ttOpiExtendedSales.getCREATED_AT_START())
				&& ttOpiExtendedSales.getCREATED_AT_END() != null
				&& !"".equals(ttOpiExtendedSales.getCREATED_AT_END())) {
			assist.setRequires(Assist.andLte("bsm.CREATED_AT", ttOpiExtendedSales.getCREATED_AT_END()));
			assist.setRequires(Assist.andGte("bsm.CREATED_AT", ttOpiExtendedSales.getCREATED_AT_START()));
			// assist.setRequires(Assist.andEq("bsm.CREATED_AT",
			// ttOpiExtendedSales.getORDER_STATUS()));
		}

		if (ttOpiExtendedSales.getCLOSED_AT_START() != null && !"".equals(ttOpiExtendedSales.getCLOSED_AT_START())
				&& ttOpiExtendedSales.getCLOSED_AT_END() != null && !"".equals(ttOpiExtendedSales.getCLOSED_AT_END())) {
			assist.setRequires(Assist.andLte("bsm.CLOSED_AT", ttOpiExtendedSales.getCLOSED_AT_END()));
			assist.setRequires(Assist.andGte("bsm.CLOSED_AT", ttOpiExtendedSales.getCLOSED_AT_START()));
			// assist.setRequires(Assist.andEq("bsm.CREATED_AT",
			// ttOpiExtendedSales.getORDER_STATUS()));
		}
		assist.setOrder("bsm.PRODUCT_SALES_ID,bsm.PRODUCT_SALES_ORDER,bsm.CREATED_AT", true);
		long count = dmsSalesService.getSalesRowCount(assist);
		List<Map> list = dmsSalesService.getSalesList(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;

	}

	// 导出销售单信息
	@RequestMapping(value = "/ajax/exportSalesExcel", method = RequestMethod.GET)
	public void exportSalesExcel(@RequestParam(required = false) String PRODUCT_SALES_ORDER,
			@RequestParam(required = false) String PRODUCT_NO, @RequestParam(required = false) String PRODUCT_NAME,
			@RequestParam(required = false) String PRODUCT_DATE, @RequestParam(required = false) String BRAND_ID,
			@RequestParam(required = false) String SERIES_ID, @RequestParam(required = false) String MODEL_ID,
			@RequestParam(required = false) String VIN, @RequestParam(required = false) String LICENSE_NO,
			@RequestParam(required = false) String CUSTOMER_NAME, @RequestParam(required = false) String ORDER_STATUS,
			@RequestParam(required = false) String CREATED_AT_START,
			@RequestParam(required = false) String CREATED_AT_END,
			@RequestParam(required = false) String CLOSED_AT_START,
			@RequestParam(required = false) String CLOSED_AT_END, HttpServletRequest request,
			HttpServletResponse response, HttpSession httpSession) {

		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		Map map = dmsSalesService.getEntityCode(tmUser.getDEALER_CODE());
		Assist assist = new Assist();
		if (map != null) {
			assist.setRequires(Assist.andEq("bsm.DEALER_CODE", map.get("ENTITY_CODE").toString()));
		}
		if (PRODUCT_DATE != null && !"0".equals(PRODUCT_DATE)) {
			assist.setRequires(Assist.andEq("bsm.PRODUCT_DATE", PRODUCT_DATE));
		}
		if (PRODUCT_SALES_ORDER != null && !"".equals(PRODUCT_SALES_ORDER)) {
			assist.setRequires(Assist.andLike("bsm.PRODUCT_SALES_ORDER", "%" + PRODUCT_SALES_ORDER + "%"));
		}
		if (PRODUCT_NO != null && !"".equals(PRODUCT_NO)) {
			assist.setRequires(Assist.andLike("bsm.PRODUCT_NO", "%" + PRODUCT_NO + "%"));
		}
		if (PRODUCT_NAME != null && !"".equals(PRODUCT_NAME)) {
			assist.setRequires(Assist.andLike("bsm.PRODUCT_NAME", "%" + PRODUCT_NAME + "%"));
		}
		if (BRAND_ID != null && !"".equals(BRAND_ID)) {
			Map brandMap = commonNoService.getDealerCodeAndName(BRAND_ID);
			if (brandMap != null) {
				assist.setRequires(Assist.andEq("bsm.BRAND_CODE", brandMap.get("GROUP_CODE")));
			}
		}

		if (SERIES_ID != null && !"".equals(SERIES_ID)) {
			Map seriesMap = commonNoService.getDealerCodeAndName(SERIES_ID);
			if (seriesMap != null) {
				assist.setRequires(Assist.andEq("bsm.SERIES_CODE", seriesMap.get("GROUP_CODE")));
			}
		}

		if (MODEL_ID != null && !"".equals(MODEL_ID)) {
			Map modelMap = commonNoService.getDealerCodeAndName(MODEL_ID);
			if (modelMap != null) {
				assist.setRequires(Assist.andEq("bsm.MODEL_CODE", modelMap.get("GROUP_CODE")));
			}
		}

		if (VIN != null && !"".equals(VIN)) {
			assist.setRequires(Assist.andLike("bsm.VIN", "%" + VIN + "%"));
		}

		if (LICENSE_NO != null && !"".equals(LICENSE_NO)) {
			assist.setRequires(Assist.andLike("bsm.LICENSE_NO", "%" + LICENSE_NO + "%"));
		}
		if (CUSTOMER_NAME != null && !"".equals(CUSTOMER_NAME)) {
			assist.setRequires(Assist.andLike("bsm.CUSTOMER_NAME", "%" + CUSTOMER_NAME + "%"));
		}

		if (ORDER_STATUS != null && !"0".equals(ORDER_STATUS)) {
			assist.setRequires(Assist.andEq("bsm.ORDER_STATUS", ORDER_STATUS));
		}

		if (CREATED_AT_START != null && !"".equals(CREATED_AT_START) && CREATED_AT_END != null
				&& !"".equals(CREATED_AT_END)) {
			assist.setRequires(Assist.andLte("bsm.CREATED_AT", CREATED_AT_END));
			assist.setRequires(Assist.andGte("bsm.CREATED_AT", CREATED_AT_START));
		}

		if (CLOSED_AT_START != null && !"".equals(CLOSED_AT_START) && CLOSED_AT_END != null
				&& !"".equals(CLOSED_AT_END)) {
			assist.setRequires(Assist.andLte("bsm.CLOSED_AT", CLOSED_AT_END));
			assist.setRequires(Assist.andGte("bsm.CLOSED_AT", CLOSED_AT_START));
			// assist.setRequires(Assist.andEq("bsm.CREATED_AT",
			// ttOpiExtendedSales.getORDER_STATUS()));
		}
		assist.setOrder("bsm.PRODUCT_SALES_ID,bsm.PRODUCT_SALES_ORDER", true);

		ExportExcel exportExcel = new ExportExcel();

		List<Map> resultList = dmsSalesService.exportSalesExcel(assist);

		Map<String, List<Map>> excelData = new HashMap<String, List<Map>>();
		excelData.put("销售单信息", resultList);

		List<ExcelExportColumn> exportColumnList = new ArrayList<ExcelExportColumn>();

		exportColumnList.add(new ExcelExportColumn("ORDER_STATUS", "单据状态"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_SALES_ORDER", "销售单编号"));
		exportColumnList.add(new ExcelExportColumn("SAP_SALES_ORDER", "SAP订单号"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_NO", "产品编号"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_NAME", "产品名称"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DESCRIBTION", "产品说明"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DATE", "产品有效期"));
		exportColumnList.add(new ExcelExportColumn("CUSTOMER_NAME", "客户姓名"));
		exportColumnList.add(new ExcelExportColumn("CUSTOMER_CONTACT", "客户联系方式"));
		exportColumnList.add(new ExcelExportColumn("VIN", "VIN"));
		exportColumnList.add(new ExcelExportColumn("BILLING_AT", "开票日期"));
		exportColumnList.add(new ExcelExportColumn("LICENSE_NO", "车牌号"));
		exportColumnList.add(new ExcelExportColumn("OWNER_NO", "车主编号"));
		exportColumnList.add(new ExcelExportColumn("OWNER_NAME", "车主姓名"));
		exportColumnList.add(new ExcelExportColumn("OWNER_PHONE", "车主电话"));
		exportColumnList.add(new ExcelExportColumn("OWNER_MOBILE", "车主手机"));
		exportColumnList.add(new ExcelExportColumn("BRAND_NAME", "品牌"));
		exportColumnList.add(new ExcelExportColumn("SERIES_NAME", "车系"));
		exportColumnList.add(new ExcelExportColumn("MODEL_NAME", "车型"));
		exportColumnList.add(new ExcelExportColumn("APACKAGE", "配置"));
		exportColumnList.add(new ExcelExportColumn("YEAR_MODEL", "年款"));
		exportColumnList.add(new ExcelExportColumn("TAKE_EFFECT_START", "生效开始时间"));
		exportColumnList.add(new ExcelExportColumn("TAKE_EFFECT_END", "生效结束时间"));
		exportColumnList.add(new ExcelExportColumn("CREATE_NAME", "创建人"));
		exportColumnList.add(new ExcelExportColumn("CREATED_AT", "创建时间"));
		exportColumnList.add(new ExcelExportColumn("PURCHASE_NUMBER", "购买数量"));
		exportColumnList.add(new ExcelExportColumn("TERMINAL_NON_SALES_PRICE", "终端不含税销售价"));
		exportColumnList.add(new ExcelExportColumn("TERMINAL_SALES_PRICE", "终端含税销售价（6%）"));
		exportColumnList.add(new ExcelExportColumn("ACTUAL_NON_SALES_PRICE", "实际不含税销售价"));
		exportColumnList.add(new ExcelExportColumn("TOTAL_AMOUNT", "含税总额（6%）"));
		exportColumnList.add(new ExcelExportColumn("CLOSED_NAME", "结案人"));
		exportColumnList.add(new ExcelExportColumn("CLOSED_AT", "结案时间"));
		exportColumnList.add(new ExcelExportColumn("INVALID_NAME", "作废人"));
		exportColumnList.add(new ExcelExportColumn("INVALID_AT", "作废时间"));
		exportExcel.generateExcelForDms(excelData, exportColumnList, "销售单信息.xls", request, response);

	}

	// 销售单明细
	@RequestMapping(value = "/ajax/toSalesDetail", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView toSalesDetail(@RequestParam String productSalesId) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/detailSales");

		if (productSalesId != null && !"".equals(productSalesId)) {
			mav.addObject("ttOpiExtendedSales", dmsSalesService.selectTtOpiExtendedSales(productSalesId));
		}

		return mav;
	}

	@RequestMapping(value = "/ajax/invalidSales", method = RequestMethod.GET)
	@ResponseBody
	public String invalidSales(@RequestParam String productSalesId, HttpSession httpSession) {
		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		Map invalidMap = new HashMap();
		Map map = dmsSalesService.getEntityCode(tmUser.getDEALER_CODE());
		// Map mapUser = dmsSalesService.getUserName(map.get("ENTITY_CODE").toString(),
		// tmUser.getEMPLOYEE_NO());
		Map mapId = new HashMap();
		mapId.put("dealerCode", map.get("ENTITY_CODE").toString());
		mapId.put("employeeNo", tmUser.getEMPLOYEE_NO());
		if (productSalesId != null && !"".equals(productSalesId)) {
			invalidMap.put("PRODUCT_SALES_ID", productSalesId);
		}
		invalidMap.put("INVALID_BY", commonNoService.getTmUserId(mapId).get("USER_ID").toString());

		if (invalidMap != null) {
			dmsSalesService.updateSalesInvalid(invalidMap);
			return "0";
		}
		return "1";
	}

	// 销售单编辑
	@RequestMapping(value = "/ajax/toSalesEdit", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView toSalesEdit(@RequestParam String productSalesId) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/editSales");

		if (productSalesId != null && !"".equals(productSalesId)) {
			mav.addObject("ttOpiExtendedSales", dmsSalesService.selectTtOpiExtendedSales(productSalesId));
		}

		return mav;
	}

	// 编辑销售订单
	@RequestMapping(value = "/ajax/editSales", method = RequestMethod.GET)
	@ResponseBody
	public String editSales(TtOpiExtendedSales ttOpiExtendedSales, HttpSession httpSession) {
		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		Map mapCode = dmsSalesService.getEntityCode(tmUser.getDEALER_CODE());
		if (tmUser.getDEALER_CODE() != null && !"".equals(tmUser.getDEALER_CODE())) {
			Map map = new HashMap();
			map.put("dealerCode", mapCode.get("ENTITY_CODE").toString());
			map.put("employeeNo", tmUser.getEMPLOYEE_NO());
			// commonNoService.getTmUserId(map);
			// ttOpiExtendedSales.setPRODUCT_SALES_ID(commonNoService.getId("ID",
			// mapCode.get("ENTITY_CODE").toString()));
			ttOpiExtendedSales.setDEALER_CODE(mapCode.get("ENTITY_CODE").toString());

			if (ttOpiExtendedSales.getORDER_STATUS() != null && !"".equals(ttOpiExtendedSales.getORDER_STATUS())) {
				ttOpiExtendedSales.setORDER_STATUS_T(OemDictCodeConstants.PRODUCT_SALES_STATUS_01);
			}

			ttOpiExtendedSales.setUPDATED_BY(commonNoService.getTmUserId(map).get("USER_ID").toString());
			dmsSalesService.updateSales(ttOpiExtendedSales);
			return "0";
		}
		return "1";
	}

	// 提交销售订单到SAP
	@RequestMapping(value = "/ajax/submitSales", method = RequestMethod.GET)
	@ResponseBody
	public String submitSales(@RequestParam String productSalesOrder, HttpSession httpSession) {
		TmUser tmUser = (TmUser) httpSession.getAttribute("users");
		Map mapt = dmsSalesService.getEntityCode(tmUser.getDEALER_CODE());
		Map mapId = new HashMap();
		mapId.put("dealerCode", mapt.get("ENTITY_CODE").toString());
		mapId.put("employeeNo", tmUser.getEMPLOYEE_NO());
		if (productSalesOrder != null && !"".equals(productSalesOrder)) {
			Map map = dmsSalesService.selectDataToSap(productSalesOrder);
			if (map != null) {
				Map returnMap = Sdsd001Main.Sdsd001ToSap(map);
				if (returnMap != null) {
					returnMap.put("PRODUCT_SALES_ORDER", map.get("PRODUCT_SALES_ORDER"));
					returnMap.put("PRODUCT_SALES_ID", map.get("PRODUCT_SALES_ID"));
					if ("S".equals(returnMap.get("IS_RESULT"))) {
						returnMap.put("ORDER_STATUS", 55011002);
						returnMap.put("CLOSED_BY", commonNoService.getTmUserId(mapId).get("USER_ID").toString());
						returnMap.put("CLOSED_AT", new Date());
						
						double totalAmount = Double.parseDouble(map.get("TOTAL_AMOUNT").toString());
						double taxCostPrice =  Double.parseDouble(map.get("TAX_COST_PRICE").toString());
						double costProfit = (totalAmount - taxCostPrice);
						returnMap.put("COST_PROFIT", costProfit);
					} else {
						returnMap.put("ORDER_STATUS", 55011003);
						returnMap.put("CLOSED_BY", null);
						returnMap.put("CLOSED_AT", null);
						returnMap.put("COST_PROFIT", null);
					}

					dmsSalesService.updateSapData(returnMap);

					if ("S".equals(returnMap.get("IS_RESULT"))) {
						return "0";
					}

				}
			}
		}
		return "1";

	}

	// 销售单打印

	@RequestMapping(value = "/ajax/toSalesPrint", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView toSalesPrint(@RequestParam String productSalesOrder) {
		ModelAndView mav = new ModelAndView("sysPage/dmsSales/printSales");

		if (productSalesOrder != null && !"".equals(productSalesOrder)) {
			mav.addObject("ttOpiExtendedSales", dmsSalesService.selectTtOpiExtendedSalesPrint(productSalesOrder));
		}

		return mav;
	}

}
