package com.bluemobi.pro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bluemobi.sys.service.BaseService;

@Service
public class XxCommonsServiceImpl extends BaseService{

	public static final String PRIFIX = XxCommonsServiceImpl.class.getName();
	
	// 根据区ID查询街道
	public List<Map<String,Object>> findStreet(Map<String,Object> params) throws Exception {
		return this.getBaseDao().getList(PRIFIX + ".findStreet", params);
	}
	
	// 查询首页图片
	public List<Map<String,Object>> findIndexImages() throws Exception {
		return this.getBaseDao().getList(PRIFIX + ".findIndexImages");
	}
}
