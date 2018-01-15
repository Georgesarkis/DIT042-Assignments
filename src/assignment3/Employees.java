package assignment3;

public  abstract class  Employees implements Comparable <Employees>{
	protected String ID;
	protected String name;
	protected double grossSalary;
	
	
	Employees(String ID , String name , double grossSalary){
		this.ID = ID;
		this.name = name;
		this.grossSalary = grossSalary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String setName(String newName) {
		return this.name = newName;
	}
	
	public double setGrossSalary(double newGrossSalary) {
		return this.grossSalary = newGrossSalary;
	}
	
	public abstract double getGrossSalary() ;
	
	public abstract  String toString();
	
	public abstract double getNetSalary();
	
	/*public static Comparator<Employees> getCompByName(){
		
	 Comparator comp = new Comparator<Employees>(){
	     @Override
	     public int compare(Employees s1, Employees s2)
	     {
	         return s1.name.compareTo(s2.name);
	     }

	      
	 };
	 return comp;
	}*/

	@Override
	public int compareTo(Employees o) {
		//return this.getName().compareTo(o.getName());
		String myName = this.getName();
		String stragersName = o.getName();
		int resultComparison = myName.compareTo(stragersName);
		if(resultComparison == 0 ) {
			if(this.getGrossSalary()<o.getGrossSalary()) {
		          return -1;
		          }
		    else if(o.getGrossSalary()<this.getGrossSalary()) {
		          return 1;
		          }
		    else{
		    	return 0;
		    	}
		}
		else {
			return resultComparison;
			}
	}

}