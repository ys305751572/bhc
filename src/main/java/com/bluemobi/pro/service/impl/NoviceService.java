package com.bluemobi.pro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Novice;
import com.bluemobi.sys.service.BaseService;

@Service
public class NoviceService extends BaseService{

	private static final String PRIXIF = Novice.class.getName();
	
	public List<Novice> findAll() throws Exception {
		return this.getBaseDao().getList(PRIXIF + ".findAllNovice");
	}
}
