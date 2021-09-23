package com.main;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author faraz
 * This class represents contact object and its fields
 */
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
		return "first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone_number=" + phone_number + ", email=" + email;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(first_name, last_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(first_name, other.first_name) && Objects.equals(last_name, other.last_name);
	}

}
