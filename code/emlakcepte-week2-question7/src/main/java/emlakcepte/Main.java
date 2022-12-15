package emlakcepte;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.SalesType;
import emlakcepte.model.enums.PropertyType;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.model.utils.createUtils;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		UserService userService = context.getBean(UserService.class);
		RealtyService realtyService = context.getBean(RealtyService.class);

		List<User> dummyUsers = dummyUsers(); // dummy User'lar oluşturuldu.
		/* Kullanıcılar sisteme kayıt edilir */
		dummyUsers.forEach(userService::createUser);

		/**
		 * @NOTE: dummyRealties metodunda kullanıcının fazladan ilan vermesi ve konut
		 *        tipi harici ilan verme senaryosunu içermektedir creatyRealty'de hata
		 *        mesajı verecek
		 */
		List<Realty> dummyRealty = dummyRealties(dummyUsers); // dummy Realty'lar oluşturuldu.
		/* Realty'ler sisteme kayıt edilir */
		dummyRealty.forEach(realtyService::createRealty);

		/** @Note: Sisteme kayıtlı tüm kullanıcıları yazdıracak */
//		userService.printAllUser();
		/** @Note: Sisteme kayıtlı ilanları yazdırıcak */
//		realtyService.printAll(); 	

		
		/** @Note: Şehir ve ilçe bazlı arama : Istanbul ilinde kadiköy ve Beylikdüzü ilçesinde bulunan ilanlar : */
//		System.out.println("-------------Istanbul ilinde kadiköy ve Beylikdüzü ilçesinde bulunan ilanlar -----------------");
//		realtyService.findRealtyByProvinceAndDistrict("istanbul", "kadıköy","beylikdüzü").forEach(System.out::println);
//		// veya Ankara ili çankaya ilçesinde bulunan ilanları ver :  
//		System.out.println("------------- Ankara ili çankaya ilçesinde bulunan ilanları ver -----------------");
//		realtyService.findRealtyByProvinceAndDistrict("Ankara", "Çankaya").forEach(System.out::println);
		
		
		/** @Note: Istanbul,Ankara,izmir'de bulunan ilanlar ve sayısı yazdırılacak */
//		System.out.println("-------------Istanbul,Ankara,izmir'de bulunan ilanlar -----------------");
//  		Integer findAllRealtySizeByProvince = realtyService.findAllRealtySizeByProvince("istanbul", "ankara", "izmir");
//  		System.out.println("Aramadaki ilan sayısı : " + findAllRealtySizeByProvince);
//		realtyService.findAllRealtyByProvince("istanbul", "ankara", "izmir");

		
		/** @Note: Istanbul,Ankara,izmir'de bulunan satılık ilanların sayısı yazdırılacak */
//		System.out.println("\n-------------Istanbul,Ankara,izmir'de bulunan satılık ilanlar -----------------");
//		List<Realty> saleRealty = realtyService.findSaleRealtyByProvince("istanbul", "ankara", "izmir");
//		System.out.println("Aramadaki satılık ilan sayısı : " + saleRealty.size());"

		
		/** @Note: Girilen ile ait ilanlardan oluşturulmuş sehir vitrinini verecektir */
		System.out.println("\n---------İstanbul iline ait oluşturulmus şehir vitrini---------");
		realtyService.provinceShowcase("istanbul")
		.forEach(it->System.out.println(it));
		System.out.println("---------Ankara iline ait oluşturulmus şehir vitrini---------");
		realtyService.provinceShowcase("Ankara")
		.forEach(it->System.out.println(it));
		
		
//		Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
//				userSami);
//		userSami.setMessages(Arrays.asList(message));
//		userPelin.setMessages(Arrays.asList(message));
//		userSami.getMessages();
	}

	private static List<User> dummyUsers() {
		User userPelin = createUtils.prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
		User userSami = new User("Sami", "sami@gmail.com", "12345", UserType.INDIVIDUAL);
		User userHuseyin = new User("huseyin", "hsyn@gmail.com", "12345", UserType.INDIVIDUAL);
		User userCem = new User("Cem", "cem@gmail.com", "12345", UserType.INDIVIDUAL);

		return Arrays.asList(userPelin, userSami, userHuseyin, userCem);
	}

	private static List<Realty> dummyRealties(List<User> users) {
		Realty realty = createUtils.prepareRealty("ZEKERİYAKÖY ' de 1200 M2 kiralık VİLLA", "Istanbul", "Beylikdüzü",
				users.get(0), RealtyType.PASSIVE, SalesType.RENT, PropertyType.RESIDENTAL);
		Realty realty1 = createUtils.prepareRealty("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA",
				"Istanbul", "Kadıköy", users.get(0), RealtyType.ACTIVE, SalesType.SALE, PropertyType.RESIDENTAL);
		Realty realty2 = createUtils.prepareRealty("AKTOPRAK MAHALLESİ FULL TADİLATLI 3+1 SATILIK DAİRE ", "Izmir",
				"Karşıkaya", users.get(1), RealtyType.PASSIVE, SalesType.SALE, PropertyType.RESIDENTAL);
		Realty realty3 = createUtils.prepareRealty("Kadriye de site içinde kiralık eşyalı triplex villa", "Antalya",
				"Serik", users.get(1), RealtyType.ACTIVE, SalesType.RENT, PropertyType.RESIDENTAL);
		Realty realty4 = createUtils.prepareRealty("KUŞADASI DAVUTLARDA SATILIK 2+1 ARAKAR SIFIR DAİRE", "Aydın",
				"Davutlar", users.get(1), RealtyType.ACTIVE, SalesType.SALE, PropertyType.RESIDENTAL);
		Realty realty5 = createUtils.prepareRealty("Konya Karatay Atiker Kooperatif'te Satılık Dükkan", "Konya",
				"Karatay", users.get(2), RealtyType.ACTIVE, SalesType.SALE, PropertyType.RESIDENTAL);
		Realty realty6 = createUtils.prepareRealty("Nişantaşı Abdi İpekçi Caddesi Köşe Mülk Satılık", "Istanbul",
				"Kadıköy", users.get(2), RealtyType.ACTIVE, SalesType.SALE, PropertyType.RESIDENTAL);
		Realty realty7 = createUtils.prepareRealty("ALACAATLI'DA SIFIR BİNADA KAT SEÇENEKLERİYLE 4+1 KİRALIK DAİRELER",
				"Ankara", "Çankaya", users.get(3), RealtyType.ACTIVE, SalesType.RENT, PropertyType.RESIDENTAL);
		Realty realty8 = createUtils.prepareRealty("KAZIM KARABEKİR MAHALLESİNDE FULL YAPILI 3+1 SATILIK DAİRE!!",
				"Ankara", "Etimesgut", users.get(3), RealtyType.ACTIVE, SalesType.SALE, PropertyType.RESIDENTAL);
		Realty realty9 = createUtils.prepareRealty("ÇETİN EMLAK'TAN PROTOKOL YOLU YAK.MANZARALI 9.KAT 4+1 DAİRE",
				"Ankara", "Çankaya", users.get(3), RealtyType.PASSIVE, SalesType.RENT, PropertyType.RESIDENTAL);

		/**
		 * @Note : son user 4 ilan hazırladı son ilan createRealty'de kayıt edilmeyecek
		 *       ve hata mesajı verecek
		 */
		Realty realty10 = createUtils.prepareRealty("MANZARALI 9.KAT 4+1 DAİRE", "Sivas", "Merkez", users.get(3),
				RealtyType.ACTIVE, SalesType.RENT, PropertyType.RESIDENTAL);
		/** @Note : ilk user COMMERCIAL tipinde ilan hazırladı ama kayıt edilmeyecek */
		Realty realty11 = createUtils.prepareRealty("MANZARALI 9.KAT 4+1 DAİRE", "Kayseri", "Merkez", users.get(0),
				RealtyType.ACTIVE, SalesType.RENT, PropertyType.COMMERCIAL);

		return Arrays.asList(realty, realty1, realty2, realty3, realty4, realty5, realty6, realty7, realty8, realty9,
				realty10, realty11);
	}

}
