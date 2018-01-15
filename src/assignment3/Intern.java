package assignment3;

public class Intern extends Employees {
	private int GPA;

	Intern(String ID, String name, double grossSalary , int GPA) throws Exception {
		super(ID, name, grossSalary);
		if(GPA > 0) {
		this.GPA = GPA;
		}
		else throw new Exception("Wrong GPA");
		
	}
	
	public String toString() {
		return  super.getID() + " with name: " + super.getName() + " and with GPA of " + this.GPA + " 's gross salary is of " + this.grossSalary + " SEK per month.";
	}
	
	public double getNetSalary() {
		double benifits = 1000;
		if (this.GPA <=  5 ) {
		return super.grossSalary;
		}
		else if(this.GPA >= 8) {
			return super.grossSalary + benifits;
		}
		else {
			return super.grossSalary;
		}
	}
	
	public int setGPA(int newGPA) throws Exception {  // cant exces it with reference employee and object intern, can only be entered by object and reference intern, or we should downcase or change the reference
		if (newGPA > 0) {
		return this.GPA = newGPA;}
		else throw new Exception("wrong GPA");
	}
	public int getGPA() {
		return this.GPA;
	}


	public double getGrossSalary() {
		return super.grossSalary;
	}
	
}
