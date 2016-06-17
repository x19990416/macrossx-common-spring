package com.macrossx.springframework.common;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;


public class DispatcherServlet extends org.springframework.web.servlet.DispatcherServlet {
	private static final long serialVersionUID = 2443644849485331473L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
}
