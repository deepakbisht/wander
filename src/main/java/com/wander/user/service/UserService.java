package com.wander.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wander.user.model.Note;
import com.wander.user.model.User;
import com.wander.user.model.request.LoginObject;
import com.wander.user.model.request.NoteRequest;
import com.wander.user.model.request.UserRequest;

@Service
public interface UserService {

	public String saveUser(UserRequest user);
	public List<Note> getUserNotes(String username);
	public List<Note> updateNotes(List<NoteRequest> noteRequests,String username);
	public User findByUsername(String username);
	public User login(LoginObject loginObject);
}
