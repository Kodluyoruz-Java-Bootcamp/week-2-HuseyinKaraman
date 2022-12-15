package mymedium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mymedium.model.Blog;
import mymedium.model.User;
import mymedium.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/** User'i kayıt eder.
	 * @param user
	 */
	public void createUser(User user) {
		userDao.createUser(user);
	}

	/**  User'i siler.
	 * @param user
	 */
	public void removeUser(User user) {
		userDao.removeUser(user);
	}

	/** Butun User'ları verir.
	 * @return
	 */
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	/** istenilen id'ye göre User'i verir.
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id) {
		return userDao.findById(id);
	}

	/** User Girilen id'ye ait kullanıcı takip edilir.
	 * @param user
	 * @param userId
	 */
	public void followUserById(User user, int userId) {
		userDao.followUserById(user, userId);
	}

	/** User Girilen tag'i takip eder.
	 * @param user
	 * @param tag
	 */
	public void subscribeTag(User user, String tag) {
		userDao.subscribeTag(user, tag);
	}

	/** OLuşturulmus blog'u kullanıcı property'sine atanır.
	 * @param user
	 * @param blog
	 */
	public void addBlog(User user, Blog blog ) {
		userDao.addBlog(user, blog);
	}

	// kullanıcın oluşturdugu blog 'un Id leri kullanının propertysine atar.
	public void setBlogIds(int userId,List<Integer> blogIds) {
		userDao.setBlogIds(userId,blogIds);
	}

}
