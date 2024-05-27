package Tester;

import java.util.Comparator;

import Core.Employee;

public class CompartorJoining implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getJoiningDate().compareTo(o2.getJoiningDate());
	}

}
