package test;
import java.util.*;
public class GetMInStack {
	public static Scanner sc=new Scanner(System.in);
	
	public static class Stack
	{
		protected int maxSize;
		protected int[]array1;
		protected int[]array2;
		protected int top1;
		protected int top2;
		protected int min;
		public Stack(int size)
		{
			maxSize=size;
			array1=new int[maxSize];
			array2=new int[maxSize];
			top1=-1;
			top2=-1;
			min=0;
		}
		public void push1(int data)
		{
			array1[++top1]=data;
		}
		public void push2(int data)
		{
			array2[++top2]=data;
		}
		public void popinternal()
		{
			int temp=array2[top2--];
			if(top2==-1)
				min=0;
			else
			{
			min=temp-(2*array2[top2]);
			}
		}
		public int pop()
		{
			popinternal();
			return array1[top1--];
		}
		public int getMin()
		{
			return min;
		}
	}
	
	public static void buildModifiedStack(int[]array,Stack stack)
	{
		int n=array.length;
		for(int i=0;i<n;i++)
		{
			stack.push1(array[i]);
		}
		for(int i=0;i<n;i++)
		{
			int temp;
			if(stack.top2==-1)
			{
				temp=2*0+stack.min;
				stack.push2(temp);
			}
			else
			{
				temp=2*stack.array2[stack.top2]+stack.min;
				stack.push2(temp);
			}
			if(array[i]<=stack.min)
				stack.min=array[i];
		}
	}
	
	public static void main(String args[])
	{
		int n;
		System.out.println("Enter the number of inputs");
		n=sc.nextInt();
		int[]array=new int[n];
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
		}
		
		Stack stack=new Stack(n);
		buildModifiedStack(array,stack);
		System.out.println(stack.min);
		System.out.println(stack.pop());
		System.out.println(stack.min);
		
		
	}

}
