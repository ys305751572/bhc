package com.bluemobi.pro.controller.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.cache.CacheService;
import com.bluemobi.constant.ErrorCode;
import com.bluemobi.pro.entity.Children;
import com.bluemobi.pro.entity.RegisterUser;
import com.bluemobi.pro.entity.User;
import com.bluemobi.pro.service.impl.ChildrenService;
import com.bluemobi.pro.service.impl.UserService;
import com.bluemobi.utils.Result;

@Controller
@RequestMapping("/app/member/manager/")
public class MemberApp {

	@Autowired
	private UserService service;
	
	@Autowired
	private ChildrenService childrenService;
	
	@Resource(name = "cacheTempCodeServiceImpl")
	private CacheService<String> cacheService;
	
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
			String requestCode = user.getCode();
			String code = cacheService.get(user.getMobile());
			
			User _user = service.findUserByMobile(user);
			if(_user == null) return Result.failure(ErrorCode.ERROR_06);
			if(StringUtils.isBlank(requestCode) || !requestCode.equals(code)) {
				 return Result.failure(ErrorCode.ERROR_10);
			 }
			user.setUserId(_user.getUserId());
			service.modifyUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "relatives/list", method = RequestMethod.POST)
	@ResponseBody
	public Result relatives(String userId) {
		
		List<Children> list = null;
		try {
			list = childrenService.findList(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(list);
	}
	
	/**
	 * 修改备注
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "relatives/note", method = RequestMethod.POST)
	@ResponseBody
	public Result note(@RequestParam Map<String,Object> params) {
		try {
			childrenService.note(params);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
}
