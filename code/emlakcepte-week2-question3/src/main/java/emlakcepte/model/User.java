package emlakcepte.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import emlakcepte.factory.Prototype;

/**
 * @Note: getClone methodu ile User'in aynı özelliklere sahip clonu oluşturulur.
 * @author hsykr
 *
 */
public class User implements Prototype{
	
	private String name;
	private String mail;
	private String password;
	private UserType type;
	private List<Realty> realtyList;	
	private List<Realty>  favoriteRealtyList;
	private List<Message> messages;
	private LocalDateTime createDate;
	

	public User() {
		this("","","",UserType.INDIVIDUAL,new ArrayList<>());
	}
	public User(String name, String mail, String password, UserType type, List<Realty> realtyList) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.type = type;
		this.realtyList = realtyList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public List<Realty> getRealtyList() {
		return realtyList;
	}
	public void setRealtyList(List<Realty> realtyList) {
		this.realtyList = realtyList;
	}
	public List<Realty> getFavoriteRealtyList() {
		return favoriteRealtyList;
	}
	public void setFavoriteRealtyList(List<Realty> favoriteRealtyList) {
		this.favoriteRealtyList = favoriteRealtyList;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", mail=" + mail + ", password=" + password + ", type=" + type +   "createDate="
				+ createDate + "]";
	}
	
	@Override
	public Prototype getClone() {
		User newUser = new User(name, mail, password, type, realtyList);
		newUser.setMessages(messages);
		newUser.setFavoriteRealtyList(favoriteRealtyList);
		newUser.setCreateDate(createDate);
		return newUser;
	}


}
