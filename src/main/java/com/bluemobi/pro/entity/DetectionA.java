package com.bluemobi.pro.entity;

/**
 * 题目答案
 * 
 * @author yesong
 *
 */
public class DetectionA {

	private String id; //
	private String detectionQId; // 题目ID
	private String answer; // 选择答案

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetectionQId() {
		return detectionQId;
	}

	public void setDetectionQId(String detectionQId) {
		this.detectionQId = detectionQId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
