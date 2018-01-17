package com.gacfcasales.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InvoicDateUtil {
	public static void main(String[] args) {
		String invoiceDate="1460476800000";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(invoiceDate)); 
		Date date = c.getTime();
		System.out.println(formatter.format(date));
	}
}
