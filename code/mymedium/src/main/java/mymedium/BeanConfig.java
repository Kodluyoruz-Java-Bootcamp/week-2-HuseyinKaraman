package mymedium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mymedium.dao.BlogDao;
import mymedium.dao.UserDao;
import mymedium.service.BlogService;
import mymedium.service.UserService;


@Configuration
public class BeanConfig {
		
	@Bean
	@Scope("singleton")
	public UserDao userDao() {
		return new UserDao();
	}
	
	@Bean
	@Scope("singleton")
	public BlogDao blogDao() {
		return new BlogDao();
	}
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public BlogService blogService() {
		return new BlogService();
	}
	
}
