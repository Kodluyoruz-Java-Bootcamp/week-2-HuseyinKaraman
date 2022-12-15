package com.javacourse.project.HibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.HibernateAndJpa.entities.City;

/** @Note: JPA -ORM hibernate de spring'de JPA 'i implemente ediyor */
@Repository /* repo katmanı oldugunu bildiriyoruz! */
public class HibernateCityDal implements ICityDal {

	private EntityManager entityManager;

	@Autowired // constructor injection!
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // AOP -> Aspect Oriented Programming -> session açma kapama kodlarını kendi ekliyor!
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class); // hibernate session'i ver
		// Bize butun City 'leri verecektir
		List<City> cities = session.createQuery("From City c", City.class).getResultList(); 
		return cities;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		// yeni bir city ekler
		session.saveOrUpdate(city);
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		// var olan city guncellenir
		session.saveOrUpdate(city);
	}

	@Override
	public void delete(City city) { // direk city verince map edemedi bizde once id ile çektik sonra onu object olarak verdik
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete); 
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		// Id si girilen city 'i verir
		City city = session.get(City.class, id);
		return city;
	}

}
