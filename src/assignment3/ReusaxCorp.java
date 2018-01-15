package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

	public class ReusaxCorp {
	private List<Employees> employeelist;
	
	public ReusaxCorp(){
		this.employeelist = new ArrayList<>();
	}
	
	public String printEmployee(String ID) {
		Employees foundEmployee = retriveEmployee(ID);
		if(foundEmployee != null) {
		return foundEmployee.toString();
		}
		else {
			return "employee does not exist";
		}
	}
	
	public String printAllEmployees() {
	 return employeelist.toString();
	}
	
	public Employees retriveEmployee(String ID) {
		for(int i = 0 ; i < employeelist.size()  ; i++) {
			if(employeelist.get(i).getID().equals(ID)) {
				return  employeelist.get(i);
			}
		}
		return  null;
	}
	
	public void promotionToManager(Employees foundEmployee, String education ) {
			createManger(foundEmployee.getID(), foundEmployee.getName(), foundEmployee.getGrossSalary() , education);
			employeelist.remove(foundEmployee);
	}
	
	public void promotionToDirector(Employees foundEmployee, String education , String department) {
			createDirector(foundEmployee.getID(), foundEmployee.getName(), foundEmployee.getGrossSalary(), education , department);
			employeelist.remove(foundEmployee);
	}
	
	public void promotionToIntern(Employees foundEmployee, int GPA) throws Exception{
			createIntern(foundEmployee.getID(), foundEmployee.getName(), foundEmployee.getGrossSalary(), GPA);
			employeelist.remove(foundEmployee);
	}
	
	public void promotionToRegularEmployee(Employees foundEmployee) {
		createRegulareEmployee(foundEmployee.getID(), foundEmployee.getName(), foundEmployee.getGrossSalary());
		employeelist.remove(foundEmployee);
	}	
	
	public void setEmployeeName(Employees foundEmployee,String newName) {
		foundEmployee.setName(newName);	
	}
	
	public void setEmployeeGrossSalary(Employees foundEmployee, double newGrossSalary) {
		foundEmployee.setGrossSalary(newGrossSalary);
	}
	
	public void Remove(String ID) throws Exception{
		Employees foundEmployee = retriveEmployee(ID);
			if(foundEmployee != null) {
					employeelist.remove(foundEmployee);
				}
			else {
				Exception banana = new Exception("Emplyee fuck you");
				throw banana;
				//throw new Exception("Employee does not exict"); this is better
			}
	}
	
	public double netSalaries() {
		double netSalaries = 0 ;
		for(int i = 0 ; i < employeelist.size(); i ++) {
			netSalaries = netSalaries + employeelist.get(i).getNetSalary();
		}
		return netSalaries;
	}
	
	public double grossSalaries() {
		double grossSalaries = 0;
		for(int i = 0 ; i < employeelist.size(); i ++) {
			grossSalaries = grossSalaries + employeelist.get(i).getGrossSalary();
			
		}
		return grossSalaries;
	}
	
	public void printEmployeeInfo(String ID) throws Exception {
		Employees foundEmployee = retriveEmployee(ID);
		if(foundEmployee != null) {
			System.out.println(foundEmployee.toString());
		}
		else {
			throw new Exception("An employee of ID "+ ID + " is not registered.");
		}
	}
	
	public void removeEmployee(String ID) {
		Employees foundEmployee = retriveEmployee(ID);
		if(foundEmployee != null) {
				employeelist.remove(foundEmployee);
		}
		else {
			System.out.println("An employee of ID "+ ID + " is not registered in the system. ");
		}
	}
	
	public void createRegulareEmployee(String ID, String name , double grossSalary) {
		Employees employee = new RegularIncome(ID , name , grossSalary);
		employeelist.add(employee);	
	}

	public void createIntern(String ID, String name, double grossSalary, int GPA) throws Exception {
		Employees employee = new Intern(ID , name , grossSalary, GPA);
		employeelist.add(employee);
	}

	public void createDirector(String ID , String name , double grossSalary, String education, String department) {
		Employees employee = new Directors(ID , name , grossSalary, education , department);
		employeelist.add(employee);
	}

	public void createManger(String ID, String name , double grossSalary , String education) {
		Employees employee = new Manager(ID , name , grossSalary, education);
		employeelist.add(employee);
	}
	
	public void sortEmployee() { 
		//Collections.sort(employeelist, Employees.getCompByName());
		Collections.sort(employeelist);
	}

	public int numberOfEmployees() {
		return employeelist.size();
	}


}
