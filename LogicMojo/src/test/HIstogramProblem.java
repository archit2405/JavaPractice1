package test;
import java.util.*;

import test.BinaryMatrixMaxSizeRectangle.Stack;
public class HIstogramProblem {
	public static Scanner sc=new Scanner(System.in);
	 
	public static int findLargestRectangleNovice(int[]array)
	{
		int maxArea=0;
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
	
	public static class Stack
	{
		protected int maxSize;
		protected int[]array;
		protected int top;
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
			return array[top--];
		}
		public boolean isEmpty()
		{
			if(top==-1)
				return true;
			else
				return false;
		}
		public boolean isFull()
		{
			if(top==maxSize-1)
				return true;
			else
				return false;
		}
	}
	public static int findLargestRectangleEfficient(int[]array)
	{
		//yet to solve it by stack
		/*int largestHistogram=0;
		Stack stack=new Stack(array.length);
		for(int i=0;i<array.length;i++)
		{
			if(stack.top==-1)
				stack.push(array[i]);
			else
			{
				if(array[i]<stack.array[stack.top])
				{
					int k=stack.top;
					while(k>=0 && array[i]<stack.array[k])
					{
					int begin;
					int end;
					end=i;
					int j=stack.top;
					while(array[i]<stack.array[j])
					{
						j--;
						if(j==-1)
							break;
					}
					begin=j+1;
					int area=stack.array[stack.top]*(end-begin);
					if(area>largestHistogram)
						largestHistogram=area;
					stack.pop();
					k--;
					}
					stack.push(array[i]);
				}
				else
					stack.push(array[i]);
			}
		}
		return largestHistogram;*/
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter the no of bars");
		int n=sc.nextInt();
		int[] array=new int[n];
		System.out.println("Enter the length of each bar");
		System.out.println("The width of the bars is already fixed i.e 1");
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
		}
		int result1=findLargestRectangleNovice(array);
		System.out.println(result1);
		//int result2=findLargestRectangleEfficient(array);
		//System.out.println(result2);
		
	}

}
