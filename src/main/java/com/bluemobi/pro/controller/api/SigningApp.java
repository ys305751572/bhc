package com.bluemobi.pro.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.constant.ErrorCode;
import com.bluemobi.pro.entity.Doctor;
import com.bluemobi.pro.service.impl.SigningService;
import com.bluemobi.utils.CommonUtils;
import com.bluemobi.utils.PayConfig;
import com.bluemobi.utils.Result;

@RequestMapping("/app/signing")
@Controller
public class SigningApp {

	public static final Integer DEFAULT_MONTH = 5;
	
	@Autowired
	private SigningService service;

	/**
	 * 签约医师详情 没有签约医师则返回NULL
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/detail")
	@ResponseBody
	public Result signingDetail(String userId) {

		Doctor doctor = null;
		try {
			doctor = service.findSignDoctor(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(doctor);
	}

	/**
	 * 签约医师 每个用户只能签约一个医师 签约时间到了则取消签约
	 * 
	 * @param userId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/sign")
	public Result payConfig(HttpServletRequest request, HttpServletResponse response, String userId, String doctorId,
			String payWay, Integer month) {

		if (month <= DEFAULT_MONTH) {
			return Result.failure(ErrorCode.ERROR_15);
		}
		Double totalFee = (month - DEFAULT_MONTH) <= 0 ? 0.0 : ((month - DEFAULT_MONTH) * 100.0);
		
		Map<String,Object> configMap = new HashMap<String,Object>();
		try {
			String sn = CommonUtils.generateSn();
			service.sign(userId, doctorId,sn);
			configMap = PayConfig.config(request, response, sn, totalFee, payWay);
			
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
			return Result.failure(ErrorCode.ERROR_16);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		} 
		return Result.success(configMap);
	}
	/**
	 * 解除签约
	 * 
	 * @param userId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/unsign")
	public Result unSigning(String userId, String doctorId) {

		try {
			service.unSign(userId, doctorId);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
}
