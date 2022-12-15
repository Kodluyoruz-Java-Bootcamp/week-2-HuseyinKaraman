package emlakcepte.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.factory.MyBeanFactory;
import emlakcepte.factory.Prototype;
import emlakcepte.factory.Type;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class RealtyService implements Prototype {
	
	private RealtyDao realtyDao = MyBeanFactory.getInstanceRealtyDao(Type.PROTOTYPE);
	
	public void createRealty(Realty realty) {			
		realtyDao.saveRealty(realty);
		System.out.println("createRealty :: " + realty.getTitle());
	}
	
	public List<Realty> getAll(){
		return realtyDao.findAll();
	}
	
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {
		
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		//.count();
		.forEach(realty -> System.out.println(realty));
		
	}
	
	public List<Realty> getAllByUserName(User user){	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail())).collect(Collectors.toList());
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.collect(Collectors.toList());
	}

	@Override
	public Prototype getClone() {
		return new RealtyService();
	}

}
