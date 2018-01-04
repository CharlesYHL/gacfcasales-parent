package com.gacfcasales.common.util;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

	 private static final String STR_NEW_LINE                   = "\n\r";
	 // 定义日志接口
	 private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	 
	 public static boolean isNullOrEmpty(Collection<?> list) {
	        return list == null || list.isEmpty();
	 }
	 
	 public static boolean isNullOrEmpty(Map<?, ?> map) {
	        return map == null || map.isEmpty();
	 }
	 
	 public static String checkNull(String string) {
			if (string != null && !"null".equals(string))
				return string.trim();
			else
				return "";
	}
	 public static String checkNull(Object obj) {
			if (obj != null && !"null".equals(obj))
				return obj.toString().trim();
			else
				return "";
	}
	 
	 public static Integer checkNullInt(Object obj,Integer defaultValue) {
			if (obj != null)
				try {
					return Integer.parseInt(obj.toString().trim());
				} catch (Exception e) {
					return defaultValue;
				}
			else
				return defaultValue;
	}
	 
	 
	 
}
