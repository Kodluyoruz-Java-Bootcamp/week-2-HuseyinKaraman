package mymedium;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mymedium.model.Blog;
import mymedium.model.Status;
import mymedium.model.User;
import mymedium.service.BlogService;
import mymedium.service.UserService;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		UserService userService = context.getBean(UserService.class);
		BlogService blogService = context.getBean(BlogService.class);

		List<User> users = dummyUsers();
		users.forEach(userService::createUser); // Kullanıcılar oluşturuldu.

		List<Blog> blogs = dummyBlogs();
		blogs.forEach(blogService::createBlog); // Bloglar oluşturuldu.

		// her blog'un Id'si ait oldugu kullanıcıya atanır..
		users.forEach(
				user -> userService.setBlogIds(user.getUserId(),  
											  blogService.findBlogsIdByUserId(user.getUserId())));

		
		System.out.println("---------Fecth Blogs-----------");
		List<Blog> user0Blogs = blogService.findBlogsByUserId(0); 		// User0'in Blogları alınır
		user0Blogs.forEach(System.out::println);
		
		System.out.println("---------Remove Blog-----------");
		blogService.removeBlog(user0Blogs.get(0)); 						// User0'in ilk blogu yayından kaldırıldı.
		userService.setBlogIds(0, blogService.findBlogsIdByUserId(0)); 	// User0'in blog listesi guncellenir
		
		
		System.out.println("---------ReFecth Blogs-----------");
		List<Blog> user0Blogs2 = blogService.findBlogsByUserId(0);		// User0'in Blogları tekrar alınır
		user0Blogs2.forEach(System.out::println);
		
		
		System.out.println("---------Following Users-----------");
		userService.followUserById(users.get(0), 1);  // User0 istenilen userslara abone oldu
		userService.followUserById(users.get(0), 2);
		userService.followUserById(users.get(0), 4);
		for (Integer userId : users.get(0).getFollowingIds()) { 
			System.out.println(userService.findUserById(userId));
		}
		
		
		System.out.println("---------List subscribed Tags -----------");
		userService.subscribeTag(users.get(0), "Java"); // User0 istenilen tag'e abone olabilir
		userService.subscribeTag(users.get(0), "Python");
		System.out.println(users.get(0));
		

	}

	private static List<User> dummyUsers() {
		User user = new User("Huseyin", "hsy@gmail.com", "S3cret");
		User user1 = new User("John", "doe@gmail.com", "S3cret");
		User user2 = new User("Lia", "hmanoch9@time.com", "QQJrthPrHiW6");
		User user3 = new User("Antonia", "tharsent1@dot.gov", "tuAL8ln4ti");
		User user4 = new User("Lia", "idegliabbati2@dagondesign.com", "");
		User user5 = new User("Laure", "jsueter3@sphinn.com", "rv4Ws0");
		return Arrays.asList(user,user1, user2, user3, user4, user5);
	}

	private static List<Blog> dummyBlogs() {
		Blog blog = new Blog("Java", "Pattern Design", 1); 					// tag, title, userId
		Blog blog1 = new Blog("React", "React Hooks", 2);
		Blog blog2 = new Blog("Java", "Hello Java", 3 , Status.PUBLISHED); // tag, title, userId, status
		Blog blog3 = new Blog("JavaScript", "Hello JS", 0, Status.PUBLISHED); 
		Blog blog4 = new Blog("Python", "Hello Python", 2);
		Blog blog5 = new Blog("Java", "Collections", 0,  Status.PUBLISHED);
		Blog blog6 = new Blog("Python", "Django", 4);
		Blog blog7 = new Blog("React", "Redux'a giriş", 0);

		return Arrays.asList(blog, blog1, blog2, blog3, blog4, blog5, blog6, blog7);
	}
}
