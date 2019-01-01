import java.util.Scanner;
import java.util.ArrayList;

public class OpGameStrat {

	 	int max(int a, int b) { return a > b ? a : b; }
	    int min(int a, int b) { return a < b ? a : b; }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		
		System.out.println("Enter a sequence of numbers: ");
		while(scanner.hasNextDouble())
			sequence.add(scanner.nextInt());
	    	int n = sequence.size();
	    	Integer[] array = new Integer[n];
	    	for(int i = 0; i < n; i++)
	    		array[i] = sequence.get(i);
		System.out.println("" + optimalStrategyOfGame(array, n));
	}

	public  static int optimalStrategyOfGame(Integer[] array, int n)
    {
        // Create a table to store solutions of subproblems
        int table[][] = new int[n][n];
        int gap, i, j, x, y, z;

        for (gap = 0; gap < n; ++gap)
        {
            for (i = 0, j = gap; j < n; ++i, ++j){

                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? table[i +1 ][j -  1] : 0;
                z = (i <= (j - 2)) ? table[i][j - 2]: 0;
     
                table[i][j] = Math.max(array[i] +
                              Math.min(x, y), array[j] +
                              Math.min(y, z));
            }
        }
     
        return table[0][n - 1];
    }
}
