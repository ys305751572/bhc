package com.bluemobi.pro.service.impl;

import com.bluemobi.pro.entity.Doctor;
import com.bluemobi.pro.entity.Signing;
import com.bluemobi.pro.entity.User;
import com.bluemobi.sys.service.BaseService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

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
    public void sign(String userId,String doctorId) throws Exception,IllegalAccessException{
        Signing signing = this.getBaseDao().get(PREFIX + ".findByUserId",userId);
        if(signing != null) throw new IllegalAccessException();

        Signing newSigning = new Signing();

        User user = new User();
        user.setUserId(userId);

        Doctor doctor = new Doctor();
        doctor.setId(doctorId);
        newSigning.setUser(user);
        newSigning.setDoctor(doctor);

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
}
