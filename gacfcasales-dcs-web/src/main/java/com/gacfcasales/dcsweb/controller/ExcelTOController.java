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

import com.gacfcasales.common.excel.ExcelExportColumn;
import com.gacfcasales.common.excel.ExportExcel;
import com.gacfcasales.dcsweb.service.ExcelTOService;

@Controller
@RequestMapping("/excelTo")
public class ExcelTOController {
	private static Logger logger = LoggerFactory.getLogger(ExcelTOController.class);
	
	@Autowired ExcelTOService excelDemoService;
	
	@RequestMapping(value="/excel/action",method = RequestMethod.GET)
    public void ExcelCity( HttpServletRequest request,HttpServletResponse response){
        ExportExcel exportExcel = new ExportExcel();
        List<Map> resultList = excelDemoService.findAllAction();
        Map<String, List<Map>> excelData = new HashMap<String, List<Map>>();
        excelData.put("请求列表", resultList);

        List<ExcelExportColumn> exportColumnList = new ArrayList<ExcelExportColumn>();

        exportColumnList.add(new ExcelExportColumn("DEFAULT_ACTION_ID", "主键"));
        exportColumnList.add(new ExcelExportColumn("ACTION_CODE", "操作代码"));
        exportColumnList.add(new ExcelExportColumn("ACTION_NAME", "操作名称"));
        exportColumnList.add(new ExcelExportColumn("ACTION_METHOD", "操作方法"));
        exportColumnList.add(new ExcelExportColumn("MODULE", "模块"));
        exportColumnList.add(new ExcelExportColumn("DESCRIPTION", "描述"));
        exportColumnList.add(new ExcelExportColumn("OWNER", "开发人员"));
        exportColumnList.add(new ExcelExportColumn("CREATED_AT", "创建时间"));
        exportExcel.generateExcelForDms(excelData, exportColumnList, "请求列表.xls", request, response);
    }

    //双层表头导出
    @RequestMapping(value="/excel/double/action",method = RequestMethod.GET)
    public void ExcelDoubleCity( HttpServletRequest request,HttpServletResponse response) throws Exception{
        ExportExcel exportExcel = new ExportExcel();
        List<Map> lstRows = excelDemoService.findAllAction();

        Map<String, Object> mapParam = new HashMap();
        mapParam.put("reportHeader", getReportDetailHeader(false));
        mapParam.put("reportTopHeader", getReportTopHeader(false));
        mapParam.put("reportName", "请求列表(双层)");
        Map<String, List<Map>> excelData = getExcelData("请求列表(双层)", lstRows);
        List<Map> exportColumnList = getExcelColumns(mapParam);
        Map mergedRegion = exportColumnList.get(2);
        exportExcel.generateExcel1(excelData, exportColumnList, mergedRegion, "城市列表(双层).xls", request, response);
    }

    /**
     *
     * @param sheetName
     * @param lstData
     * @return
     */
    private Map<String, List<Map>> getExcelData(String sheetName, List<Map> lstData) {
        Map<String, List<Map>> result = new HashMap();
        result.put(sheetName, lstData);
        return result;
    }

    //@SuppressWarnings({ "unchecked" })
    private List<Map> getExcelColumns(Map<String, Object> mapParam) throws Exception {
        String[] topHeader = (String[]) mapParam.get("reportTopHeader");
        String[] secHeader = (String[]) mapParam.get("reportHeader");

        List<Map> list = new ArrayList();

        Map<String, List<ExcelExportColumn>> map1 = new HashMap<String, List<ExcelExportColumn>>();
        Map<String, List<ExcelExportColumn>> map2 = new HashMap<String, List<ExcelExportColumn>>();
        Map map3 = new HashMap();

        List<ExcelExportColumn> exportColumnList1 = new ArrayList<ExcelExportColumn>();
        List<ExcelExportColumn> exportColumnList2 = new ArrayList<ExcelExportColumn>();
        List<int[]> list1 = new ArrayList<int[]>();

        int i = 0;
        int idx = 0;
        int col = 0;
        while (i < topHeader.length) {
            String strCnt = topHeader[i+1];
            int cnt = Integer.parseInt(strCnt);
            if (cnt > 1) {
                for (int j = 0 ; j < cnt; j++) {
                    exportColumnList1.add(new ExcelExportColumn(secHeader[idx+1], topHeader[i]));
                    exportColumnList2.add(new ExcelExportColumn("", secHeader[idx]));
                    idx += 2;
                }
                list1.add(new int[]{0,0,col,col + cnt - 1});
                col = col + cnt;
            } else {
                exportColumnList1.add(new ExcelExportColumn(secHeader[idx+1], topHeader[i]));
                exportColumnList2.add(new ExcelExportColumn("", secHeader[idx]));
                list1.add(new int[]{0,1,col,col});
                col++;
                idx+=2;
            }
            i+=2;
        }

        map1.put(mapParam.get("reportName").toString(), exportColumnList1);
        map2.put(mapParam.get("reportName").toString(), exportColumnList2);
        map3.put(mapParam.get("reportName").toString(), list1);

        list.add(map1);
        list.add(map2);
        list.add(map3);
        return list;
    }

    private static String[] getReportDetailHeader(boolean isDetail) {
        String[] r = new String[] {"主键", "DEFAULT_ACTION_ID", "操作代码", "ACTION_CODE",
                "操作名称", "ACTION_NAME", "操作方法", "ACTION_METHOD","模块","MODULE","描述","DESCRIPTION",
                "OWNER", "开发人员", "创建时间","CREATED_AT"};

        return r;
    }

    private static String[] getReportTopHeader(boolean isDetail) {
        String[] r = new String[] {"主键", "1", "操作", "3", "模块", "1", "描述", "1", "开发人员", "1", "创建时间", "1" };
        return r;
    }
}
