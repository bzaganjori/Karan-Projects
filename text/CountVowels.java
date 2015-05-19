package text;

import java.util.Scanner;

public class CountVowels {

	public static int count(String s) {
		char array[], test[] = {'a', 'e', 'i', 'o', 'u'};
		int i, j, count = 0;
		
		s = s.toLowerCase();
		array = s.toCharArray();
		for(i = 0; i < array.length; i++) {
			for(j = 0; j < test.length; j++) {
				if(array[i] == test[j]) count++;
			}
		}
		return count;
	}
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a sentence: ");
		System.out.println("Number of vowels in sentence: " + count(scanner.nextLine()));
	}
}
