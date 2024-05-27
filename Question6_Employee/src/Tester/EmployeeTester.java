package Tester;

import static CollectionUtils.Utils.deleteEmployee;
import static CollectionUtils.Utils.displayEmployee;
import static CollectionUtils.Utils.populateList;
import static CollectionUtils.Utils.searchByAadharCard;
import static EmployeeValidation.EmployeeValidationRules.validateInputsFTE;
import static EmployeeValidation.EmployeeValidationRules.validateInputsPTE;
import static EmployeeValidation.EmployeeValidationRules.isSameAadhar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Core.Employee;
import Core.FullTimeEmployee;
import Core.PartTimeEmployee;

public class EmployeeTester {
	public static void main(String[] args) {
		int choice ;
		 int empId;
		 String name;
		 String joiningDate ;
		 String phone;
		 String aadharCard;
		 double monSalary;
		 double hourlySalary;
		 ArrayList<Employee> EmpList = populateList();
		try(Scanner scan = new Scanner(System.in)){
			do {
				System.out.println("1. Add FullTime Employee\n"
						+ "2. Add PartTime Employee\n"
						+ "3. Delete Employee by Id\n"
						+ "4. Search Employee by Aadhar\n"
						+ "5. Display All Employee Details\n"
						+ "6. Sort Employee by Joining Date\n"
						+ "7. Exit");
				System.out.print("Enter your Choice : ");
				choice = scan.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter the name");
					name = scan.next();
					System.out.println("Enter the joining Date ");
					joiningDate = scan.next();
					System.out.println("Enter the phone number");
					phone = scan.next();
					System.out.println("Enter the Aadhar card ");
					aadharCard = scan.next();
					System.out.println("Enter the Monthly Salary ");
					monSalary = scan.nextDouble();
					
					isSameAadhar(aadharCard,EmpList);

					FullTimeEmployee fte	= validateInputsFTE(name,joiningDate,phone,aadharCard,monSalary); 
					EmpList.add(fte);
					break;
					
				case 2:
					System.out.println("Enter the name");
					name = scan.next();
					System.out.println("Enter the joining Date ");
					joiningDate = scan.next();
					System.out.println("Enter the phone number");
					phone = scan.next();
					System.out.println("Enter the Aadhar card ");
					aadharCard = scan.next();
					System.out.println("Enter the hourly Salary ");
					hourlySalary = scan.nextDouble();
					
					isSameAadhar(aadharCard,EmpList);

					PartTimeEmployee pte	= validateInputsPTE(name,joiningDate,phone,aadharCard,hourlySalary); 
					EmpList.add(pte);
					break;
				case 3:
					System.out.println("Enter the emp id for Deletion");
					int del = scan.nextInt();
					
					deleteEmployee(del,EmpList);
				
				case 4:
					System.out.print("Enter Aadhar Card Number ");
					String acard = scan.next();
					
					searchByAadharCard(acard,EmpList);
					break;
				
				case 5:
					System.out.println("Displaying Employees Details ");
					System.out.println();
					
					displayEmployee(EmpList);
					break;
					
				case 6:
					Collections.sort(EmpList,new CompartorJoining());
					for(Employee e : EmpList ) {
						System.out.println(e);
					}
					break;
				
			   case 0:
				   System.out.println("EXITING ... ");
				   break;
				}
					
				
			}while(choice!=0);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
