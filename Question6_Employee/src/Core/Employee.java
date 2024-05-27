package Core;

import java.time.LocalDate;

public class Employee {
	private int empId;
	private String name;
	private static int count = 0 ;
	private LocalDate joiningDate ;
	private String phone;
	private String aadharCard;
	
	
	public Employee( String name, LocalDate joiningDate, String phone, String aadharCard) {
		super();
		this.empId = count++;
		this.name = name;
		this.joiningDate = joiningDate;
		this.phone = phone;
		this.aadharCard = aadharCard;
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", joiningDate=" + joiningDate + ", phone=" + phone
				+ ", aadharCard=" + aadharCard ;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Employee) {
			Employee e = (Employee)o;
			return this.aadharCard.equals(e.aadharCard);
		}
		return false;
	}
	

	
	
	
}
