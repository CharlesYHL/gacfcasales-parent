package com.gacfcasales.common.excel;

/**
 * @author Charles
 * @Title: ExcelExportColumn
 * @Package com.gacfcasales.common.excel
 * @Description: TODO
 * @date 2017/9/28 15:39
 */
public class ExcelExportColumn {
    private String fieldName;
    private String title;
    private String format;
    private ExcelDataType dataType;


    /**
     *
     * 默认构造函数
     * @author zhangxc
     * @date 2016年9月28日
     * @param fieldName
     * @param title
     */
    public ExcelExportColumn(String fieldName,String title){
        this.fieldName = fieldName;
        this.title = title;
    }

    /**
     *
     * 指定格式化样式
     * @author zhangxc
     * @date 2016年9月28日
     * @param fieldName
     * @param title
     * @param format
     */
    public ExcelExportColumn(String fieldName,String title,String format){
        this.fieldName = fieldName;
        this.title = title;
        this.format = format;
    }

    /**
     *
     * 指定字段类型
     * @author zhangxc
     * @date 2016年9月28日
     * @param fieldName
     * @param title
     * @param dataType
     */
    public ExcelExportColumn(String fieldName,String title,ExcelDataType dataType){
        this.fieldName = fieldName;
        this.title = title;
        this.dataType = dataType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public ExcelDataType getDataType() {
        return dataType;
    }

    public void setDataType(ExcelDataType dataType) {
        this.dataType = dataType;
    }
}
