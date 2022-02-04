package test;
import java.util.*;
public class NextGreaterEleemntInArray 
{
	public static Scanner sc=new Scanner(System.in);
	
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
			 return array[top--];
		 }
	 }
	
	public static HashMap<Integer,Integer> findNextGreaterEfficientApproach(int[]array)
	{
		HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++)
		{
			map.put(array[i],-1);
		}
		Stack stack=new Stack(array.length);
		int i=0;
		stack.push(array[i]);
		for( i=1;i<array.length;i++)
		{
			if(array[i]>stack.array[stack.top])
			{
				int j=stack.top;
				while(j>=0 && stack.array[j]<array[i])
				{
					int temp=stack.pop();
					map.put(temp,array[i]);
					j--;
				}
				stack.push(array[i]);
			}
			else
				stack.push(array[i]);
		}
		return map;
	}
	
	public static void findNextGreaterNaiveApproach(int[]array)
	{
		for(int i=0;i<array.length;i++)
		{
			int flag=0;
			int temp=array[i];
			int nextMax=-1;
			
			for(int j=i+1;j<array.length;j++)
			{
				if((array[j]>array[i]) && (array[j]>nextMax))
				{
					nextMax=array[j];
					System.out.print(nextMax+" ");
					flag=1;
					break;
				}
			}
			if(flag==0)
				System.out.print(nextMax+" ");
		}
	}
	
	public static void main(String args[])
	{
		int n;
		System.out.println("Enter the length of the array");
		n=sc.nextInt();
		int[] array=new int[n];
		System.out.println("Enter the elements of the array");
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
		}
		findNextGreaterNaiveApproach(array);
		System.out.println();
		HashMap<Integer,Integer>result=findNextGreaterEfficientApproach(array);
		for(HashMap.Entry m : result.entrySet())
		{    
		    System.out.println(m.getKey()+" "+m.getValue());    
		}
}
}
