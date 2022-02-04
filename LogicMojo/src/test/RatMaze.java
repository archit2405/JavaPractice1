package test;
import java.util.*;
public class RatMaze {
	public static Scanner sc=new Scanner(System.in);
	public static int n;
	public static boolean findPath(int[][]matrix,int row,int col)
	{
		if(row>=0 && row<n && col>=0 && col<n)
		{
		if(row==n-1 && col==n-1)
		{
			matrix[row][col]=2;
			return true;
		}
		else
		{
			if(matrix[row][col]==0)
			{
				int temp=matrix[row][col];
				matrix[row][col]=2;
				if(row<n-1)
				{
					if(findPath(matrix,row+1,col)==true)
						return true;
				}
				if(col<n-1)
				{
					if(findPath(matrix,row,col+1)==true)
						return true;
				}
				matrix[row][col]=temp;	
				return false;
			}
			return false;	
		}
		}
		return true;
	}
	public static void main(String args[])
	{
		System.out.println("Enter the dimension of the matrix");
		n=sc.nextInt();
		int[][] matrix=new int[n][n];
		System.out.println("Enter 0 for open cell and 1 for closed cell");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		}
		boolean flag=findPath(matrix,0,0);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
