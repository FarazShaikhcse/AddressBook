package com.main;

public class Contact {
		
	public String first_name;
	public String last_name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone_number;
	public String email;
	

	@Override
	public String toString() {
		return "first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", phone_number=" + phone_number + ", email=" + email;
	}
	

}
