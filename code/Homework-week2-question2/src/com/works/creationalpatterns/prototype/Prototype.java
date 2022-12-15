package com.works.creationalpatterns.prototype;

/**
 * Prototip deseni belirli nesnelerin kopyasını oluşturarak daha sonra yapılacak işlemler için, 
 * oluşturulan kopyanın kullanılmasını sağlayan yaratımsal desendir. 
 * @author hsykrmn
 */
public interface Prototype {
	
	public Prototype getClone();
}
