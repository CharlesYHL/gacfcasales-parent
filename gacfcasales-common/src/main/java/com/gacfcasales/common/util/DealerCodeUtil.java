package com.gacfcasales.common.util;

public class DealerCodeUtil {
	
	private String getDealerCodes(String dealerCode) {
		String dealers = "";
		dealerCode = dealerCode.replaceAll("，", ",");
		dealerCode = dealerCode.replaceAll("\\n", ",");
		String[] dealerCodes = dealerCode.split(",");
		for (int i = 0; i < dealerCodes.length; i++) {
			String str = dealerCodes[i];
			if ("".equals(dealers)) {
				dealers = "'" + str + "'";
			} else {
				dealers = dealers + ",'" + str + "'";
			}

		}
		return dealers;
	}
	
	
}
