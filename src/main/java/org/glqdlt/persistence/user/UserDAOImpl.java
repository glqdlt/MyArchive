package org.glqdlt.persistence.user;

import java.util.Map;

import org.glqdlt.home.servers.domain.user.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public UserVO login(Map<String, String> userDTO) throws Exception {

		UserVO uvo = new UserVO();
		uvo.setUserId("jhun");
		uvo.setUserPw("jhun12345");
		uvo.setUserAuth(9);
		uvo.setUserEmail("jhun@jhun.com");

		return uvo;
	}

	@Override
	public boolean create(UserVO uvo) throws Exception {

		return true;
	}

	@Override
	public boolean loginOut() throws Exception {
		return true;
	}

}
