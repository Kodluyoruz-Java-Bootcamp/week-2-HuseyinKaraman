package emlakcepte;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import emlakcepte.dao.RealtyDao;
import emlakcepte.dao.UserDao;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;



@Configuration
public class BeanConfig {
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public RealtyService realtyService() {
		return new RealtyService();
	}
	
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}

	@Bean
	public RealtyDao realtyDao() {
		return new RealtyDao();
	}
}
