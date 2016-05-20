package com.bluemobi.pro.entity;

/**
 * 跑步记录
 * @author Administrator
 *
 */
public class RunRecord {

	private Long id;
	
	private String userId;
	
	private Double mileage;
	
	private Integer step;
	
	private Double consumption;
	
	private String createDate;

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

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
