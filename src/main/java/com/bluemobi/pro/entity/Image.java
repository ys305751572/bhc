package com.bluemobi.pro.entity;

public class Image {

	private Integer id;
	private String path;
	private String feekbackId;
	
	public String getFeekbackId() {
		return feekbackId;
	}
	public void setFeekbackId(String feekbackId) {
		this.feekbackId = feekbackId;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
