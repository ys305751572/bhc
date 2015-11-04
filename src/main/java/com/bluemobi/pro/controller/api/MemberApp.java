package com.bluemobi.pro.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.constant.ErrorCode;
import com.bluemobi.pro.entity.RegisterUser;
import com.bluemobi.pro.entity.User;
import com.bluemobi.pro.service.impl.UserService;
import com.bluemobi.utils.Result;

@Controller
@RequestMapping("/app/member/manager/")
public class MemberApp {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "modifyInfo", method = RequestMethod.POST)
	@ResponseBody
	public Result modifyMemberInfo(User user) {
		
		try {
			service.modifyUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
	
	@RequestMapping(value = "forget", method = RequestMethod.POST)
	@ResponseBody
	public Result forget(RegisterUser user) {
		
		try {
			User _user = service.findUserByMobile(user);
			if(_user == null) return Result.failure(ErrorCode.ERROR_06);
			
			service.modifyUser(_user);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
}
