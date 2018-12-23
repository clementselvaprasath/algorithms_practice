package ood.reservationsystem;

public interface ReservationSystem<K> {
	
	boolean reserve(K res);
	
	K getReserveInfo(String id);
}
