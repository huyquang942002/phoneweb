package me.thlshop.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	String value;

	public HttpUtil(String value) {
		this.value = value;
	}
	
	/*
	 *Chuyển từ kiểu dữ liệu json của client
	 *sang kiểu dữ liệu String để đẩy vào Model
	 *rồi đưa lên Server
	 */

	public static HttpUtil of(BufferedReader reader) {
		StringBuilder sBuilder = new StringBuilder();
		try {	
			String line;
			while ((line = reader.readLine()) != null) {
				sBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HttpUtil(sBuilder.toString());
	}
	
	/*
	 * Mapping giữa những key, value trong String
	 * vào những model
	 * tClass là những Class Model
	 */
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}
