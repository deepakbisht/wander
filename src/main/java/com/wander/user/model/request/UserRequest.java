package com.wander.user.model.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class UserRequest {

	private String username;
	private String name;
	private List<NoteRequest> notes;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NoteRequest> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteRequest> notes) {
		this.notes = notes;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", name=" + name + ", notes=" + notes + "]";
	}

}
