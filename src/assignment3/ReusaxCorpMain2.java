package assignment3;

import java.util.ArrayList;

import static dit042.SimpleIO.*;
public class ReusaxCorpMain2 {
	private static ArrayList<Employees> employeelist = new ArrayList<>();
	public static void main(String[] args) {
		println("==Welcome to ResaxCorp==");
		int answer = '0';
		while(answer != 9) {
			println("1.Register a new employee.");
			println("2.Remove an employee.");
			println("3.Retrieve an employee.");
			println("4.Update employees information.");
			println("5.Calculate The Total Expenses In By paying GrossSalaries");
			println("6.Calculate The Total Expenses In By paying NetSalaries");
			println("7.Inform The Total Number of Employees Registered.");
			println("8.Quit");
			println("Enter the option you want to choose: ");
			answer = readInt();
			
			
			if(answer == 1) {
				print("Enter the ID of the employee: ");
				String ID = readString();
				String name;
				double grossSalary;
				String education;
				String department;
				int GDP;
					println("Enter the type of the employee; 1.Manager, 2.Director , 3.Intern , 4.Regular Employee.");
					int ans = readInt();
					print("Enter the name of the employee:");
					name = readString();
					print("Enter the gross salary");
					grossSalary = readDouble();
					if(ans == 1) {
						print("Enter the education level: ");
						education = readString();
						Employees employee = new Manager(ID , name , grossSalary, education);
						employeelist.add(employee);
					
					}
					else if ( ans == 2) {
						print("Enter the education level: ");
						education = readString();
						print("Enter the department: ");
						department = readString();
						Employees employee = new Directors(ID , name , grossSalary, education , department);
						employeelist.add(employee);
						
					}
					else if (ans == 3) {
						print("Enter the GDP of the Intern: ");
						GDP = readInt();
						Employees employee = new Intern(ID , name , grossSalary, GDP);
						employeelist.add(employee);
						
					}
					else {
						Employees employee = new RegularIncome(ID , name , grossSalary);
						employeelist.add(employee);
					
					}
					
				}
				
			
			else if(answer == 2) {
				print("Enter the ID of the employee: ");
				String ID = readString();
				for( int i = 0 ; i < employeelist.size() ; i++) {
					if ( employeelist.get(i).getID().equals(ID)) {
						employeelist.remove(i);
					}
					else {
						println("An employee of ID "+ ID + " is not registered in the system. ");
					}
				}
			}
			
			
			else if(answer == 3) {
				print("Enter the ID of the employee: ");
				String ID = readString();
				for( int i = 0 ; i < employeelist.size() ; i++) {
					if ( employeelist.get(i).getID().equals(ID)) {
					println(employeelist.get(i).toString());
					}
					else {
						println("An employee of ID "+ ID + " is not registered in the system. ");
					}
					
				}
			}
			
			
			else if(answer == 4) {
				print("Enter the ID of the employee: ");
				String ID = readString();
				for( int i = 0 ; i < employeelist.size() ; i++) {
					if ( employeelist.get(i).getID().equals(ID)) {
					print("please choose what you want to update:1.Name , 2.grossSalary.");
					int ans = readInt();
					if(ans == 1) {
						print("Enter the new name: ");
						String newName = readString();
						employeelist.get(i).setName(newName);
						}
					else {
						print("Enter the new gross salary: ");
						double newGrossSalary = readDouble();
						employeelist.get(i).setGrossSalary(newGrossSalary);
						}
					}
					else {
						println("An employee of ID "+ ID + " is not registered in the system. ");
					}
				}
			}
			
			
			else if(answer == 5) {
				double grossSalaries = 0;
				for( int i = 0 ; i < employeelist.size() ; i++) {
					grossSalaries = grossSalaries + employeelist.get(i).getGrossSalary();
						println(grossSalaries);
				}
			}
			
			
			else if(answer == 6) {
				double netSalaries = 0;
				for( int i = 0 ; i < employeelist.size() ; i++) {
					netSalaries = netSalaries + employeelist.get(i).getNetSalary();
						println(netSalaries);
				}
			}
				
			
			else if(answer == 7) {
				println(employeelist.size());
				
			}
			
			
			else if(answer == 8) {
				break;
			}
			
			
			else{
				println("Invalide choise please choose again");
			}
			
		}
		println("goodbye");
	}
}

	


