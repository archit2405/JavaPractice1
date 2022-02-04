package test;
import java.util.*;
public class LRUCache {
	public static Scanner sc=new Scanner (System.in);
	public static class Node
	{
		int key,value;
		Node next,prev;
		Node(int key,int value)
		{
			this.key=key;
			this.value=value;
			next=null;
			prev=null;
		}
	}
	public static Node head=null;
	public static Node tail=null;
	public static int cacheCount=0;
	public static void print(Node head)
	{
		Node temp;
		temp=head;
		while(temp!=null)
		{
			System.out.println(temp.key+" "+temp.value);
			temp=temp.next;
		}
	}
	public static void main(String args[])
	{
		HashMap<Integer,Node>cache=new HashMap<Integer,Node>();
		while(true)
		{
		System.out.println("1.To put the key and value in cache");
		System.out.println("2:To get the element from the cache");
		System.out.println("3. To exit");
		int i;
		i=sc.nextInt();
		if(i==3)
			break;
		if(i==1)
		{
			int key,value;
			System.out.println("Enter the key and value");
			key=sc.nextInt();
			value=sc.nextInt();
			Node temp=new Node(key,value);
			if(cacheCount==3)
			{
				cache.remove(head.key);
				head=head.next;
				cacheCount--;
			}
			if(head==null)
			{
				head=temp;
				cacheCount++;
				tail=head;
			}
			else
			{
				tail.next=temp;
				Node prev=tail;
				tail=tail.next;
				tail.prev=prev;
				cacheCount++;
			}
			cache.put(key,temp);
			//tail pointer still need to be adjusted for each iteration
			Node temp1=head;
			while(temp1.next!=null)
			{
				temp1=temp1.next;
				
			}
			tail=temp1;
		}
		if(i==2)
		{
			System.out.println("Enter the key whose value need to be retreived");
			int key=sc.nextInt();
			Node result=cache.get(key);
			System.out.println(result.value);
			if(head.key==result.key)
			{
				Node prev=head;
				head=head.next;
				head.prev=null;
				tail.next=prev;
				tail.next.prev=tail;
				tail=tail.next;
				tail.next=null;
			}
			else
			{
			Node prev=result.prev;
			Node next=result.next;
			prev.next=next;
			prev.next.prev=prev;
			tail.next=result;
			tail.next.prev=tail;
			tail=tail.next;
			tail.next=null;
			
			}
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
				
			}
			tail=temp;
		}
		
			
		}
		System.out.println(cache);
		print(head);
		}
		
	}
