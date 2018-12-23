package ood.reservationsystem;

public class Reservation {
	
	private String user_id;
	private Table table;
	private int customer_num;
	private int start;
	private int end;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public int getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
