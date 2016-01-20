package com.bluemobi.pro.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Device;
import com.bluemobi.pro.entity.UserDevice;
import com.bluemobi.sys.service.BaseService;
import com.bluemobi.utils.DateUtils;
import com.bluemobi.utils.UUIDUtil;

/**
 * 设备service
 * @author Administrator
 *
 */
@Service
public class DeviceService extends BaseService{

	private static final String PRIFIX = DeviceService.class.getName();
	
	/**
	 * 用户添加设备
	 * @throws Exception
	 */
	public String addDevice(Device device) throws Exception {
		device.setDeviceId(UUIDUtil.generateUUID());
		device.setBak6(Timestamp.valueOf(DateUtils.getCurrentTime()));
		if(!checkDevice(device)) {
			// 检测该用户是否已经绑定此设备
			this.getBaseDao().save(PRIFIX + ".insert", device);
			UserDevice ud = buildUserDevice(device);
			ud.setId(UUIDUtil.generateUUID());
			this.getBaseDao().save(PRIFIX + ".insertBind", ud);
		}
		return device.getDeviceId();
	}
	
	/**
	 * 检测该用户是否已绑定此设备
	 * @return
	 * @throws Exception 
	 */
	private boolean checkDevice(Device device) throws Exception {
		return (Integer)this.getBaseDao().get(PRIFIX + ".findBing", device) > 0 ? true : false;
	}
	
	public UserDevice buildUserDevice(Device device) {
		UserDevice ud = new UserDevice();
		ud.setUser_id(device.getUserId());
		ud.setDevice_id(device.getDeviceId());
		ud.setBindTime(DateUtils.getCurrentTime());
		ud.setIsAdmin("0");
		return ud;
	}
	
	/**
	 * 更新设备
	 * @param device
	 * @throws Exception
	 */
	public void modifyDevice(Device device) throws Exception {
		this.getBaseDao().update(PRIFIX + ".update", device);
	}
	
	/**
	 * 删除设备
	 * @param deviceId
	 * @throws Exception
	 */
	public void deleteDevice(String deviceId) throws Exception {
		this.getBaseDao().delete(PRIFIX + ".deleteByDeviceId", deviceId);
	}
	
	/**
	 * 根据用户ID查询设备集合
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Device> findDeviceByUserId(String userId) throws Exception {
		return this.getBaseDao().getList(PRIFIX + ".findDeviceByUserId", userId);
	}
	
	/**
	 * 根据设备ID，查询设备信息
	 * @param deviceId
	 * @return
	 * @throws Exception
	 */
	public Device findDeviceById(String deviceId) throws Exception {
		return this.getBaseDao().getObject(PRIFIX + ".findDeviceById", deviceId);
	}
}
