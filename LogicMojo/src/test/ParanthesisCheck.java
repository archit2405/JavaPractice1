package test;
import java.util.*;
public class ParanthesisCheck {
	public static Scanner sc=new Scanner(System.in);
	
	public static boolean isValidString(char[]array)
	{
		int flag=0;
		Stack stack=new Stack(array.length);
		for(int i=0;i<array.length;i++)
		{
			if(array[i]=='{' || array[i]=='[' || array[i]=='(')
			{
				stack.push(array[i]);
			}
			else if(array[i]=='}' || array[i]==']' || array[i]==')')
			{
				if(array[i]=='}')
				{
					char temp=stack.pop();
					if(temp!='{')
					{
						flag=1;
						break;
					}
				}
				if(array[i]==']')
				{
					char temp=stack.pop();
					if(temp!='[')
					{
						flag=1;
						break;
					}
				}
				if(array[i]==')')
				{
					char temp=stack.pop();
					if(temp!='(')
					{
						flag=1;
						break;
					}
				}
				
			}
			else
				return false;
		}
		if(flag==1)
			return false;
		if(stack.isEmpty()==true)
			return true;
		else
			return false;
		
	}
	
	
	
	
	
	public static class Stack
	{
		protected int maxSize;
		protected int top;
		protected char[]array;
		public Stack(int size)
		 {
			maxSize=size;
			array=new char[maxSize];
			top=-1;
		 }
		public void push(char data)
		{
			array[++top]=data;
		}
		public char pop()
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
	public static void main(String args[])
	{
		String str;
		System.out.println("Entrer the string containing paranthesis only");
		str=sc.nextLine();
		char[]array1=str.toCharArray();
		boolean flag=isValidString(array1);
		if(flag==true)
			System.out.println("The string is valid.");
		else
			System.out.println("The string is not valid.");
		
	}

}
