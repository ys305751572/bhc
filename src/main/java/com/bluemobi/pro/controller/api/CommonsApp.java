package com.bluemobi.pro.controller.api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app/common/")
public class CommonsApp {

	/**
	 * 发送验证码
	 * @param params
	 * @return
	 */
	public String sendCode(@RequestParam Map<String,Object> params) {
		
		return null;
	}
	
	
}
