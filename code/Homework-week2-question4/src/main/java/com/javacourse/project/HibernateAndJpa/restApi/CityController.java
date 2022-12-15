package com.javacourse.project.HibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.HibernateAndJpa.business.ICityService;
import com.javacourse.project.HibernateAndJpa.entities.City;

@RestController
@RequestMapping("/api")
public class CityController {

	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	/** @Note: http://localhost:8080/api/cities  */
	@GetMapping("/cities")
	public List<City> get() {
		 return cityService.getAll();
	}
	
	/** @Note: Yeni City ekler parametreleri yapılan istegin body'sinde alıcagız */
	@PostMapping("/add")
	public void add(@RequestBody City city) { 
		 cityService.add(city);
	}
	
	/** @Note: Var olan city gunceller
	 * @param city
	 */
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		 cityService.update(city);
	}
	
	/** @Note: var olan city siler
	 * @param city
	 */
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		 cityService.delete(city);
	}
	
	/** @Note: id'si girilen city'i verecektir.
	 * @param id
	 * @return
	 */
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id) {
		 return cityService.getById(id);
	}
	
}
