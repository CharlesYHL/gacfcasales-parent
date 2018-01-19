package com.gacfcasales.dcsweb.controller;

import java.util.ArrayList;
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

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.dto.DealerDto;
import com.gacfcasales.common.entity.TtOpiExtendedSales;
import com.gacfcasales.common.util.DealerCodeUtil;
import com.gacfcasales.dcsweb.service.CommonNoService;
import com.gacfcasales.dcsweb.service.SalesDcsService;

@Controller
@RequestMapping("/dcsSales")
public class SalesDcsController {
	private static Logger logger = LoggerFactory.getLogger(SalesDcsController.class);

	@Autowired
	CommonNoService commonNoService;

	@Autowired
	SalesDcsService salesDcsService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toProductListPage() {
		System.out.println("========进入页面=========");
		return "sysPage/dcsSales/list";
	}

	// 大区查询
	@RequestMapping(value = "/ajax/getBigOrgList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map> getBigOrgList() {
		List<Map> list = commonNoService.selectMaxDistrict();
		return list;
	}

	// 小区区查询
	@RequestMapping(value = "/ajax/getSmallOrgList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map> getSmallOrgList(@RequestParam String bigOrg) {
		List<Map> list = commonNoService.selectMinDistrict(bigOrg);
		return list;
	}

	@RequestMapping(value = "/ajax/getDealerAll", method = RequestMethod.POST)
	@ResponseBody
	public Result<DealerDto> getDealerAll(DealerDto dealerDto, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize) {

		Result<DealerDto> result = new Result<DealerDto>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (dealerDto.getDealerCode() != null && !"".equals(dealerDto.getDealerCode())) {
			assist.setRequires(Assist.andIn("bsm.DEALER_CODE", dealerDto.getDealerCode()));
		}
		if (dealerDto.getDealerShortname() != null && !"".equals(dealerDto.getDealerShortname())) {
			assist.setRequires(Assist.andLike("bsm.DEALER_SHORTNAME", "%" + dealerDto.getDealerShortname() + "%"));
		}
		if (dealerDto.getDealerName() != null && !"".equals(dealerDto.getDealerName())) {
			assist.setRequires(Assist.andLike("bsm.DEALER_NAME", "%" + dealerDto.getDealerName() + "%"));
		}

		if (dealerDto.getBigOrg() != null && !"0".equals(dealerDto.getBigOrg()) && !"".equals(dealerDto.getBigOrg())) {
			assist.setRequires(Assist.andIn("bsm.BIG_ORG_ID", dealerDto.getBigOrg()));
		}

		if (dealerDto.getSmallOrg() != null && !"0".equals(dealerDto.getSmallOrg())
				&& !"".equals(dealerDto.getSmallOrg())) {
			assist.setRequires(Assist.andIn("bsm.SMALL_ORG_ID", dealerDto.getSmallOrg()));
		}

		long count = commonNoService.selectDealerArrRowCount(assist);
		List<Map> list = commonNoService.selectDealerAll(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;
	}

	@RequestMapping(value = "/ajax/toDealerPage", method = RequestMethod.GET)
	public ModelAndView toDealerPage() {
		ModelAndView mav = new ModelAndView("sysPage/dcsSales/dealerList");
		return mav;
	}

	// 销售单查询
	@RequestMapping(value = "/ajax/getSalesList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TtOpiExtendedSales> getSalesList(TtOpiExtendedSales ttOpiExtendedSales,
			@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize,
			HttpSession httpSession) {
		Result<TtOpiExtendedSales> result = new Result<TtOpiExtendedSales>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}
		Map<String, Object>  map = new HashMap<String, Object>();
		if (ttOpiExtendedSales.getBIG_ORG() != null && !"0".equals(ttOpiExtendedSales.getBIG_ORG()) && !"".equals(ttOpiExtendedSales.getBIG_ORG())) {
			//assist.setRequires(Assist.andIn("bsm.BIG_ORG_ID", ttOpiExtendedSales.getBIG_ORG()));
			map.put("BIG_ORG_ID", ttOpiExtendedSales.getBIG_ORG());
		}
		if (ttOpiExtendedSales.getSMALL_ORG() != null && !"0".equals(ttOpiExtendedSales.getSMALL_ORG())
				&& !"".equals(ttOpiExtendedSales.getSMALL_ORG())) {
			//assist.setRequires(Assist.andIn("bsm.SMALL_ORG_ID", ttOpiExtendedSales.getSMALL_ORG()));
			map.put("SMALL_ORG_ID", ttOpiExtendedSales.getSMALL_ORG());
		}

		if (ttOpiExtendedSales.getDEALER_CODE() != null && !"".equals(ttOpiExtendedSales.getDEALER_CODE())) {
			//assist.setRequires(Assist.andIn("bsm.DEALER_CODE", getDealerCodes(ttOpiExtendedSales.getDEALER_CODE())));
			map.put("dealerCode", getDealerCodes3(ttOpiExtendedSales.getDEALER_CODE()));
		}

		if (ttOpiExtendedSales.getDEALER_NAME() != null && !"".equals(ttOpiExtendedSales.getDEALER_NAME())) {
			//assist.setRequires(Assist.andLike("bsm.DEALER_NAME", "%" + ttOpiExtendedSales.getDEALER_NAME() + "%"));
			map.put("DEALER_NAME", ttOpiExtendedSales.getDEALER_NAME());
		}

		if (ttOpiExtendedSales.getPRODUCT_DATE() != null && !"0".equals(ttOpiExtendedSales.getPRODUCT_DATE())) {
			//assist.setRequires(Assist.andEq("bsm.PRODUCT_DATE", ttOpiExtendedSales.getPRODUCT_DATE()));
			map.put("PRODUCT_DATE", ttOpiExtendedSales.getPRODUCT_DATE());
		}
		if (ttOpiExtendedSales.getPRODUCT_SALES_ORDER() != null
				&& !"".equals(ttOpiExtendedSales.getPRODUCT_SALES_ORDER())) {
			//assist.setRequires(Assist.andLike("bsm.PRODUCT_SALES_ORDER", "%" + ttOpiExtendedSales.getPRODUCT_SALES_ORDER() + "%"));
			map.put("PRODUCT_SALES_ORDER",ttOpiExtendedSales.getPRODUCT_SALES_ORDER());
		}
		if (ttOpiExtendedSales.getPRODUCT_NO() != null && !"".equals(ttOpiExtendedSales.getPRODUCT_NO())) {
			//assist.setRequires(Assist.andLike("bsm.PRODUCT_NO", "%" + ttOpiExtendedSales.getPRODUCT_NO() + "%"));
			map.put("PRODUCT_NO", ttOpiExtendedSales.getPRODUCT_NO());
		}
		if (ttOpiExtendedSales.getPRODUCT_NAME() != null && !"".equals(ttOpiExtendedSales.getPRODUCT_NAME())) {
			//assist.setRequires(Assist.andLike("bsm.PRODUCT_NAME", "%" + ttOpiExtendedSales.getPRODUCT_NAME() + "%"));
			map.put("PRODUCT_NAME", ttOpiExtendedSales.getPRODUCT_NAME());
		}
		if (ttOpiExtendedSales.getBRAND_ID() != null && !"".equals(ttOpiExtendedSales.getBRAND_ID())) {
			Map brandMap = commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getBRAND_ID());
			if (brandMap != null) {
				//assist.setRequires(Assist.andEq("bsm.BRAND_CODE", brandMap.get("GROUP_CODE")));
				map.put("BRAND_CODE", brandMap.get("GROUP_CODE"));
			}
		}

		if (ttOpiExtendedSales.getSERIES_ID() != null && !"".equals(ttOpiExtendedSales.getSERIES_ID())) {
			Map seriesMap = commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getSERIES_ID());
			if (seriesMap != null) {
				//assist.setRequires(Assist.andEq("bsm.SERIES_CODE", seriesMap.get("GROUP_CODE")));
				map.put("SERIES_CODE", seriesMap.get("GROUP_CODE"));
			}
		}

		if (ttOpiExtendedSales.getMODEL_ID() != null && !"".equals(ttOpiExtendedSales.getMODEL_ID())) {
			Map modelMap = commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getMODEL_ID());
			if (modelMap != null) {
				//assist.setRequires(Assist.andEq("bsm.MODEL_CODE", modelMap.get("GROUP_CODE")));
				map.put("MODEL_CODE", modelMap.get("GROUP_CODE"));
			}
		}

		if (ttOpiExtendedSales.getVIN() != null && !"".equals(ttOpiExtendedSales.getVIN())) {
			//assist.setRequires(Assist.andLike("bsm.VIN", "%" + ttOpiExtendedSales.getVIN() + "%"));
			map.put("VIN", ttOpiExtendedSales.getVIN());
		}

		if (ttOpiExtendedSales.getLICENSE_NO() != null && !"".equals(ttOpiExtendedSales.getLICENSE_NO())) {
			//assist.setRequires(Assist.andLike("bsm.LICENSE_NO", "%" + ttOpiExtendedSales.getLICENSE_NO() + "%"));
			map.put("LICENSE_NO", ttOpiExtendedSales.getLICENSE_NO());
		}
		if (ttOpiExtendedSales.getCUSTOMER_NAME() != null && !"".equals(ttOpiExtendedSales.getCUSTOMER_NAME())) {
			//assist.setRequires(Assist.andLike("bsm.CUSTOMER_NAME", "%" + ttOpiExtendedSales.getCUSTOMER_NAME() + "%"));
			map.put("CUSTOMER_NAME", ttOpiExtendedSales.getCUSTOMER_NAME());
		}

		if (ttOpiExtendedSales.getORDER_STATUS() != null && !"0".equals(ttOpiExtendedSales.getORDER_STATUS())) {
			//assist.setRequires(Assist.andEq("bsm.ORDER_STATUS", ttOpiExtendedSales.getORDER_STATUS()));
			map.put("ORDER_STATUS", ttOpiExtendedSales.getORDER_STATUS());
		}

		if (ttOpiExtendedSales.getCREATED_AT_START() != null && !"".equals(ttOpiExtendedSales.getCREATED_AT_START())
				&& ttOpiExtendedSales.getCREATED_AT_END() != null
				&& !"".equals(ttOpiExtendedSales.getCREATED_AT_END())) {
			//assist.setRequires(Assist.andLte("bsm.CREATED_AT", ttOpiExtendedSales.getCREATED_AT_END()));
			//assist.setRequires(Assist.andGte("bsm.CREATED_AT", ttOpiExtendedSales.getCREATED_AT_START()));
			map.put("CREATED_AT_END", ttOpiExtendedSales.getCREATED_AT_END());
			map.put("CREATED_AT_START", ttOpiExtendedSales.getCREATED_AT_START());
		}

		if (ttOpiExtendedSales.getCLOSED_AT_START() != null && !"".equals(ttOpiExtendedSales.getCLOSED_AT_START())
				&& ttOpiExtendedSales.getCLOSED_AT_END() != null && !"".equals(ttOpiExtendedSales.getCLOSED_AT_END())) {
			//assist.setRequires(Assist.andLte("bsm.CLOSED_AT", ttOpiExtendedSales.getCLOSED_AT_END()));
			//assist.setRequires(Assist.andGte("bsm.CLOSED_AT", ttOpiExtendedSales.getCLOSED_AT_START()));
			map.put("CLOSED_AT_END", ttOpiExtendedSales.getCLOSED_AT_END());
			map.put("CLOSED_AT_START", ttOpiExtendedSales.getCLOSED_AT_START());
		}
		
		map.put("startRow", assist.getStartRow());
		map.put("rowSize", assist.getRowSize());
		long count = salesDcsService.getSalesRowCount(map);
		List<Map> list = salesDcsService.getSalesList(map);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;

	}

	// 销售单查询
	@RequestMapping(value = "/ajax/exportSalesExcel", method = RequestMethod.GET)
	public void exportSalesExcel(@RequestParam(required = false) String BIG_ORG,
			@RequestParam(required = false) String SMALL_ORG, @RequestParam(required = false) String DEALER_CODE,
			@RequestParam(required = false) String DEALER_NAME,
			@RequestParam(required = false) String PRODUCT_SALES_ORDER,
			@RequestParam(required = false) String PRODUCT_NO, @RequestParam(required = false) String PRODUCT_NAME,
			@RequestParam(required = false) String PRODUCT_DATE, @RequestParam(required = false) String BRAND_ID,
			@RequestParam(required = false) String SERIES_ID, @RequestParam(required = false) String MODEL_ID,
			@RequestParam(required = false) String VIN, @RequestParam(required = false) String LICENSE_NO,
			@RequestParam(required = false) String CUSTOMER_NAME,
			@RequestParam(required = false) String CREATED_AT_START,
			@RequestParam(required = false) String CREATED_AT_END,
			@RequestParam(required = false) String CLOSED_AT_START,
			@RequestParam(required = false) String CLOSED_AT_END, HttpServletRequest request,
			HttpServletResponse response, HttpSession httpSession) {
		Result<TtOpiExtendedSales> result = new Result<TtOpiExtendedSales>();
		Assist assist = new Assist();

		/*
		 * if(ttOpiExtendedSales.getBIG_ORG() != null &&
		 * !"0".equals(ttOpiExtendedSales.getBIG_ORG()) &&
		 * !"".equals(ttOpiExtendedSales.getBIG_ORG())) {
		 * assist.setRequires(Assist.andIn("bsm.BIG_ORG_ID",
		 * ttOpiExtendedSales.getBIG_ORG())); } if(ttOpiExtendedSales.getSMALL_ORG() !=
		 * null && !"0".equals(ttOpiExtendedSales.getSMALL_ORG()) &&
		 * !"".equals(ttOpiExtendedSales.getSMALL_ORG())) {
		 * assist.setRequires(Assist.andIn("bsm.SMALL_ORG_ID",
		 * ttOpiExtendedSales.getSMALL_ORG())); }
		 * 
		 * if(ttOpiExtendedSales.getDEALER_CODE() != null &&
		 * !"".equals(ttOpiExtendedSales.getDEALER_CODE())) {
		 * assist.setRequires(Assist.andIn("bsm.DEALER_CODE",
		 * getDealerCodes(ttOpiExtendedSales.getDEALER_CODE()))); }
		 * 
		 * if (ttOpiExtendedSales.getDEALER_NAME() != null &&
		 * !"".equals(ttOpiExtendedSales.getDEALER_NAME())) {
		 * assist.setRequires(Assist.andLike("bsm.DEALER_NAME", "%" +
		 * ttOpiExtendedSales.getDEALER_NAME() + "%")); }
		 * 
		 * if (ttOpiExtendedSales.getPRODUCT_DATE() != null &&
		 * !"0".equals(ttOpiExtendedSales.getPRODUCT_DATE())) {
		 * assist.setRequires(Assist.andEq("bsm.PRODUCT_DATE",
		 * ttOpiExtendedSales.getPRODUCT_DATE())); } if
		 * (ttOpiExtendedSales.getPRODUCT_SALES_ORDER() != null &&
		 * !"".equals(ttOpiExtendedSales.getPRODUCT_SALES_ORDER())) {
		 * assist.setRequires( Assist.andLike("bsm.PRODUCT_SALES_ORDER", "%" +
		 * ttOpiExtendedSales.getPRODUCT_SALES_ORDER() + "%")); } if
		 * (ttOpiExtendedSales.getPRODUCT_NO() != null &&
		 * !"".equals(ttOpiExtendedSales.getPRODUCT_NO())) {
		 * assist.setRequires(Assist.andLike("bsm.PRODUCT_NO", "%" +
		 * ttOpiExtendedSales.getPRODUCT_NO() + "%")); } if
		 * (ttOpiExtendedSales.getPRODUCT_NAME() != null &&
		 * !"".equals(ttOpiExtendedSales.getPRODUCT_NAME())) {
		 * assist.setRequires(Assist.andLike("bsm.PRODUCT_NAME", "%" +
		 * ttOpiExtendedSales.getPRODUCT_NAME() + "%")); } if
		 * (ttOpiExtendedSales.getBRAND_ID() != null &&
		 * !"".equals(ttOpiExtendedSales.getBRAND_ID())) { Map brandMap =
		 * commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getBRAND_ID()); if
		 * (brandMap != null) { assist.setRequires(Assist.andEq("bsm.BRAND_CODE",
		 * brandMap.get("GROUP_CODE"))); } }
		 * 
		 * if (ttOpiExtendedSales.getSERIES_ID() != null &&
		 * !"".equals(ttOpiExtendedSales.getSERIES_ID())) { Map seriesMap =
		 * commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getSERIES_ID()); if
		 * (seriesMap != null) { assist.setRequires(Assist.andEq("bsm.SERIES_CODE",
		 * seriesMap.get("GROUP_CODE"))); } }
		 * 
		 * if (ttOpiExtendedSales.getMODEL_ID() != null &&
		 * !"".equals(ttOpiExtendedSales.getMODEL_ID())) { Map modelMap =
		 * commonNoService.getDealerCodeAndName(ttOpiExtendedSales.getMODEL_ID()); if
		 * (modelMap != null) { assist.setRequires(Assist.andEq("bsm.MODEL_CODE",
		 * modelMap.get("GROUP_CODE"))); } }
		 * 
		 * if (ttOpiExtendedSales.getVIN() != null &&
		 * !"".equals(ttOpiExtendedSales.getVIN())) {
		 * assist.setRequires(Assist.andLike("bsm.VIN", "%" +
		 * ttOpiExtendedSales.getVIN() + "%")); }
		 * 
		 * if (ttOpiExtendedSales.getLICENSE_NO() != null &&
		 * !"".equals(ttOpiExtendedSales.getLICENSE_NO())) {
		 * assist.setRequires(Assist.andLike("bsm.LICENSE_NO", "%" +
		 * ttOpiExtendedSales.getLICENSE_NO() + "%")); } if
		 * (ttOpiExtendedSales.getCUSTOMER_NAME() != null &&
		 * !"".equals(ttOpiExtendedSales.getCUSTOMER_NAME())) {
		 * assist.setRequires(Assist.andLike("bsm.CUSTOMER_NAME", "%" +
		 * ttOpiExtendedSales.getCUSTOMER_NAME() + "%")); }
		 * 
		 * if (ttOpiExtendedSales.getORDER_STATUS() != null &&
		 * !"0".equals(ttOpiExtendedSales.getORDER_STATUS())) {
		 * assist.setRequires(Assist.andEq("bsm.ORDER_STATUS",
		 * ttOpiExtendedSales.getORDER_STATUS())); }
		 * 
		 * if (ttOpiExtendedSales.getCREATED_AT_START() != null &&
		 * !"".equals(ttOpiExtendedSales.getCREATED_AT_START()) &&
		 * ttOpiExtendedSales.getCREATED_AT_END() != null &&
		 * !"".equals(ttOpiExtendedSales.getCREATED_AT_END())) {
		 * assist.setRequires(Assist.andLte("bsm.CREATED_AT",
		 * ttOpiExtendedSales.getCREATED_AT_END()));
		 * assist.setRequires(Assist.andGte("bsm.CREATED_AT",
		 * ttOpiExtendedSales.getCREATED_AT_START())); //
		 * assist.setRequires(Assist.andEq("bsm.CREATED_AT", //
		 * ttOpiExtendedSales.getORDER_STATUS())); }
		 * 
		 * if (ttOpiExtendedSales.getCLOSED_AT_START() != null &&
		 * !"".equals(ttOpiExtendedSales.getCLOSED_AT_START()) &&
		 * ttOpiExtendedSales.getCLOSED_AT_END() != null &&
		 * !"".equals(ttOpiExtendedSales.getCLOSED_AT_END())) {
		 * assist.setRequires(Assist.andLte("bsm.CLOSED_AT",
		 * ttOpiExtendedSales.getCLOSED_AT_END()));
		 * assist.setRequires(Assist.andGte("bsm.CLOSED_AT",
		 * ttOpiExtendedSales.getCLOSED_AT_START())); //
		 * assist.setRequires(Assist.andEq("bsm.CREATED_AT", //
		 * ttOpiExtendedSales.getORDER_STATUS())); }
		 * assist.setOrder("bsm.PRODUCT_SALES_ID,bsm.PRODUCT_SALES_ORDER", true);
		 * 
		 * long count = salesDcsService.getSalesRowCount(assist); List<Map> list =
		 * salesDcsService.getSalesList(assist); result.setTotalCount(count);
		 * result.setDataListMap(list); return result;
		 */

	}

	private String getDealerCodes(String dealerCode) {
		String dealers = "";
		dealerCode = dealerCode.replaceAll("，", ",");
		dealerCode = dealerCode.replaceAll("\\n", ",");
		String[] dealerCodes = dealerCode.split(",");
		for (int i = 0; i < dealerCodes.length; i++) {
			String str = dealerCodes[i];
			if ("".equals(dealers)) {
				dealers = "'" + str + "'";
			} else {
				dealers = dealers + ",'" + str + "'";
			}

		}
		dealers = "( "+dealers+" )";
		return dealers;
	}
	
	private Map getDealerCodes2(String dealerCode) {
		Map map = new HashMap();
		String dealers = "";
		dealerCode = dealerCode.replaceAll("，", ",");
		dealerCode = dealerCode.replaceAll("\\n", ",");
		String[] dealerCodes = dealerCode.split(",");
		for (int i = 0; i < dealerCodes.length; i++) {
			String str = dealerCodes[i];
			if ("".equals(dealers)) {
				//dealers = "'" + str + "'";
				dealers = str ;
			} else {
				dealers = dealers + "," + str + "";
			}

		}
		map.put("dealers", dealers);
		return map;
	}
	
	
	public List getDealerCodes3(String dealerCode) {
		String dealers = "";
		dealerCode = dealerCode.replaceAll("，", ",");
		dealerCode = dealerCode.replaceAll("\\n", ",");
		String[] dealerCodes = dealerCode.split(",");
		final List list = new ArrayList();
		for (int i = 0; i < dealerCodes.length; i++) {
			list.add(dealerCodes[i]);
		}
		return list;
	}
	
}
