package mymedium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mymedium.dao.BlogDao;
import mymedium.model.Blog;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;

//	@Autowired
//	public BlogService(BlogDao blogDao) {
//		this.blogDao = blogDao;
//	}
	
	/** Yeni Blog olusturur
	 * @param blog
	 */
	public void createBlog(Blog blog) {
		blogDao.saveBlog(blog);
	}
	
	/** Var olan Blog'u siler.
	 * @param blog
	 */
	public void removeBlog(Blog blog) {
		blogDao.removeBlog(blog);
	}
	
	/** Tüm Blogları verir.
	 * @return
	 */
	public List<Blog> getAllBlog() {
		return blogDao.findAll();
	}
	
	/** Tüm Blogları yazdırır.
	 * @return
	 */
	public void printBlogs() {
		getAllBlog().forEach(System.out::println);
	}
		
	/** BlogId göre istenilen Blog'u bulur.
	 * @param blogId
	 * @return
	 */
	public Blog findBlogByBlogId(Integer blogId) {
		return blogDao.findBlogByBlogId(blogId);
	}
	
	/** Girilen userId'ye göre User'in Blog'larını verir.
	 * @param userId
	 * @return
	 */
	public List<Blog> findBlogsByUserId(Integer userId) {
		return blogDao.findBlogsByUserId(userId);
	}

	/** Girilen userId'ye göre User'in abone oldugu taglari verir.
	 * @param userId
	 * @return
	 */
	public List<String> findTagsByUserId(Integer userId) { 
		return blogDao.findTagsByUserId(userId);
	}
	
	/** Girilen userId'ye göre User'in Blog'larının Id sini verir.
	 * @param userId
	 * @return
	 */
	public List<Integer> findBlogsIdByUserId(Integer userId) {
		return blogDao.findBlogsIdByUserId(userId);
	}
	
}
