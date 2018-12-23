package ood.reservationsystem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ResterauntReservationSystem implements ReservationSystem<Reservation> {
	
	TableManagement table_management;
	Map<String, Deque<Reservation>> reservations = new HashMap<>();
	
	@Override
	public boolean reserve(Reservation res) {
		Table t = table_management.getTable(res.getStart(), res.getEnd(), res.getCustomer_num());
		if (t == null) return false;
		
		if (reservations.get(res.getUser_id()) == null) {
			reservations.put(res.getUser_id(), new ArrayDeque<>());
		}
		reservations.get(res.getUser_id()).add(res);
		
		return true;
	}

	@Override
	public Reservation getReserveInfo(String id) {
		if (!reservations.containsKey(id)) return null;
		Deque<Reservation> q = reservations.get(id);
		
		Reservation res = q.pollFirst();
		if (q.size() == 0) reservations.remove(id);
		
		return res;
	}
}
