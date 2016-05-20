package com.bluemobi.pro.service.impl;

import com.bluemobi.pro.entity.Doctor;
import com.bluemobi.pro.entity.Signing;
import com.bluemobi.pro.entity.User;
import com.bluemobi.sys.service.BaseService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/4/26.
 */
@Service
public class SigningService extends BaseService{

    public static final String PREFIX = Signing.class.getName();

    public Doctor findSignDoctor(String userId) throws Exception {

        Doctor doctor = null;
        Signing signing = this.getBaseDao().get(PREFIX + ".findByUserId",userId);
        if(signing != null) {
            doctor = signing.getDoctor();
        }
        return doctor;
    }

    /**
     * 签约医师
     * @param userId
     * @param doctorId
     * @throws Exception
     */
    public void sign(String userId,String doctorId,String sn,Integer month) throws Exception,IllegalAccessException{
        Signing signing = this.getBaseDao().get(PREFIX + ".findByUserId",userId);
        if(signing != null) throw new IllegalAccessException();

        Signing newSigning = new Signing();

        User user = new User();
        user.setUserId(userId);

        Doctor doctor = new Doctor();
        doctor.setId(doctorId);
        newSigning.setUser(user);
        newSigning.setDoctor(doctor);
        newSigning.setMonth(month);
        newSigning.setSn(sn);
        newSigning.setIsSign(1);
        newSigning.setCreateDate(System.currentTimeMillis());

        this.getBaseDao().save(PREFIX + ".insert",newSigning);
    }


    /**
     * 解除签约
     * 这里做逻辑删除，以免以后新增签约记录需求
     * @param userId
     * @param doctorId
     * @throws Exception 
     */
    public void unSign(String userId,String doctorId) throws Exception {
    	
    	Map<String,String> params = new HashMap<String,String>();
    	params.put("userId", userId);
    	params.put("doctorId",doctorId);
    	this.getBaseDao().update(PREFIX + ".unSign", params);
    }
    
    /**
     * 支付完成业务
     * 1.修改订单状态
     * 2.修改是否签约状态
     * @throws Exception 
     */
    @Transactional
    public void payComplate(String sn) throws Exception {
    	Signing signing = this.getBaseDao().getObject(PREFIX + ".findBySn", sn);
    	if(signing != null && signing.getId() != null) {
    		this.getBaseDao().update(PREFIX + "payComplate", sn);
    	}
    }
    
    public Signing findByUserId(String userId) throws Exception {
    	return this.getBaseDao().getObject(PREFIX + ".findByUserId", userId);
    }
 }
