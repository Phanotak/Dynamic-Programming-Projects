import java.util.Scanner;

//recursive program that counts number of ways to cover a distance using 1, 2, and 3 steps.

public class CalcDist {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a distance: ");
		int distance = scanner.nextInt();
		
		System.out.println(printCountDP(distance));
	}

	public static int printCountDP(int distance) {
		if (distance < 0)
			return 0;
		if (distance == 0)
			return 1;
		//return printCountDP(distance - 1) + printCountDP(distance - 2) + printCountDP(distance - 3);
		return printCountDP(distance - 1) + printCountDP(distance - 3);
	}
}
