package assignment2;
import static dit042.SimpleIO.*;
public class Assignment2 {

	public static void main(String[] args) {  
			println(" === Welcome to Global Economy === ");
			final int numofcountries = 5;
			Country countries[] = new Country[numofcountries];
			int option;
		do{
			printMenuOptions();
			
			option = readInt();
					
			
					if (option == 1) {
						creatCountry();
						questionToCreat();
					}
					
					
					
					else if(option == 2) {
						for(int i = 0 ; i < numofcountries ; i++) {
							if(countries[i] != null) {
							println(countries[i].toString()); 
							}
						}
					}
					
					
					
					else if(option == 3) {
						print("Enter the name of the country that you want to print: ");
						String ans = readString();
						for(int i = 0 ; i < numofcountries ; i++) {
							if(countries[i] != null && ans.equals(countries[i].name)) {
								println(countries[i].toString());
							}
							else {
							}
						}
						
					}
					
					
					
					else if(option == 4) {
						print("Enter the name of the country that you want to enject money: ");
						String answer = readString();
						print("Enter the amont that you want to enject: ");
						double enject = readDouble();
						for(int i = 0 ; i < numofcountries ; i++) {
							if (countries[i] != null && answer.equals(countries[i].name)) {
								countries[i].economyInjection(enject);
							}
						}
						
					}
					
					
					
					else if ( option == 5) {
						print("Enter the name of the country that you want to enject money: ");
						String answer = readString();
						print("Enter the amont that you want to pay: ");
						double paydebts = readDouble();
						for(int i = 0 ; i < numofcountries ; i++) {
							if (countries[i] != null && answer.equals(countries[i].name)) {
								countries[i].payDebts(paydebts);
							}
						}
					} 
					
					
					
					else if(option == 6) {
						print("Enter the name of the country that you want to update: ");
						String answer = readString();
						for(int i = 0 ; i < numofcountries ; i++) {
							if(countries[i] != null && answer.equals(countries[i].name)) {
									println("1.Change " + countries[i].name + "'s name.");
									println("2.Change " + countries[i].name + "'s population.");
									int ans = readInt();
									if( ans == 1) {
										print("Enter the new name: ");
										countries[i].name = readString();
									}
									else {
										print("Enter the new population:");
										countries[i].population = readDouble();
									}
							}
							else if (countries[i] != null && !answer.equals(countries[i].name)){
								println("ERROR!! Country is not regisered!");
							}
						}
					}
					
					
					
					else if(option == 7) {
						println("Thanks! Goodbye.");
						break;
					}
					
					
					else {
						println("Wrong input, please try again!");
					}
					
				}
		while (option != 7); {
			println("");
		}
	}


	private static void printMenuOptions() {
		System.out.println(" === Welcome to Global Economy === ");
		System.out.println(" Choose an option below: ");
		System.out.println(" ");
		System.out.println(" 1. Register a country. ");
		System.out.println(" 2. Print all countries. ");
		System.out.println(" 3. Print a country's information. ");
		System.out.println(" 4. Inject money to a country. ");
		System.out.println(" 5. Pay a country's debt. ");
		System.out.println(" 6. Quit this program. ");
		System.out.println();
	}
	public static Country creatCountry() {
		final int numofcountries = 5;
		Country countries[] = new Country[numofcountries];
		for (int i = 0 ; i < numofcountries ; i++) {
			if(countries[i] == null) {
				print("Enter the name of the country: ");
				String newName = readString();
				print("Enter the GDP: ");
				double newGDP = readDouble();
				print("Enter the number of the population: ");
				double newPopulation = readDouble();
				countries[i] = new Country (newName , newGDP , newPopulation );
				return countries[i];
				
			}
			else {
				
			}
		}
		public static questionToCreat() {
			println("Do you want to enter a new country?Press N to exit?");
			char answer = readChar();
				if(answer == 'N') {
					break;
				}
				else {
					creatCounty();
				}
		}
	}
}
