package com.macrossx.springframework.common;

import java.util.LinkedHashMap;

import com.macrossx.springframework.Constants;

import lombok.ToString;


@ToString
public class MapResponse extends LinkedHashMap<String,Object>{	
	private static final long serialVersionUID = -2752445163247290989L;
	private final static String STATUS = "status";
	private final static String MSG="result";
	public MapResponse(String status,Object msg){
		super();
		put(STATUS,status);
		put(MSG,msg);
	}
	public MapResponse(Object msg){
		super();
		put(STATUS,Constants.message_success_code);
		put(MSG,msg);
	}
}


