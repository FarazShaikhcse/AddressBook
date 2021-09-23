package com.main;

import java.util.*;

/**
 * @author faraz
 * This main class implements all the main functionality of addressbook management
 */
public class AddressBookMain {

	static HashMap<String, AddressBook> addressBooks = new HashMap<String, AddressBook>();

	public static void main(String[] args) {

		int choice = 0;
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Address Book Program");

		while (choice != 6) {
			System.out.println(
					"Enter your choice\n1.Create AddressBook\n2.Add Contact\n3.Edit Contact\n4.Display AddressBook\n5.Delete contact\n6.Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter addressbook name");
				String name = scanner.next();
				addressBooks.put(name, new AddressBook(name));
				break;

			case 2:
				System.out.println("Enter the addressbook name to add contact");
				String name2 = scanner.next();
				flag = false;
				for (Map.Entry m : addressBooks.entrySet()) {
					if (m.getKey().equals(name2)) {
						AddressBook addressBook = (AddressBook) m.getValue();
						addressBook.addContact();
						flag = true;
					}
				}
				if (flag == false)
					System.out.println("Addressbook not found");

				break;
			case 3:
				System.out.println("Enter the addressbook name to edit");
				String name3 = scanner.next();
				flag = false;
				for (Map.Entry m : addressBooks.entrySet()) {
					if (m.getKey().equals(name3)) {
						AddressBook addressBook = (AddressBook) m.getValue();
						addressBook.editContact();
						flag = true;
					}
				}
				if (flag == false)
					System.out.println("Addressbook not found");

				break;

			case 4:
				System.out.println("Enter the addressbook name to display");
				String name4 = scanner.next();
				flag = false;
				for (Map.Entry m : addressBooks.entrySet()) {
					if (m.getKey().equals(name4)) {
						AddressBook addressBook = (AddressBook) m.getValue();
						addressBook.display();
						flag = true;
					}
				}
				if (flag == false)
					System.out.println("Addressbook not found");
				break;

			case 5:
				System.out.println("Enter the addressbook name to delete");
				String name5 = scanner.next();
				flag = false;
				for (Map.Entry m : addressBooks.entrySet()) {
					if (m.getKey().equals(name5)) {
						AddressBook addressBook = (AddressBook) m.getValue();
						addressBook.deleteContact();
						flag = true;
					}
				}
				if (flag == false)
					System.out.println("Addressbook not found");
				break;

			}
		}

	}

}
