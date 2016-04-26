package com.bluemobi.pro.service.impl;

import com.bluemobi.pro.entity.Doctor;
import com.bluemobi.pro.entity.Signing;
import com.bluemobi.pro.entity.User;
import com.bluemobi.sys.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
            // TODO 讲座是否翻页
            // 如果翻页，讲座需要单独访问接口
        }
        return doctor;
    }

    /**
     * 签约医师
     * @param userId
     * @param doctorId
     * @throws Exception
     */
    public void sign(String userId,String doctorId) throws Exception {
        Signing signing = this.getBaseDao().get(PREFIX + ".findByUserId",userId);
        if(signing != null) throw new IllegalAccessError();

        Signing newSigning = new Signing();

        User user = new User();
        user.setUserId(userId);

        Doctor doctor = new Doctor();
        doctor.setId(doctorId);
        newSigning.setUser(user);
        newSigning.setDoctor(doctor);

        this.getBaseDao().save(PREFIX + ".insert",newSigning);
    }


}
