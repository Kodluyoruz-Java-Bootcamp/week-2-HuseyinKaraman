package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.factory.Prototype;
import emlakcepte.model.User;

public class UserDao implements Prototype {
	
	private static List<User> userList = new ArrayList<>();

	public void createUser(User user) {	
		userList.add(user);
	}
	
	public List<User> findAllUsers() {	
		return userList;
	}

	@Override
	public Prototype getClone() {
		return new UserDao();
	}

}
