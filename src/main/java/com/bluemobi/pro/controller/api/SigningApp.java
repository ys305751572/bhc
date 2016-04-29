package com.bluemobi.pro.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.constant.ErrorCode;
import com.bluemobi.pro.entity.Doctor;
import com.bluemobi.pro.service.impl.SigningService;
import com.bluemobi.utils.Result;

@RequestMapping("/app/signing")
@Controller
public class SigningApp {

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
	@ResponseBody
	public Result signing(String userId, String doctorId) {

		try {
			service.sign(userId, doctorId);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return Result.failure(ErrorCode.ERROR_01);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
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
