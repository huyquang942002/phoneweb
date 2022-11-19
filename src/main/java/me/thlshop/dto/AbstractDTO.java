package me.thlshop.dto;

import java.util.*;

public class AbstractDTO<T> {
	
	private List<T> listResult = new ArrayList<T>();
	private Integer[] ids;
	private String type;

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	
}
