package com.bluemobi.pro.service.impl;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.User;
import com.bluemobi.sys.service.BaseService;

@Service
public class UserService extends BaseService{

	private static final String PRIFIX = UserService.class.getName();
	
	/**
	 * 新增用户记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addUser(User user) throws Exception {
		return this.getBaseDao().save(PRIFIX + ".insert", user);
	}
	
	/**
	 * 判断用户是否存在
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public Boolean isExist(User user) throws Exception  {
		
		User reUser = findUserByMobile(user);
		if(reUser != null && reUser.getMobile() != null && reUser.getUserId() != null) {
			return Boolean.valueOf(true);
		}
		return Boolean.valueOf(false);
	}
	
	/**
	 * 根据手机号查询用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUserByMobile(User user) throws Exception {
		User reUser = this.getBaseDao().getObject(PRIFIX + ".findUserByMobile", user);
		return reUser;
	} 
	
}