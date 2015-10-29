package com.bluemobi.location;

// 位置信息
public class Location {

	private String aolUserId; // 长辈用户ID
	
	private Double lon; // 经度
	
	private Double lat; // 维度
	
	private Long lastLocationTime; // 最后发送地理位置时间

	
	public Location() {}
	
	public Location(String aolUserId,Long lastLocationTime) {
		this.aolUserId = aolUserId;
		this.lastLocationTime = lastLocationTime;
	}
	
	public Location(String aolUserId,Double lon,Double lat) {
		this.aolUserId = aolUserId;
		this.lon = lon;
		this.lat = lat;
		this.lastLocationTime = System.currentTimeMillis();
	}
	
	public String getAolUserId() {
		return aolUserId;
	}

	public void setAolUserId(String aolUserId) {
		this.aolUserId = aolUserId;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Long getLastLocationTime() {
		return lastLocationTime;
	}

	public void setLastLocationTime(Long lastLocationTime) {
		this.lastLocationTime = lastLocationTime;
	}
	
	
}
