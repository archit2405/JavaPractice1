package Graph;//flagship problem
import java.util.*;
public class RottenOrangeProblem {
	public static Scanner sc=new Scanner(System.in);
	public static int row,col;
	public static class myclass
	{
		int x,y;
		int time;
		public myclass(int x,int y,int time)
		{
			this.x=x;
			this.y=y;
			this.time=time;
		}
	}
	
	public static boolean isValid(int x ,int y)
	{
		if(x>=0 && x<row && y>=0 && y<col)
			return true;
		else
			return false;
	}
	public static int calculateTime(int[][]matrix,int row,int col)
	{
		Queue<myclass>queue=new LinkedList<myclass>();
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(matrix[i][j]==2)
				{
					queue.add(new myclass(i,j,0));
				}
			}
		}
		int t=0;//as we are going to return the last time of the last removed element
		while(queue.isEmpty()==false)
		{
			myclass temp=queue.remove();
			int x,y;
			x=temp.x;
			y=temp.y;
			t=temp.time;
			if(isValid(x+1,y) && matrix[x+1][y]==1)
			{
				 matrix[x+1][y]=2;
				 queue.add(new myclass(x+1,y,t+1));
			}
			if(isValid(x-1,y) && matrix[x-1][y]==1)
			{
				 matrix[x-1][y]=2;
				 queue.add(new myclass(x-1,y,t+1));
			}
			if(isValid(x,y+1) && matrix[x][y+1]==1)
			{
				 matrix[x][y+1]=2;
				 queue.add(new myclass(x,y+1,t+1));
			}
			if(isValid(x,y-1) && matrix[x][y-1]==1)
			{
				 matrix[x][y-1]=2;
				 queue.add(new myclass(x,y-1,t+1));
			}
		}
		return t;
	}
	public static void main(String args[])
	{
		System.out.println("Please wait..System is taking matrix input");
		int[][]matrix=
			{
					{2,1,0,2,1},
					{1,0,1,2,1},
					{1,0,0,2,1}
			};
		System.out.println("Enter the row and column");
		row=sc.nextInt();
		col=sc.nextInt();
		int result=calculateTime(matrix,row,col);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(matrix[i][j]==1)
				{
					System.out.println("Every orange can not be rotten");
					System.exit(0);
				}
					
			}
		}
		System.out.println(result);
	}
}
