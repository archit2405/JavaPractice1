package test;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class KnightWalkProblem
{
	public static Scanner sc=new Scanner(System.in);
	public static class Node
	{
		int x;
		int y;
		int distance;
		protected Node(int x,int y,int distance)
		{
			this.x=x;
			this.y=y;
			this.distance=distance;
		}
	}
	public static int[]array1= {-2,-2,-1,-1,+2,+2,+1,+1};
	public static int[]array2= {+1,-1,+2,-2,-1,+1,-2,+2};
	public static int[][] visited=new int[8][8];
	public static boolean isValid(Node temp)
	{
		if(temp.x>=0 && temp.x<=7)
		{
			if(temp.y>=0 && temp.y<=7)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public static int findMinPath(Queue<Node>queue,int x,int y)
	{
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			visited[temp.x][temp.y]=1;
			if(temp.x==x && temp.y==y)
			{
				return temp.distance;
			}
			for(int i=0;i<8;i++)
			{
				Node temp1=new Node(temp.x+array1[i],temp.y+array2[i],temp.distance+1);
				if(isValid(temp1)==true && visited[temp1.x][temp1.y]==0)
				queue.add(temp1);
			}
		}
		return 0;
	}
	public static void main(String args[])
	{
		System.out.println("Enter the source co ordinates");
		System.out.println("Enter the x co ordinate");
		int x=sc.nextInt();
		System.out.println("Enter the y co ordinate");
		int y=sc.nextInt();
		Node source=new Node(x,y,0);
		Queue<Node> queue=new LinkedList<>();
		queue.add(source);
		System.out.println("Enter the destination address");
		System.out.println("Enter the x co ordinate of the destination");
		x=sc.nextInt();
		System.out.println("Enter the y co ordinate of the destination");
		y=sc.nextInt();
		int result=findMinPath(queue,x,y);
		System.out.println(result);
	}
	
}