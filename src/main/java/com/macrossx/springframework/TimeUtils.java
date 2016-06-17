package com.macrossx.springframework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	private static final String Full_Time = "yyyy-MM-dd HH:mm:ss";
	public static final String fullTime(long time){
		return new SimpleDateFormat(Full_Time)	.format(new Date(time));
	}
}
