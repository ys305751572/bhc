package com.bluemobi.utils;

import java.util.Map;

public class Result {

	private Integer status; // 状态 0:成功 1:失败（异常）
	private String errorMessage; // 错误信息
	private Map<String, Object> data; // 数据内容

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Result success() {
		Result result = new Result();
		result.status = 0;
		result.errorMessage = "";
		return result;
	}

	public Result success(Object data) {
		Result result = new Result();
		result.status = 0;
		result.errorMessage = "";
		
		
		return result;
	}
}
