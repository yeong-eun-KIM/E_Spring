package kr.co.work;

public interface UserDAO {
	
	User selectUser(String id);
	void deleteAll() throws Exception;
	int insertUser(User user);
	int updateUser(User user);
}
