import java.util.Scanner;

public class CalcDistME {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a distance: ");
		int distance = scanner.nextInt();
		
		System.out.println(printCountDP(distance));
	}
	
	public static int printCountDP(int distance) {
		int [] Storage = new int[distance + 1];
		Storage[0] = 1;
		Storage[1] = 1;
		Storage[2] = 2;
		for(int i = 0; i <= distance; i++)
			Storage[i] = Storage[i - 1] + Storage[i - 2] + Storage[i - 3];
		return Storage[distance];
	}
}
