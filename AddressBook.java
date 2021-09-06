package com.main;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	public ArrayList<Contact> contacts = new ArrayList<>();
	String name;

	public AddressBook(String name) {
		this.name = name;
	}

	public void deleteContact() {

		System.out.println("Enter the name of the person whose contact is to be deleted");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		for (int j = 0; j < contacts.size(); j++) {
			if (contacts.get(j).first_name.equals(name)) {
				contacts.remove(j);
				System.out.println(name + " deleted from address book");
				return;
			}
		}
		System.out.println(name + " not found in the address book");

	}

	public void display() {

		if (contacts.size() == 0) {
			System.out.println("Address book is empty");
			return;
		}
		System.out.println("Contact Details are:\n");
		for (int j = 0; j < contacts.size(); j++) {

			System.out.println("Contact details of person");
			System.out.println(contacts.get(j) + "\n");
		}
	}

	public void editContact() {

		Boolean flag = false;
		System.out.println("Enter the name of the person whose contact is to be edited"); // to edit existing address
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		for (int j = 0; j < contacts.size(); j++) {

			if (contacts.get(j).first_name.equals(name)) {
				flag = true;
				int choice = 0;
				while (choice != 9) {
					System.out.println(
							"Enter the field which you want to edit\n1.first name\n2.last name\n3.address\n4.city\n5.state\n6.zip\n7.phone number\n8.email\n9.Exit");
					choice = scanner.nextInt();
					switch (choice) {

					case 1:
						System.out.println("Enter new first name:");
						contacts.get(j).first_name = scanner.next();
						break;

					case 2:
						System.out.println("Enter new last name:");
						contacts.get(j).last_name = scanner.next();
						break;

					case 3:
						System.out.println("Enter new address:");
						contacts.get(j).address = scanner.next();
						break;

					case 4:
						System.out.println("Enter new city:");
						contacts.get(j).city = scanner.next();
						break;

					case 5:
						System.out.println("Enter new state:");
						contacts.get(j).state = scanner.next();
						break;

					case 6:
						System.out.println("Enter new zip:");
						contacts.get(j).zip = scanner.next();
						break;

					case 7:
						System.out.println("Enter new phone_number:");
						contacts.get(j).phone_number = scanner.next();
						break;

					case 8:
						System.out.println("Enter new email:");
						contacts.get(j).email = scanner.next();
						break;

					}
				}
			}
		}
		if (flag == false)
			System.out.println(name + " not found in address book");

	}

	void addContact() {

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
