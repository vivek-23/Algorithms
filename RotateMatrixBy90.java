import java.util.*;
import java.lang.*;
import java.io.*;

class RotateMatrixBy90 {
	private static void printMatrix(int[][] mat)
	{
	  System.out.println();
	  
		for(int i=0;i<mat.length;++i)
		{
		   for(int j=0;j<mat[0].length;++j)
				System.out.print(mat[i][j]+" ");
				
		   System.out.println();
		}
		
	}
	private static void rotateClockwise(int[][] mat)
	{
		if(mat.length == 1)
			return;
		
		
		int col1 = 0,
		    row1 = 0,
			col2 = 0,
			row2 = 0,
			temp = 0;
		
        for(int i=0;i<mat.length/2;++i)
		{
		  col1 = i;
		  row1 = i;
		  col2 = mat[0].length-i-1;
		  row2 = mat.length-i-1;
		  
			for(int j=i;j<mat[0].length-i-1;++j)
			{
				temp = mat[row2][i];
				
				mat[row2][i] = mat[mat.length-i-1][col2];
				mat[mat.length-i-1][col2] = mat[row1][mat[0].length-i-1];
				mat[row1][mat[0].length-i-1] = mat[i][col1];
				mat[i][col1] = temp;
				
				col1++;
				row1++;
				col2--;
				row2--;
			}
		}	
		
	}
	private static void input()
	{
	  Scanner sc = new Scanner(System.in);	
      int test_cases = 0,
	      a = 0,
          b = 0,
          n = 0;		  
	  
	  test_cases = Integer.parseInt(sc.next());
	  
	  while(test_cases-- > 0)
	  {
		  n = Integer.parseInt(sc.next());
		  int[][] mat = new int[n][n];
		  
		  for(int i=0;i<n;++i)
		  {
			  for(int j=0;j<n;++j)
				  mat[i][j] = Integer.parseInt(sc.next());
		  }

         rotateClockwise(mat);
         printMatrix(mat);		 
	  }
	  
	  sc.close();
	}
	public static void main (String[] args) {
		input();
	}
}
