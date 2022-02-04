package test;
import java.util.*;
public class DoublyLinkedList {
	public static Scanner sc=new Scanner(System.in);
	public static class Node
	{
		int data;
		Node prev,next;
		Node(int data)
		{
			this.data=data;
			prev=next=null;
		}
	}
	public static Node head;
	public static void insert()
	{
		int data;
		System.out.println("Insert the data");
		data=sc.nextInt();
		if(head==null)
			head=new Node(data);
		else
		{
			Node pointer=head;
			while(pointer.next!=null)
			{
				pointer=pointer.next;
			}
			Node temp=new Node(data);
			pointer.next=temp;
			temp.prev=pointer;
		}
	}
	public static void delete()
	{
		int data;
		System.out.println("Enter the key to be deleted");
		data=sc.nextInt();
		Node pointer=head;
		if(head.data==data)
		{
			head=head.next;
			head.prev=null;
			return;
		}
		while(pointer.next.data!=data)
		{
			pointer=pointer.next;
		}
		pointer.next=pointer.next.next;
		pointer.next.prev=pointer;
	}
	public static void print() 
	{
		Node pointer=head;
		while(pointer!=null)
		{
			if(pointer.next!=null) {
			System.out.print(pointer.data+"->");
			}
			else
				System.out.print(pointer.data);
			pointer=pointer.next;
		}
	}
	public static void main(String args[])
	{
		while(true) 
		{
		System.out.println("Insert:1,Delete:2,Print:3,Exit:0");
		int a;
		a=sc.nextInt();
		if(a==1)
			insert();
		else if(a==2)
			delete();
		
		else if(a==3) {
			print();
			System.out.println();
		}
		else
		{
			System.out.println("Program terminates");
			break;
		}
		
		}
	}

}
