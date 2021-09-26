package com.main;

import java.util.*;

/**
 * @author faraz This main class implements all the main functionality of
 *         addressbook management
 */
public class AddressBookMain {

	static HashMap<String, AddressBook> addressBooks = new HashMap<String, AddressBook>();

	public static void main(String[] args) {

		int choice = 0;
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Address Book Program");

		while (choice != 8) {
			System.out.println(
					"Enter your choice\n1.Create AddressBook\n2.Add Contact\n3.Edit Contact\n4.Display AddressBook\n"
							+ "" + "5.Delete contact\n6.Display contacts by place\n7.Sort \n8.Exit");
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
			case 6:
				searchbyPlace();
				break;
			case 7:
				int ch = 0;
				System.out.println("Sort by:\n1. Name\n2. City\n3. State\n4. Zip");
				ch = scanner.nextInt();
				for (Map.Entry<String, AddressBook> entry : addressBooks.entrySet()) {
					AddressBook obj = entry.getValue();
					switch (ch) {
					case 1:
						obj.sortByName();
						break;
					case 2:
						obj.sortByCity();
						break;
					case 3:
						obj.sortByState();
						break;
					case 4:
						obj.sortByZip();
						break;
					}
				}

				break;

			}
		}

	}

	private static void searchbyPlace() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Search contacts from\n1 City\n2 State");
		int ch = reader.nextInt();
		if (ch == 1) {
			Scanner r1 = new Scanner(System.in);
			System.out.println("Enter city name");
			String place = r1.nextLine();
			int count = 0;
			for (Map.Entry<String, AddressBook> entry : addressBooks.entrySet()) {
				AddressBook obj = entry.getValue();
				count += obj.searchCity(place);
			}
			System.out.println(count + " contact found in city " + place);

		} else if (ch == 2) {
			Scanner r2 = new Scanner(System.in);
			System.out.println("Enter state name");
			String place = r2.nextLine();
			int count = 0;
			for (Map.Entry<String, AddressBook> entry : addressBooks.entrySet()) {
				AddressBook obj = entry.getValue();
				count += obj.searchState(place);
			}
			System.out.println(count + " contact found in State " + place);

		}
	}

}
