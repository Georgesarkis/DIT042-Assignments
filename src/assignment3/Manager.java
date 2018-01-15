package assignment3;

public class Manager extends Employees  {
	private String education;
	
	
	
	Manager(String ID, String name, double grossSalary, String education) {
		super(ID, name, grossSalary);
		this.education = education;
	}
	
	public String toString() {
		return  super.getID() + " with name: " + super.getName() + " and the education " + this.education + " 's gross salary is of " + this.grossSalary + " SEK per month.";
	}

	public double getGrossSalary() {
		double grossSalaryWbonus = 0;
		if (this.education.equals("BSc")) {
			double newgrossSalary = super.grossSalary + (super.grossSalary * 10) / 100 ; 
			grossSalaryWbonus = newgrossSalary;
		}
		else if (this.education.equals("MSc")) {
			double newgrossSalary = super.grossSalary + (super.grossSalary * 20) / 100 ; 
			grossSalaryWbonus = newgrossSalary;
		}
		else if (this.education.equals("PhD")) {
			double newgrossSalary = super.grossSalary + (super.grossSalary * 35) / 100 ; 
			grossSalaryWbonus = newgrossSalary;
		}
		return grossSalaryWbonus;
	}
	
	public double getNetSalary() {
		if ( this.getGrossSalary() < 30000) {
			return this.getGrossSalary() - (this.getGrossSalary() * 0.1);
		}
		else if(this.getGrossSalary()  > 50000) {
			double mintaxamount = 30000;
			double rest = this.getGrossSalary() - mintaxamount;
			return this.getGrossSalary() - (mintaxamount * 0.2) - (rest * 0.4);
		}
		else {
			return this.getGrossSalary() * 0.2;
		}
	}
	
}
