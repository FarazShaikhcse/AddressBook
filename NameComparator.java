package com.main;

import java.util.Comparator;

public class NameComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		return o1.first_name.compareTo(o2.first_name);
	}

}
