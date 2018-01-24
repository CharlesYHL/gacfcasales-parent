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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.dto.DealerDto;
import com.gacfcasales.common.entity.TtOpiExtendedSales;
import com.gacfcasales.common.excel.ExcelExportColumn;
import com.gacfcasales.common.excel.ExportExcel;
import com.gacfcasales.dcsweb.service.CommonNoService;
import com.gacfcasales.dcsweb.service.ProfitDcsService;

@Controller
@RequestMapping("/dcsProfit")
public class ProfitDcsController {
	private static Logger logger = LoggerFactory.getLogger(ProfitDcsController.class);

	@Autowired
	CommonNoService commonNoService;

	@Autowired
	ProfitDcsService profitDcsService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toProductListPage() {
		System.out.println("========进入页面=========");
		return "sysPage/dcsProfit/list";
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

	// 销售单盈利查询
	@RequestMapping(value = "/ajax/getProfitList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TtOpiExtendedSales> getProfitList(TtOpiExtendedSales ttOpiExtendedSales,
			@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize,
			HttpSession httpSession) {
		Result<TtOpiExtendedSales> result = new Result<TtOpiExtendedSales>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (ttOpiExtendedSales.getBIG_ORG() != null && !"0".equals(ttOpiExtendedSales.getBIG_ORG())
				&& !"".equals(ttOpiExtendedSales.getBIG_ORG())) {
			map.put("BIG_ORG_ID", ttOpiExtendedSales.getBIG_ORG());
		}
		if (ttOpiExtendedSales.getSMALL_ORG() != null && !"0".equals(ttOpiExtendedSales.getSMALL_ORG())
				&& !"".equals(ttOpiExtendedSales.getSMALL_ORG())) {
			map.put("SMALL_ORG_ID", ttOpiExtendedSales.getSMALL_ORG());
		}

		if (ttOpiExtendedSales.getDEALER_CODE() != null && !"".equals(ttOpiExtendedSales.getDEALER_CODE())) {
			map.put("dealerCode", getDealerCodes3(ttOpiExtendedSales.getDEALER_CODE()));
		}

		if (ttOpiExtendedSales.getDEALER_NAME() != null && !"".equals(ttOpiExtendedSales.getDEALER_NAME())) {
			map.put("DEALER_NAME", ttOpiExtendedSales.getDEALER_NAME());
		}

		if (ttOpiExtendedSales.getPRODUCT_DATE() != null && !"0".equals(ttOpiExtendedSales.getPRODUCT_DATE())) {
			map.put("PRODUCT_DATE", ttOpiExtendedSales.getPRODUCT_DATE());
		}
		if (ttOpiExtendedSales.getPRODUCT_SALES_ORDER() != null
				&& !"".equals(ttOpiExtendedSales.getPRODUCT_SALES_ORDER())) {
			map.put("PRODUCT_SALES_ORDER", ttOpiExtendedSales.getPRODUCT_SALES_ORDER());
		}
		if (ttOpiExtendedSales.getPRODUCT_NO() != null && !"".equals(ttOpiExtendedSales.getPRODUCT_NO())) {
			map.put("PRODUCT_NO", ttOpiExtendedSales.getPRODUCT_NO());
		}
		if (ttOpiExtendedSales.getPRODUCT_NAME() != null && !"".equals(ttOpiExtendedSales.getPRODUCT_NAME())) {
			map.put("PRODUCT_NAME", ttOpiExtendedSales.getPRODUCT_NAME());
		}
		if (ttOpiExtendedSales.getVIN() != null && !"".equals(ttOpiExtendedSales.getVIN())) {
			map.put("VIN", ttOpiExtendedSales.getVIN());
		}

		if (ttOpiExtendedSales.getLICENSE_NO() != null && !"".equals(ttOpiExtendedSales.getLICENSE_NO())) {
			map.put("LICENSE_NO", ttOpiExtendedSales.getLICENSE_NO());
		}
		if (ttOpiExtendedSales.getCUSTOMER_NAME() != null && !"".equals(ttOpiExtendedSales.getCUSTOMER_NAME())) {
			map.put("CUSTOMER_NAME", ttOpiExtendedSales.getCUSTOMER_NAME());
		}

		if (ttOpiExtendedSales.getCREATED_AT_START() != null && !"".equals(ttOpiExtendedSales.getCREATED_AT_START())
				&& ttOpiExtendedSales.getCREATED_AT_END() != null
				&& !"".equals(ttOpiExtendedSales.getCREATED_AT_END())) {
			map.put("CREATED_AT_END", ttOpiExtendedSales.getCREATED_AT_END());
			map.put("CREATED_AT_START", ttOpiExtendedSales.getCREATED_AT_START());
		}

		if (ttOpiExtendedSales.getCLOSED_AT_START() != null && !"".equals(ttOpiExtendedSales.getCLOSED_AT_START())
				&& ttOpiExtendedSales.getCLOSED_AT_END() != null && !"".equals(ttOpiExtendedSales.getCLOSED_AT_END())) {
			map.put("CLOSED_AT_END", ttOpiExtendedSales.getCLOSED_AT_END());
			map.put("CLOSED_AT_START", ttOpiExtendedSales.getCLOSED_AT_START());
		}

		map.put("startRow", assist.getStartRow());
		map.put("rowSize", assist.getRowSize());
		long count = profitDcsService.getProfitRowCount(map);
		List<Map> list = profitDcsService.getProfitList(map);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;

	}

	// 销售单盈利导出
	@RequestMapping(value = "/ajax/exportProfitExcel", method = RequestMethod.GET)
	public void exportProfitExcel(@RequestParam(required = false) String BIG_ORG,
			@RequestParam(required = false) String SMALL_ORG, @RequestParam(required = false) String DEALER_CODE,
			@RequestParam(required = false) String DEALER_NAME,
			@RequestParam(required = false) String PRODUCT_SALES_ORDER,
			@RequestParam(required = false) String PRODUCT_NO, @RequestParam(required = false) String PRODUCT_NAME,
			@RequestParam(required = false) String PRODUCT_DATE, @RequestParam(required = false) String VIN,
			@RequestParam(required = false) String LICENSE_NO, @RequestParam(required = false) String CUSTOMER_NAME,
			@RequestParam(required = false) String CREATED_AT_START,
			@RequestParam(required = false) String CREATED_AT_END,
			@RequestParam(required = false) String CLOSED_AT_START,
			@RequestParam(required = false) String CLOSED_AT_END, HttpServletRequest request,
			HttpServletResponse response, HttpSession httpSession) {

		Map<String, Object> map = new HashMap<String, Object>();
		if (BIG_ORG != null && !"0".equals(BIG_ORG) && !"".equals(BIG_ORG) && !"null".equals(BIG_ORG)) {
			map.put("BIG_ORG_ID", BIG_ORG);
		}
		if (SMALL_ORG != null && !"0".equals(SMALL_ORG) && !"null".equals(SMALL_ORG) && !"".equals(SMALL_ORG)) {
			map.put("SMALL_ORG_ID", SMALL_ORG);
		}

		if (DEALER_CODE != null && !"".equals(DEALER_CODE)) {
			map.put("dealerCode", getDealerCodes3(DEALER_CODE));
		}

		if (DEALER_NAME != null && !"".equals(DEALER_NAME)) {
			map.put("DEALER_NAME", DEALER_NAME);
		}

		if (PRODUCT_DATE != null && !"0".equals(PRODUCT_DATE)) {
			map.put("PRODUCT_DATE", PRODUCT_DATE);
		}
		if (PRODUCT_SALES_ORDER != null && !"".equals(PRODUCT_SALES_ORDER)) {
			map.put("PRODUCT_SALES_ORDER", PRODUCT_SALES_ORDER);
		}
		if (PRODUCT_NO != null && !"".equals(PRODUCT_NO)) {
			map.put("PRODUCT_NO", PRODUCT_NO);
		}
		if (PRODUCT_NAME != null && !"".equals(PRODUCT_NAME)) {
			map.put("PRODUCT_NAME", PRODUCT_NAME);
		}

		if (VIN != null && !"".equals(VIN)) {
			map.put("VIN", VIN);
		}

		if (LICENSE_NO != null && !"".equals(LICENSE_NO)) {
			map.put("LICENSE_NO", LICENSE_NO);
		}
		if (CUSTOMER_NAME != null && !"".equals(CUSTOMER_NAME)) {
			map.put("CUSTOMER_NAME", CUSTOMER_NAME);
		}

		if (CREATED_AT_START != null && !"".equals(CREATED_AT_START) && CREATED_AT_END != null
				&& !"".equals(CREATED_AT_END)) {
			map.put("CREATED_AT_END", CREATED_AT_END);
			map.put("CREATED_AT_START", CREATED_AT_START);
		}

		if (CLOSED_AT_START != null && !"".equals(CLOSED_AT_START) && CLOSED_AT_END != null
				&& !"".equals(CLOSED_AT_END)) {
			map.put("CLOSED_AT_END", CLOSED_AT_END);
			map.put("CLOSED_AT_START", CLOSED_AT_START);
		}

		map.put("startRow", 0);
		map.put("rowSize", 50000);

		ExportExcel exportExcel = new ExportExcel();
		List<Map> resultList = profitDcsService.getProfitListExport(map);
		Map<String, List<Map>> excelData = new HashMap<String, List<Map>>();
		excelData.put("销售单盈利信息表", resultList);

		List<ExcelExportColumn> exportColumnList = new ArrayList<ExcelExportColumn>();
		exportColumnList.add(new ExcelExportColumn("BIG_ORG", "大区"));
		exportColumnList.add(new ExcelExportColumn("SMALL_ORG", "小区"));
		exportColumnList.add(new ExcelExportColumn("DEALER_CODE", "经销商代码"));
		exportColumnList.add(new ExcelExportColumn("DEALER_NAME", "经销商名称"));
		exportColumnList.add(new ExcelExportColumn("ORDER_STATUS", "单据状态"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_SALES_ORDER", "销售单编号"));
		exportColumnList.add(new ExcelExportColumn("SAP_SALES_ORDER", "SAP订单号"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_NO", "产品编号"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_NAME", "产品名称"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DATE", "产品有效期"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DESCRIBTION", "产品说明"));
		exportColumnList.add(new ExcelExportColumn("CUSTOMER_NAME", "客户姓名"));
		exportColumnList.add(new ExcelExportColumn("CUSTOMER_CONTACT", "客户联系方式"));
		exportColumnList.add(new ExcelExportColumn("VIN", "VIN"));
		exportColumnList.add(new ExcelExportColumn("LICENSE_NO", "车牌号"));
		exportColumnList.add(new ExcelExportColumn("OWNER_NAME", "车主姓名"));
		exportColumnList.add(new ExcelExportColumn("OWNER_MOBILE", "车主手机"));
		exportColumnList.add(new ExcelExportColumn("CREATED_AT", "创建时间"));
		exportColumnList.add(new ExcelExportColumn("CREATE_NAME", "创建人"));
		exportColumnList.add(new ExcelExportColumn("TAKE_EFFECT_START", "生效开始时间"));
		exportColumnList.add(new ExcelExportColumn("TAKE_EFFECT_END", "生效结束时间"));
		exportColumnList.add(new ExcelExportColumn("PURCHASE_NUMBER", "购买数量"));
		exportColumnList.add(new ExcelExportColumn("NON_TAX_COST_PRICE", "不含税成本价"));
		exportColumnList.add(new ExcelExportColumn("TAX_COST_PRICE", "含税成本价"));
		exportColumnList.add(new ExcelExportColumn("TERMINAL_NON_SALES_PRICE", "终端不含税销售价"));
		exportColumnList.add(new ExcelExportColumn("TERMINAL_SALES_PRICE", "终端含税销售价（6%）"));
		exportColumnList.add(new ExcelExportColumn("ACTUAL_NON_SALES_PRICE", "实际不含税销售价"));
		exportColumnList.add(new ExcelExportColumn("TOTAL_AMOUNT", "含税总额（6%）"));
		exportColumnList.add(new ExcelExportColumn("COST_PROFIT", "毛利"));
		exportColumnList.add(new ExcelExportColumn("CLOSED_NAME", "结案人"));
		exportColumnList.add(new ExcelExportColumn("CLOSED_AT", "结案时间"));
		exportExcel.generateExcelForDms(excelData, exportColumnList, "销售单盈利信息表.xls", request, response);

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
		dealers = "( " + dealers + " )";
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
				// dealers = "'" + str + "'";
				dealers = str;
			} else {
				dealers = dealers + "," + str + "";
			}

		}
		map.put("dealers", dealers);
		return map;
	}

	public List<String> getDealerCodes3(String dealerCode) {
		String dealers = "";
		dealerCode = dealerCode.replaceAll("，", ",");
		dealerCode = dealerCode.replaceAll("\\n", ",");
		String[] dealerCodes = dealerCode.split(",");
		final List<String> list = new ArrayList<String>();
		for (int i = 0; i < dealerCodes.length; i++) {
			// String str = "'" + dealerCodes[i] + "'";
			list.add(dealerCodes[i]);
		}
		return list;
	}

	// 查询盈利明细
	@RequestMapping(value = "/ajax/detailProfit", method = RequestMethod.GET)
	public ModelAndView toProfitDetail(@RequestParam String PRODUCT_SALES_ID) {
		ModelAndView mav = new ModelAndView("sysPage/dcsProfit/detail");
		if (PRODUCT_SALES_ID != null && !"".equals(PRODUCT_SALES_ID)) {
			Map map = profitDcsService.getProfitFindBySalesId(PRODUCT_SALES_ID);
			mav.addObject("ttOpiSalesAll", map);
		}
		return mav;
	}

}
