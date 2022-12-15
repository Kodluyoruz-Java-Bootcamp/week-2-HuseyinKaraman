package emlakcepte;

import java.time.LocalDateTime;
import java.util.Arrays;
import emlakcepte.factory.MyBeanFactory;
import emlakcepte.factory.Type;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

/**
 *  @Note: MyBeanFactory class'indan istenilen pattern'e göre çıktı uretilecektir 
 * @author hsykrmn
 *
 */
public class Main {

	public static void main(String[] args) {
		
		UserService userService = MyBeanFactory.getInstanceUserService(Type.SINGLETON);
		RealtyService realtyService = MyBeanFactory.getInstanceRealtyService(Type.SINGLETON);
		
		User userPelin = MyBeanFactory.getInstanceUser(Type.PROTOTYPE);
		userPelin.setName("Pelin");
		userPelin.setMail("mimar.pelin@gmail.com");
		userPelin.setPassword("Pelin123");
		
		User userSami = MyBeanFactory.getInstanceUser(Type.PROTOTYPE);
		userSami.setName("Sami");
		userSami.setMail("sami@gmail.com");
		userSami.setPassword("123");
		
		
		/** @Note: clone userlar oluşturuldu. */ 
		User clonePelin = MyBeanFactory.getInstanceUser(Type.PROTOTYPE);
		clonePelin.setName("clonePelin");
		User cloneSami = MyBeanFactory.getInstanceUser(Type.PROTOTYPE);
		cloneSami.setName("cloneSami");
		
		/** @Note:  userDao objelerinde oluşturulacak olan singleton obje'nin adresleri gösterilecek*/
		userService.createUser(userPelin);
		userService.createUser(userSami);
		userService.createUser(cloneSami);
		userService.createUser(userPelin);
		
		userService.printAllUser();


		Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
				RealtyType.ACTIVE);
		realty.setProvince("İstanbul");

		Realty realty1 = new Realty(124L,"Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA",LocalDateTime.now(),userPelin,RealtyType.ACTIVE);
		realty1.setProvince("Ankara");
		
		/** @Note: clone Realty'ler oluşturuldu */
		Realty cloneRealty = (Realty) realty.getClone();
		cloneRealty.setTitle("CLONE "+ cloneRealty.getTitle());
		Realty cloneRealty1 = (Realty) realty1.getClone();
		cloneRealty1.setTitle("CLONE "+ cloneRealty.getTitle());
		
		
		realtyService.createRealty(realty);
		realtyService.createRealty(realty1);
		realtyService.createRealty(cloneRealty);
		realtyService.createRealty(cloneRealty1);

		userSami.setRealtyList(Arrays.asList(realty, cloneRealty));
		userPelin.setRealtyList(Arrays.asList(realty1, cloneRealty1));

		// sistemdeki bütün ilanlar

		System.out.println("Bütün ilanlar");

		realtyService.printAll(realtyService.getAll());

		
	}

}
