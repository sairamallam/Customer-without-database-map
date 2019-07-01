package com.customerapp.dto;

public class CustomerDetailsDto {

	private int id;
	   private String name;
	   private long phone;
		private String role;
	   public int getId() {
		return id;
	}
	   
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
