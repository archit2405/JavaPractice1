package Graph;
import java.util.*;
public class LargestIsland {
public static Scanner sc=new Scanner(System.in);
public static class myclass
	{
		
		 int x,y;
		 public myclass(int x,int y)
		 {
			 this.x=x;
			 this.y=y;
		 }
	}
public static int[][]matrix= {
		{0,0,1,1,0},
		{1,0,1,1,0},
		{0,0,0,0,0},
		{1,0,1,0,1},
		{0,1,0,1,0}
		};
public static int n=matrix[0].length;
public static boolean[][]isFree=new boolean[matrix[0].length][matrix[0].length];

	public static void main(String args[])
	{
		int maxcount=Integer.MIN_VALUE;
		int FF=0;
		for(int i=0;i<matrix[0].length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==1)
					isFree[i][j]=true;
			}
		}
		while(true)
		{
			int count=0;
		int flag=0;
		Queue<myclass>queue=new LinkedList<>();
		for(int i=0;i<matrix[0].length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==1 && isFree[i][j]==true)
				{
					flag=1;
					queue.add(new myclass(i,j));
					isFree[i][j]=false;
					count++;
					break;
				}
			}
			if(flag==1)
				break;
		}
		if(flag==0)
		{
			break;
		}
		while(queue.isEmpty()==false)
		{
			myclass buffer=queue.poll();
			int x=buffer.x;
			int y=buffer.y;
			if(x>=0 && x<=n-1 && y-1>=0 && y-1<=n-1 && matrix[x][y-1]==1 && isFree[x][y-1]==true)
			{
				myclass buffer1=new myclass(x,y-1);
				queue.add(buffer1);
				count++;
				isFree[x][y-1]=false;
			}
			if(x>=0 && x<=n-1 && y+1>=0 && y+1<=n-1 && matrix[x][y+1]==1 && isFree[x][y+1]==true)
			{
				myclass buffer1=new myclass(x,y+1);
				queue.add(buffer1);
				count++;
				isFree[x][y+1]=false;
			}
			if(x-1>=0 && x-1<=n-1 && y-1>=0 && y-1<=n-1 && matrix[x-1][y-1]==1 && isFree[x-1][y-1]==true)
			{
				myclass buffer1=new myclass(x-1,y-1);
				queue.add(buffer1);
				count++;
				isFree[x-1][y-1]=false;
			}
			if(x-1>=0 && x-1<=n-1 && y>=0 && y<=n-1 && matrix[x-1][y]==1 && isFree[x-1][y]==true)
			{
				myclass buffer1=new myclass(x-1,y);
				queue.add(buffer1);
				count++;
				isFree[x-1][y]=false;
			}
			if(x-1>=0 && x-1<=n-1 && y+1>=0 && y+1<=n-1 && matrix[x-1][y+1]==1 && isFree[x-1][y+1]==true)
			{
				myclass buffer1=new myclass(x-1,y+1);
				queue.add(buffer1);
				count++;
				isFree[x-1][y+1]=false;
			}
			if(x+1>=0 && x+1<=n-1 && y-1>=0 && y-1<=n-1 && matrix[x+1][y-1]==1 && isFree[x+1][y-1]==true)
			{
				myclass buffer1=new myclass(x+1,y-1);
				queue.add(buffer1);
				count++;
				isFree[x+1][y-1]=false;
			}
			if(x+1>=0 && x+1<=n-1 && y>=0 && y<=n-1 && matrix[x+1][y]==1 && isFree[x+1][y]==true)
			{
				myclass buffer1=new myclass(x+1,y);
				queue.add(buffer1);
				count++;
				isFree[x+1][y]=false;
			}
			if(x+1>=0 && x+1<=n-1 && y+1>=0 && y+1<=n-1 && matrix[x+1][y+1]==1 && isFree[x+1][y+1]==true)
			{
				myclass buffer1=new myclass(x+1,y+1);
				queue.add(buffer1);
				count++;
				isFree[x+1][y+1]=false;
			}
		}
		if(count>maxcount)
			maxcount=count;
	}
		System.out.println(maxcount);
}
}
