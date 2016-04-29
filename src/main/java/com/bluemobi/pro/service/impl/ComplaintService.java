package com.bluemobi.pro.service.impl;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Complaint;
import com.bluemobi.sys.service.BaseService;

@Service
public class ComplaintService extends BaseService{

	private static final String PRIFIX = Complaint.class.getName();
	
	public void insert(Complaint complaint) throws Exception {
		this.getBaseDao().save(PRIFIX + ".insert", complaint);
	}
}
