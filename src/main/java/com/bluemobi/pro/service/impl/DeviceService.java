package com.bluemobi.pro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Device;
import com.bluemobi.sys.service.BaseService;
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
		this.getBaseDao().save(PRIFIX + ".insert", device);
		return device.getDeviceId();
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
