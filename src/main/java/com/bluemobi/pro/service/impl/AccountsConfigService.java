package com.bluemobi.pro.service.impl;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.AccountsConfig;
import com.bluemobi.sys.service.BaseService;

@Service
public class AccountsConfigService extends BaseService{

	private static final String PRIFIX = AccountsConfig.class.getName();
	
	public AccountsConfig find() throws Exception {
		return this.getBaseDao().getObject(PRIFIX + ".findConfig", null);
	}
}
