package com.bluemobi.pro.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Signing implements Serializable{
	
	private static final long serialVersionUID = -7716606982466545225L;
	private Long id;
    private User user;

    private Doctor doctor;

    private Integer month;

    private Long createDate;

    private Integer isSign ; // 是否签约 0:签约 1:解约
    
    public Integer getIsSign() {
		return isSign;
	}

	public void setIsSign(Integer isSign) {
		this.isSign = isSign;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}
