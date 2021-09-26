package com.main;

import java.util.Comparator;

public class StateComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		return o1.state.compareTo(o2.state);
	}

}
