package emlakcepte.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import emlakcepte.model.Realty;
import emlakcepte.model.enums.SalesType;
import emlakcepte.model.enums.RealtyType;

@Repository
public class RealtyDao {

	private static List<Realty> realtyList = new ArrayList<>();

	/**
	 * @Note:Oluşturulan realty kayıt edilir.
	 * @param realty
	 */
	public void saveRealty(Realty realty) {
		realtyList.add(realty);
	}

	/**
	 * @Note: girilen realty silinir
	 * @param realty
	 */
	public void deleteRealty(Realty realty) {
		realtyList.remove(realty);
	}

	/**
	 * @Note: butun realty'leri verir
	 * @return
	 */
	public List<Realty> findAll() {
		return realtyList;
	}

	/**
	 * @Note: Girilen realtyId'sine ait Realty'i doner
	 * @param realtyId
	 * @return
	 */
	public Realty findRealtyByRealtyId(Integer realtyId) {
		List<Realty> collect = realtyList.stream().filter(it -> Objects.equals(it.getId().intValue(), realtyId))
				.collect(Collectors.toList());
		return !collect.isEmpty() ? collect.get(0) : null;
	}

	/**
	 * @Note:Email'i girilen kullanıcıya ait realtyleri verir.
	 * @param email
	 * @return
	 */
	public List<Realty> getRealtyByUserMail(String email) {
		return findAll().stream().filter(realty -> realty.getUser().getMail().equals(email))
				.collect(Collectors.toList());
	}

	/**
	 * @Note:Girilen il veya iller 'de bulunan ilanları verir
	 * 
	 * @param province
	 * @return
	 */
	public List<Realty> findRealtyByProvince(String... province) {
		return realtyList.stream()
				.filter(it -> Arrays.toString(province).toLowerCase().contains(it.getProvince().toLowerCase()))
				.collect(Collectors.toList());
	}

	/**
	 * @Note:Girilen il veya iller 'de bulunan aktif ilanları verir
	 * 
	 * @param province
	 * @return
	 */
	public List<Realty> findActiveRealtyByProvince(String... province) {
		return realtyList.stream()
				.filter(it -> Arrays.toString(province).toLowerCase().contains(it.getProvince().toLowerCase()))
				.filter(it -> it.getStatus().equals(RealtyType.ACTIVE)).collect(Collectors.toList());
	}

	/**
	 * @Note:Girilen il veya iller 'de bulunan satılık ilanları verir
	 * 
	 * @param province
	 * @return
	 */
	public List<Realty> findSaleRealtyByProvince(String... province) {
		return realtyList.stream()
				.filter(it -> Arrays.toString(province).toLowerCase().contains(it.getProvince().toLowerCase()))
				.filter(it -> it.getCategoryType().equals(SalesType.SALE)).collect(Collectors.toList());
	}

	/**
	 * @Note: girilen il ve ilçeye göre bulunan Realty'leri verir
	 * @param province
	 * @param district
	 * @return
	 */
	public List<Realty> findRealtyByProvinceAndDistrict(String province, String... district) {
		return findRealtyByProvince(province).stream()
				.filter(it -> Arrays.toString(district).toLowerCase().contains(it.getDistrict().toLowerCase()))
				.collect(Collectors.toList());
	}

	/**
	 * @Note: Her ile ait Vitrin olusturulacak maksimum 10 tane elemana sahip olacak
	 * @return
	 */
	public Map<String, List<Realty>> provinceShowcase(List<String> provinces) {
		Map<String, List<Realty>> showcase = new LinkedHashMap<>();
		for (String province : provinces) {
			List<Realty> findRealtyByProvince = findRealtyByProvince(province);
			showcase.put(province.toLowerCase(),
					findRealtyByProvince.size() > 10 ? findRealtyByProvince.subList(0, 9) : findRealtyByProvince);
		}
		return showcase;
	}

	
}
