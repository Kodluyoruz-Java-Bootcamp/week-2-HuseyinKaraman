package mymedium.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mymedium.model.Blog;

@Repository
public class BlogDao {
	
	private static List<Blog> blogList = new ArrayList<>();

	/** Yeni Blog olusturur
	 * @param blog
	 */
	public void saveBlog(Blog blog) {
		blogList.add(blog);
	}
	
	/** Var olan Blog'u siler.
	 * @param blog
	 */
	public void removeBlog(Blog blog) {
		System.out.println("Blog Silindi");
		blogList.remove(blog);
	}
	
	/** Tüm Blogları verir.
	 * @return
	 */
	public List<Blog> findAll() {
		return blogList;
	}
	
	/** BlogId göre istenilen Blog'u bulur.
	 * @param blogId
	 * @return
	 */
	public Blog findBlogByBlogId(Integer blogId) {
		List<Blog> collect = blogList.stream().filter(it -> Objects.equals(it.getBlogId(), blogId)).collect(Collectors.toList());
		return !collect.isEmpty() ? collect.get(0) : null;
	}
	
	/** Girilen userId'ye göre User'in abone oldugu taglari verir.
	 * @param userId
	 * @return
	 */
	public List<String> findTagsByUserId(Integer userId) {
		 return blogList.stream().filter(it -> it.getUserId() == userId)
				.map(Blog::getTag)
				.collect(Collectors.toList());
	}
	
	/** Girilen userId'ye göre User'in Blog'larını verir.
	 * @param userId
	 * @return
	 */
	public List<Blog> findBlogsByUserId(Integer userId) {
		return blogList.stream().filter(it -> Objects.equals(it.getUserId(), userId))
								.collect(Collectors.toList());
	}
	
	/** Girilen userId'ye göre User'in Blog'larının Id sini verir.
	 * @param userId
	 * @return
	 */
	public List<Integer> findBlogsIdByUserId(Integer userId) {
		return blogList.stream().filter(it -> Objects.equals(it.getUserId(), userId)).map(it-> it.getBlogId())
								.collect(Collectors.toList());
	}
}
