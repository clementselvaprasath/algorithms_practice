package ood.lockersystem;

public class Locker {
	private long id;
	private long timestamp;
	private LockerSize size;
	
	public void open() {
		
	}
	
	public boolean unlock() {
		return false;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public LockerSize getSize() {
		return size;
	}
	public void setSize(LockerSize size) {
		this.size = size;
	}
}
