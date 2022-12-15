package com.javacourse.project.HibernateAndJpa.business;

import java.util.List;

import com.javacourse.project.HibernateAndJpa.entities.City;

// ilerde fonksiyonlarının imzası degişebilecegi için ICityDal Kullanılmadı!
public interface ICityService {
	List<City> getAll();

	City getById(int id);
	
	void add(City city);

	void update(City city);

	void delete(City city);
}
