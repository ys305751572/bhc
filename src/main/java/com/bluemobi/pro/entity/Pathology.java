package com.bluemobi.pro.entity;

import java.sql.Timestamp;

/**
 * 病理
 * @author yesong
 *
 */
public class Pathology {

	private String id; // ID
	private String title; // 病理分析标题
	private String content; // 病理分析内容
	private String image; // 封面
	private Timestamp createDate; // 创建时间
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
