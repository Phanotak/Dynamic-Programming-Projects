import java.util.ArrayList;
import java.util.Scanner;

public class SubSetSumDP {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		System.out.println("Enter a sum: ");
		int sum = scanner.nextInt();
		System.out.println("Enter a sequence of integers: ");
		while(scanner.hasNextDouble())
        	sequence.add(scanner.nextInt());
    	int n = sequence.size();
    	Integer[] array = new Integer[n];
    	for(int i = 0; i < n; i++)
    		array[i] = sequence.get(i);
    	
    	if (isSubsetSum(array, n, sum) == true)
            System.out.println("Found a subset" + " with given sum");
        else
            System.out.println("No subset with" + " given sum");

	}
	
	public static boolean isSubsetSum(Integer[] array, int n, int sum){
		
		boolean subset[][] = new boolean[sum + 1][n + 1];
		
		// If sum is 0, then answer is true
		for(int i = 0; i <= n; i++)
			subset[0][i] = true;
		// If sum is not 0 and set is empty, then answer is false
		for(int i = 0; i <= sum; i++)
			subset[i][0] = false;
		
		for(int i = 1; i <= sum; i++ ) {
			for(int j = 0; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
                if (i >= array[j - 1])
                subset[i][j] = subset[i][j] || subset[i - array[j - 1]][j - 1];
			}
		}
		
		return subset[sum][n];
	}
}
