package com.bluemobi.pro.controller.api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluemobi.utils.Result;

@Controller
@RequestMapping("/app/common/")
public class CommonsApp {

	/**
	 * 发送验证码
	 * @param params
	 * @return
	 */
	public Result sendCode(@RequestParam Map<String,Object> params) {
		
		
		return null;
	}
	
}
