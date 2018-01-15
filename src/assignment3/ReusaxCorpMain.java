package assignment3;

import static dit042.SimpleIO.*;

public class ReusaxCorpMain {
	
	private static final int createEmployee = 1;
	private static final int remove = 2;
	private static final int printEmployeeInfo = 3;
	private static final int printAllEmployeeInfo = 4;
	private static final int updateEmployee = 5;
	private static final int grossSalaries = 6;
	private static final int netSalaries = 7;
	private static final int numberOfEmployees = 8;
	private static final int promotion = 9;
	private static final int sortEmployee = 10;
	private static final int Quit = 11;
	
	private ReusaxCorp company;
	int HRdipartment = 0;
	int techdipartment = 0;
	int businessdipartment = 0;
	public ReusaxCorpMain () {
		this.company = new ReusaxCorp();
	}
	
	public static void main(String[] args) {
		ReusaxCorpMain program = new ReusaxCorpMain();
		program.run();
	}

	public void run() {
		int answer;
		do {
			mainMenu();
			print("Enter the option that you want: ");
			answer = readInt();
			
			switch (answer) {
			
			case createEmployee:
				createEmployee();
				break;
				
			case remove:
				Remove();
				break;
			
			case printEmployeeInfo:
				printEmployeeInfo();
				break;
				
			case printAllEmployeeInfo:
				println(company.printAllEmployees());
				break;
			
			case updateEmployee:
				updateEmployee();
				break;
			
				
			case grossSalaries:
				System.out.println("the total gross salaries of all employees is: " + company.grossSalaries());
				break;
				
			case netSalaries:
				System.out.println("the total net salaries of all employees is: " + company.netSalaries());
				break;
				
			case numberOfEmployees:
				System.out.println(company.numberOfEmployees());
				break;
				
			case promotion:
				promotion();
				break;
				
				
			case sortEmployee:
				sortEmployee();
				break;
				
				
			case Quit: break;
			
			
			default:
				System.out.println("Option "+ answer +" is not valid.");
				System.out.println();
				
			}
		}
		while(answer != 11 );{
			print("Goodbye!!!");
		}
	}
	
	public void sortEmployee() {
		company.sortEmployee();
		//println(company.printAllEmployees());
	}

	private void promotion() {
			try{
			String ID = readEmployeeID();
			Employees foundEmployee = company.retriveEmployee(ID);
		
			print("what do you want to promote for: 1.Manager, 2.Director , 3.Intern , 4.Regular Employee.");
			int ans = readInt();
			final int MANAGER = 1;
			final int DIRECTOR = 2;
			final int INTERN = 3;
			final int REGULAREMPLOYEE = 4;
			switch (ans) {
			
				case MANAGER: 
					print("Enter the education level of the manager: BSc , MSc , PhD : ");
					String education = readString();
					company.promotionToManager(foundEmployee, education);
					break;
					
				
				case DIRECTOR:
					
					print("Enter the education level of the manager: BSc , MSc , PhD : ");
					education = readString();
					print("Enter the department of the director: 1.Human Resources , 2.Technical , 3.Business: ");
					String department = readString();
					if(department.equals("Human") && HRdipartment < 1) {
						HRdipartment++;
						company.promotionToDirector(foundEmployee, education, department);
						break;
					}
					else if(department.equals("Technical") && techdipartment < 1) {
						techdipartment++;
						company.promotionToDirector(foundEmployee, education, department);
					}
					else if(department.equals("Business") && businessdipartment < 1) {
						businessdipartment++;
						company.promotionToDirector(foundEmployee, education, department);
					}
					else {
						System.out.println(department + " is invalide or already has an director");
					}
					break;
					
					
				case INTERN:
					print("Enter the GPA of the intern: ");
					int GPA = readInt();
					company.promotionToIntern(foundEmployee, GPA);
					break;
					
				case REGULAREMPLOYEE:	
					company.promotionToRegularEmployee(foundEmployee);
					break;
			} }
			catch(Exception Ex) {
				println(Ex.getMessage());
			}
		}
		
	

	public String readEmployeeID() {
		print("Enter the ID: ");
		String ID = readString();
		return ID;
	} 

	public void updateEmployee() {
		String ID = readEmployeeID();
		Employees foundEmployee = company.retriveEmployee(ID);
		if(foundEmployee != null) {
		
			System.out.print("Please choose what you want to update: 1.Name, 2.grossSalary: ");
			int ans = readInt();
		
			final int NAME = 1;
			final int GROSSSALARY = 2;
			
			switch (ans) {
			
				case NAME:
					
					print("Enter the new name: ");
					String newName = readString();
					company.setEmployeeName(foundEmployee, newName);
					break;
					
					
				case GROSSSALARY:
					
					print("Enter the new gross salary: ");
					double newGrossSalary = readDouble();
					company.setEmployeeGrossSalary(foundEmployee, newGrossSalary);
					break;
					
			}
		}
		
		else {
			println("An employee of ID "+ ID +" is not registered in the system. ");
		}
	
	}
			
	public void Remove() {
		try{String ID = readEmployeeID();
		company.Remove(ID);}
		catch(Exception ex) {
			println(ex);
		}
	}
		
	private void mainMenu() {
		println("==Welcome to ResaxCorp==");
		println("");
		println("1.Register a new employee.");
		println("2.Remove an employee.");
		println("3.Retrieve an employee.");
		println("4.Print all employees. ");
		println("5.Update the employee information.");
		println("6.Calculate the total expenses in by paying gross salaries.");
		println("7.Calculate the total expenses in by paying net salaries.");
		println("8.Inform The Total Number of Employees Registered.");
		println("9.Promote an employee.");
		println("10.Sort the employees.");
		println("11.Quit.");
		println("");
	}
		
	public void printEmployeeInfo() {
		try{String ID = readEmployeeID();
		println(company.printEmployee(ID));}
		
		catch(Exception ex) {
			println(ex);
		}
	}
		

		
	public void createEmployee() {
		
		String ID = readEmployeeID();
		Employees foundEmployee = company.retriveEmployee(ID);
		if(foundEmployee != null) {
			println("An employee of ID "+ ID + " is already registered in the system. ");
		
		}
		
		
		else {
			
			println("Enter the type of the employee; 1.Manager, 2.Director , 3.Intern , 4.Regular Employee.");
			int ans = readInt();
			print("Enter the name of the employee:");
			String name = readString();
			print("Enter the gross salary");
			double grossSalary = readDouble();
			
			
			final int MANAGER = 1;
			final int DIRECTOR = 2;
			final int INTERN = 3;
			final int REGULAREMPLOYEE = 4;
			
			
				switch (ans) {
			
				
				case MANAGER:
					print("Enter the education of the manager: BSc , MSc , PhD: ");
					String education = readString();
					company.createManger(ID, name, grossSalary, education);
					break;
				
				case DIRECTOR:
					print("Enter the education level of the manager: BSc , MSc , PhD : ");
					education = readString();
					print("Enter the department of the director: 1.Human Resources , 2.Technical , 3.Business: ");
					String department = readString();
					if(department.equals("Human") && HRdipartment < 1) {
						HRdipartment++;
						company.createDirector(ID,name,grossSalary, education, department);
						break;
					}
					else if(department.equals("Technical") && techdipartment < 1) {
						techdipartment++;
						company.createDirector(ID,name,grossSalary, education, department);
					}
					else if(department.equals("Business") && businessdipartment < 1) {
						businessdipartment++;
						company.createDirector(ID,name,grossSalary, education, department);
					}
					else {
						System.out.println(department + " is invalide or already has an director");
					}
					break;
				
				case INTERN:
					try {
					print("Enter the GPA of the intern: ");
					int GPA = readInt();
					company.createIntern(ID, name, grossSalary, GPA);
					break;}
					catch (Exception ex) {
						println(ex.getMessage());
					}
					
				case REGULAREMPLOYEE:
					company.createRegulareEmployee(ID, name, grossSalary);
					break;
				
				}

			
		}
		
	}

}

