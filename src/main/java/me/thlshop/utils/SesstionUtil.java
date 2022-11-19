package me.thlshop.utils;

import javax.servlet.http.HttpServletRequest;

public class SesstionUtil {
	private static SesstionUtil sesstionUtil = null;
	public static SesstionUtil getInstance() {
		if(sesstionUtil == null) {
			sesstionUtil = new SesstionUtil();
		}
		return sesstionUtil;
	}
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
