package com.bluemobi.pro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Children;
import com.bluemobi.sys.service.BaseService;

@Service
public class ChildrenService extends BaseService{

	private static final String PRIFIX = Children.class.getName();
	
	public List<Children> findList(String userId) throws Exception {
		return this.getBaseDao().getList(PRIFIX + ".findList", userId);
	}
	
	/**
	 * 修改备注
	 * @param params
	 * @throws Exception
	 */
	public void note(Map<String,Object> params) throws Exception {
		this.getBaseDao().update(PRIFIX + ".note", params);
	}
}
