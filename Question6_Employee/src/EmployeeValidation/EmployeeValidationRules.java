package EmployeeValidation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Core.Employee;
import Core.FullTimeEmployee;
import Core.PartTimeEmployee;
import EmployeeException.AadharNumberException;
import EmployeeException.PhoneNumberException;
import EmployeeException.SameAadharCardNumberException;

public class EmployeeValidationRules {
	public static FullTimeEmployee validateInputsFTE(String name,String joiningDate,String phone,String aadharCard,double monsal) throws PhoneNumberException, AadharNumberException {
		String p =validatePhone(phone);
		String  a = validateAadhar(aadharCard);
		
		return new FullTimeEmployee(name, LocalDate.parse(joiningDate), p, a, monsal);
	}
	
	
	public static void isSameAadhar(String aadharCard,ArrayList<Employee> emp) throws SameAadharCardNumberException {
		for(Employee e : emp) {
			if((e.getAadharCard().equals(aadharCard))) {
				throw new SameAadharCardNumberException("Aadhar Number Cannot be Same");
			}
		}
		
	}


	public static PartTimeEmployee validateInputsPTE(String name,String joiningDate,String phone,String aadharCard,double honsal) throws PhoneNumberException, AadharNumberException {
		validatePhone(phone);
		
		String p =validatePhone(phone);
		String  a = validateAadhar(aadharCard);
		return new PartTimeEmployee(name, LocalDate.parse(joiningDate), phone, aadharCard, honsal);
	}
	
	
	public static String validatePhone(String phone) throws PhoneNumberException {
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Pattern pat2 = Pattern.compile("^[0-9]+$");
		
		Matcher mat = pattern.matcher(phone);
		Matcher mat1 = pattern.matcher(phone);
		
		if(mat.matches() && mat1.matches()) {
			return phone;
		}
		throw new PhoneNumberException("Invalid Phone number ");

	}
	
	public static String validateAadhar(String aadhar) throws PhoneNumberException, AadharNumberException {
		Pattern pattern = Pattern.compile("^\\d{12}$");
		Pattern pat = Pattern.compile("^[0-9]+$");
		
		Matcher mat = pattern.matcher(aadhar);
		Matcher mat1 = pattern.matcher(aadhar);
		
		if(mat.matches() && mat1.matches()) {
		return aadhar;
		}
		throw new AadharNumberException("Invalid Aadhar number ");
	}
	
	



}
