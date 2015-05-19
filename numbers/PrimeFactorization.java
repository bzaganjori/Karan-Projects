package numbers;

import java.util.Scanner;

/** Returns all numbers that are prime factors of users desired console input */
public class PrimeFactorization {
	
	private static int isPrime(int n) {
		int i;
		if(n <= 1) return 0;
		else if(n <= 3) return 1;
		else if(n % 2 == 0 || n % 3 == 0) return 0;
		for(i = 5; n >= i * i; i += 6) {
			if(n % i == 0 || n % (i + 2) == 0) return 0;
		}
		return 1;
	}
	
	private static String factor() {
		Scanner scanner = new Scanner(System.in);
		int number, i;
		String result = "";
		
		System.out.print("Please enter a number to factor: ");
		number = scanner.nextInt();
		System.out.print("1");
		for(i = 1; i <= number; i++) {
			if(number % i == 0 && isPrime(i) == 1) result += ", " + i;
		}
		return result;
	}
	
	public static void main(String args[]) {
		System.out.println(factor());
		System.exit(1);
	}

}
