package com.gacfcasales.common.excel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Charles
 * @Title: ExcelGenerator
 * @Package com.gacfcasales.common.excel
 * @Description: TODO
 * @date 2017/9/28 15:37
 */
public interface ExcelGenerator {
    void generateExcel(@SuppressWarnings("rawtypes") Map<String, List<Map>> excelData, List<ExcelExportColumn> columnDefineList, String fileName, HttpServletRequest request, HttpServletResponse response);

    void generateExcelForDms(@SuppressWarnings("rawtypes") Map<String, List<Map>> excelData, List<ExcelExportColumn> columnDefineList,String fileName,HttpServletRequest request, HttpServletResponse response);

    void generateExcel1(Map<String, List<Map>> excelData, List<Map> columnDefineList ,Map mergedRegion, String fileName,
                        HttpServletRequest request, HttpServletResponse response);

    void generateExcelVertica(Map<String,Map<String, List<Map>>> excelData, Map<String,List<Map>> columnDefineListMap, Map mergedRegion, String fileName, HttpServletRequest request, HttpServletResponse response);

}
