package mymedium.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mymedium.model.Blog;
import mymedium.model.User;

@Repository
public class UserDao {

	private static List<User> userList = new ArrayList<>();

	/** User'i kayıt eder.
	 * @param user
	 */
	public void createUser(User user) {
		userList.add(user);
	}
	
	/**  User'i siler.
	 * @param user
	 */
	public void removeUser(User user) {
		userList.remove(user);
	}

	/** Butun User'ları verir.
	 * @return
	 */
	public List<User> findAll() {
		return userList;
	}

	/** istenilen id'ye göre User'i verir.
	 * @param id
	 * @return
	 */
	public User findById(Integer id) {
		return userIsAvailable(id)
				? userList.stream().filter(it -> Objects.equals(it.getUserId(), id)).collect(Collectors.toList()).get(0)
				: null;
	}

	/** User Girilen id'ye ait kullanıcı takip edilir.
	 * @param user
	 * @param userId
	 */
	public void followUserById(User user, int userId) {
		user.getFollowingIds().add(userId);
	}

	/** User Girilen tag'i takip eder.
	 * @param user
	 * @param tag
	 */
	public void subscribeTag(User user, String tag) {
		user.getTags().add(tag);
	}

	/** OLuşturulmus blog'u kullanıcı property'sine atanır
	 */
	public void addBlog(User user,Blog blog) {
		user.getBlogIds().add(blog.getBlogId());
	}

	/* User'a ait olan blogların id'si user'a atanır
	 */
	public void setBlogIds(int userId, List<Integer> blogIds) {
		findById(userId).setBlogIds(blogIds);
	}

	/** Girilen Id'ye ait Users varmı kontrol edilir
	 * @param userId
	 * @return
	 */
	private boolean userIsAvailable(int userId) {
		return findAll().stream().anyMatch(user -> user.getUserId() == userId);
	}

}
