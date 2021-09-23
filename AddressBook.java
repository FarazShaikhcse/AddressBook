package com.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author faraz
 * This class represents addressbook object which contains set of contacts 
 * and the operations that will be performed on them.
 */
public class AddressBook {

	/**
	 * hashset is used to avoid duplicates
	 */
	String addressbookname;
	HashSet<Contact> contacts = new HashSet<Contact>();
	Stream<Contact> stream = contacts.stream();
	
	public AddressBook(String name) {
		addressbookname = name;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(addressbookname);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBook other = (AddressBook) obj;
		return Objects.equals(addressbookname, other.addressbookname);
	}



	/**
	 * This method will delete the specified contact from the specified addressbook
	 */
	public void deleteContact() {

		System.out.println("Enter the name of the person whose contact is to be deleted");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Iterator itr = contacts.iterator();
		while (itr.hasNext()) {
			Contact contact = (Contact) itr.next();
			if (contact.first_name.equals(name)) {
				contacts.remove(contact);
				System.out.println(name + " deleted from address book");
				return;
			}
		}
		System.out.println(name + " not found in the address book");

	}

	/**
	 * This method will display all the contacts of the addressbook
	 */
	public void display() {

		if (contacts.size() == 0) {
			System.out.println("Address book is empty");
			return;
		}
		System.out.println("Contact Details are:\n");
		Iterator itr = contacts.iterator();
		while (itr.hasNext()) {
			Contact contact = (Contact) itr.next();
			System.out.println("Contact details of person");
			System.out.println(contact + "\n");
		}

	      
    }
	

	/**
	 * This method will prompt the user to edit the required fields of the contact
	 */
	public void editContact() {

		Boolean flag = false;
		System.out.println("Enter the name of the person whose contact is to be edited"); // to edit existing address
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Iterator itr = contacts.iterator();
		while (itr.hasNext()) {
			Contact contact = (Contact) itr.next();
			if (contact.first_name.equals(name)) {
				flag = true;
				int choice = 0;
				while (choice != 9) {
					System.out.println(
							"Enter the field which you want to edit\n1.first name\n2.last name\n3.address\n4.city\n5.state\n6.zip\n7.phone number\n8.email\n9.Exit");
					choice = scanner.nextInt();
					switch (choice) {

					case 1:
						System.out.println("Enter new first name:");
						contact.first_name = scanner.next();
						break;

					case 2:
						System.out.println("Enter new last name:");
						contact.last_name = scanner.next();
						break;

					case 3:
						System.out.println("Enter new address:");
						contact.address = scanner.next();
						break;

					case 4:
						System.out.println("Enter new city:");
						contact.city = scanner.next();
						break;

					case 5:
						System.out.println("Enter new state:");
						contact.state = scanner.next();
						break;

					case 6:
						System.out.println("Enter new zip:");
						contact.zip = scanner.next();
						break;

					case 7:
						System.out.println("Enter new phone_number:");
						contact.phone_number = scanner.next();
						break;

					case 8:
						System.out.println("Enter new email:");
						contact.email = scanner.next();
						break;

					}
				}
			}
		}
		if (flag == false)
			System.out.println(name + " not found in address book");

	}

	/**
	 * This method will add a new contact to the addressbook
	 */
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
		Stream.of(newContact).collect(Collectors.toCollection(() -> contacts));
	}
	
	public void search(String place) {
		//Set<Map.Entry<String, Contact>> entries = contacts.entrySet();
		Stream<Contact> entriesStream = contacts.stream();

//		Set<String> keySet = contacts.keySet();
//		Collection<Contact> values = contacts.values();
//
//		Stream<Contact> valuesStream = values.stream();
//		Stream<String> keysStream = keySet.stream();

		entriesStream.anyMatch((x) -> {
			if (x.city.equals(place) || x.state.equals(place)) {
				System.out.println(x);
				return true;
			} else {
				return false;
			}
		});

	}
}
