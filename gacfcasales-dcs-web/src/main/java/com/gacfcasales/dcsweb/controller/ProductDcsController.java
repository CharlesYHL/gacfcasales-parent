package com.gacfcasales.dcsweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.gacfcasales.common.dto.ListDto;
import com.gacfcasales.common.entity.ModelPage;
import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.entity.TiOpiExtendedModel;
import com.gacfcasales.common.entity.TmPartInfo;
import com.gacfcasales.common.entity.TmPartInfoPage;
import com.gacfcasales.common.excel.ExcelExportColumn;
import com.gacfcasales.common.excel.ExportExcel;
import com.gacfcasales.dcsweb.service.CommonNoService;
import com.gacfcasales.dcsweb.service.ProductService;

@Controller
@RequestMapping("/sysProduct")
public class ProductDcsController {
	private static Logger logger = LoggerFactory.getLogger(ProductDcsController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	CommonNoService commonNoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toProductListPage() {
		System.out.println("========进入页面=========");
		return "sysPage/sysProduct/list";
	}

	@RequestMapping(value = "/ajax/addProduct", method = RequestMethod.GET)
	public String toAddProductPage() {
		System.out.println("========进入新增页面=========");
		return "sysPage/sysProduct/addProduct";
		// return "include/header";
	}

	@RequestMapping(value = "/ajax/partInfo", method = RequestMethod.GET)
	public ModelAndView toPartInfoPage(@RequestParam String partNo) {
		System.out.println(partNo + "========进入PartInfo页面=========");
		ModelAndView mav = new ModelAndView("sysPage/sysProduct/partInfo");
		mav.addObject("partNo", partNo);
		return mav;
		// return "include/header";
	}

	@RequestMapping(value = "/ajax/productExcel", method = RequestMethod.GET)
	public void ProductExcel(TiOpiExtendedDCS tiOpiExtendedDCS, HttpServletRequest request,
			HttpServletResponse response) {
		ExportExcel exportExcel = new ExportExcel();

		List<Map> resultList = productService.exportProduct(tiOpiExtendedDCS);

		Map<String, List<Map>> excelData = new HashMap<String, List<Map>>();
		excelData.put("产品信息表", resultList);

		List<ExcelExportColumn> exportColumnList = new ArrayList<ExcelExportColumn>();

		exportColumnList.add(new ExcelExportColumn("PRODUCT_NO", "产品编号"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_NAME", "产品名称"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_CATEGORY", "产品类别"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_PROPERTY", "产品属性"));
		exportColumnList.add(new ExcelExportColumn("DNP_PRICE", "DNP价格"));
		exportColumnList.add(new ExcelExportColumn("MSRP_PRICE", "MSRP价格"));
		exportColumnList.add(new ExcelExportColumn("RELEASE_STATUS", "发布状态"));
		exportColumnList.add(new ExcelExportColumn("RELEASE_DATE", "发布时间"));
		exportColumnList.add(new ExcelExportColumn("STOP_DATE", "停用时间"));
		exportColumnList.add(new ExcelExportColumn("IS_VALID", "是否有效"));
		exportColumnList.add(new ExcelExportColumn("IS_C_SALE", "是否可销售"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DATE", "产品有效期"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_MODEL", "适用车型"));
		exportColumnList.add(new ExcelExportColumn("SALES_DATE", "销售时间"));
		exportExcel.generateExcelForDms(excelData, exportColumnList, "产品信息表.xls", request, response);
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/productExcel_bak", method = RequestMethod.GET)
	public void ProductExcel(@RequestParam(required = false) Long PRODUCT_NO,
			@RequestParam(required = false) String PRODUCT_NAME,
			@RequestParam(required = false) String PRODUCT_CATEGORY,
			@RequestParam(required = false) String PRODUCT_PROPERTY, @RequestParam(required = false) Integer IS_VALID,
			@RequestParam(required = false) Integer PRODUCT_DATE, @RequestParam(required = false) Integer IS_C_SALE,
			@RequestParam(required = false) String releaseStart, @RequestParam(required = false) String releaseEnd,
			@RequestParam(required = false) String salesStart, @RequestParam(required = false) String salesEnd,
			HttpServletRequest request, HttpServletResponse response) {
		TiOpiExtendedDCS tiOpiExtendedDCS = new TiOpiExtendedDCS();
		tiOpiExtendedDCS.setPRODUCT_NO(PRODUCT_NO);
		tiOpiExtendedDCS.setPRODUCT_NAME(PRODUCT_NAME);
		tiOpiExtendedDCS.setPRODUCT_CATEGORY(PRODUCT_CATEGORY);
		tiOpiExtendedDCS.setPRODUCT_PROPERTY(PRODUCT_PROPERTY);
		if (IS_VALID != 0) {
			tiOpiExtendedDCS.setIS_VALID(IS_VALID);
		}
		if (PRODUCT_DATE != 0) {
			tiOpiExtendedDCS.setPRODUCT_DATE(PRODUCT_DATE);
		}

		if (IS_C_SALE != 0) {
			tiOpiExtendedDCS.setIS_C_SALE(IS_C_SALE);
		}
		tiOpiExtendedDCS.setReleaseStart(releaseStart);
		tiOpiExtendedDCS.setReleaseEnd(releaseEnd);
		tiOpiExtendedDCS.setSalesStart(salesStart);
		tiOpiExtendedDCS.setSalesEnd(salesEnd);

		ExportExcel exportExcel = new ExportExcel();

		List<Map> resultList = productService.exportProduct(tiOpiExtendedDCS);

		Map<String, List<Map>> excelData = new HashMap<String, List<Map>>();
		excelData.put("产品信息表", resultList);

		List<ExcelExportColumn> exportColumnList = new ArrayList<ExcelExportColumn>();

		exportColumnList.add(new ExcelExportColumn("PRODUCT_NO", "产品编号"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_NAME", "产品名称"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_CATEGORY", "产品类别"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_PROPERTY", "产品属性"));
		exportColumnList.add(new ExcelExportColumn("DNP_PRICE", "DNP价格"));
		exportColumnList.add(new ExcelExportColumn("MSRP_PRICE", "MSRP价格"));
		exportColumnList.add(new ExcelExportColumn("RELEASE_STATUS", "发布状态"));
		exportColumnList.add(new ExcelExportColumn("RELEASE_DATE", "发布时间"));
		exportColumnList.add(new ExcelExportColumn("STOP_DATE", "停用时间"));
		exportColumnList.add(new ExcelExportColumn("IS_VALID", "是否有效"));
		exportColumnList.add(new ExcelExportColumn("IS_C_SALE", "是否可销售"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_DATE", "产品有效期"));
		exportColumnList.add(new ExcelExportColumn("PRODUCT_MODEL", "适用车型"));
		exportColumnList.add(new ExcelExportColumn("SALES_DATE", "销售时间"));
		exportExcel.generateExcelForDms(excelData, exportColumnList, "产品信息表.xls", request, response);

		/*
		 * if (resultList != null && resultList.size() > 0) {
		 * 
		 * 
		 * return "1"; } return "0";
		 */
	}

	@RequestMapping(value = "/ajax/getProductList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TiOpiExtendedDCS> getSysProductList(TiOpiExtendedDCS tiOpiExtendedDCS,
			@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize) {
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

		if (tiOpiExtendedDCS.getPRODUCT_CATEGORY() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_CATEGORY())) {
			assist.setRequires(Assist.andLike("PRODUCT_CATEGORY", "%" + tiOpiExtendedDCS.getPRODUCT_CATEGORY() + "%"));
		}
		if (tiOpiExtendedDCS.getPRODUCT_PROPERTY() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_PROPERTY())) {
			assist.setRequires(Assist.andLike("PRODUCT_PROPERTY", "%" + tiOpiExtendedDCS.getPRODUCT_PROPERTY() + "%"));
		}
		int isValid = Integer.parseInt(tiOpiExtendedDCS.getIS_VALID().toString());
		if (isValid != 0) {
			assist.setRequires(Assist.andEq("IS_VALID", isValid));
		}
		int productDate = Integer.parseInt(tiOpiExtendedDCS.getPRODUCT_DATE().toString());
		if (productDate != 0) {
			assist.setRequires(Assist.andEq("PRODUCT_DATE", productDate));
		}
		int releaseStatus = Integer.parseInt(tiOpiExtendedDCS.getRELEASE_STATUS().toString());
		if (releaseStatus != 0) {
			assist.setRequires(Assist.andEq("RELEASE_STATUS", releaseStatus));
		}

		if (tiOpiExtendedDCS.getPRODUCT_MODEL() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_MODEL())) {
			assist.setRequires(Assist.andEq("PRODUCT_MODEL", tiOpiExtendedDCS.getPRODUCT_MODEL()));
		}

		int isCSales = Integer.parseInt(tiOpiExtendedDCS.getIS_C_SALE().toString());
		if (isCSales != 0) {
			assist.setRequires(Assist.andEq("IS_C_SALE", isCSales));
		}

		if (tiOpiExtendedDCS.getReleaseStart() != null && !"".equals(tiOpiExtendedDCS.getReleaseStart())
				&& tiOpiExtendedDCS.getReleaseEnd() != null && !"".equals(tiOpiExtendedDCS.getReleaseEnd())) {
			assist.setRequires(Assist.andLte("RELEASE_DATE", tiOpiExtendedDCS.getReleaseEnd()));
			assist.setRequires(Assist.andGte("RELEASE_DATE", tiOpiExtendedDCS.getReleaseStart()));
		}

		if (tiOpiExtendedDCS.getSalesStart() != null && !"".equals(tiOpiExtendedDCS.getSalesStart())
				&& tiOpiExtendedDCS.getSalesEnd() != null && !"".equals(tiOpiExtendedDCS.getSalesEnd())) {
			assist.setRequires(Assist.andLte("SALES_DATE", tiOpiExtendedDCS.getSalesEnd()));
			assist.setRequires(Assist.andGte("SALES_DATE", tiOpiExtendedDCS.getSalesStart()));
		}

		assist.setOrder("PRODUCT_NO,PRODUCT_ID", true);

		long count = productService.getSysProductRowCount(assist);
		List<TiOpiExtendedDCS> list = productService.selectSysProduct(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}

	@RequestMapping(value = "/ajax/getPartList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TmPartInfo> getPartInfoList(TmPartInfo tmPartInfo, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize) {
		Result<TmPartInfo> result = new Result<TmPartInfo>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (tmPartInfo.getPART_NO() != null && !"".equals(tmPartInfo.getPART_NO())) {
			assist.setRequires(Assist.andLike("PART_NO", "%" + tmPartInfo.getPART_NO() + "%"));
		}

		if (tmPartInfo.getPART_NAME() != null && !"".equals(tmPartInfo.getPART_NAME())) {
			assist.setRequires(Assist.andLike("PART_NAME", "%" + tmPartInfo.getPART_NAME() + "%"));
		}

		if (tmPartInfo.getPART_NAME() != null && !"".equals(tmPartInfo.getPART_NAME())) {
			assist.setRequires(Assist.andLike("PART_NAME", "%" + tmPartInfo.getPART_NAME() + "%"));
		}
		int partStatus = tmPartInfo.getPART_STATUS();
		if (partStatus != 0) {
			assist.setRequires(Assist.andEq("PART_STATUS", tmPartInfo.getPART_STATUS()));
		}
		int partProperty = tmPartInfo.getPART_PROPERTY();
		if (partProperty != 0) {
			assist.setRequires(Assist.andEq("PART_PROPERTY", tmPartInfo.getPART_PROPERTY()));
		}
		int partGroupCode = tmPartInfo.getPART_GROUP_CODE();
		if (partGroupCode != 0) {
			assist.setRequires(Assist.andEq("PART_GROUP_CODE", tmPartInfo.getPART_GROUP_CODE()));
		}

		/*
		 * if(tmPartInfo.getReleaseStart()!= null &&
		 * !"".equals(tmPartInfo.getReleaseStart()) &&
		 * tiOpiExtendedDCS.getReleaseEnd()!= null &&
		 * !"".equals(tiOpiExtendedDCS.getReleaseEnd()) ){
		 * assist.setRequires(Assist.andLte("RELEASE_DATE",
		 * tmPartInfo.getReleaseEnd()));
		 * assist.setRequires(Assist.andGte("RELEASE_DATE",
		 * tmPartInfo.getReleaseStart())); }
		 */

		// assist.setRequires(Assist.andEq("PART_STATUS", 10011001));
		// assist.setRequires(Assist.orEq("PART_STATUS", 12781001));
		assist.setOrder("PART_NO,PART_NAME", true);

		long count = productService.getPartInfoRowCount(assist);
		List<TmPartInfo> list = productService.selectPartInfo(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}

	@RequestMapping(value = "/ajax/toProduct", method = RequestMethod.GET)
	public ModelAndView toProduct(@RequestParam String PART_NO, @RequestParam String PART_NAME,
			@RequestParam String PART_GROUP_CODE, @RequestParam String PART_PROPERTY, @RequestParam String CLAIM_PRICE,
			@RequestParam String LIMIT_PRICE, @RequestParam String IS_SJV, @RequestParam String IS_MOP,
			@RequestParam String IS_C_SALE, @RequestParam String PART_STATUS) {
		TmPartInfoPage tmPartInfoPage = new TmPartInfoPage();
		tmPartInfoPage.setPART_NO(PART_NO);
		tmPartInfoPage.setPART_NAME(PART_NAME);
		tmPartInfoPage.setPART_GROUP_CODE(PART_GROUP_CODE);
		tmPartInfoPage.setPART_PROPERTY(PART_PROPERTY);
		tmPartInfoPage.setCLAIM_PRICE(CLAIM_PRICE);
		tmPartInfoPage.setLIMIT_PRICE(LIMIT_PRICE);
		tmPartInfoPage.setIS_SJV(IS_SJV);
		tmPartInfoPage.setIS_MOP(IS_MOP);
		tmPartInfoPage.setIS_C_SALE(IS_C_SALE);
		tmPartInfoPage.setPART_STATUS(PART_STATUS);

		if ("是".equals(IS_C_SALE)) {
			tmPartInfoPage.setIS_C_SALE_INT(12781001);
		} else {
			tmPartInfoPage.setIS_C_SALE_INT(12781002);
		}

		List<Map> list = productService.getProductOne(tmPartInfoPage);
		if (list.size() > 0) {
			tmPartInfoPage.setPRODUCT_ID(Long.parseLong(list.get(0).get("PRODUCT_ID").toString()));
		} else {
			tmPartInfoPage.setPRODUCT_ID(commonNoService.getId("ID", "999999"));
			productService.insertAndRetuanID(tmPartInfoPage);
		}

		ModelAndView mav = new ModelAndView("sysPage/sysProduct/addProduct");
		mav.addObject("tmPartInfo", tmPartInfoPage);
		return mav;
		// return "include/header";
	}

	@RequestMapping(value = "/ajax/getProductModelList", method = RequestMethod.POST)
	@ResponseBody
	public Result<TmPartInfo> getProductModelList(TiOpiExtendedDCS tiOpiExtendedDCS,
			@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize) {
		Result<TmPartInfo> result = new Result<TmPartInfo>();
		if (tiOpiExtendedDCS.getPRODUCT_ID() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_ID())) {
			Assist assist = new Assist();
			if (null != pageindex && null != pageSize) {
				assist.setStartRow((pageindex - 1) * pageSize);
				assist.setRowSize(pageSize);
			}

			if (tiOpiExtendedDCS.getPRODUCT_ID() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_ID())) {
				assist.setRequires(Assist.andEq("PRODUCT_ID", tiOpiExtendedDCS.getPRODUCT_ID()));
			}

			if (tiOpiExtendedDCS.getPRODUCT_NAME() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_NAME())) {
				assist.setRequires(Assist.andLike("PRODUCT_NAME", "%" + tiOpiExtendedDCS.getPRODUCT_NAME() + "%"));
			}

			if (tiOpiExtendedDCS.getPRODUCT_CATEGORY() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_CATEGORY())) {
				assist.setRequires(Assist.andLike("PRODUCT_CATEGORY", "%" + tiOpiExtendedDCS.getPRODUCT_CATEGORY() + "%"));
			}

			if (tiOpiExtendedDCS.getPRODUCT_PROPERTY() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_PROPERTY())) {
				assist.setRequires(Assist.andLike("PRODUCT_PROPERTY", "%" + tiOpiExtendedDCS.getPRODUCT_PROPERTY() + "%"));
			}

			int productFiat = tiOpiExtendedDCS.getPRODUCT_FAIT();
			if (productFiat != 0) {
				assist.setRequires(Assist.andEq("PRODUCT_FAIT", productFiat));
			}

			int productJeep = tiOpiExtendedDCS.getPRODUCT_JEEP();
			if (productFiat != 0) {
				assist.setRequires(Assist.andEq("PRODUCT_JEEP", productJeep));
			}

			int productCjd = tiOpiExtendedDCS.getPRODUCT_CJD();
			if (productFiat != 0) {
				assist.setRequires(Assist.andEq("PRODUCT_CJD", productCjd));
			}

			/*
			 * double dnpPrice = tiOpiExtendedDCS.getDNP_PRICE();
			 * assist.setRequires(Assist.andEq("DNP_PRICE", dnpPrice)); double msrpPrice =
			 * tiOpiExtendedDCS.getMSRP_PRICE();
			 * assist.setRequires(Assist.andEq("DNP_PRICE", dnpPrice));
			 */

			assist.setOrder("PRODUCT_MODEL_ID,PRODUCT_ID", true);

			long count = productService.getProductModelRowCount(assist);
			List<Map> list = productService.getProductModelList(assist);
			result.setTotalCount(count);
			result.setDataListMap(list);
		}else {
			result.setTotalCount(0);
			result.setDataListMap(null);
		}
		return result;
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

	@RequestMapping(value = "/ajax/searchModel", method = RequestMethod.GET)
	public ModelAndView searchModelPage(@RequestParam String productId) {
		System.out.println(productId + "========进入Model页面=========");
		ModelAndView mav = new ModelAndView("sysPage/sysProduct/addModel");
		mav.addObject("productId", productId);
		return mav;
		// return "include/header";
	}

	// 按车型查询
	@RequestMapping(value = "/ajax/getModelTableList", method = RequestMethod.POST)
	@ResponseBody
	public Result<ModelPage> getModelTableList(ModelPage modelPage, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize) {
		Result<ModelPage> result = new Result<ModelPage>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (modelPage.getBRAND_ID() != null && !"".equals(modelPage.getBRAND_ID())
				&& !"0".equals(modelPage.getBRAND_ID())) {
			assist.setRequires(Assist.andEq("BSM.BRAND_ID", modelPage.getBRAND_ID()));
		}
		if (modelPage.getSERIES_ID() != null && !"".equals(modelPage.getSERIES_ID())
				&& !"0".equals(modelPage.getSERIES_ID())) {
			assist.setRequires(Assist.andEq("BSM.SERIES_ID", modelPage.getSERIES_ID()));
		}
		if (modelPage.getMODEL_ID() != null && !"".equals(modelPage.getMODEL_ID())
				&& !"0".equals(modelPage.getMODEL_ID())) {
			assist.setRequires(Assist.andEq("BSM.MODEL_ID", modelPage.getMODEL_ID()));
		}

		// assist.setOrder("PRODUCT_NO,PRODUCT_ID", true);

		long count = commonNoService.getModelTableRowCount(assist);
		List<ModelPage> list = commonNoService.getModelTableList(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}

	// 按车系查询

	// 按车型查询
	@RequestMapping(value = "/ajax/getSeriesTableList", method = RequestMethod.POST)
	@ResponseBody
	public Result<ModelPage> getSeriesTableList(ModelPage modelPage, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize) {
		Result<ModelPage> result = new Result<ModelPage>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (modelPage.getBRAND_ID() != null && !"".equals(modelPage.getBRAND_ID())
				&& !"0".equals(modelPage.getBRAND_ID())) {
			assist.setRequires(Assist.andEq("BSM.BRAND_ID", modelPage.getBRAND_ID()));
		}
		if (modelPage.getSERIES_ID() != null && !"".equals(modelPage.getSERIES_ID())
				&& !"0".equals(modelPage.getSERIES_ID())) {
			assist.setRequires(Assist.andEq("BSM.SERIES_ID", modelPage.getSERIES_ID()));
		}
		if (modelPage.getMODEL_ID() != null && !"".equals(modelPage.getMODEL_ID())
				&& !"0".equals(modelPage.getMODEL_ID())) {
			assist.setRequires(Assist.andEq("BSM.MODEL_ID", modelPage.getMODEL_ID()));
		}

		// assist.setOrder("PRODUCT_NO,PRODUCT_ID", true);

		long count = commonNoService.getSeriesTableRowCount(assist);
		List<ModelPage> list = commonNoService.getSeriesTableList(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}

	// 添加车型信息
	@RequestMapping(value = "/ajax/addProductModel", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	@ResponseBody
	public String addProductModel(@RequestBody ListDto listDto) {
		System.out.println(JSON.toJSONString(listDto));
		List<ModelPage> modelPageList = listDto.getModelPageList();
		TmPartInfoPage tmPartInfoPage = new TmPartInfoPage();
		if (modelPageList.size() > 0) {
			TiOpiExtendedDCS tiOpiExtendedDCS = new TiOpiExtendedDCS();
			
			for(int i=0;i<modelPageList.size();i++) {
				ModelPage model = new ModelPage();
				// System.out.println(modelPage.getBRAND_ID());
				
				if (modelPageList.get(i).getPRODUCT_ID() != null && !"".equals(modelPageList.get(i).getPRODUCT_ID())) {
					tiOpiExtendedDCS = productService.getProductByID(modelPageList.get(i).getPRODUCT_ID());
				}
				TiOpiExtendedModel tiOpiExtendedModel = new TiOpiExtendedModel();
				
				if (tiOpiExtendedDCS != null) {
					// tiOpiExtendedModel.set
					int modelCount = productService.getProductModel(modelPageList.get(i));
					if (modelCount == 0) {
						tiOpiExtendedModel.setPRODUCT_MODEL_ID(commonNoService.getId("ID", "999999"));
						tiOpiExtendedModel.setPRODUCT_ID(Long.parseLong(modelPageList.get(i).getPRODUCT_ID()));
						tiOpiExtendedModel.setPRODUCT_NO(tiOpiExtendedDCS.getPRODUCT_NO().toString());
						tiOpiExtendedModel.setPRODUCT_NAME(tiOpiExtendedDCS.getPRODUCT_NAME());
						tiOpiExtendedModel.setPRODUCT_PROPERTY(tiOpiExtendedDCS.getPRODUCT_PROPERTY());
						tiOpiExtendedModel.setBRAND_CODE(modelPageList.get(i).getBRAND_CODE());
						tiOpiExtendedModel.setBRAND_NAME(modelPageList.get(i).getBRAND_NAME());
						tiOpiExtendedModel.setSERIES_CODE(modelPageList.get(i).getSERIES_CODE());
						tiOpiExtendedModel.setSERIES_NAME(modelPageList.get(i).getSERIES_NAME());
						tiOpiExtendedModel.setMODEL_CODE(modelPageList.get(i).getMODEL_CODE());
						tiOpiExtendedModel.setMODEL_NAME(modelPageList.get(i).getMODEL_NAME());
						tiOpiExtendedModel.setCREATED_AT(new Date());
						tiOpiExtendedModel.setIS_VALID(12781001);
						tiOpiExtendedModel.setIS_DELETE(0);
						tiOpiExtendedModel.setPRODUCT_CATEGORY(tiOpiExtendedDCS.getPRODUCT_CATEGORY());
						tiOpiExtendedModel.setBRAND_ID(modelPageList.get(i).getBRAND_ID());
						tiOpiExtendedModel.setSERIES_ID(modelPageList.get(i).getSERIES_ID());
						tiOpiExtendedModel.setMODEL_ID(modelPageList.get(i).getMODEL_ID());
						productService.insertProductModel(tiOpiExtendedModel);
					}
					
				}
			}
			tmPartInfoPage.setPART_NO(tiOpiExtendedDCS.getPRODUCT_NO().toString());
			tmPartInfoPage.setPART_NAME(tiOpiExtendedDCS.getPRODUCT_NAME());
			tmPartInfoPage.setPART_GROUP_CODE(tiOpiExtendedDCS.getPRODUCT_CATEGORY());
			tmPartInfoPage.setPART_PROPERTY(tiOpiExtendedDCS.getPRODUCT_PROPERTY());
			tmPartInfoPage.setCLAIM_PRICE(tiOpiExtendedDCS.getDNP_PRICE().toString());
			tmPartInfoPage.setLIMIT_PRICE(tiOpiExtendedDCS.getMSRP_PRICE().toString());
			tmPartInfoPage.setIS_C_SALE(tiOpiExtendedDCS.getIS_C_SALE().toString());
			// tmPartInfoPage.setPART_STATUS(tiOpiExtendedDCS.getPRODUCT_);

			if (tiOpiExtendedDCS.getIS_C_SALE() == 12781001) {
				tmPartInfoPage.setIS_C_SALE("是");
			} else {
				tmPartInfoPage.setIS_C_SALE("否");
			}
			return "0";
		}
		/*ModelAndView mav = new ModelAndView("sysPage/sysProduct/addProduct");
		mav.addObject("tmPartInfoPage", tmPartInfoPage);*/
		return "1";
	}
	
	@RequestMapping(value = "/ajax/modelToProduct", method = RequestMethod.GET)
	public ModelAndView modelToProduct(@RequestParam String productId) {
		System.out.println(productId + "========进入AddProduct页面=========");
		
		TmPartInfoPage tmPartInfoPage = new TmPartInfoPage();
		TiOpiExtendedDCS tiOpiExtendedDCS = productService.getProductByID(productId);
		tmPartInfoPage.setPART_NO(tiOpiExtendedDCS.getPRODUCT_NO().toString());
		tmPartInfoPage.setPART_NAME(tiOpiExtendedDCS.getPRODUCT_NAME());
		tmPartInfoPage.setPART_GROUP_CODE(tiOpiExtendedDCS.getPRODUCT_CATEGORY());
		tmPartInfoPage.setPART_PROPERTY(tiOpiExtendedDCS.getPRODUCT_PROPERTY());
		tmPartInfoPage.setCLAIM_PRICE(tiOpiExtendedDCS.getDNP_PRICE().toString());
		tmPartInfoPage.setLIMIT_PRICE(tiOpiExtendedDCS.getMSRP_PRICE().toString());
		tmPartInfoPage.setPRODUCT_ID(tiOpiExtendedDCS.getPRODUCT_ID());
		if (tiOpiExtendedDCS.getIS_C_SALE() == 12781001) {
			tmPartInfoPage.setIS_C_SALE("是");
		} else {
			tmPartInfoPage.setIS_C_SALE("否");
		}

		ModelAndView mav = new ModelAndView("sysPage/sysProduct/addProduct");
		mav.addObject("tmPartInfo", tmPartInfoPage);
		return mav;
		// return "include/header";
	}
	
	
}
