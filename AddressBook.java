package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

/**
 * @author faraz This class represents addressbook object which contains set of
 *         contacts and the operations that will be performed on them.
 */
public class AddressBook {

	/**
	 * hashset is used to avoid duplicates
	 */
	String addressbookname;
	HashSet<Contact> contacts = new HashSet<Contact>();
	String basePath = "/Users/farazshabbir/eclipse-workspace/AddressBook/src/com/main/Data/";

	public AddressBook(String name) {
		addressbookname = name;
	}

	/**
	 *over riding hashcode and equals method to avoid duplicate addressbook names
	 */
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

	/**
	 * @param place is the city name of the contacts to be displayed this method
	 *              searches for the contacts that belong to the given city
	 */
	public int searchCity(String place) {

		Map<String, Contact> cityMap = new HashMap<>();

		Stream<Contact> valuesStream = contacts.stream();

		valuesStream.anyMatch((x) -> {
			if (x.city.equals(place)) {
				cityMap.put(x.city, x);
				return true;
			}
			return false;
		});

		for (Map.Entry<String, Contact> entry : cityMap.entrySet())
			System.out.println(entry.getValue());

		return cityMap.size();

	}

	/**
	 * @param place is the state name of the contacts to be displayed this method
	 *              searches for the contacts that belong to the given state
	 */
	public int searchState(String place) {

		Map<String, Contact> statesMap = new HashMap<>();

		Stream<Contact> valuesStream = contacts.stream();

		valuesStream.anyMatch((x) -> {
			if (x.state.equals(place)) {
				statesMap.put(x.state, x);
				return true;
			}
			return false;
		});

		for (Map.Entry<String, Contact> entry : statesMap.entrySet()) {

			System.out.println(entry.getValue());
		}

		return statesMap.size();

	}

	/**
	 * sorts the contacts by name
	 */
	public void sortByName() {
		contacts.stream().sorted(new NameComparator()).forEach(s -> System.out.println(s));

	}
	/**
	 * sorts the contacts by city
	 */
	public void sortByCity() {
		contacts.stream().sorted(new CityComparator()).forEach(s -> System.out.println(s));

	}
	/**
	 * sorts the contacts by zip
	 */
	public void sortByZip() {
		contacts.stream().sorted(new ZipComparator()).forEach(s -> System.out.println(s));
	}
	/**
	 * sorts the contacts by state
	 */
	public void sortByState() {
		contacts.stream().sorted(new StateComparator()).forEach(s -> System.out.println(s));

	}

	
	/**
	 * @param file is the addressbook name
	 * this method writes addressbook contacts to file
	 */
	public void writeFile(String file) {
		try {
			FileWriter writer = new FileWriter(basePath + file + ".txt", true);
			contacts.stream().forEach(c -> {
				try {
					writer.write(c+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * @param file
	 * @throws IOException
	 * this method reads the addressbook file 
	 */
	public void readFile(String file) throws IOException {
		FileReader fr = new FileReader(basePath + file + ".txt");
		int i;
		while ((i = fr.read()) != -1)
			System.out.print((char) i);
	}
	
	/**
	 * @param file
	 * This method adds a contact to addressbook from the csv file
	 */
	public void addContactCsv(String file) {
		try {

			// Create an object of filereader class
			// with CSV file as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object
			// and skip first Line
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();
			Contact contact;

			// print Data
			for (String[] row : allData) {
				contact = new Contact(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
				System.out.println(contact+"test");
				contacts.add(contact);
			}

			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param filePath=path to csv file Writes the contacts in dictionary to csv
	 *                      file
	 */
	public void writeContactCsv(String filePath) {
		File file = new File(filePath);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile, ',', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			// adding header to csv
			String[] header = { "FistName", "Lastname", "Address", "City", "State", "Zip", "Phone Number", "Email" };
			writer.writeNext(header);

			for (Contact c : contacts) {
				String[] data1 = { c.first_name, c.last_name, c.address, c.city, c.state, c.zip, c.phone_number, c.email };
				writer.writeNext(data1);
			}

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * @param file
	 * generates JSON from contacts and writes to JSON file
	 */
	public void writeContactJson(String file) {
		Gson gson = new Gson();
		try {
			FileWriter writer = new FileWriter(file);
			for (Contact c : contacts) {
				String json = gson.toJson(c);

				writer.write(json);
				writer.write("\n");

			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param file=json file path Reads the contacts from json file
	 */
	public void addContactJson(String file) {
		Gson gson = new Gson();
		try {
			System.out.println("Reading JSON from a file");
			System.out.println("----------------------------");

			BufferedReader br = new BufferedReader(new FileReader(file));
			Contact contactObj = gson.fromJson(br, Contact.class);
			contacts.add(contactObj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
