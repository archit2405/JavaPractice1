package test;
import java.util.*;
public class QueueImplementation {
	public static Scanner sc=new Scanner(System.in);
	public static class CircularQueue
	{
		private int size;
		private int[]array;
		private int rear;
		private int front;
		
		public CircularQueue(int size)
		{
			this.size=size;
			rear=-1;
			front=-1;
			array=new int[size];
		}
		
		public void enqueue(int data)
		{
			if(front==-1) 
			{
				front++;
				rear++;
				array[rear]=data;
			}
			else
			{
				rear=(rear+1)%size;
				array[rear]=data;
			}
		}
		public int dequeue()
		{
			if(front==rear)
			{
				int temp=array[front];
				front=-1;
				rear=-1;
				return temp;
			}
			else
			{
			int temp=array[front];
			front=(front+1)%size;
			return temp;
			}
		}
		public boolean isEmpty()
		{
			if(front==-1 && rear==-1)
				return true;
			return false;
		}
		public boolean isFull()
		{
			if(front==((rear+1)%size))
				return true;
			return false;	
		}
	}
	public static class Queue
	{
		private int front;
		private int rear;
		private int[]array;
		private int size;
		public Queue(int size)
		{
			this.size=size;
			array=new int[size];
			front=-1;
			rear=-1;
		}
		public void enqueue(int data) 
		{
			if(front==-1)
			{
				array[++front]=data;
				rear++;
			}
			else
			{
				array[++rear]=data;
			}
		}
		public int dequeue()
		{
			if(front==rear)
			{
				rear=-1;
				int temp= array[front];
				front=-1;
				return temp;
			}
			else
			{
				return array[front++];
			}
		}
		public boolean isEmpty()
		{
			if(front==-1)
				return true;
			else
				return false;
		}
		public boolean isFull()
		{
			if(rear==size-1)
				return true;
			else
				return false;
		}
		
	}
	public static void main(String args[])
	{
		/*int a1,a2,a3;
		a1=0;
		a2=0;a3=0;
		System.out.println("Enter the size of the queue ");
		int n=sc.nextInt();
		Queue queue1=new Queue(n);
		queue1.enqueue(10);
		queue1.enqueue(20);
		queue1.enqueue(30);
		if(!queue1.isEmpty())
		{
			a1=queue1.dequeue();
		}
		else
			System.out.println("the queue is empty");
		if(!queue1.isEmpty())
		{
		a2=queue1.dequeue();
		}
		else
			System.out.println("the queue is empty");
		queue1.enqueue(40);
		if(!queue1.isEmpty())
		{
			a3=queue1.dequeue();
		}
		else
			System.out.println("the queue is empty");
		System.out.println(a1+" "+a2+" "+a3);
		if(!queue1.isEmpty())
		{
			a3=queue1.dequeue();
		}
		else
			System.out.println("the queue is empty");
		System.out.println(a1+" "+a2+" "+a3);

		if(!queue1.isEmpty())
		{
			a3=queue1.dequeue();
		}
		else
			System.out.println("the queue is empty");
		System.out.println(a1+" "+a2+" "+a3);*/
		CircularQueue queue=new CircularQueue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		int temp1=queue.dequeue();
		queue.enqueue(50);
		queue.enqueue(60);
		System.out.println(temp1);
		System.out.println(queue.isFull());
		System.out.println(queue.isEmpty());
		 temp1=queue.dequeue();
		 System.out.println(temp1);
		 System.out.println(queue.isFull());
		 temp1=queue.dequeue();
		 System.out.println(temp1);
		 temp1=queue.dequeue();
		 System.out.println(temp1);
		 temp1=queue.dequeue();
		 System.out.println(temp1);
		 System.out.println(queue.isEmpty());
		 temp1=queue.dequeue();
		 System.out.println(temp1);
		 System.out.println(queue.isFull());
		 System.out.println(queue.isEmpty());
		
		
		
	}
}
