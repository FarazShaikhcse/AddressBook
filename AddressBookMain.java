package com.main;

import java.util.*;


public class AddressBookMain {

	public static Set<AddressBook> addressBooks = new HashSet<>();
	
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
				addressBooks.add(new AddressBook(name));
			    break;
			
			case 2:
				System.out.println("Enter the addressbook name to add contact");
				String name2 = scanner.next();
				flag = false;
				for (AddressBook a : addressBooks) {
					if (a.name.equals(name2)) {
						a.addContact();
						flag = true;
					}
				}
				if(flag==false)
					System.out.println("Addressbook not found");
				
				break;
			case 3:
				System.out.println("Enter the addressbook name to edit");
				String name3 = scanner.next();
				flag = false;
				for (AddressBook a : addressBooks) {
					if (a.name.equals(name3)) {
						a.editContact();
						flag = true;
					}
				}
				if(flag==false)
					System.out.println("Addressbook not found");
				
				break;

			case 4:
				System.out.println("Enter the addressbook name to display");
				String name4 = scanner.next();
				flag = false;
				for (AddressBook a : addressBooks) {
					if (a.name.equals(name4)) {
						a.display();
						flag = true;
					}
				}
				if(flag==false)
					System.out.println("Addressbook not found");
				break;

			case 5:
				System.out.println("Enter the addressbook name to delete");
				String name5 = scanner.next();
				flag = false;
				for (AddressBook a : addressBooks) {
					if (a.name.equals(name5)) {
						a.deleteContact();
						flag = true;
					}
				}
				if(flag==false)
					System.out.println("Addressbook not found");
				break;
				
			}
		}

	}

	

}
