package Core;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {
	private double hourlySalary;

	public PartTimeEmployee( String name, LocalDate joiningDate, String phone, String aadharCard,
			double hourlySalary) {
		super(name, joiningDate, phone, aadharCard);
		this.hourlySalary = hourlySalary;
	}

	public double getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	@Override
	public String toString() {
		return super.toString()+ "hourlySalary=" + hourlySalary + "]";
	}
	
	

}
