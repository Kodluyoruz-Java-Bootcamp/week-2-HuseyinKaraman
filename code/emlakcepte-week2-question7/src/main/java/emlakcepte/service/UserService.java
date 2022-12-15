package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.UserDao;
import emlakcepte.model.User;

@Service
public class UserService {
		
	@Autowired
	private UserDao userDao;

	public void createUser(User user) {						
		userDao.createUser(user);		
	}
	
	public List<User> getAllUser() {
		return userDao.findAllUsers();
	}
	
	public void printAllUser() {
		getAllUser().forEach(user -> System.out.println(user.getName()));
	}
	


}
