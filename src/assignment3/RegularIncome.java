package assignment3;

public class RegularIncome extends Employees {
	RegularIncome(String ID, String name, double grossSalary) {
		super(ID, name, grossSalary);
	}
	
	
	public String toString() {
		return this.ID + " with name: " + this.name + "'s gross salary is of " + this.grossSalary + " SEK per month.";
	}
	
	public double getNetSalary() {
		return this.grossSalary - (this.grossSalary * 0.1);
	}
	
	public double getGrossSalary() {
		return this.grossSalary;	
	}

}
