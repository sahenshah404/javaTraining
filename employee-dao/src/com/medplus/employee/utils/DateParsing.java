package com.medplus.employee.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParsing {
	public static Date getSqlDate(String doj) {
		Date sqlDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utilDate;
		try {
			utilDate = sdf.parse(doj);
			sqlDate = new Date(utilDate.getTime());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return sqlDate;
	}
}
