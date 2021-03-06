package numbers;

import java.util.Scanner;

/** Returns desired n-th Fibonacci number */
public class FibonacciSequence {
	
	private static int fibSeq(int input) {
		if (input == 0) return 0;
		else if (input == 1) return 1;
		else if (input == 2) return 2;
		else return fibSeq(input - 1) + fibSeq(input - 2);
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int input;
		System.out.print("Please enter a number: ");
		input = in.nextInt();
		System.out.println(fibSeq(input - 1));
		System.exit(1);
	}
}
