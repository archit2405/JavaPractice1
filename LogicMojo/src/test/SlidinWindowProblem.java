package test;
import java.util.*;
import java.util.LinkedList;
public class SlidinWindowProblem {
	
	public static Scanner sc=new Scanner(System.in);
	
	public static void slidingWindowProblem(int[]array,int k)
	{
		 Deque<Integer> Qi = new LinkedList<Integer>(); 
	        int i; 
	        for (i = 0; i < k; ++i) { 
	            
	            while (!Qi.isEmpty() && array[i] >= array[Qi.peekLast()]) 
	                Qi.removeLast(); 
	            Qi.addLast(i); 
	        } 
	        for (; i < array.length; i++) { 
	            
	            System.out.print(array[Qi.peek()] + " "); 
	            
	            while ((!Qi.isEmpty()) && Qi.peek() <= i - k) 
	                Qi.removeFirst(); 
	            
	            while ((!Qi.isEmpty()) && array[i] >= array[Qi.peekLast()]) 
	                Qi.removeLast(); 
	            
	            Qi.addLast(i); 
	        } 
	  
	        System.out.print(array[Qi.peek()]); 
	
	}
	
	public static void main(String args[])
	{
		System.out.println("Enter the length of the array");
		int n=sc.nextInt();
		int[]array=new int[n];
		System.out.println("Enter the elements of the array");
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
		}System.out.println("enter the window size");
		int w=sc.nextInt();
		slidingWindowProblem(array,w);
	}

}
