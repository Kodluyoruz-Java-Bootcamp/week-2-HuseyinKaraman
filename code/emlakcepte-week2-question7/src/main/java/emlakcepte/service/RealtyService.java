package emlakcepte.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.Realty;
import emlakcepte.model.enums.PropertyType;
import emlakcepte.model.enums.UserType;

@Service
public class RealtyService {

	@Autowired
	private RealtyDao realtyDao;

	/**
	 * @Note:Oluşturulan realty kayıt edilir.
	 * @param realty
	 */
	public void createRealty(Realty realty) {
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			List<Realty> realtyList = realty.getUser().getRealtyList();
			if (realtyList.size() > 2) {
				System.err.println("İlanınız kaydedilmedi!. Bireysel kullanıcı tipi maksimum 3 ilan verilebilir");
				return;
			}else if (realty.getPropertyType().equals(PropertyType.COMMERCIAL)) {
				System.err.println("İlanınız kaydedilmedi!.Commercial tipinde ilan veremezsiniz!");
				return;
			}
		}
		realty.getUser().getRealtyList().add(realty);
		realtyDao.saveRealty(realty);
	}

	/** 
	 * @Note: girilen realty silinir
	 * @param realty
	 */
	public void deleteRealty(Integer realtyId) {
		Realty findRealtyById = realtyDao.findRealtyByRealtyId(realtyId);
		if (Objects.nonNull(findRealtyById)) {
			realtyDao.deleteRealty(findRealtyById);
		}
	}
	
	/**
	 * @Note: butun realty'leri verir
	 * @return
	 */
	public List<Realty> getAll() {
		return realtyDao.findAll();
	}
	 
	/**  @Note: Butun ilanları yazdırır.
	 * 
	 */
	public void printAll() {
		getAll().forEach(System.out::println);
	}

	/**
	 * @Note: Girilen realtyId'sine ait Realty'i doner
	 * @param realtyId
	 * @return
	 */
	public Realty findRealtyByRealtyId(Integer realtyId) {
		return realtyDao.findRealtyByRealtyId(realtyId);
	}
	
	/**
	 * @Note:Email'i girilen kullanıcıya ait realtyleri verir.
	 * @param email
	 * @return
	 */
	public void printAllByUserEmail(String email) {
		realtyDao.getRealtyByUserMail(email).forEach(System.out::println);
	}

	/**@Note:  Girilen il veya iller 'de bulunan ilanları verir
	 * @param province
	 * @return
	 */
	public List<Realty> findAllRealtyByProvince(String... province) {
		return realtyDao.findRealtyByProvince(province);
	}

	/**@Note: girilen il veya iller'de bulunan aktif ilanları verir
	 * @param province
	 */
	public List<Realty> findActiveRealtyByProvince(String... province) {
		return  realtyDao.findActiveRealtyByProvince(province);
	}
	
	/**@Note: Girilen il veya iller 'de bulunan satılık ilanları verir
	 * @param province
	 * @return
	 */
	public List<Realty> findSaleRealtyByProvince(String... province) {
		return realtyDao.findSaleRealtyByProvince(province);
	}
	
	/**
	 * @Note: girilen il ve ilçeye göre bulunan Realty'leri verir
	 * @param province
	 * @param district
	 * @return
	 */
	public List<Realty> findRealtyByProvinceAndDistrict(String province, String...  district) {
		return realtyDao.findRealtyByProvinceAndDistrict(province, district);
	}

	/**
	 * @Note: Girilen ile ait vitrini verir. 
	 * @return
	 */
	public List<Realty> provinceShowcase(String province) {
		List<String> provinceList = provinceList();
		if (!provinceList.contains(province)) System.err.println("Girilen il bulunamadı"); 
		return realtyDao.provinceShowcase(provinceList).get(province.toLowerCase());
	}
	
	/**
	 * @Note: sistemde bulunan iller bulunur
	 * @return
	 */
	 private List<String> provinceList() {
		return realtyDao.findAll().stream().map(Realty::getProvince).distinct().collect(Collectors.toList());
	 }

}
