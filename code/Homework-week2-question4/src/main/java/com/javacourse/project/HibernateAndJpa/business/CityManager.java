package com.javacourse.project.HibernateAndJpa.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.HibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.HibernateAndJpa.entities.City;

@Service
public class CityManager implements ICityService {

	private ICityDal cityDal;	
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return this.cityDal.getAll();
	}
	

	@Override
	@Transactional
	public City getById(int id) {
		return this.cityDal.getById(id);
	}

	@Override
	@Transactional
	public void add(City city) {
		 // TODO: business logic, this city maybe exist ? 
		this.cityDal.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		 // TODO: business logic,
		this.cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		 // TODO: business logic,
		this.cityDal.delete(city);
	}


}
