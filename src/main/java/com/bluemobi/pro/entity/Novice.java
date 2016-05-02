package com.bluemobi.pro.entity;

import java.io.Serializable;

/**
 * 新手指导
 * @author yesong
 *
 */
public class Novice {

	private Long id;
	
	private String content;
	
	private String path;
	
	private Integer index; // 顺序


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
