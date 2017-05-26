package org.glqdlt.service;

import java.util.Map;

import javax.inject.Inject;

import org.glqdlt.home.servers.domain.user.UserVO;
import org.glqdlt.persistence.user.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO uDao;

	@Override
	public UserVO login(Map<String, String> userDTO) throws Exception {

		return uDao.login(userDTO);
	}

	@Override
	public boolean loginOut() throws Exception {
		
		
		return uDao.loginOut();
	}

	@Override
	public boolean create(UserVO uvo) throws Exception {

		return uDao.create(uvo);
	}

}
