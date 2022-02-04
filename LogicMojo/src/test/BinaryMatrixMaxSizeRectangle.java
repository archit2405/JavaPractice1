package test;
import java.util.*;
public class BinaryMatrixMaxSizeRectangle 
{
	public static Scanner sc =new Scanner(System.in);
	 public static int largestAreaRectangle=0;
	 
	 public static class Stack
	 {
		 protected int maxSize;
		 protected int top;
		 protected int[]array;
		 public Stack(int size)
		 {
			 maxSize=size;
			 array=new int[maxSize];
			 top=-1;
		 }
		 public void push(int data)
		 {
			 array[++top]=data;
		 }
		 public int pop()
		 {
			 return array[top++];
		 }
	 }
	public static int calculateLargestHistogram(int[][]matrix,int row)
	{
		int maxArea=0;
		int length=matrix[row].length;
		int[]array=new int[length];
		Stack stack=new Stack(array.length);
		for(int i=0;i<array.length;i++)
		{
			array[i]=matrix[row][i];
		}
		for(int i=0;i<array.length;i++)
		{
			int area;
			area=array[i];
			int j=i-1;
			int k=i+1;
			while(j>=0)
			{
				if(array[j]>=array[i])
				{
					area=area+array[i];
					j--;
				}
				else
					break;
			}
			while(k<=array.length-1)
			{
				if(array[k]>=array[i])
				{
					area=area+array[i];
					k++;
				}
				else
					break;
			}
			if(area>maxArea)
				maxArea=area;
		}
		return maxArea;
	}
	public static int findLargestRectangle(int[][]matrix,int d)
	{
		//here I have taken row and column both as d i.e square matrix.
		int largestRectangle=0;
		int temp;
		int row,col;
		row=d;
		col=d;
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(matrix[i][j]==1)
				{
					matrix[i][j]+=matrix[i-1][j];
				}
			}
			temp=calculateLargestHistogram(matrix,i);
			if(temp>largestRectangle)
				largestRectangle=temp;
		}
		return largestRectangle;
	}
	public static void main(String args[])
	{
		System.out.println("Enter the dimension of matrix");
		int n;
		n=sc.nextInt();
		int[][]matrix=new int[n][n];
		System.out.println("Enter the binary matrix consisting of 1 and 0");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		}
		int result=findLargestRectangle(matrix,n);
		System.out.println(result);
	}
}
