package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.factory.Prototype;
import emlakcepte.model.Realty;

public class RealtyDao implements Prototype{
	
	private static List<Realty> realtyList = new ArrayList<>();
	
	public void saveRealty(Realty realty) {
		realtyList.add(realty);
	}
	
	public List<Realty> findAll(){
		return realtyList;
	}

	@Override
	public Prototype getClone() {
		return new RealtyDao();
	}

	
}
