package org.glqdlt.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.glqdlt.home.servers.domain.user.UserVO;
import org.glqdlt.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Inject
	UserService uService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserVO login() throws Exception {

		Map<String, String> map = new HashMap<>();

		return uService.login(map);

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
