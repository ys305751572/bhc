package com.bluemobi.pro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Measure;
import com.bluemobi.sys.service.BaseService;

/**
 * 测量service
 * @author yesong
 *
 */
@Service
public class MeasureService extends BaseService{

	private static final String PRIFIX = MeasureService.class.getName();
	
	/**
	 * 新增测量结果
	 * @param measure
	 * @throws Exception
	 */
	public void insertMeasureValue(Measure measure) throws Exception {
		this.getBaseDao().save(PRIFIX + "insert", measure);
	}
	
	public List<Measure> findMeasureValue(Measure measure) throws Exception {
		return this.getBaseDao().getList(PRIFIX + ".findMeasureValue", measure);
	}
	
	public void deleteMeasureValue(String measureId) throws Exception {
		this.getBaseDao().delete(PRIFIX + ".deleteById", measureId);
	}
}
