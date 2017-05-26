package org.glqdlt.home.servers.domain.user;

public class UserVO {

	private String userId;
	private String userPw;
	private Integer userAuth;
	private String userEmail;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public Integer getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(Integer userAuth) {
		this.userAuth = userAuth;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
