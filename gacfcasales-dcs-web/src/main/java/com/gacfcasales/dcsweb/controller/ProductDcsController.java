package com.gacfcasales.dcsweb.controller;

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
import com.gacfcasales.common.entity.SysResource;
import com.gacfcasales.common.entity.TiOpiExtendedDCS;
import com.gacfcasales.common.excel.ExcelExportColumn;
import com.gacfcasales.common.excel.ExportExcel;
import com.gacfcasales.dcsweb.service.ProductService;

@Controller
@RequestMapping("/sysProduct")
public class ProductDcsController {
	private static Logger logger = LoggerFactory.getLogger(ProductDcsController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String  toProductListPage(){
		System.out.println("========进入页面=========");
		return "sysPage/sysProduct/list";
	}
	
	@RequestMapping(value="/ajax/addProduct",method=RequestMethod.GET)
	public String  toAddProductPage(){
		System.out.println("========进入新增页面=========");
		return "sysPage/sysProduct/addProduct";
		//return "include/header";
	}
	
	@RequestMapping(value="/ajax/productExcel",method = RequestMethod.GET)
	public void ProductExcel(TiOpiExtendedDCS tiOpiExtendedDCS,HttpServletRequest request,HttpServletResponse response){
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
	
	
	@RequestMapping(value="/ajax/getProductList",method=RequestMethod.POST)
	@ResponseBody
	public Result<TiOpiExtendedDCS> getSysProductList(TiOpiExtendedDCS tiOpiExtendedDCS,@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize){
		Result<TiOpiExtendedDCS> result = new Result<TiOpiExtendedDCS>();
		Assist assist = new Assist();
		if(null != pageindex && null != pageSize){
			assist.setStartRow((pageindex-1) * pageSize);
			assist.setRowSize(pageSize);
		}
		
		if(tiOpiExtendedDCS.getPRODUCT_NO() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_NO())){
			assist.setRequires(Assist.andLike("PRODUCT_NO", "%"+tiOpiExtendedDCS.getPRODUCT_NO()+"%"));
		}
		
		if(tiOpiExtendedDCS.getPRODUCT_NAME() != null && !"".equals(tiOpiExtendedDCS.getPRODUCT_NAME())){
			assist.setRequires(Assist.andLike("PRODUCT_NAME", "%"+tiOpiExtendedDCS.getPRODUCT_NAME()+"%"));
		}
		
		if(tiOpiExtendedDCS.getPRODUCT_CATEGORY()!= null && !"".equals(tiOpiExtendedDCS.getPRODUCT_CATEGORY())){
			assist.setRequires(Assist.andLike("PRODUCT_CATEGORY", "%"+tiOpiExtendedDCS.getPRODUCT_CATEGORY()+"%"));
		}
		if(tiOpiExtendedDCS.getPRODUCT_PROPERTY()!= null && !"".equals(tiOpiExtendedDCS.getPRODUCT_PROPERTY())){
			assist.setRequires(Assist.andLike("PRODUCT_PROPERTY", "%"+tiOpiExtendedDCS.getPRODUCT_PROPERTY()+"%"));
		}
		int isValid = Integer.parseInt(tiOpiExtendedDCS.getIS_VALID().toString());
		if(isValid != 0) {
			assist.setRequires(Assist.andEq("IS_VALID", isValid));
		}
		int productDate = Integer.parseInt(tiOpiExtendedDCS.getPRODUCT_DATE().toString());
		if(productDate != 0) {
			assist.setRequires(Assist.andEq("PRODUCT_DATE", productDate));
		}
		int releaseStatus = Integer.parseInt(tiOpiExtendedDCS.getRELEASE_STATUS().toString());
		if(releaseStatus != 0) {
			assist.setRequires(Assist.andEq("RELEASE_STATUS", releaseStatus));
		}
		
		if(tiOpiExtendedDCS.getPRODUCT_MODEL()!= null && !"".equals(tiOpiExtendedDCS.getPRODUCT_MODEL())){
			assist.setRequires(Assist.andEq("PRODUCT_MODEL", tiOpiExtendedDCS.getPRODUCT_MODEL()));
		}
		
		int isCSales = Integer.parseInt(tiOpiExtendedDCS.getIS_C_SALE().toString());
		if(isCSales != 0) {
			assist.setRequires(Assist.andEq("IS_C_SALE", isCSales));
		}
		
		if(tiOpiExtendedDCS.getReleaseStart()!= null && !"".equals(tiOpiExtendedDCS.getReleaseStart()) && tiOpiExtendedDCS.getReleaseEnd()!= null && !"".equals(tiOpiExtendedDCS.getReleaseEnd()) ){
			assist.setRequires(Assist.andLte("RELEASE_DATE", tiOpiExtendedDCS.getReleaseEnd()));
			assist.setRequires(Assist.andGte("RELEASE_DATE", tiOpiExtendedDCS.getReleaseStart()));
		}
		
		if(tiOpiExtendedDCS.getSalesStart()!= null && !"".equals(tiOpiExtendedDCS.getSalesStart()) && tiOpiExtendedDCS.getSalesEnd()!= null && !"".equals(tiOpiExtendedDCS.getSalesEnd()) ){
			assist.setRequires(Assist.andLte("SALES_DATE", tiOpiExtendedDCS.getSalesEnd()));
			assist.setRequires(Assist.andGte("SALES_DATE", tiOpiExtendedDCS.getSalesStart()));
		}
		
		assist.setOrder("PRODUCT_NO,PRODUCT_ID", true);
		
		long count = productService.getSysProductRowCount(assist);
		List<TiOpiExtendedDCS> list =  productService.selectSysProduct(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}
	
}
