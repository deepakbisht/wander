package com.wander.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wander.user.model.Note;
import com.wander.user.model.User;
import com.wander.user.model.request.LoginObject;
import com.wander.user.model.request.NoteRequest;
import com.wander.user.model.request.UserRequest;
import com.wander.user.repository.UserRepository;
import com.wander.user.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/


	@Override
	public String saveUser(UserRequest userRequest) {

		if (getUserInformation(userRequest.getUsername()) != null) {
			return "Username already exists";
		}
		User user = new User();
		user.setName(userRequest.getName());
		user.setUsername(userRequest.getUsername());
		user.setPassword(userRequest.getPassword());
		List<Note> notes = noteRequestToDBObject(userRequest.getNotes());
		user.setNotes(notes);
		user.setUpdateDate(new Date());
		userRepository.save(user);
		return "Registration Successful";
	}

	private User getUserInformation(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<Note> getUserNotes(String username) {
		User user = getUserInformation(username);
		if (user == null) {
			throw new IllegalArgumentException("User Does not exist");
		}
		return user.getNotes();
	}

	@Override
	public List<Note> updateNotes(List<NoteRequest> noteRequests, String username) {
		User user = getUserInformation(username);
		if(user==null) {
			throw new IllegalArgumentException("User does not exist");
		}
		
			List<Note> notes = noteRequestToDBObject(noteRequests);
			// updatedate
			notes.forEach(note -> note.setUpdateDate(new Date()));
			user.setNotes(notes);
			userRepository.save(user);
			return getUserNotes(username);
		
	}

	private List<Note> noteRequestToDBObject(List<NoteRequest> noteRequests) {
		List<Note> notes = new ArrayList<>();
		if (noteRequests != null) {
			noteRequests.forEach(noteRequest -> {
				Note note = new Note();
				note.setDescription(noteRequest.getDescription());
				note.setTitle(noteRequest.getTitle());
				notes.add(note);
			});
		}
		return notes;
	}

	@Override
	public User findByUsername(String username) {
		
		return getUserInformation(username);
	}

	@Override
	public User login(LoginObject loginObject) {
		User user = userRepository.findByUsernameAndPassword(loginObject.getUsername(), loginObject.getPassword());
		if(user==null) {
			throw new IllegalArgumentException("Username or password is invalid");
		}
		return user;
	}

}
