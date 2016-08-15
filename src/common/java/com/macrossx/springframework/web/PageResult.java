package com.macrossx.springframework.web;

import java.util.List;

import lombok.Data;

@Data
public class PageResult {
	/**
	 * 值
	 */
	private List<?> pageList;
	/**
	 * 总页数
	 */
	private Long pageCount;
	/**
	 * 页码
	 */
	private Long pageIndex = 1l;
	/**
	 * 每页大小
	 */
	private Long pageSize = 10l;
	
}