package com.bluemobi.pro.service.impl;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.FeedBack;
import com.bluemobi.sys.service.BaseService;

@Service
public class FeedBackService extends BaseService{

	private static final String PRIFIX = FeedBackService.class.getName();
	
	/**
	 * 新增一键反馈
	 * @param feedBack
	 * @throws Exception
	 */
	public void insert(FeedBack feedBack) throws Exception {
		this.getBaseDao().save(PRIFIX + "insert", feedBack);
	}
}
