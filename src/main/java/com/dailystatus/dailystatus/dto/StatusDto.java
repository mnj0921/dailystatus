package com.dailystatus.dailystatus.dto;

import java.util.Date;

public class StatusDto {

	private Long id;
	private String currentStatus;
	private Date createDate;
	private Date updateDate;
	private String userId;
	private String userName;
	private String fileName;
	private String fileType;
	private byte[] attachment;
	
	
	public StatusDto(Long id, String currentStatus, Date createDate, Date updateDate, String userId, String userName,
			String fileName, String fileType, byte[] attachment) {
		
		this.id = id;
		this.currentStatus = currentStatus;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
		this.userName = userName;
		this.fileName = fileName;
		this.fileType = fileType;
		this.attachment = attachment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	
	

}
