package me.thlshop.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	@SuppressWarnings({"unchecked"})
	public static <T> T toModel(Class<T> c, HttpServletRequest request) {
		T target = null;
		try {
			target = c.getDeclaredConstructor().newInstance();
			BeanUtils.populate(target , request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.print(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return target;
	}
}
