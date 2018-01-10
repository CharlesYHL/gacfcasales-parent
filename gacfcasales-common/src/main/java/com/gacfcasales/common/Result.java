package com.gacfcasales.common;

import java.util.List;
import java.util.Map;

public class Result<T> {
	
	
	private int code;
	
	private String message;
	
	private Map dataMap;
	
	private long totalCount;
	
	private List<T> dataList;
	
	private List<Map> dataListMap;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long count) {
		this.totalCount = count;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public Result(){
		this.code=200;
	}
	
	public Result(int code,String message){
		this.code = code;
		this.message = message;
	}
	public Result(String message){
		this.message = message;
	}

	public List<Map> getDataListMap() {
		return dataListMap;
	}

	public void setDataListMap(List<Map> dataListMap) {
		this.dataListMap = dataListMap;
	}

}
