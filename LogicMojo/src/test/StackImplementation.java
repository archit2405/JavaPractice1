package test;
import java.util.*;
public class StackImplementation {
	public static class Stack
	{
		private int maxsize;
		private int[]stack;
		private int top=-1;
		public Stack(int size)
		{
			maxsize=size;
			stack=new int[maxsize];
		}
		public void push(int data)
		{
			stack[++top]=data;
		}
		public int pop()
		{
			return stack[top--];
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
			if(top==maxsize-1)
				return true;
			else
				return false;
		}
	}
	public static void main(String args[])
	{
		Stack stack1=new Stack(4);
		stack1.push(12);
		stack1.push(14);
		System.out.println(stack1.pop());
		stack1.push(16);
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.isFull());
		System.out.println(stack1.isEmpty());
	}
}
