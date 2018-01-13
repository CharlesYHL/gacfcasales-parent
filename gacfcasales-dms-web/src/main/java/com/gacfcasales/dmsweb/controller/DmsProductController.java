package com.gacfcasales.dmsweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.dto.LoginInfoDto;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.excel.ExcelExportColumn;
import com.gacfcasales.common.excel.ExportExcel;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.dmsweb.service.CommonNoService;
import com.gacfcasales.dmsweb.service.DmsProductService;

@Controller
@RequestMapping("/dmsProduct")
public class DmsProductController {
	private Logger logger = LoggerFactory.getLogger(DmsProductController.class);

	@Autowired
	DmsProductService dmsProductService;

	@Autowired
	CommonNoService commonNoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toProductListPage() {
		System.out.println("========进入页面=========");
		return "sysPage/dmsProduct/list";
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/productExcel", method = RequestMethod.GET)
	public void ProductExcel(@RequestParam(required = false) String PRODUCT_NO,
			@RequestParam(required = false) String PRODUCT_NAME, @RequestParam(required = false) Integer PRODUCT_DATE,
			@RequestParam(required = false) Integer RELEASE_STATUS,
			@RequestParam(required = false) String PRODUCT_MODEL, @RequestParam(required = false) String releaseStart,
			@RequestParam(required = false) String releaseEnd, @RequestParam(required = false) String salesStart,
			@RequestParam(required = false) String salesEnd, HttpServletRequest request, HttpServletResponse response) {
		LoginInfoDto loginInfo = ApplicationContextHelper.getBeanByType(LoginInfoDto.class);
		logger.debug(loginInfo.getDealerCode()+"======"+loginInfo.getUserId());
		Assist assist = new Assist();
		if (PRODUCT_NO != null && !"".equals(PRODUCT_NO)) {
			assist.setRequires(Assist.andLike("PRODUCT_NO", "%" + PRODUCT_NO + "%"));
		}
		if (PRODUCT_NAME != null && !"".equals(PRODUCT_NAME)) {
			assist.setRequires(Assist.andLike("PRODUCT_NAME", "%" + PRODUCT_NAME + "%"));
		}
		if (PRODUCT_MODEL != null && !"".equals(PRODUCT_MODEL)) {
			assist.setRequires(Assist.andLike("PRODUCT_MODEL", "%" + PRODUCT_MODEL + "%"));
		}
		int productDate = Integer.parseInt(PRODUCT_DATE.toString());
		if (productDate != 0) {
			assist.setRequires(Assist.andEq("PRODUCT_DATE", productDate));
		}
		int releaseStatus = Integer.parseInt(RELEASE_STATUS.toString());
		if (releaseStatus != 0) {
			assist.setRequires(Assist.andEq("RELEASE_STATUS", releaseStatus));
		}
		if (releaseStart != null && !"".equals(releaseStart) && releaseEnd != null && !"".equals(releaseEnd)) {
			assist.setRequires(Assist.andLte("RELEASE_DATE", releaseEnd));
			assist.setRequires(Assist.andGte("RELEASE_DATE", releaseStart));
		}

		if (salesStart != null && !"".equals(salesStart) && salesEnd != null && !"".equals(salesEnd)) {
			assist.setRequires(Assist.andLte("SALES_DATE_END", salesEnd));
			assist.setRequires(Assist.andGte("SALES_DATE_START", salesEnd));
		}

		assist.setOrder("PRODUCT_NO,PRODUCT_ID", true);

		ExportExcel exportExcel = new ExportExcel();

		List<Map> resultList = dmsProductService.exportExcel(assist);

		Map<String, List<Map>> excelData = new HashMap<String, List<Map>>();
		excelData.put("产品信息表", resultList);

		List<ExcelExportColumn> exportColumnList = new ArrayList<ExcelExportColumn>();

		exportColumnList.add(new ExcelExportColumn("PRODUCT_NO", "产品编号"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_NAME", "产品名称"));
		exportColumnList.add(new ExcelExportColumn("IS_VALID", "是否有效"));
		exportColumnList.add(new ExcelExportColumn("NON_TAX_COST_PRICE", "不含税成本价"));
		exportColumnList.add(new ExcelExportColumn("TAX_COST_PRICE", "含税成本价(6%)"));
		exportColumnList.add(new ExcelExportColumn("TERMINAL_NON_SALES_PRICE", "终端不含税销售价"));
		exportColumnList.add(new ExcelExportColumn("TERMINAL_SALES_PRICE", "终端含税销售价(6%)"));
		exportColumnList.add(new ExcelExportColumn("SALES_DATE_ALL", "销售时间"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DATE", "产品有效期"));
		exportColumnList.add(new ExcelExportColumn("RELEASE_DATE", "发布时间"));
		exportColumnList.add(new ExcelExportColumn("RELEASE_STATUS", "发布状态"));
		exportColumnList.add(new ExcelExportColumn("IS_C_SALE", "是否可销售"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_MODEL", "适用车型"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DESCRIBTION", "产品说明"));
		exportExcel.generateExcelForDms(excelData, exportColumnList, "产品信息表.xls", request, response);
	}
	
	
	@RequestMapping(value = "/ajax/getProductList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TiOpiExtendedDCS> getPartInfoList(TiOpiExtendedDCS tiOpiExtendedDCS, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize) {
		Result<TiOpiExtendedDCS> result = new Result<TiOpiExtendedDCS>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (tiOpiExtendedDCS.getPRODUCT_NO() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_NO())) {
			assist.setRequires(Assist.andLike("PRODUCT_NO", "%" + tiOpiExtendedDCS.getPRODUCT_NO() + "%"));
		}

		if (tiOpiExtendedDCS.getPRODUCT_NAME() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_NAME())) {
			assist.setRequires(Assist.andLike("PRODUCT_NAME", "%" + tiOpiExtendedDCS.getPRODUCT_NAME() + "%"));
		}
		if (tiOpiExtendedDCS.getPRODUCT_MODEL() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_MODEL())) {
			assist.setRequires(Assist.andLike("PRODUCT_MODEL", "%" + tiOpiExtendedDCS.getPRODUCT_MODEL() + "%"));
		}
		int productDate = Integer.parseInt(tiOpiExtendedDCS.getPRODUCT_DATE().toString());
		if (productDate != 0) {
			assist.setRequires(Assist.andEq("PRODUCT_DATE", productDate));
		}
		int releaseStatus = Integer.parseInt(tiOpiExtendedDCS.getRELEASE_STATUS().toString());
		if (releaseStatus != 0) {
			assist.setRequires(Assist.andEq("RELEASE_STATUS", releaseStatus));
		}
		
		if (tiOpiExtendedDCS.getReleaseStart() != null && !"".equals(tiOpiExtendedDCS.getReleaseStart())
				&& tiOpiExtendedDCS.getReleaseEnd() != null && !"".equals(tiOpiExtendedDCS.getReleaseEnd())) {
			assist.setRequires(Assist.andLte("RELEASE_DATE", tiOpiExtendedDCS.getReleaseEnd()));
			assist.setRequires(Assist.andGte("RELEASE_DATE", tiOpiExtendedDCS.getReleaseStart()));
		}

		if (tiOpiExtendedDCS.getSalesStart() != null && !"".equals(tiOpiExtendedDCS.getSalesStart())
				&& tiOpiExtendedDCS.getSalesEnd() != null && !"".equals(tiOpiExtendedDCS.getSalesEnd())) {
			assist.setRequires(Assist.andLte("SALES_DATE_END", tiOpiExtendedDCS.getSalesEnd()));
			assist.setRequires(Assist.andGte("SALES_DATE_START", tiOpiExtendedDCS.getSalesStart()));
		}

		assist.setOrder("PRODUCT_NO,PRODUCT_ID", true);

		long count = dmsProductService.getDmsProductRowCount(assist);
		List<Map> list = dmsProductService.getDmsProductList(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;
	}
	
}
