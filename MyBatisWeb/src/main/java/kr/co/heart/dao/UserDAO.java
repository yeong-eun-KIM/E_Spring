package kr.co.heart.dao;

import kr.co.heart.domain.User;

public interface UserDAO {
	
	User selectUser(String id);
	void deleteAll() throws Exception;
	int insertUser(User user);
	int updateUser(User user);
}
