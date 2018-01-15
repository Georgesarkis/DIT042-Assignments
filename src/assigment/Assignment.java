package assigment;

import static dit042.SimpleIO.*;


/**
 *  String Library. The program implements a set of string operators.
 *  @author Daniel Jansson <jansson215@gmail.com>
 *  @author Sarkis George Sarkisian <sakogeorge@gmail.com>
 *  @date 2017-09-08
 */


public class Assignment {

	public static void main(String[] args) {
		char A = 0; // Choice input
		String s1, s2; // Input strings
		
		// Displays main logo
		println("******************************\r\n" + 
				"**                          **\r\n" + 
				"**   Welcome to the DIT042  **\r\n" + 
				"**       String Library     **\r\n" + 
				"**                          **\r\n" + 
				"******************************");
		
		
		while (A != 'q') { // Main event loop
			
			println("Please choose a String operation or press 'q' to quit:\r\n" + 
				"Press c for concatenation\r\n" + 
				"Press e for equals\r\n" + 
				"Press s for substring\r\n" + 
				"Press t for trim\r\n" + 
				"Press l for lastIndexOf\r\n" + 
				"Press h for contains");
			A = readChar();
			
			switch (A) {
			
				/* String operator concatenation - adds two strings together. */
			case 'c': {		// Concatenation
					String result = "";
					print("please enter the first string: ");
					s1 = readString();
					print("please enter the secound string: ");
					s2 = readString();
	
					result = s1;
					for (int count = 0; count < s2.length(); count++) {
						result += s2.charAt(count);
					}
					println("\nThe result of concatenating " +s1 + " and "+ s2 + " is: " + result);
					break;
				}
				
			/* String operator equals - compares to strings and returns result as a boolean */ 
			case 'e': {	
					boolean result = true; // Initialize result
					
					// Prompt user to enter two strings.
					print("please enter the first string: ");
					s1 = readString();
					print("please enter the secound string: ");
					s2 = readString();
					
					// If string length are the same, each characters are compared in the for loop.
					if (s1.length() == s2.length()){
						for (int count = 0; count < s1.length(); count++)
							if (s1.charAt(count) != s2.charAt(count)) {
								result = false; // Set result to false if characters don't match
								break;
							}
					}
					else {
						result = false;
					}
					
					println("\nThe result of comparing " + s1 + " and " + s2 + " is: " + result);
					break;
				}
				
			/* String operator substring - returns the substring within a string. */
			case 's': { 	
					// Variables
					int x , y; // first and second index
					String result = ""; // result string
					
					// Prompt the user for a string and indexes for the substring.
					print("please enter the string: ");
					s1 = readString();
					print("please enter the first index: ");
					x = readInt();
					print("please enter the secound index: ");
					y = readInt();
					if (y > s1.length() || x > y) {
						println("ERROR!");
						break;
					}
					// For loop that iterates thru the input string and appends character
					//  by character to the output if the char is within given index.
					else{for (int count = 0; count < s1.length(); count++){
						if (count >= x && count < y){
							result += s1.charAt(count);
						}
					}
					// Print the result to console
					println("\nThe resulting substring is: " + result);
					break;
				}
			}
			
			// String operator trim - removes spaces from string		
			case 't': { 		
					String result = ""; // results
					
					//Prompt user for a string
					print("Please enter a sentence to trim: ");
					s1 = readLine();
					
					// Iterates thru string and append each char to new if not char is a space
					for (int count = 0 ; count < s1.length() ; count++) {
						if (s1.charAt(count) !=  ' ' ) {
							result += s1.charAt(count);
							
						}
					}
					
					// Print result to console
					println("The resulting trimmed sentence is: " + result);
					break;
				}
	
			/* String operator last index of - returns the last index of a chosen character */
			case 'l': {
					// Variables
					int lastIndex = 0; 				// index
					boolean contains = false;		// contains (will be true if the input string contains the character)
					char x;							// character
					
					// Prompt user for a string and a character.
					print("please enter the first string: ");
					s1 = readString();
					print("please enter a character: ");
					x = readChar();
					
					// Iterates thru given string and saves last index of the character if found.
					for (int count = 0; count < s1.length(); count++) {
						if (s1.charAt(count) == x){
							lastIndex = count;
							contains = true;
						}
					}
					
					// Print out result to console
					if (contains){ // executed if character is in string.
						println("\nThe index of character " + x + " in string " + s1 + " is: " + lastIndex);
					}
					else { // executed if character is not in string.
						println("\nThe string: " + s1 + " does not contain the character: " + x);
					}
					break;
				}
					
			
				/* String operator contains - compare if one string contains another string. */
				case 'h': {
					boolean result = false; // result
					
					// Prompt user for two strings
					println("please enter the first string: ");
					s1 = readString();
					println("please enter the secound string: ");
					s2 = readString();
					
					// Compares char by char if the length of first string equals or longer to the second string
					if (s1.length() >= s2.length()) {
						for (int count = 0; count < s1.length(); count ++) {
								if (s1.charAt(count) == s2.charAt(0)){
									for (int count2 = 0; count2 < s2.length(); count2++){
										if (s1.charAt(count + count2) == s2.charAt(count2)){
											if (count2 == s2.length() -1){ 
												result = true;
											}
										}								
									}
								}
							}
						}
					// Print results to console
					if (result){
						println("\nThe string '" + s1 + "' does contain the string '" + s2 + "'.");
					}
					else {
						println("\nThe string '" + s1 + "' does not contain the string '" + s2 + "'.");
					}
					break;
				}
				
			
			
			
			case 'q': { // quit program
				break;
				}
			
					
			default: {// If none of the valid input's where met. 
				println("This is not a valid choice. Please retry!");
				break;
				}
			}
			
			
			/* Program end, ask user to quit or continue.
			 * Will not show if 'q' has been pressed for quit.
			 */
			if (A != 'q'){ 
				println("\nType 'q' to quit program, otherwise press enter to continue.");
				A = readChar();
				
			}
			
		}
		
		// Print goodbye to console when exiting program.
		println("\n\n");
		println("Thanks! Goodbye.");
		
	}
}