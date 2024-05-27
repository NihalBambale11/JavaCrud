package CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;

import Core.Employee;
import Core.FullTimeEmployee;
import Core.PartTimeEmployee;

public class Utils {
	public static ArrayList<Employee> populateList() {
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(
				new FullTimeEmployee("John Smith", LocalDate.parse("2023-01-02"), "947654321", "240456789112", 22300));
		empList.add(
				new FullTimeEmployee("Mathew Snow", LocalDate.parse("2024-01-01"), "957654321", "203456789112", 1300));
		empList.add(
				new PartTimeEmployee("James Andrew", LocalDate.parse("2024-01-01"), "687654321", "303456789112", 2000));
		empList.add(
				new FullTimeEmployee("Virat Kohli", LocalDate.parse("2022-03-25"), "787654321", "903456789112", 125000));
		empList.add(
				new FullTimeEmployee("Rohit Sharma", LocalDate.parse("2022-10-10"),"887654321", "503456789112", 102300));
		return empList;
	}
	
	///case 3
	public static void deleteEmployee(int id , ArrayList<Employee> em) {
		for(Employee e : em) {
			if(e.getEmpId() == id) {
				em.remove(id);
			}
		}
	}

	///case 4
	public static void searchByAadharCard(String id ,ArrayList<Employee> emp) {
		for(Employee e: emp) {
			if(e.getAadharCard().equals(id)) {
				System.out.println(e);
			}
		}
	}
	
	/// case 5

	public static void displayEmployee(ArrayList<Employee> emp) {
		for (Employee e : emp) {
			System.out.println(e);
		}
	}

}
