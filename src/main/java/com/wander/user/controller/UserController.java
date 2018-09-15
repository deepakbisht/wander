package com.wander.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wander.user.model.Note;
import com.wander.user.model.User;
import com.wander.user.model.request.LoginObject;
import com.wander.user.model.request.NoteRequest;
import com.wander.user.model.request.UserRequest;
import com.wander.user.response.Response;
import com.wander.user.response.ResponseModel;
import com.wander.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseModel saveUser(@RequestBody UserRequest user) {

		return new Response<String>(userService.saveUser(user));

	}

	@ResponseBody
	@RequestMapping(value = "/notes/{username}", method = RequestMethod.GET)
	public ResponseModel notes(@PathVariable("username") String username) {

		List<Note> notes = null;
		try {
			notes = userService.getUserNotes(username);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return new Response<List<Note>>(notes);

	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseModel notes(@RequestBody LoginObject loginObject) {

		User user = null;
		try {
			user = userService.login(loginObject);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return new Response<User>(user);

	}

	@ResponseBody
	@RequestMapping(value = "/notes/{username}", method = RequestMethod.PUT)
	public ResponseModel updateNotes(@PathVariable("username") String username, @RequestBody List<NoteRequest> noteRequests) {

		return new Response<List<Note>>(userService.updateNotes(noteRequests, username));

	}
}
