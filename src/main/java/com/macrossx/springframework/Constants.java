package com.macrossx.springframework;

public class Constants {
	public static final String EMPTY = "empty:";
	public static final String REDIS_NULL_VALUE = "1";
	public static final Long REDIS_TIME_OUT = 60l;
	public static final String message_success_code="000000";
	

	public static enum RESPONSE_MESSAGE {
		M400("400","错误请求"),
		M401("401","权限不够或未授权"),
		M500("500","内部错误");
		private String code;
		private String msg;
		RESPONSE_MESSAGE(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String code() {
			return code;
		}

		public String message() {
			return msg;
		}
	}
}




