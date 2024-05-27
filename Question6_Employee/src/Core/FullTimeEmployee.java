package Core;

import java.time.LocalDate;

public class FullTimeEmployee  extends Employee {
	private double monSalary;

	public FullTimeEmployee( String name, LocalDate joiningDate, String phone, String aadharCard,
			double monSalary) {
		super(name, joiningDate, phone, aadharCard);
		this.monSalary = monSalary;
	}

	public double getMonSalary() {
		return monSalary;
	}

	public void setMonSalary(double monSalary) {
		this.monSalary = monSalary;
	}

	@Override
	public String toString() {
		return super.toString()+" , monSalary=" + monSalary + "]";
	}
	
	
	
}
