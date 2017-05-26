package org.glqdlt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout() {
		
	}
	
	
	

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createGet() {

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createPost() {

	}

}
