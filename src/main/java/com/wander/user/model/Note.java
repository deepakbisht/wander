package com.wander.user.model;

import java.util.Date;

public class Note {

	private String title;
	private String description;
	private Date createDate = new Date();
	private Date updateDate = new Date();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "Note [title=" + title + ", description=" + description + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

}
