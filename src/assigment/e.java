package assigment;
import static dit042.SimpleIO.*;
import static dit042.Random.*;
public class e {

	public static void PlayOne (int old_array[][], int new_array[][]) {
		// TODO Auto-generated method stub
			print("Write the number of row");
			int x = readInt();
			print("Write the number of columns");
			int y = readInt();
			print("Write how many generation you want to run");
			int gen = readInt();
			if ( x < 2 || y < 3) {
				println("Board is too small");
				return;
			}
			else if ( x != y){
				println("Board is not a rectangle.");
				return;
			}
			else {char oldarray[][] = new char [x][y];
			println("enter the line");
		for (int i = 0 ; i < gen ; i++) {
			for (int X = 0 ; X < x ; X++) {
				int Y = 0;
				oldarray [X][Y] = readChar();
				for (Y = 0 ; Y < y ; Y++) {
					println(oldarray[X][Y]);
				}
			}
			}
				
			}
		
	}

}
