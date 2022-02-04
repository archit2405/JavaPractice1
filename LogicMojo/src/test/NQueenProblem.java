//Best problem 
package test;
import java.util.*;
public class NQueenProblem {
	public static Scanner sc=new Scanner(System.in);
	public static int N;
	public static boolean checkSafePosition(int[][]board,int row,int col)
	{
		//check for he queen in the same row left side of the position
		int i=row;
		int j=col;
		while(j>=0)
		{
			j--;
			if(j!=-1 && i!=-1)
			{
			if(board[i][j]==1)
				return false;
			}
		}
		//check for the left upper diagonal 
		i=row;
		j=col;
		while(i>=0 && j>=0) 
		{
			i--;
			j--;
			if(i!=-1 && j!=-1)
			{
				if(board[i][j]==1)
					return false;
			}
		}
		//check for the right upper diagonal
		i=row;
		j=col;
		while(i<N && j>=0)
		{
			i++;
			j--;
			if(i!=N && j!=-1)
			{
				if(board[i][j]==1)
					return false;
			}
		}
		return true;
	}
	public static boolean checkQueen(int[][]board,int col)
	{
		if(col==N)
			return true;
		for(int row=0;row<N;row++)
		{
			if(checkSafePosition(board,row,col)==true)
			{
				board[row][col]=1;
				if(checkQueen(board,col+1)==true)
					return true;
				board[row][col]=0;
			}
		}
		return false;
	}
	public static void main(String args[])
	{
		System.out.println("Enter the dimension of the matrix");
		N=sc.nextInt();
		int[][] board=new int[N][N];
		boolean flag=checkQueen(board,0);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
