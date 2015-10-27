package com.bluemobi.pro.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluemobi.pro.entity.User;
import com.bluemobi.utils.Result;

@Controller
@RequestMapping("/member/manager/")
public class MemberApp {

	public Result modifyMemberInfo(User user) {
		
		return null;
	}
}
