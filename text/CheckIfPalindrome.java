package text;

import java.util.Scanner;
import text.ReverseString;

public class CheckIfPalindrome {

	public static boolean palindrome(String s) {
		String input = ReverseString.reverse(s);
		return input.equals(s);
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a string to check if palindrome: ");
		System.out.println(palindrome(scanner.nextLine()));
	}
}
