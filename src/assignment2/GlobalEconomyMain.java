package assignment2;

import java.util.Scanner;

public class GlobalEconomyMain {
	
	private static final int REGISTER_COUNTRY = 1;
	private static final int PRINT_COUNTRIES = 2;
	private static final int PRINT_COUNTRY = 3;
	private static final int INJECT_MONEY = 4;
	private static final int PAY_DEBT = 5;
	private static final int CHANGE = 6;
	private static final int QUIT = 7;

	
	private Country[] countries;
	private int registeredCountries;
	private Scanner input;
	
	
	// the size of the array is 5
	public GlobalEconomyMain() {
		final int MAX_COUNTRIES = 5;
		this.countries = new Country[MAX_COUNTRIES];
		this.registeredCountries = 0;
		input = new Scanner(System.in);
	}
	
	// retrieve the country name every time before executing the any methods
	public  Country retrieveCountry(String countryName) { 
		int count = 0;  						// used this way to print just ERROR massage one time and wait the FOR loop to go all over the array before printing ERROR
		for (int i = 0; i < this.registeredCountries; i++) {
			if(countries[i] != null && countries[i].getName().equals(countryName)) {
				return countries[i];
			}
			else if(countries[i] != null && !countries[i].getName().equals(countryName)) {
			count++;
			}
		}
		if (count > 0) {
		System.out.println("ERROR! "+ countryName + " name does not exist!!!");
		}
		return null;
	}
	
	public Country createCountry() {		
				System.out.println("Enter the name of the country: ");
				Scanner input = new Scanner (System.in);
				String name = input.next();
				System.out.println("Enter the number of GDP");
				double gdp = input.nextDouble();
				System.out.println("Enter the population");
				double population = input.nextDouble();
				Country newCountry = new Country (name, gdp,population);
				return newCountry;
	}	
	
	public void run() {
		
		int option;
		do {
			printMenuOptions();
			System.out.print(" Type the option number: ");
			
			option = input.nextInt();
			input.nextLine(); //this skips the enter 
							  //that the user types after 
							  //typing the integer option.
			
			switch (option) {
			case REGISTER_COUNTRY:
				
				Country newCountry = createCountry();
				this.countries[registeredCountries] = newCountry;
				this.registeredCountries = this.registeredCountries + 1;
				
				break;
	
			case PRINT_COUNTRIES:
				printAllCountries();
				break;
	
			case PRINT_COUNTRY:
				printOneCountry();				
				break;
	
			case INJECT_MONEY:
				injectMoney();
				break;
	
			case PAY_DEBT:
				payDebt();
				break;
	
			case CHANGE:
				change();
				break;
				
			case QUIT:
				System.out.println("Thank you for using Global Economy Solutions. See you soon!");
				System.out.println();
				break;
				
			default:
				System.out.println("Option "+option+" is not valid.");
				System.out.println();
				break;
			}
		} while (option != QUIT);
	}

	//This method is private because it should be used only by
	// this class since the menu is specific to this main.
	private void printMenuOptions() {
		System.out.println(" === Welcome to Global Economy === ");
		System.out.println(" Choose an option below: ");
		System.out.println(" ");
		System.out.println(" 1. Register a country. ");
		System.out.println(" 2. Print all countries. ");
		System.out.println(" 3. Print a country's information. ");
		System.out.println(" 4. Inject money to a country. ");
		System.out.println(" 5. Pay a country's debt. ");
		System.out.println(" 6. Make a change. ");
		System.out.println(" 7. Quit this program. ");
		System.out.println();
	}
	
	public void printAllCountries() {
		for (int i=0; i<this.countries.length;i++) {
			if (countries[i] != null) {
				System.out.println(countries[i]);
			}
		}
	}
	
	public void printOneCountry() {		
		String countryName = readCountryName();
		Country foundCountry = retrieveCountry(countryName);
		if(foundCountry != null) {
			System.out.println(foundCountry);
			}
			return;
		
		
	}

	
	public String readCountryName() {
		System.out.print("Type the name of the country that you want to use: ");
		String countryName = input.nextLine();
		return countryName;
	}

	// injecting money to the countries GDP
	public void injectMoney() {
		String countryName = readCountryName();		
		Country foundCountry = retrieveCountry(countryName);
		if(foundCountry != null) {		// to prevent program from running if the country does not exist
				System.out.println("Enter the amount: ");
				Scanner input = new Scanner (System.in);
				double amount = input.nextDouble();
				foundCountry.economyInjection(amount);
				}
		
	}
	
	public void change() {
		String countryName = readCountryName();
		Country foundCountry = retrieveCountry(countryName);
		if(foundCountry != null) {		// to prevent program from running if the country does not exist
			System.out.println("To change the name of the country press \"1\".");
			System.out.println("To change the population press \"2\".");
			Scanner in = new Scanner(System.in);
			int number = in.nextInt();
			if (number ==1 ) {
				System.out.println("Enter the new name: ");
				Scanner inputs = new Scanner (System.in);
				String newname = inputs.next();
				foundCountry.changeCoutryName(newname);	
				
		
			} 
			else {
				System.out.println("Enter the population: ");
				Scanner inputs = new Scanner (System.in);
				double newpopulation = inputs.nextDouble();
				foundCountry.changePopulation(newpopulation);
				
			}
		}
	}
	
	public void payDebt() {
		String countryName = readCountryName();		
		Country foundCountry = retrieveCountry(countryName);
		if(foundCountry != null) { 			// to prevent program from running if the country does not exist
				System.out.println("Enter the amount that you want to pay: ");
				Scanner input = new Scanner(System.in);
				double pay = input.nextDouble();
				foundCountry.payDebts(pay);
		}
		
	}
	
	public static void main(String[] args) {
		GlobalEconomyMain program = new GlobalEconomyMain();
		program.run();
	}
}

	


