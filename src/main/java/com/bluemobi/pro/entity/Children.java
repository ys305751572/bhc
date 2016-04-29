package com.bluemobi.pro.entity;

import java.io.Serializable;

public class Children implements Serializable{

	private static final long serialVersionUID = -4680819631280693007L;

	private String id;
	
	private String nickname;
	
	private String mobile;
	
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
