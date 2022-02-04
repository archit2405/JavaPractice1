package Graph;
import java.util.*;
public class GateWallAlgorithm {
	public static Scanner sc=new Scanner(System.in);
	
	public static boolean[][]visited=new boolean[4][4];
	
	public static class myclass
	{
		int x;
		int y;
		int dist;
		public myclass(int x,int y,int dist)
		{
			this.x=x;
			this.y=y;
			this.dist=dist;
		}
	}
	
	public static boolean isValid(int x,int y)
	{
		if(x>=0 && x<4)
		{
			if(y>=0 && y<4)
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	public static double[][] calculateMinimumDistanceFromGate(double[][]matrix)
	{
		Queue<myclass>queue=new LinkedList<>();
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(matrix[i][j]==0)
				{
					queue.add(new myclass(i,j,0));
					visited[i][j]=true;
				}
			}
		}
		while(queue.isEmpty()==false)
		{
			myclass flag=queue.remove();
			int x,y;
			x=flag.x;
			y=flag.y;
			if(isValid(x-1,y) && matrix[x-1][y]!=-1 && visited[x-1][y]==false)
			{
				matrix[x-1][y]=flag.dist+1;
				queue.add(new myclass(x-1,y,flag.dist+1));
				visited[x-1][y]=true;
			}
			if(isValid(x,y+1) && matrix[x][y+1]!=-1 && visited[x][y+1]==false)
			{
				matrix[x][y+1]=flag.dist+1;
				queue.add(new myclass(x,y+1,flag.dist+1));
				visited[x][y+1]=true;
			}
			if(isValid(x,y-1) && matrix[x][y-1]!=-1 && visited[x][y-1]==false)
			{
				matrix[x][y-1]=flag.dist+1;
				queue.add(new myclass(x,y-1,flag.dist+1));
				visited[x][y-1]=true;
			}
			if(isValid(x+1,y) && matrix[x+1][y]!=-1 && visited[x+1][y]==false)
			{
				matrix[x+1][y]=flag.dist+1;
				queue.add(new myclass(x+1,y,flag.dist+1));
				visited[x+1][y]=true;
			}
		}
		return matrix;
	}
	public static void main(String args[])
	{
		double INF=Double.POSITIVE_INFINITY;
		//0 gate
		//-1 wall
		//Infinity empty
		double[][]matrix= {
				{INF,-1,0,INF},
				{INF,INF,INF,-1},
				{INF,-1,INF,-1},
				{ 0,-1,INF,INF}
		};
		double[][]result=calculateMinimumDistanceFromGate(matrix);
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}
