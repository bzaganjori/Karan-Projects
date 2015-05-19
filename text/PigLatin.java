package text;

import java.util.Scanner;

public class PigLatin {

	public static String convertString(String s) {
		char array[];
		int i;
		String result = "";
		
		array = s.toCharArray();
		if(array[0] == 'a' || array[0] == 'e' || array[0] == 'i' || array[0] == 'o' || array[0] == 'u') {
			return s;
		}
		for(i = 1; i < array.length; i++) result += array[i];
		result += "-" + array[0] + "ay";
		return result;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String s = scanner.nextLine();
		System.out.println(convertString(s));
	}
}
