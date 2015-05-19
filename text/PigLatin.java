package text;

import java.util.Scanner;

public class PigLatin {

	public static String convertString(String s) {
		char array[];
		int i, j;
		String result = "", temp = "";
		
		array = s.toCharArray();
		result = result + "-";
		for(i = 0; i < array.length; i++) {
			if(array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u') {
				for(j = i; j < array.length; j++) {
					temp += array[j];
				}
				result = temp + result;
				break;
			} else {
				result += array[i];
			}
		}
		result += "ay";
		return result;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String s = scanner.nextLine();
		System.out.println(convertString(s));
	}
}
