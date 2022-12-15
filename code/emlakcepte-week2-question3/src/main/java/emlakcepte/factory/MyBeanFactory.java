package emlakcepte.factory;

import java.util.Objects;

import emlakcepte.dao.RealtyDao;
import emlakcepte.dao.UserDao;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class MyBeanFactory {

	// Objeye ait tek instance'i olacak.
	private static UserService INSTANCE_USERSERVICE = null;
	private static RealtyService INSTANCE_REALTYSERVICE = null;
	private static UserDao INSTANCE_USERDAO = null;
	private static RealtyDao INSTANCE_REALTYDAO = null;
	private static User INSTANCE_USER = null;
	private static Realty INSTANCE_REALTY = null;

	// constructor ile instance olusturulmasını onlenir
	private MyBeanFactory() {}

	
	 /**
	 * @Note: Type -> Singleton veya Prototype olabilir istenilen pattern'e göre cıktı verecektir.
	 * Class uzerinde erişim izni var.
	 * Eger başlangıçta nesne null ise yeni nesne oluşturulur.
	 * Signleton type'i seçilirse tek tek instance oluşturulacaktır.
	 * Prototype seçilirse aynı ozelliklere sahip clonlar oluşturulur
	 */
	
	public static UserService getInstanceUserService(Type type) {
		if (Objects.isNull(INSTANCE_REALTYSERVICE)) INSTANCE_USERSERVICE = new UserService(); 
		return type.equals(Type.SINGLETON) ? INSTANCE_USERSERVICE : (UserService) INSTANCE_USERSERVICE.getClone();
	}

	public static RealtyService getInstanceRealtyService(Type type) {
		if (Objects.isNull(INSTANCE_REALTYSERVICE)) INSTANCE_REALTYSERVICE = new RealtyService();
		return type.equals(Type.SINGLETON) ? INSTANCE_REALTYSERVICE : (RealtyService) INSTANCE_REALTYSERVICE.getClone();
	}

	public static UserDao getInstanceUserDao(Type type) {
		if (Objects.isNull(INSTANCE_USERDAO)) INSTANCE_USERDAO = new UserDao();
		return type.equals(Type.SINGLETON) ? INSTANCE_USERDAO : (UserDao) INSTANCE_USERDAO.getClone();
	}

	public static RealtyDao getInstanceRealtyDao(Type type) {
		if (Objects.isNull(INSTANCE_REALTYDAO))	INSTANCE_REALTYDAO = new RealtyDao();
		return type.equals(Type.SINGLETON) ? INSTANCE_REALTYDAO : (RealtyDao) INSTANCE_REALTYDAO.getClone();
	}
	
	public static User getInstanceUser(Type type) {
		if (Objects.isNull(INSTANCE_USER)) INSTANCE_USER= new User();
		return type.equals(Type.SINGLETON) ? INSTANCE_USER : (User) INSTANCE_USER.getClone();
	}
	
	public static Realty getInstanceRealty(Type type) {
		if (Objects.isNull(INSTANCE_REALTY)) INSTANCE_REALTY = new Realty();
		return type.equals(Type.SINGLETON) ? INSTANCE_REALTY : (Realty) INSTANCE_REALTY.getClone();
	}

}
