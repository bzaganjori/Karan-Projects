package numbers;

import java.util.Scanner;

/** User enters the price and amount paid for an item in the console. Returns change due. */
public class changeReturnProgram {
	
	private static String calculateChange(double cost, double paid) {
		return String.format("%.2f", paid - cost);
	}
	
	private static void prompt() {
		Scanner scanner = new Scanner(System.in);
		double cost, paid;
		System.out.print("Cost of item: ");
		cost = scanner.nextDouble();
		System.out.print("Amount paid: ");
		paid = scanner.nextDouble();
		System.out.println("Customer change is: " + calculateChange(cost, paid));
	}
	
	public static void main(String args[]) {
		prompt();
		System.exit(1);
	}

}
