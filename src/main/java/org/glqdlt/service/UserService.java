package org.glqdlt.service;

import java.util.Map;

import org.glqdlt.home.servers.domain.user.UserVO;

public interface UserService {
	
	public UserVO login(Map<String, String> userDTO) throws Exception;
	public boolean loginOut() throws Exception;
	public boolean create(UserVO uvo) throws Exception;

}
