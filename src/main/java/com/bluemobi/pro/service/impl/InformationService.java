package com.bluemobi.pro.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Information;
import com.bluemobi.sys.page.Page;
import com.bluemobi.sys.service.BaseService;

@Service
public class InformationService extends BaseService{

	private static final String PRIFIX = Information.class.getName();
	
	public Page<Information> page(Map<String,Object> params,int currentPage,int pagesize) {
		return this.getBaseDao().page(PRIFIX + ".findList", params, currentPage, pagesize);
	}
	
	public Information detail(Integer id) throws Exception {
		return this.getBaseDao().get(PRIFIX + ".findDetail", id);
	}
}
