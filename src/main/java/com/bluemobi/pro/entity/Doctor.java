package com.bluemobi.pro.entity;

import java.io.Serializable;

/**
 * 专家医师
 * 
 * @author yesong
 *
 */
public class Doctor implements Serializable{

	private static final long serialVersionUID = -7062217446465505118L;
	private String id;
	private String name; // 医生名字
	private String detail; // 医生简介
	private String depart; // 所在科室
	private String domain; // 所在领域
	private String mobile; // 手机号
	private String tel; // 座机电话
	private String head; // 头像地址
	private int gender; // 性别1:男 2:女
	private int age; // 年龄
	private String level; // 医师等级
	private String birthday; // 出生日期
	private String online; // 在诊时间
	private int type; // 类型 0:专家 1:家庭医生

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
