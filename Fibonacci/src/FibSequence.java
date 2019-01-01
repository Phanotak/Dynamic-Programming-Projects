import java.util.Scanner;
import java.math.BigInteger;

public class FibSequence {

	public static void main(String[] args) {
		Scanner number = new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int n = number.nextInt();
		System.out.println(fibonacci(n) );
	}
	
	public static BigInteger fibonacci(int n) {
		BigInteger[] sequence = new BigInteger[n + 2];
		int i;
		sequence[0] = BigInteger.ZERO;
		sequence[1] = BigInteger.ONE;
		for (i = 2; i <= n; i++)
			sequence[i] = sequence[i-1].add(sequence[i-2]);
		return sequence[n];
	}
	
}

