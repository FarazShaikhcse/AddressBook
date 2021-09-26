package com.main;

import java.util.Comparator;

public class ZipComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		return o1.zip.compareTo(o2.zip);
	}

}
