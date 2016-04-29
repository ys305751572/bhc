package com.bluemobi.pro.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bluemobi.pro.entity.Measure;
import com.bluemobi.pro.service.impl.MeasureService;
import com.bluemobi.utils.Result;

@Controller
@RequestMapping("/app/measure/")
public class MeasureApp {

	@Autowired
	private MeasureService service;
	
	/**
	 * 
	 * @param userId
	 * @param type 1:血压 2:血糖
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "index", method = RequestMethod.POST)
	@ResponseBody
	public Result index(String userId,Integer type) {
		
		Measure m = new Measure();
		m.setUserId(userId);
		m.setMeasureType(String.valueOf(type));
		List<Measure> list = null;
		try {
			list = service.findMeasureValue(m);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(list);
	}
	
	/**
	 * 新增测量结果
	 * @param measure
	 * @return
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public Result addNewMeasure(Measure measure) {
		
		try {
			service.insertMeasureValue(measure);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
	
	/**
	 * 移除测量结果
	 * @param measure
	 * @return
	 */
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	@ResponseBody
	public Result removeMeasure(Measure measure) {
		
		try {
			service.deleteMeasureValue(measure.getMeasureId());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
	
	/**
	 * 根据用户ID查询测量结果
	 * @param measure
	 * @return
	 */
	@RequestMapping(value = "findByUserId", method = RequestMethod.POST)
	@ResponseBody
	public Result findByUseId(Measure measure) {
		List list = null;
		try {
			list = service.findMeasureValue(measure);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(list);
	}
}
