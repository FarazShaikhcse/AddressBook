package com.main;

import java.util.Comparator;

public class CityComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact arg0, Contact arg1) {
		return arg0.city.compareTo(arg1.city);
	}

}
