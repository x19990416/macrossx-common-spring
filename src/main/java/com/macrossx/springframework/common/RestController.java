package com.macrossx.springframework.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


public class RestController {

	@ExceptionHandler(Exception.class)
    @ResponseBody
    public MapResponse handleIOException(Exception e) {
		MapResponse response = new MapResponse("0001",e.getMessage());
        return response;
    }
}	
