package emlakcepte.model.utils;

import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.SalesType;
import emlakcepte.model.enums.PropertyType;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;

public class createUtils {

	private createUtils() {}
	
	public static User prepareUser(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(email);
		user.setPassword(password);
		user.setType(UserType.INDIVIDUAL);
		return user;
	}

	public static Realty prepareRealty(String title, String province, String district, User user, RealtyType status, SalesType categoryType, PropertyType propertyType) {
		Realty realty = new Realty();
		realty.setTitle(title);
		realty.setUser(user);
		realty.setProvince(province);
		realty.setDistrict(district);
		realty.setStatus(status);
		realty.setCategoryType(categoryType);
		realty.setPropertyType(propertyType);
		return realty;
	}

	
}
