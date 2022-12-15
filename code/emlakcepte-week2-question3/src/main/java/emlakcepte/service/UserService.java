package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.UserDao;
import emlakcepte.factory.MyBeanFactory;
import emlakcepte.factory.Prototype;
import emlakcepte.factory.Type;
import emlakcepte.model.User;


public class UserService implements Prototype {
		
	private UserDao userDao = MyBeanFactory.getInstanceUserDao(Type.PROTOTYPE);

	public void createUser(User user) {		
		//UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
		System.out.println("ben bir userDao objesiyim:" + userDao.toString());	
		userDao.createUser(user);		
	}
	
	public List<User> getAllUser() {
		//UserDao userDao = new UserDao();		
		return userDao.findAllUsers();
	}
	
	public void printAllUser() {
		
		getAllUser().forEach(user -> System.out.println(user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		// önce hangi user bul ve passwordü update et.
	}

	@Override
	public Prototype getClone() {
		return new UserService();
	}

}
