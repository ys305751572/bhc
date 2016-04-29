package com.bluemobi.pro.entity;

import java.io.Serializable;

public class Information implements Serializable{
	private static final long serialVersionUID = -6394294007620987122L;

	private Integer id;
	
	private String title;
	
	private String content;
	
	private String path;

	private Long createDate;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
