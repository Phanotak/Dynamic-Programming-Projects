import java.util.ArrayList;
import java.util.Scanner;
//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

public class SubsetSum {

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
	
	// Returns true if there is a subset of set[] with sum equal to given sum
	public static boolean isSubsetSum(Integer[] array, int n, int sum) {
		
		if(sum == 0)
			return true;
		
		if(n == 0 && sum != 0)
			return false;
		
		if (array[n - 1] > sum)
	        return isSubsetSum(array, n - 1, sum);
		
		return isSubsetSum(array, n - 1, sum) || isSubsetSum(array, n - 1, sum - array[n - 1]); 
		 
	}
}
