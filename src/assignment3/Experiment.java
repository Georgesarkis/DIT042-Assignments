package assignment3;

public class Experiment {
	public static void main(String[] args){
		String id = "12314";
		String name = "george";
		double grossSalary = 321;
		int GPA = 1;
		Employees ee = null ;
		try {
		   ee = new Intern(id,name,grossSalary,GPA);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			if(ee instanceof Intern) {
			Intern newee = (Intern) ee;
			System.out.println(newee.getGPA());
				try{newee.setGPA(-1);
				}
				catch (Exception E) {
					System.out.println(E);
					System.out.println(E.getMessage());
					System.out.println("vgdwfdghafas");
					
				}

			System.out.println(newee.getGPA());
			System.out.println("vgdwfdghafas");
		}
			else {
				System.out.println("wrong tipe");
			}
			
			
			
	}
}
