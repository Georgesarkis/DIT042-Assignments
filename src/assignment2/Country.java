package assignment2;

public class Country {
	private String countryName; 	
	private double population; 
	private double gdp;	
	
	
	private double gdpCap;
	private	String classification;
	
	Country (String countryName, double gdp, double population) {
		this.countryName = countryName;
		this.gdp = gdp;
		this.population = population;
		getGdpCap();
		classification();
		
	}
	
	public void classification() {
		if (gdpCap >= 10000) {
			this.classification = "developed country";
		}
		else if (gdpCap < 10000 && gdp > 1000) {
		this.classification = "economy in transition";
		}   
	else {
		this.classification = "developing country";
		}
	}
		public void economyInjection (double economyInject) {
		  double newGdp = this.gdp + economyInject;
		  if (newGdp <= 0) {
			  System.out.println("Error");
		  }else {
			 this.gdp = newGdp;
			 this.gdpCap = this.gdp / this.population;
		  classification();
		  }
	}
		public void payDebts (double payDebts) {
			double newGdp = this.gdp - payDebts;
			if (newGdp <= 0) {
				System.out.println("Error");
			}else {
				this.gdp = newGdp;
				this.gdpCap = this.gdp / this.population;
				classification();
			}
		}
		public String getName() {
			return this.countryName;
		}
		public String toString() {
			String line = this.countryName+ ": (" + this.classification + ").\r\n" 
		                	+ "Population: " +this.population+"\r\n"
		                	+ "GDP: " + this.gdp + "\r\n"
		                	+ this.gdpCap + " per capita.";
			return line; 
		}
		public double getPopulation() {
			return this.population;
		}
		public double getGdpCap() {
			this.gdpCap = this.gdp / this.population;
			return this.gdpCap;
		}
		public double getGdp() {
			return this.gdp;
		}
		public void changeCoutryName (String newcountryName) {
			this.countryName = newcountryName;
		}
		public void changePopulation (double newPopulation) {
			synchronized (classification) {
				this.population = newPopulation ; 
				getGdpCap();
				classification();
			}
			
		}
}