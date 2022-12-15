package emlakcepte.model;

import java.time.LocalDateTime;

import emlakcepte.model.enums.SalesType;
import emlakcepte.model.enums.PropertyType;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.utils.IdGenerator;

public class Realty {
	
	private Long id;
	private String title;
	private LocalDateTime publishedDate;
	private User user;
	private String province;
	private String district;
	private RealtyType status;
	private SalesType categoryType;
	private PropertyType propertyType;
	
	public Realty() {
		this("BAŞLIK GİRİNİZ",null,RealtyType.PASSIVE,SalesType.SALE,PropertyType.RESIDENTAL);
	}
	
	public Realty(String title, User user, RealtyType status, SalesType categoryType, PropertyType propertyType) {
		this.id = IdGenerator.getRealtyIdGenerator();
		this.title = title;
		this.publishedDate = LocalDateTime.now();
		this.user = user;
		this.status = status;
		this.propertyType = propertyType;
		this.setCategoryType(categoryType);
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public RealtyType getStatus() {
		return status;
	}

	public void setStatus(RealtyType status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}

	public SalesType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(SalesType categoryType) {
		this.categoryType = categoryType;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	@Override
	public String toString() {
		return "Realty [no=" + id + ", title=" + title + ", userName=" + user.getName() + ", userId=" + user.getUserId() + ", status=" + status + ", province="
				+ province + ", district=" + district + "]";
	}

}
