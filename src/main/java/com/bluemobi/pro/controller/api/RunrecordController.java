package com.bluemobi.pro.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.pro.entity.RunRecord;
import com.bluemobi.pro.service.impl.RunRecordService;
import com.bluemobi.utils.DateUtils;
import com.bluemobi.utils.Result;

@Controller
@RequestMapping(value = "/app/runrecord")
public class RunrecordController {
	
	@Autowired
	private RunRecordService service;
	
	/**
	 *
	 * @param runRecord
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private Result insert(RunRecord runRecord) {
		
		try {
			runRecord.setCreateDate(DateUtils.getCurrentTime("yyyy-MM-dd"));
			service.insert(runRecord);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@ResponseBody
	public Result find(RunRecord runRecord) {
		RunRecord record = null;
		try {
			record = service.find(runRecord);
			if(record == null) {
				record = new RunRecord();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(record);
	}
}
