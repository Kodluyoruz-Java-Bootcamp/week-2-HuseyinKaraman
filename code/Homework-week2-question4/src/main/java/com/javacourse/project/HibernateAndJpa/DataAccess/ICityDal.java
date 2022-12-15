package com.javacourse.project.HibernateAndJpa.DataAccess;

import java.util.List;

import com.javacourse.project.HibernateAndJpa.entities.City;

public interface ICityDal {
	List<City> getAll();
	
	City getById(int id);

	void add(City city);

	void update(City city);

	void delete(City city);
}
