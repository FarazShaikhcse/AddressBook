package com.main;

import java.io.File;
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

		while (choice != 12) {
			System.out.println(
					"Enter your choice\n1.Create AddressBook\n2.Add Contact\n3.Edit Contact\n4.Display AddressBook\n"
							+ "" + "5.Delete contact\n6.Display contacts by place\n7.Sort\n8.Write addressbook to file\n" + 
							"9.Read addressbook from file\n10.Read from csv\n11.Write to csv\n12.Exit");
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
				AddressBook addressBook = getAddressBook(name2);
				if(addressBook!=null)
					addressBook.addContact();
				else
					System.out.println("Addressbook not found");

				break;
			case 3:
				System.out.println("Enter the addressbook name to edit");
				String name3 = scanner.next();
				AddressBook addressBook1 = getAddressBook(name3);
				if(addressBook1!=null)
					addressBook1.editContact();
				else
					System.out.println("Addressbook not found");

				break;

			case 4:
				System.out.println("Enter the addressbook name to display");
				String name4 = scanner.next();
				AddressBook addressBook11 = getAddressBook(name4);
				if(addressBook11!=null)
					addressBook11.display();
				else
					System.out.println("Addressbook not found");
				break;

			case 5:
				System.out.println("Enter the addressbook name to delete");
				String name5 = scanner.next();
				AddressBook addressBook111 = getAddressBook(name5);
				if(addressBook111!=null)
					addressBook111.deleteContact();
				else
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
			case 8: 
				System.out.println("Enter the addressbook name to write");
				String name6 = scanner.next();
				AddressBook addressBook2 = getAddressBook(name6);
				if(addressBook2!=null)
					addressBook2.writeFile(name6);
				else
					System.out.println("Addressbook not found");
				break;
			
			case 9:
				System.out.println("Enter the addressbook name to read");
				String name7 = scanner.next();
				AddressBook addressBook3 = getAddressBook(name7);
				if(addressBook3!=null)
					try {
						addressBook3.readFile(name7);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				else
					System.out.println("Addressbook not found");
				break;
			case 10: 
				readFromCsv();
				break;
			case 11:
				writeTocsv();
				break;
			

			}
		}

	}

	private static AddressBook getAddressBook(String name) {
		
		for (Map.Entry m : addressBooks.entrySet()) {
			if (m.getKey().equals(name)) {
				AddressBook addressBook = (AddressBook) m.getValue();
				return addressBook;
				
			}
		}
		return null;
		
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
	private static void writeTocsv() {
		String basePath = "/Users/farazshabbir/eclipse-workspace/AddressBook/src/com/main/Data";
		Scanner m = new Scanner(System.in);
		System.out.println("Enter the address book you wanna write");
		String fileName = m.next();
		AddressBook Book = addressBooks.get(fileName);
		if (Book == null) {
			System.out.println("No book found");
			return;

		}
		addressBooks.get(fileName).writeContactCsv(basePath + "/" + fileName + ".csv");
	}

	/**
	 * Reads the addressbook from csv file
	 */
	private static void readFromCsv() {
		String basePath = "/Users/farazshabbir/eclipse-workspace/AddressBook/src/com/main/Data";
		Scanner m = new Scanner(System.in);
		System.out.println("Enter the address book you want to read");
		String filename = m.next();
		File file = new File(basePath + "/" + filename + ".csv");
		if (!file.exists()) {
			System.out.println("Address book not found");
			return;
		}
		AddressBook adBook = new AddressBook(filename);
		addressBooks.put(filename, adBook);
		adBook.addContactCsv(basePath + "/" + filename + ".csv");
	}

}
