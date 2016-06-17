package com.macrossx.springframework.web;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.Maps;

public class PageHttpUtil {
	public static PageResult convertPage(List<?> pageList, Long count, Long pageIndex, Long pageSize) {
		PageResult pageResult = new PageResult();
		pageResult.setPageIndex(pageIndex);
		pageResult.setPageSize(pageSize);
		pageResult.setPageCount(count);
		pageResult.setPageList(pageList);
		Long pageCount = pageResult.getPageCount() / pageResult.getPageSize();
		if (pageResult.getPageCount() % pageResult.getPageSize() > 0) {
			pageCount++;
		}
		pageResult.setPageCount(pageCount);

		return pageResult;
	}

	public static String getPageParams(HttpServletRequest request) {
		Map<String, String[]> paramsMap = getParameterMap(request);
		Iterator<Entry<String, String[]>> entries = paramsMap.entrySet().iterator();
		String param = "";
		while (entries.hasNext()) {
			Map.Entry<String, String[]> entry = entries.next();
			String name = (String) entry.getKey();
			String value = entry.getValue()[0].toString();
			if (!"pageIndex".equals(name)) {
				param += "&" + name + "=" + value;
			}
		}
		return param;
	}

	public static Map<String, String[]> getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map<String, String[]> properties = request.getParameterMap();
		// 返回值Map
		Map<String, String[]> returnMap = Maps.newHashMap();
		Iterator<Entry<String, String[]>> entries = properties.entrySet().iterator();
		String name, value = "";
		while (entries.hasNext()) {
			Map.Entry<String, String[]> entry = entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, new String[] { value });
		}

		return returnMap;
	}

}
