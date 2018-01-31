package com.gacfcasales.dmsweb.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.dto.LoginInfoDto;
import com.gacfcasales.common.entity.TiExtendedPage;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TmPartInfo;
import com.gacfcasales.common.entity.TmUser;
import com.gacfcasales.common.excel.ExcelExportColumn;
import com.gacfcasales.common.excel.ExportExcel;
import com.gacfcasales.common.util.ApplicationContextHelper;
import com.gacfcasales.common.util.OemDictCodeConstants;
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
			@RequestParam(required = false) String salesEnd, HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) {
		System.out.println(httpSession.getAttribute("users"));
		TmUser tmUser = (TmUser)httpSession.getAttribute("users");
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
		assist.setRequires(Assist.andEq("tmd.DEALER_CODE", tmUser.getDEALER_CODE()));
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
	public Result<TiOpiExtendedDCS> getPartInfoList(TiOpiExtendedDCS tiOpiExtendedDCS,
			@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize,HttpSession httpSession) {
		
		System.out.println(httpSession.getAttribute("users"));
		TmUser tmUser = (TmUser)httpSession.getAttribute("users");
		
		/*Map userMap = dmsProductService.getDealer(tmUser.getDEALER_CODE());*/
		
		Result<TiOpiExtendedDCS> result = new Result<TiOpiExtendedDCS>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (tiOpiExtendedDCS.getPRODUCT_NO() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_NO())) {
			assist.setRequires(Assist.andLike("tipe.PRODUCT_NO", "%" + tiOpiExtendedDCS.getPRODUCT_NO() + "%"));
		}

		if (tiOpiExtendedDCS.getPRODUCT_NAME() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_NAME())) {
			assist.setRequires(Assist.andLike("tipe.PRODUCT_NAME", "%" + tiOpiExtendedDCS.getPRODUCT_NAME() + "%"));
		}
		if (tiOpiExtendedDCS.getPRODUCT_MODEL() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_MODEL())) {
			assist.setRequires(Assist.andLike("tipe.PRODUCT_MODEL", "%" + tiOpiExtendedDCS.getPRODUCT_MODEL() + "%"));
		}
		int productDate = Integer.parseInt(tiOpiExtendedDCS.getPRODUCT_DATE().toString());
		if (productDate != 0) {
			assist.setRequires(Assist.andEq("tipe.PRODUCT_DATE", productDate));
		}
		int releaseStatus = Integer.parseInt(tiOpiExtendedDCS.getRELEASE_STATUS().toString());
		if (releaseStatus != 0) {
			assist.setRequires(Assist.andEq("tipe.RELEASE_STATUS", releaseStatus));
		}

		if (tiOpiExtendedDCS.getReleaseStart() != null && !"".equals(tiOpiExtendedDCS.getReleaseStart())
				&& tiOpiExtendedDCS.getReleaseEnd() != null && !"".equals(tiOpiExtendedDCS.getReleaseEnd())) {
			assist.setRequires(Assist.andLte("tipe.RELEASE_DATE", tiOpiExtendedDCS.getReleaseEnd()));
			assist.setRequires(Assist.andGte("tipe.RELEASE_DATE", tiOpiExtendedDCS.getReleaseStart()));
		}

		if (tiOpiExtendedDCS.getSalesStart() != null && !"".equals(tiOpiExtendedDCS.getSalesStart())
				&& tiOpiExtendedDCS.getSalesEnd() != null && !"".equals(tiOpiExtendedDCS.getSalesEnd())) {
			assist.setRequires(Assist.andLte("tipe.SALES_DATE_END", tiOpiExtendedDCS.getSalesEnd()));
			assist.setRequires(Assist.andGte("tipe.SALES_DATE_START", tiOpiExtendedDCS.getSalesStart()));
		}
		//assist.setRequires(Assist.andEq("tipe.RELEASE_STATUS", OemDictCodeConstants.PRODUCT_RELEASE_STATUS_02));
		assist.setRequires(Assist.andEq("tmd.DEALER_CODE", tmUser.getDEALER_CODE()));
		
		assist.setOrder("PRODUCT_NO,PRODUCT_ID", true);

		long count = dmsProductService.getDmsProductRowCount(assist);
		List<Map> list = dmsProductService.getDmsProductList(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;
	}
	
	//产品明细
	@RequestMapping(value = "/ajax/detailProduct", method = RequestMethod.GET)
	public ModelAndView toProduct(@RequestParam String productId) {
		// System.out.println(JSON.toJSONString(listDto));
		TiExtendedPage TiExtendedPage = new TiExtendedPage();
		TiOpiExtendedDCS tiOpiExtendedDCS = dmsProductService.getProductByID(productId);
		TiExtendedPage.setPRODUCT_ID(tiOpiExtendedDCS.getPRODUCT_ID().toString());
		TiExtendedPage.setPRODUCT_NO(tiOpiExtendedDCS.getPRODUCT_NO().toString());
		TiExtendedPage.setPRODUCT_NAME(tiOpiExtendedDCS.getPRODUCT_NAME().toString());
		TiExtendedPage.setPRODUCT_CATEGORY(tiOpiExtendedDCS.getPRODUCT_CATEGORY().toString());
		TiExtendedPage.setPRODUCT_PROPERTY(tiOpiExtendedDCS.getPRODUCT_PROPERTY().toString());
		TiExtendedPage.setDNP_PRICE(tiOpiExtendedDCS.getDNP_PRICE().toString());
		TiExtendedPage.setMSRP_PRICE(tiOpiExtendedDCS.getMSRP_PRICE().toString());
		TiExtendedPage.setPRODUCT_DESCRIBTION(tiOpiExtendedDCS.getPRODUCT_DESCRIBTION());
		if (tiOpiExtendedDCS.getPRODUCT_DATE() != null) {
			TiExtendedPage.setPRODUCT_DATE(tiOpiExtendedDCS.getPRODUCT_DATE() + "个月");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (tiOpiExtendedDCS.getSALES_DATE_START() != null && !"".equals(tiOpiExtendedDCS.getSALES_DATE_START())) {
			TiExtendedPage.setSALES_DATE_START(sdf.format(tiOpiExtendedDCS.getSALES_DATE_START()));
		}
		if (tiOpiExtendedDCS.getSALES_DATE_END() != null && !"".equals(tiOpiExtendedDCS.getSALES_DATE_END())) {
			TiExtendedPage.setSALES_DATE_END(sdf.format(tiOpiExtendedDCS.getSALES_DATE_END()));
		}

		if (tiOpiExtendedDCS.getPRODUCT_FAIT() == 10041001) {
			TiExtendedPage.setPRODUCT_FAIT("是");
		} else {
			TiExtendedPage.setPRODUCT_FAIT("否");
		}

		if (tiOpiExtendedDCS.getPRODUCT_JEEP() == 10041001) {
			TiExtendedPage.setPRODUCT_JEEP("是");
		} else {
			TiExtendedPage.setPRODUCT_JEEP("否");
		}

		if (tiOpiExtendedDCS.getPRODUCT_CJD() == 10041001) {
			TiExtendedPage.setPRODUCT_CJD("是");
		} else {
			TiExtendedPage.setPRODUCT_CJD("否");
		}
		
		if(tiOpiExtendedDCS.getIS_VALID() == 12781001) {
			TiExtendedPage.setIS_VALID("是");
		}else {
			TiExtendedPage.setIS_VALID("否");
		}
		if(tiOpiExtendedDCS.getIS_C_SALE() == 12781001) {
			TiExtendedPage.setIS_C_SALE("是");
		}else {
			TiExtendedPage.setIS_C_SALE("否");
		}
		
		if(tiOpiExtendedDCS.getNON_TAX_COST_PRICE() != null) {
			TiExtendedPage.setNON_TAX_COST_PRICE(tiOpiExtendedDCS.getNON_TAX_COST_PRICE().toString());
		}else {
			TiExtendedPage.setNON_TAX_COST_PRICE("");
		}
		
		if(tiOpiExtendedDCS.getTAX_COST_PRICE() != null) {
			TiExtendedPage.setTAX_COST_PRICE(tiOpiExtendedDCS.getTAX_COST_PRICE().toString());
		}else {
			TiExtendedPage.setTAX_COST_PRICE("");
		}
		if(tiOpiExtendedDCS.getTERMINAL_NON_SALES_PRICE() != null) {
			TiExtendedPage.setTERMINAL_NON_SALES_PRICE(tiOpiExtendedDCS.getTERMINAL_NON_SALES_PRICE().toString());
		}else {
			TiExtendedPage.setTERMINAL_NON_SALES_PRICE("");
		}
		
		if(tiOpiExtendedDCS.getTERMINAL_SALES_PRICE() != null) {
			TiExtendedPage.setTERMINAL_SALES_PRICE(tiOpiExtendedDCS.getTERMINAL_SALES_PRICE().toString());
		}else {
			TiExtendedPage.setTERMINAL_SALES_PRICE("");
		}
		
		if(tiOpiExtendedDCS.getRELEASE_STATUS() == OemDictCodeConstants.PRODUCT_RELEASE_STATUS_01) {
			TiExtendedPage.setRELEASE_STATUS("未发布");
		}else if(tiOpiExtendedDCS.getRELEASE_STATUS() == OemDictCodeConstants.PRODUCT_RELEASE_STATUS_02) {
			TiExtendedPage.setRELEASE_STATUS("已发布");
		}else {
			TiExtendedPage.setRELEASE_STATUS("已取消");
		}
		
		ModelAndView mav = new ModelAndView("sysPage/dmsProduct/detail");
		mav.addObject("tiOpiExtendedDCS", TiExtendedPage);
		return mav;
	}
	
	
	@RequestMapping(value = "/ajax/getDetailModelList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TmPartInfo> getDetailModelList(TiExtendedPage TiExtendedPage,
			@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize) {
		Result<TmPartInfo> result = new Result<TmPartInfo>();
		if (TiExtendedPage.getPRODUCT_ID() != null && !"".equals(TiExtendedPage.getPRODUCT_ID())) {
			Assist assist = new Assist();
			if (null != pageindex && null != pageSize) {
				assist.setStartRow((pageindex - 1) * pageSize);
				assist.setRowSize(pageSize);
			}

			if (TiExtendedPage.getPRODUCT_ID() != null && !"".equals(TiExtendedPage.getPRODUCT_ID())) {
				assist.setRequires(Assist.andEq("PRODUCT_ID", TiExtendedPage.getPRODUCT_ID()));
			}

			assist.setOrder("PRODUCT_MODEL_ID,PRODUCT_ID", true);

			long count = dmsProductService.getDetailModelRowCount(assist);
			List<Map> list = dmsProductService.getDetailModelList(assist);
			result.setTotalCount(count);
			result.setDataListMap(list);
		} else {
			result.setTotalCount(0);
			result.setDataListMap(null);
		}
		return result;
	}
}
