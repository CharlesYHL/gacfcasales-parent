package com.gacfcasales.common.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gacfcasales.common.exception.ServiceBizException;
import com.gacfcasales.common.exception.UtilException;
import com.gacfcasales.common.util.CommonUtils;
import com.gacfcasales.common.util.FrameHttpUtil;
import com.gacfcasales.common.util.IOUtils;
import com.gacfcasales.common.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Charles
 * @Title: ExportExcel
 * @Package com.yhs.example.core.Excel
 * @Description: TODO
 * @date 2017/9/28 17:34
 */
public class ExportExcel {
    // 定义日志接口
    private static final Logger logger = LoggerFactory.getLogger(ExcelGeneratorDefaultImpl.class);

    public void generateExcel(Map<String, List<Map>> excelData, List<ExcelExportColumn> columnDefineList, String fileName, HttpServletRequest request, HttpServletResponse response) {
        // 如果excelData 中没有数据，则返回错误
        if (CommonUtils.isNullOrEmpty(excelData)) {
            throw new ServiceBizException("No excel data !");
        }

        Workbook workbook = null;
        OutputStream outputStream = null;
        try {
            // 初始化输出流
            outputStream = initOutputStream(request,response, fileName);
            // 初始化workbook
            workbook = createWorkbook(fileName);

            Set<String> sheetSet = excelData.keySet();
            for (String sheetName : sheetSet) {
                @SuppressWarnings("rawtypes")
                List<Map> rowList = excelData.get(sheetName);
                // 创建sheet 页
                Sheet sheet = workbook.createSheet(sheetName);

                // 生成标题
                generateTitleRow(sheet, columnDefineList);

                // 生成数据
                generateDataRows(sheet, rowList, columnDefineList);

                //当数据加载完成后设置sheet 格式
                setSheetFinishStyle(sheet,columnDefineList.size());

            }

            workbook.write(outputStream);
        } catch (Exception exception) {
            logger.warn(exception.getMessage(), exception);
            throw new ServiceBizException(exception.getMessage(), exception);
        } finally {
            IOUtils.closeStream(workbook);
            IOUtils.closeStream(outputStream);
        }

    }

    public void generateExcelForDms(Map<String, List<Map>> excelData, List<ExcelExportColumn> columnDefineList, String fileName, HttpServletRequest request, HttpServletResponse response) {
        // 如果excelData 中没有数据，则返回错误
        if (CommonUtils.isNullOrEmpty(excelData)) {
            throw new ServiceBizException("No excel data !");
        }

        Workbook workbook = null;
        OutputStream outputStream = null;
        try {
            // 初始化输出流
            outputStream = initOutputStream(request,response, fileName);
            // 初始化workbook
            workbook = createWorkbook(fileName);

            Set<String> sheetSet = excelData.keySet();
            for (String sheetName : sheetSet) {
                @SuppressWarnings("rawtypes")
                List<Map> rowList = excelData.get(sheetName);
                // 创建sheet 页
                Sheet sheet = workbook.createSheet(sheetName);

                // 生成标题
                generateTitleRowForDms(sheet, columnDefineList,fileName);

                // 生成数据
                generateDataRowsForDms(sheet, rowList, columnDefineList);

                //当数据加载完成后设置sheet 格式
                setSheetFinishStyle(sheet,columnDefineList.size());

            }

            workbook.write(outputStream);
        } catch (Exception exception) {
            logger.warn(exception.getMessage(), exception);
            throw new ServiceBizException(exception.getMessage(), exception);
        } finally {
            IOUtils.closeStream(workbook);
            IOUtils.closeStream(outputStream);
        }
    }

    public void generateExcel1(Map<String, List<Map>> excelData, List<Map> columnDefineList, Map mergedRegion, String fileName, HttpServletRequest request, HttpServletResponse response) {
        // 如果excelData 中没有数据，则返回错误
        if (CommonUtils.isNullOrEmpty(excelData)) {
            throw new ServiceBizException("No excel data !");
        }

        Workbook workbook = null;
        OutputStream outputStream = null;
        try {
            // 初始化输出流
            outputStream = initOutputStream(request,response, fileName);
            // 初始化workbook
            workbook = createWorkbook(fileName);

            Map<String, List<ExcelExportColumn>> columnDefineListMap1 = columnDefineList.get(0);
            Map<String, List<ExcelExportColumn>> columnDefineListMap2 = columnDefineList.get(1);

            Set<String> sheetSet = excelData.keySet();
            for (String sheetName : sheetSet) {

                List<Map> rowList = excelData.get(sheetName);
                int freeLine = 0;
                // 创建sheet 页
                Sheet sheet = workbook.createSheet(sheetName);
                Set<String> colSet = columnDefineListMap2.keySet();
                for (String col : colSet) {
                    if(col.equals(sheetName)){
                        // 生成标题
                        int count = 0;
                        for (int i = 0; i < columnDefineList.size()-1; i++) {
                            Map<String, List<ExcelExportColumn>> columnDefineListMap = columnDefineList.get(i);
                            generateTitleRows(sheet, columnDefineListMap.get(col), count);
                            count++;
                        }
//                		generateTitleRows(sheet, columnDefineListMap2.get(col), 1);

                        List<int[]> list = (List<int[]>) mergedRegion.get(col);
                        for (int i = 0; i < list.size(); i++) {
                            int[] flag = list.get(i);
                            if(freeLine<flag[1]){
                                freeLine = flag[1];
                            }
                        }
                        addMergedRegion(sheet, list);

                        // 生成数据
                        generateDataRows(sheet, rowList, columnDefineListMap1.get(col),2);
                    }
                }

                //当数据加载完成后设置sheet 格式
                setSheetFinishStyles(sheet,columnDefineListMap1.size(),freeLine+1);

            }

            workbook.write(outputStream);
        } catch (Exception exception) {
            logger.warn(exception.getMessage(), exception);
            throw new ServiceBizException(exception.getMessage(), exception);
        } finally {
            IOUtils.closeStream(workbook);
            IOUtils.closeStream(outputStream);
        }

    }

    public void generateExcelVertica(Map<String, Map<String, List<Map>>> excelData, Map<String, List<Map>> columnDefineListMap, Map mergedRegion, String fileName, HttpServletRequest request, HttpServletResponse response) {
        // 如果excelData 中没有数据，则返回错误
        if (CommonUtils.isNullOrEmpty(excelData)) {
            throw new ServiceBizException("No excel data !");
        }

        Workbook workbook = null;
        OutputStream outputStream = null;
        try {
            // 初始化输出流
            outputStream = initOutputStream(request,response, fileName);
            // 初始化workbook
            workbook = createWorkbook(fileName);


            Set<String> sheetSet = excelData.keySet();
            //循环生成Sheet页
            for (String sheetName : sheetSet) {
                Sheet sheet = workbook.createSheet(sheetName);
                //循环生成标题
                Map<String, List<Map>> excelDataList = excelData.get(sheetName);
                int rowNum =0;
                List<Map> columnDefineList = columnDefineListMap.get(sheetName);
                for (int j = 0; j < columnDefineList.size(); j++) {
                    //循环生成
                    Map<String, List<ExcelExportColumn>> columnDefine = columnDefineList.get(j);
                    Set<String> keys = columnDefine.keySet();
                    for (String key:keys) {
                        //循环纵向表头
                        generateTitleRows(sheet, columnDefine.get(key),rowNum);
                        rowNum++;
                        List<Map> excelList = excelDataList.get(key);
                        List<int[]> list = (List<int[]>) mergedRegion.get(key);
                        if(null!=excelList && excelList.size()>0){
                            //存在该表头的数据进行数据输出
                            generateDataRows(sheet, excelList, columnDefine.get(key),rowNum);
                            rowNum = rowNum+excelList.size();
                        }
                        addMergedRegion(sheet, list);
                    }
                    setSheetFinishStyles(sheet,columnDefine.size());
                }
            }

            workbook.write(outputStream);
        } catch (Exception exception) {
            logger.warn(exception.getMessage(), exception);
            throw new ServiceBizException(exception.getMessage(), exception);
        } finally {
            IOUtils.closeStream(workbook);
            IOUtils.closeStream(outputStream);
        }
    }


    /**
     * 初始化输出流
     *
     * @author Charles
     * @date 2016年9月28日
     * @param response
     * @param fileName
     * @return
     * @throws IOException
     */
    private OutputStream initOutputStream(HttpServletRequest request,HttpServletResponse response, String fileName) throws UtilException {
        try {
            FrameHttpUtil.setExportFileName(request,response, fileName);
            return response.getOutputStream();
        } catch (Exception e) {
            throw new UtilException("excel 流初始化失败", e);
        }
    }

    /**
     * 创建workbook
     *
     * @author Charles
     * @date 2016年9月28日
     * @return
     */
    private Workbook createWorkbook(String fileName) {
        Workbook workbook = null;
        if("xls".equals(fileName.substring(fileName.lastIndexOf(".")+1))){
            workbook = new HSSFWorkbook();
        }else{
            workbook = new XSSFWorkbook();
        }
        return workbook;
    }

    /**
     * 生成标题
     *
     * @author zhangxc
     * @date 2016年9月28日
     * @param sheet
     * @param
     * @param
     */
    private void generateTitleRow(Sheet sheet, List<ExcelExportColumn> columnDefineList) {
        // 生成标题
        Row row = sheet.createRow(0);
        CellStyle cellStyle = getSheetTitleStyle(sheet.getWorkbook());
        // 生成标题
        for (int i=0; i<columnDefineList.size();i++) {
            Cell cell = row.createCell(i);
            //生成标题的信息
            createStringCell(columnDefineList.get(i).getTitle(),cell,cellStyle);
        }
    }

    /**
     * 生成一行
     *
     * @author Charles
     * @date 2016年7月20日
     * @param sheet
     * @param rowList
     */
    protected void generateDataRows(final Sheet sheet, @SuppressWarnings("rawtypes") final List<Map> rowList,
                                    final List<ExcelExportColumn> columnDefineList) {
        if (CommonUtils.isNullOrEmpty(rowList)) {
            return;
        }
        //确定excel 每一列的格式化样式
        Map<Integer,CellStyle> columnCellStyle = new HashMap<Integer,CellStyle>();

        // 生成数据
        for (int i = 0; i < rowList.size(); i++) {
            @SuppressWarnings("rawtypes")
            final Map cellList = rowList.get(i);
            //生成一行
            Row row = sheet.createRow((i+1));
            for (int j = 0; j < columnDefineList.size(); j++) {
                createCell(cellList.get(columnDefineList.get(j).getFieldName()),row,j,columnCellStyle,columnDefineList.get(j));
            }
        }
    }

    /**
     * 设置excel 的字段
     *
     * @author zhangxc
     * @date 2016年9月28日
     * @param workbook
     */
    private CellStyle getSheetTitleStyle(Workbook workbook) {
        //修改字段样式
        Font font = getDefaultFont(workbook);
        font.setFontHeightInPoints((short) 12); // 字体高度
        font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 宽度

        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     *
     * 获得默认的字体
     * @author zhangxc
     * @date 2016年9月28日
     * @return
     */
    private Font getDefaultFont(Workbook workbook){
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 10); // 字体高度
        font.setColor(Font.COLOR_NORMAL); // 字体颜色
        font.setFontName("微软雅黑"); // 字体
        // font.setItalic(true); //是否使用斜体
        return font;
    }

    /**
     *
     * 获得默认的字体
     * @author Charles
     * @date 2016年9月28日
     * @return
     */
    private CellStyle getDefaultCellStyle(Workbook workbook){
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT); // 水平布局：居中
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//上下居中
        cellStyle.setBorderTop(CellStyle.BORDER_THIN); //设置边框
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);   //设置边框
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);    //设置边框
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);   //设置边框
        cellStyle.setWrapText(false);
        return cellStyle;
    }


    /**
     *
     * 创建一个单元格
     * @author zhangxc
     * @date 2016年9月28日
     * @param cellValue
     * @param row
     * @param cellIndex
     * @param
     */
    private void createCell(Object cellValue,Row row,int cellIndex,Map<Integer,CellStyle> columnCellStyle,ExcelExportColumn excelExportColumn){
        Cell cell = row.createCell(cellIndex);

        //如果是空值
        if(cellValue == null){
            if(columnCellStyle.get(-1)==null){
                //放入字符串样式,使用-1 作为空值的判断依据
                columnCellStyle.put(-1, getSheetStringStyle(row.getSheet().getWorkbook()));
            }
            cell.setCellStyle(columnCellStyle.get(-1));
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue((String)cellValue);
            return;
        }
        //设置字符串类型
        if(cellValue instanceof String) {
            if(excelExportColumn.getDataType()!=null){
                if(columnCellStyle.get(cellIndex)==null){
                    columnCellStyle.put(cellIndex, getSheetStringStyle(row.getSheet().getWorkbook()));
                }
                cell.setCellStyle(columnCellStyle.get(cellIndex));
                cell.setCellType(Cell.CELL_TYPE_STRING);
                //设置ID 对应的名称
                cell.setCellValue(getNamesByCodes((String)cellValue,excelExportColumn.getDataType()));
            }else{
                if(columnCellStyle.get(cellIndex)==null){
                    //放入字符串样式
                    columnCellStyle.put(cellIndex, getSheetStringStyle(row.getSheet().getWorkbook()));
                }
                cell.setCellStyle(columnCellStyle.get(cellIndex));
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue((String)cellValue);
            }
            return;
        }

        //设置Double 类型
        if(cellValue instanceof Double||cellValue instanceof BigDecimal) {
            if(columnCellStyle.get(cellIndex)==null){
                columnCellStyle.put(cellIndex, getSheetDoubleStyle(row.getSheet().getWorkbook(),excelExportColumn.getFormat()));
            }
            cell.setCellStyle(columnCellStyle.get(cellIndex));
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            if(cellValue instanceof BigDecimal){
                cell.setCellValue(((BigDecimal)cellValue).doubleValue());
            }else{
                cell.setCellValue((Double)cellValue);
            }
            return;
        }

        //设置整形格式
        if(cellValue instanceof Integer||cellValue instanceof Long) {
            if(excelExportColumn.getDataType()!=null){
                if(columnCellStyle.get(cellIndex)==null){
                    columnCellStyle.put(cellIndex, getSheetCodeDescStyle(row.getSheet().getWorkbook()));
                }
                cell.setCellStyle(columnCellStyle.get(cellIndex));
                cell.setCellType(Cell.CELL_TYPE_STRING);
                //设置ID 对应的名称
                cell.setCellValue(getNameByCode((Number)cellValue,excelExportColumn.getDataType()));
            }else{
                if(columnCellStyle.get(cellIndex)==null){
                    columnCellStyle.put(cellIndex, getSheetIntegerStyle(row.getSheet().getWorkbook(),excelExportColumn.getFormat()));
                }
                cell.setCellStyle(columnCellStyle.get(cellIndex));
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                if(cellValue instanceof Integer){
                    cell.setCellValue((Integer)cellValue);
                }else{
                    cell.setCellValue((Long) cellValue);
                }
            }
            return;
        }

        //设置日期格式
        if(cellValue instanceof Date) {
            if(columnCellStyle.get(cellIndex)==null){
                //放入日期格式
                columnCellStyle.put(cellIndex, getSheetDateStyle(row.getSheet().getWorkbook(),excelExportColumn.getFormat()));
            }
            cell.setCellStyle(columnCellStyle.get(cellIndex));
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue((Date)cellValue);
            return;
        }
    }

    /**
     *
     * 获得日期格式的样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param workbook
     * @return
     */
    private CellStyle getSheetStringStyle(Workbook workbook) {
        //修改字段样式
        Font font = getDefaultFont(workbook);
        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);

        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     *
     * 根据代码获得名称,代码存储为：1001001,10011002 ,用","分隔的代码
     * @author zhangxc
     * @date 2016年9月28日
     * @param value
     * @param excelDataType
     * @return
     */
   /* private String getNamesByCodes(String values,ExcelDataType excelDataType){
        String[] valuesArray = values.split(",");
        StringBuilder sb = new StringBuilder();
        for(String value:valuesArray){
            if(!StringUtils.isNullOrEmpty(value)){
                sb.append(getNameByCode(Long.parseLong(value),excelDataType)).append(",");
            }
        }
        if(sb.length()>0){
            return sb.substring(0, sb.length()-1);
        }else{
            return "";
        }
    }*/

    /**
     *
     * 获得日期格式的样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param workbook
     * @return
     */
    private CellStyle getSheetDateStyle(Workbook workbook,String format) {
        //如果format 未指定，则使用yyyy-MM-dd
        format = format==null?"yyyy-MM-dd":format;
        //修改字段样式
        Font font = getDefaultFont(workbook);
        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        //格式化样式
        DataFormat dataFormat = workbook.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat(format));
        return cellStyle;
    }

    /**
     *
     * 获得日期格式的样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param workbook
     * @return
     */
    private CellStyle getSheetDoubleStyle(Workbook workbook,String format) {
        //如果format 未指定，则使用yyyy-MM-dd
        format = format==null?"#,##0.00##":format;
        //修改字段样式
        Font font = getDefaultFont(workbook);
        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);
        cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
        cellStyle.setFont(font);
        //格式化样式
        DataFormat dataFormat = workbook.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat(format));
        return cellStyle;
    }

    /**
     *
     * 获得日期格式的样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param workbook
     * @return
     */
    private CellStyle getSheetCodeDescStyle(Workbook workbook) {
        //修改字段样式
        Font font = getDefaultFont(workbook);
        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     *
     * 获得日期格式的样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param workbook
     * @return
     */
    private CellStyle getSheetIntegerStyle(Workbook workbook,String format) {
        //如果format 未指定，则使用yyyy-MM-dd
        format = format==null?"#,##0":format;
        //修改字段样式
        Font font = getDefaultFont(workbook);
        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);
        cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
        cellStyle.setFont(font);
        //格式化样式
        DataFormat dataFormat = workbook.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat(format));
        return cellStyle;
    }

    private String getNameByCode(Number value,ExcelDataType excelDataType){
        if(excelDataType==ExcelDataType.Dict&& value.toString().length()==8){
            return value.toString();
        }
        if(excelDataType==ExcelDataType.Oem_Dict){
            if(null!=value && value.toString().length()==8 ){
                return value.toString();
            }else{
                if(value!= null &&value.toString().length()>0 && Integer.parseInt(value.toString())!=0){
                    BigDecimal bd = new BigDecimal(Double.parseDouble(value.toString()));
                    String code = bd.toPlainString().substring(0,bd.toPlainString().indexOf("."));
                    return code;
                }else {
                    return "";
                }
            }
        }
        //如果是省份城市
        if(excelDataType==ExcelDataType.Region_Provice){
            return value.toString();
        }
        //如果是城市
        if(excelDataType==ExcelDataType.Region_City){
            return value.toString();
        }
        //如果是区县
        if(excelDataType==ExcelDataType.Region_Country){
            return value.toString();
        }
        return null;
    }
    /**
     *
     * 根据代码获得名称,代码存储为：1001001,10011002 ,用","分隔的代码
     * @author Charles
     * @date 2016年9月28日
     * @param
     * @param excelDataType
     * @return
     */
    private String getNamesByCodes(String values,ExcelDataType excelDataType){
        String[] valuesArray = values.split(",");
        StringBuilder sb = new StringBuilder();
        for(String value:valuesArray){
            if(!StringUtils.isNullOrEmpty(value)){
                sb.append(getNameByCode(Long.parseLong(value),excelDataType)).append(",");
            }
        }
        if(sb.length()>0){
            return sb.substring(0, sb.length()-1);
        }else{
            return "";
        }
    }

    /**
     *
     * 创建字符串类型
     * @author Charles
     * @date 2016年9月28日
     * @param cellValue
     * @param cell
     * @param cellstyle
     */
    private void createStringCell(Object cellValue,Cell cell,CellStyle cellstyle){
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellStyle(cellstyle);
        cell.setCellValue((String)cellValue);
    }

    /**
     *
     * 当sheet 页加载完成后，设置sheet 面的样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param sheet
     */
    private void setSheetFinishStyle(Sheet sheet,int colSize){
        //设置字段宽度
        for(int i=0;i<colSize;i++){
            sheet.autoSizeColumn((short)i);
        }

        //冻结首行
        sheet.createFreezePane(0, 1, 0, 1);
    }

    /**
     *
     * @param sheet
     * @param columnDefineList
     * @param line
     */
    private void generateTitleRows(Sheet sheet, List<ExcelExportColumn> columnDefineList,int line) {
        // 生成标题
        Row row = sheet.createRow(line);
        CellStyle cellStyles = getSheetTitleStyle(sheet.getWorkbook());
        // 生成标题
        for (int i=0; i<columnDefineList.size();i++) {
            Cell cell = row.createCell(i);
            //生成标题的信息
            createStringCell(columnDefineList.get(i).getTitle(),cell,cellStyles);
        }
    }

    /**
     *
     * @param sheet
     * @param rowList
     * @param columnDefineList
     * @param addLine 加的行数
     */
    protected void generateDataRows(final Sheet sheet, @SuppressWarnings("rawtypes") final List<Map> rowList,
                                    final List<ExcelExportColumn> columnDefineList, int addLine) {
        if (CommonUtils.isNullOrEmpty(rowList)) {
            return;
        }
        //确定excel 每一列的格式化样式
        Map<Integer,CellStyle> columnCellStyle = new HashMap<Integer,CellStyle>();

        // 生成数据
        for (int i = 0; i < rowList.size(); i++) {
            @SuppressWarnings("rawtypes")
            final Map cellList = rowList.get(i);
            //生成一行
            Row row = sheet.createRow((i+addLine));
            for (int j = 0; j < columnDefineList.size(); j++) {
                createCell(cellList.get(columnDefineList.get(j).getFieldName()),row,j,columnCellStyle,columnDefineList.get(j));
            }
        }
    }
    public void addMergedRegion(Sheet sheet, List<int[]> list){
        for (int[] i : list) {
            sheet.addMergedRegion(new CellRangeAddress(i[0], i[1], i[2], i[3]));
        }
    }
    /**
     *
     * 当sheet 页加载完成后，设置sheet 面的样式   不冻结行
     * @author zhangxc
     * @date 2016年9月28日
     * @param sheet
     */
    private void setSheetFinishStyles(Sheet sheet,int colSize){
        //设置字段宽度
        for(int i=0;i<colSize;i++){
            sheet.autoSizeColumn((short)i);
        }
    }

    /**
     * 生成标题
     *
     * @author zhangxc
     * @date 2016年9月28日
     * @param sheet
     * @param
     * @param
     */
    private void generateTitleRowForDms(Sheet sheet, List<ExcelExportColumn> columnDefineList,String fileName) {
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
        //String id = FrameworkUtil.getLoginInfo().getUserName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = dateFormat.format( new Date()  );
        String title = fileName.substring(fileName.indexOf("_")+1, fileName.lastIndexOf("."));
        HSSFRow row1 = (HSSFRow) sheet.createRow(0);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue(title);

        HSSFRow row2 = (HSSFRow) sheet.createRow(1);
        HSSFCell cell2 = row2.createCell(0);
        HSSFCell cell3 = row2.createCell(1);
        HSSFCell cell4 = row2.createCell(2);
        HSSFCell cell5 = row2.createCell(3);
        cell2.setCellValue("导出日期:");
        cell3.setCellValue(time);
       /* cell4.setCellValue("导出人:");
        cell5.setCellValue(id);*/

        // 生成标题
        Row row = sheet.createRow(3);
        CellStyle cellStyle = getSheetTitleStyleForDms(sheet.getWorkbook());
        // 生成标题
        for (int i=0; i<columnDefineList.size();i++) {
            Cell cell = row.createCell(i);
            //生成标题的信息
            createStringCell(columnDefineList.get(i).getTitle(),cell,cellStyle);
        }
        CellStyle cellStyle1 = getTitleStyle(sheet.getWorkbook());

        cell1.setCellStyle(cellStyle1);
    }
    /**
     * 设置excel 的字段
     *
     * @author zhangxc
     * @date 2016年9月28日
     * @param workbook
     */
    private CellStyle getSheetTitleStyleForDms(Workbook workbook) {
        //修改字段样式
        Font font = getDefaultFont(workbook);
        font.setFontHeightInPoints((short) 12); // 字体高度
        font.setBoldweight(Font.BOLDWEIGHT_NORMAL); // 宽度

        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * 设置Excel标题格式
     * @param workbook
     * @return
     */
    private CellStyle getTitleStyle(Workbook workbook) {
        //修改字段样式
        Font font = getDefaultFont(workbook);
        font.setFontHeightInPoints((short) 12); // 字体高度
        font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 宽度

        //修改默认单元格样式
        CellStyle cellStyle = getDefaultCellStyle(workbook);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        return cellStyle;
    }


    /**
     * 生成一行for dms
     *
     * @author zhangxc
     * @date 2016年7月20日
     * @param sheet
     * @param rowList
     */
    protected void generateDataRowsForDms(final Sheet sheet, @SuppressWarnings("rawtypes") final List<Map> rowList,
                                          final List<ExcelExportColumn> columnDefineList) {
        if (CommonUtils.isNullOrEmpty(rowList)) {
            return;
        }
        //确定excel 每一列的格式化样式
        Map<Integer,CellStyle> columnCellStyle = new HashMap<Integer,CellStyle>();

        // 生成数据
        for (int i = 0; i < rowList.size(); i++) {
            @SuppressWarnings("rawtypes")
            final Map cellList = rowList.get(i);
            //生成一行
            Row row = sheet.createRow((i+4));
            for (int j = 0; j < columnDefineList.size(); j++) {
                createCell(cellList.get(columnDefineList.get(j).getFieldName()),row,j,columnCellStyle,columnDefineList.get(j));
            }
        }
    }

    /**
     *
     * 当sheet 页加载完成后，设置sheet 面的样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param sheet
     */
    private void setSheetFinishStyles(Sheet sheet,int colSize,int FreeLine){
        //设置字段宽度
        for(int i=0;i<colSize;i++){
            sheet.autoSizeColumn((short)i);
        }

        //冻结首行
        sheet.createFreezePane(0, FreeLine, 0, FreeLine);
    }
}
