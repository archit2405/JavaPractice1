package test;
import java.util.*;
public class pathFinderMatrix {
	public static Scanner sc=new Scanner(System.in);
	public static int n;
	public static int[][]matrix= {{1,0,0,0,0},
			{1,0,1,1,1},
			{1,1,1,0,1},
			{1,0,0,0,1},
			{1,0,0,0,1}};
	public static boolean isValid(int row,int col)
	{
		if(row>=n || col>=n || row<0 || col<0)
			return false;
		else
			return true;
	}
	
	public static boolean findPath(int row,int col)
	{
		if(isValid(row,col)==true)
		{
			if(matrix[row][col]==1)
			{
				matrix[row][col]=2;
				if(row==n-1 && col==n-1)
					return true;
				else
				{
				boolean a,b ,c,d;
				a=findPath(row+1,col);
				b=findPath(row,col+1);
				c=findPath(row-1,col);
				d=findPath(row,col-1);
				if(a==false && b==false && c==false && d==false)
				{
					matrix[row][col]=1;
					return false;
				}
				else
					return true;
				}
			}
			else
				return false;
		}
		return false;
	}
	public static void main(String[] args)
	{
		System.out.println("Enter the dimension of the matrix");
		 n=sc.nextInt();
		System.out.println("Enter the element of the matrix");
		boolean flag=findPath(0,0);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}

}
