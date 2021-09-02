package com.main;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

	public static ArrayList<Contact> contacts = new ArrayList<>();

	public static void main(String[] args) {

		int choice = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Address Book Program");

		while (choice != 4) {
			System.out.println("Enter your choice\n1.Add Contact\n2.Edit Contact\n3.Display AddressBook\n4.Exit"); 
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addContact();
				break;

			case 2:
				editContact();
				break;

			case 3:
				display();
				break;
			}
		}

	}

	private static void display() {

		System.out.println("Contact Details are:\n");
		for (int j = 0; j < contacts.size(); j++) {

			System.out.println("Contact details of person" + j + 1);
			System.out.println(contacts.get(j) + "\n");
		}
	}

	private static void editContact() {

		Boolean flag = false;
		System.out.println("Enter the name of the person whose contact is to be edited"); // to edit existing address
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		for (int j = 0; j < contacts.size(); j++) {

			if (contacts.get(j).first_name.equals(name)) {
				flag = true;
				System.out.println("Enter the field which you want to edit\n1.first name\n2.last name\n3.address\n4.city\n5.state\n6.zip\n7.phone number\n8.email");
				int choice = scanner.nextInt();
				switch (choice) {

				case 1:
					System.out.println("Enter first name:");
					contacts.get(j).first_name = scanner.next();
					break;

				case 2:
					System.out.println("Enter last name:");
					contacts.get(j).last_name = scanner.next();
					break;

				case 3:
					System.out.println("Enter address:");
					contacts.get(j).address = scanner.next();
					break;

				case 4:
					System.out.println("Enter city:");
					contacts.get(j).city = scanner.next();
					break;

				case 5:
					System.out.println("Enter state:");
					contacts.get(j).state = scanner.next();
					break;

				case 6:
					System.out.println("Enter ip:");
					contacts.get(j).zip = scanner.next();
					break;

				case 7:
					System.out.println("Enter phone_number:");
					contacts.get(j).phone_number = scanner.next();
					break;

				case 8:
					System.out.println("Enter email:");
					contacts.get(j).email = scanner.next();
					break;

				}
			}

		}
		if (flag == false)
			System.out.println(name + " not found in address book");

	}

	private static void addContact() {

		Scanner scanner = new Scanner(System.in);
		Contact newContact = new Contact();
		System.out.println("Enter first Name:");
		newContact.first_name = scanner.next();
		System.out.println("Enter last name:");
		newContact.last_name = scanner.next();
		System.out.println("Enter address:");
		newContact.address = scanner.next();
		System.out.println("Enter city:");
		newContact.city = scanner.next();
		System.out.println("Enter state:");
		newContact.state = scanner.next();
		System.out.println("Enter zip:");
		newContact.zip = scanner.next();
		System.out.println("Enter phone number");
		newContact.phone_number = scanner.next();
		System.out.println("Enter E-mail:");
		newContact.email = scanner.next();
		contacts.add(newContact);
	}

}
