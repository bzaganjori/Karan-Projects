package classicAlgorithms;

import java.util.Scanner;

public class CollatzConjecture {
	
	public static int collatz(int in, int count) {
		if (in <= 1) return count;
		else if (in % 2 == 0) return collatz(in / 2, count + 1);
		else return collatz((in * 3) + 1, count + 1);
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number for Collatz sequence: ");
		System.out.println(collatz(scanner.nextInt(), 0));
	}	

}
