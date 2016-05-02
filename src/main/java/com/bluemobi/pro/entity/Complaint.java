package com.bluemobi.pro.entity;

import java.io.Serializable;

public class Complaint implements Serializable{
	private static final long serialVersionUID = 5787098213918484271L;

	private Long id;
	
	private String userId;
	
	private String doctorId;
	
	private String content;
	
	private Long createDate;

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
