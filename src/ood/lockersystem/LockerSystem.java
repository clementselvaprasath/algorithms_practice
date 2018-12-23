package ood.lockersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LockerSystem {
	private Map<String, Locker> occupiedLockers = new ConcurrentHashMap<String, Locker>();
	private List<Locker> regularLockers = new ArrayList<Locker>();
	private List<Locker> largerLockers = new ArrayList<Locker>();
	
	public Locker fetchLocker() {
		
		return null;
	}
	
	public boolean unlock(String token) {
		return false;
	}
}
