package test;
import java.util.*;
public class firstNonRepeating {
	public static Scanner sc=new Scanner(System.in);
	public static class Node
	{
		char a;
		Node next,prev;
		Node(char a)
		{
			this.a=a;
			next=null;
			prev=null;
		}
	}
	public static Node head=null;
	public static Node tail=null;
	public static void insertInCharStream(char ch,Node[]ascii)
	{
		if(ascii[ch]==null)
		{
			Node temp=new Node(ch);
			ascii[ch]=temp;
			if(head==null)
			{
				head=temp;
				head.prev=null;
			}
			else
			{
				Node prev=tail;
				prev.next=temp;
				tail=tail.next;
				tail.prev=prev;
			}
			
		}
		else
		{
			if(ascii[ch].a==' ') 
			{
				System.out.println("Character already repeated");
				return;
			}
			else if(ascii[ch].a==head.a)
			{
				head.a=' ';
				head=head.next;
			}
			else {
			Node prev=ascii[ch].prev;
			Node next=ascii[ch].next;
			ascii[ch].a=' ';
			prev.next=next;
			prev.next.prev=prev;
			}
		}
		Node temp;
		temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		tail=temp;
		
	}
	public static void print(Node head) {
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.a);
			temp=temp.next;
		}
	}
	public static Node[] ascii=new Node[256];
	public static void main(String args[])
	{
		while(true)
		{
			System.out.println("Enter 1 to insert char in the stream, Enter 2 to print the first non repeated character");
			int a;
			a=sc.nextInt();
			System.out.println();
			if(a==1)
			{
				char ch;
				System.out.println("Enter the character");
				ch=sc.next().charAt(0);
				insertInCharStream(ch,ascii);
			}
			if(a==2)
			{
				//print(head);
				System.out.println(head.a);
			}
			
		}
	}
	
	
	
}
