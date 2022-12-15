package emlakcepte.factory;

import java.util.List;

import emlakcepte.model.Realty;
import emlakcepte.model.UserType;

public class UserPrototype implements Prototype {

	
	private String name;
	private String mail;
	private String password;
	private UserType type;
	private List<Realty> realtyList;	
	
	@Override
	public Prototype getClone() {
		return null;
	}

}
