package com.bluemobi.pro.service.impl;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.RunRecord;
import com.bluemobi.sys.service.BaseService;

@Service
public class RunRecordService extends BaseService{

	public static final String PREFIX = RunRecord.class.getName();
	
	public void insert(RunRecord record) throws Exception {
		this.getBaseDao().save(PREFIX + ".insert", record);
	}
	
	public RunRecord find(RunRecord runRecord) throws Exception {
		return this.getBaseDao().getObject(PREFIX + ".find", runRecord);
	}
}
