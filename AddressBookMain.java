package com.main;

import java.util.Scanner;

public class AddressBookMain {
	
	public static Contact contact;
	
	public static void main(String[] args) {
		
		int n;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Address Book Program");
		System.out.println("Enter the number of contacts to add:");
		n = scanner.nextInt();
		
		Contact[] contacts = new Contact[n];
		for(int i=0;i<n;i++) //for loop to add n people
		{
			contacts[i] = new Contact();
			System.out.println("Enter first Name:");
			contacts[i].first_name = scanner.next();
			System.out.println("Enter last name:");
			contacts[i].last_name = scanner.next();
			System.out.println("Enter address:");
			contacts[i].address = scanner.next();
			System.out.println("Enter city:");
			contacts[i].city = scanner.next();
			System.out.println("Enter state:");
			contacts[i].state = scanner.next();
			System.out.println("Enter zip:");
			contacts[i].zip = scanner.next();
			System.out.println("Enter phone number");
			contacts[i].phone_number  = scanner.next();
			System.out.println("Enter E-mail:");
			contacts[i].email = scanner.next();
		}
		
		
		System.out.println("Contact Details are:");
		for(int i=0;i<n;i++)
		{
			System.out.println("Details of person" + i+1);
			System.out.println(contacts[i]);
			
		}
		

	}

}
