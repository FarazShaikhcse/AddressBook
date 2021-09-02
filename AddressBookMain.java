package com.main;

public class AddressBookMain {
	
	public static Contact contact;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program");
		contact = new Contact("Rahul","Shetty","bypass road","Mangalore","Karnataka","574104","9876543210","shettyrahul@gmail.com");
		System.out.println("The contact is: "+contact);

	}

}
