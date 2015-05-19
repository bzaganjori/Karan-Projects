package text;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String string, result = "";
		int i;
		
		System.out.print("Please enter a string: ");
		string = in.nextLine();
		for(i = string.length() - 1; i >= 0; i--) result += string.charAt(i);
		System.out.println(result);
		System.exit(1);
	}
}
