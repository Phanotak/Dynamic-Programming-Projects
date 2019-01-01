import java.util.Scanner;

public class MatrixPath {
	
	public static int n = 3;
	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Enter the number of matrix rows: ");
		 int rows = scanner.nextInt();
		 System.out.println("Enter the number of matrix columns: ");
		 int columns = scanner.nextInt();
		 int mat[][] = new int[rows][columns];
		 enterMatrixData(scanner, mat, rows, columns);
		 System.out.println("Length of the longest path is " + finLongestOverAll(mat));

	}

	public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
	     System.out.println("Enter Matrix Data");
	          
	          for (int i = 0; i < matrixRow; i++)
	          {
	              for (int j = 0; j < matrixCol; j++)
	              {
	                  matrix[i][j] = scan.nextInt();
	              }
	          }
	  }
	
	public static int findLongestFromACell(int i, int j, int mat[][], int dp[][])
    {
        // Base case
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;
  
        // If this subproblem is already solved
        if (dp[i][j] != -1)
            return dp[i][j];
  
        // Since all numbers are unique and in range from 1 to n*n,
        // there is at most one possible direction from any cell
        if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1]))
            return dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp);
  
        if (j > 0 && (mat[i][j] + 1 == mat[i][j-1]))
            return dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp);
  
        if (i > 0 && (mat[i][j] + 1 == mat[i-1][j]))
            return dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp);
  
        if (i < n - 1 && (mat[i][j] +1 == mat[i+1][j]))
            return dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp);
  
        // If none of the adjacent fours is one greater
        return dp[i][j] = 1;
    }
     
    // Function that returns length of the longest path
    // beginning with any cell
    public static int finLongestOverAll(int mat[][])
    {
        // Initialize result
        int result = 1;  
  
        // Create a lookup table and fill all entries in it as -1
        int[][] dp = new int[n][n];
        for(int i = 0; i < n ; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;
  
        // Compute longest path beginning from all cells
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dp[i][j] == -1)
                    findLongestFromACell(i, j, mat, dp);
  
                //  Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }
  
        return result;
    }
}
