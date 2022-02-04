package test;
import java.util.*;
public class LinkedList {
	public static Scanner sc=new Scanner(System.in);
	public static class Node
	{
		int data;
		Node next;
		Node child;
		Node(int data)
		{
			this.data=data;
			next=child=null;
		}
	}
	public static Node insert(Node head)
	{
		Scanner sc=new Scanner(System.in);
		int data;
		System.out.println("Insert data");
		data=sc.nextInt();
		if(head==null)
		{
			head=new Node(data);
			return head;
		}
		Node temp=new Node(data);
		Node node=head;
		while(node.next!=null)
			node=node.next;
		node.next=temp;
		return head;
	}
	public static Node delete(Node head,int key)
	{
		//int key;
		//System.out.println("enter the key to be deleted");
		//key=sc.nextInt();
		if(head.data==key)
		{
			head=head.next;
			return head;
		}
		Node temp=head;
		while(temp.next.data!=key)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
		return head;
	}
	public static void print(Node node)
	{
		while(node!=null)
		{
			if(node.next!=null)
			{
				System.out.print(node.data+"->");
			}
			else
				System.out.print(node.data);
			node=node.next;
		}
	}
	public static Node mergeSortedLists(Node head1,Node head2)
	{
		Node new_list=null;
		Node temp=null;
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		if(head1.data<head2.data)
		{
			new_list=head1;
			head1=head1.next;
			temp=new_list;
		}
		else
		{
			new_list=head2;
			head2=head2.next;
			temp=new_list;
		}
		while(head1!=null&&head2!=null)
		{
			if(head1.data<head2.data)
			{
				temp.next=head1;
				head1=head1.next;
				temp=temp.next;
			}
			else
			{
				temp.next=head2;
				head2=head2.next;
				temp=temp.next;
			}
		}
		if(head1==null)
			temp.next=head2;
		if(head2==null)
			temp.next=head1;
		return new_list;
	}
	public static boolean palindromeCheck(Node node)
	{
		int totalcount=0;
		Node temp=node;
		while(temp!=null)
		{
			totalcount++;
			temp=temp.next;
		}
		int mid=totalcount/2;
		int count=0;
		temp=node;
		int[]array=new int[10];
		int i=0;
		while(count!=mid)
		{
			array[i]=temp.data;
			count++;
			i++;
			temp=temp.next;
		}
		i=0;
		int j=-1;
		while(array[i]!='\0')
		{
			j++;
			i++;
		}
		if(totalcount%2==1)
			temp=temp.next;
		i=0;
		while(temp!=null)
		{
			if(temp.data!=array[j])
				return false;
			j--;
			temp=temp.next;
		}
		return true;
	}
	public static Node reverse(Node node)
	{
		Node next,prev,current;
		current =node;
		prev=next=null;
		 while(current!=null)
		 {
			 next=current.next;
			 current.next=prev;
			 prev=current;
			 current=next;
		 }
		 return prev;
	}
	public static Node mergeSort(Node node)
	{
		if(node==null||node.next==null)
			return node;
		Node mid=findMid(node);
		Node temp=mid.next;
		mid.next=null;
		Node node1=mergeSort(node);
		Node node2=mergeSort(temp);
		Node result=mergeSortedLists(node1,node2);
		return result;
	}
	public static Node findMid(Node node)
	{
		Node current1=node;
		Node current2=node;
		while(current2.next!=null && current2.next.next!=null)
		{
			current2=current2.next.next;
			current1=current1.next;
		}
		//current1.next=null;
		return current1;
	}
	public static Node merge(Node node1,Node node2)
	{
		Node new_list,temp;
		if(node1==null)
			return node2;
		if(node2==null)
			return node1;
		if(node1.data<node2.data)
		{
			new_list=node1;
			node1=node1.child;
		}
		else
		{
			new_list=node2;
			node2=node2.child;	
		}
		temp=new_list;
		while(node1!=null&&node2!=null)
		{
			if(node2.data>node1.data)
			{
				temp.child=node1;
				temp=node1;
				node1=node1.child;
			}
			else
			{
				temp.child=node2;
				temp=node2;
				node2=node2.child;
			}
		}
		if(node1==null)
			temp.child=node2;
		if(node2==null)
			temp.child=node1;
		return new_list;
	}
	public static Node sumOfLinkedList(Node head1,Node head2)
	{
		int count1=0,count2=0,totalcount;
		Node temp1,temp2;
		Node new_list=null;
		temp1=head1;temp2=head2;
		while(temp1!=null)
		{
			temp1=temp1.next;
			count1++;
		}
		int final1=count1;
		while(temp2!=null)
		{
			temp2=temp2.next;
			count2++;
		}
		int final2=count2;
		if(count1>count2)
			totalcount=count2;
		else
			totalcount=count1;
		int count=0;int carry=0;
		while(count!=totalcount)
		{
			int c1=0,c2=0;
			temp1=head1;temp2=head2;
			while(c1<count1-1)
			{
				temp1=temp1.next;
				c1++;
			}
			while(c2<count2-1)
			{
				temp2=temp2.next;
				c2++;
			}
			count1--;
			count2--;
			count++;
			int sum=temp1.data+temp2.data+carry;
			int remainder=sum%10;
			carry=sum/10;
			Node sumNode=new Node(remainder);
			sumNode.next=new_list;
			new_list=sumNode;
		}
		if(final1==final2)
		{
		if(carry>0)
		{
			Node sumNode=new Node(carry);
			sumNode.next=new_list;
			new_list=sumNode;
		}
		}
		if(final1>final2)
		{
			count=0;
			int a=(final1-final2);
			while(count!=(final1-final2))
			{
				while(count!=(final1-final2))
				{
					Node temp=head1;
					count1=0;
					while(count1<a-1)
					{
						temp=temp.next;
						count1++;
					}
					a--;
					count++;
					int sum=temp.data+carry;
					int remainder=sum%10;
					carry=sum/10;
					Node sumNode=new Node(remainder);
					sumNode.next=new_list;
					new_list=sumNode;
					
				}
			}
			if(carry>0)
			{
				Node sumNode=new Node(carry);
				sumNode.next=new_list;
				new_list=sumNode;
			}
		}
		if(final2>final1)
		{
			count=0;
			int a=(final2-final1);
			while(count!=(final2-final1))
			{
				while(count!=(final2-final1))
				{
					Node temp=head2;
					count1=0;
					while(count1<a-1)
					{
						temp=temp.next;
						count1++;
					}
					a--;
					count++;
					int sum=temp.data+carry;
					int remainder=sum%10;
					carry=sum/10;
					Node sumNode=new Node(remainder);
					sumNode.next=new_list;
					new_list=sumNode;
					
				}
			}
			if(carry>0)
			{
				Node sumNode=new Node(carry);
				sumNode.next=new_list;
				new_list=sumNode;
			}
		}
		
		return new_list;
	}
	public static Node clone(Node head1)
	{
		Node head2=null;
		Node temp1=head1;
		while(temp1!=null)
		{
			Node temp2=head2;
			if(head2==null)
			{
				head2=new Node(temp1.data);
			}
			else
			{
				while(temp2.next!=null)
				{
					temp2=temp2.next;
				}
				Node temp=new Node(temp1.data);
				temp2.next=temp;
			}
			temp1=temp1.next;	
		}
		Node temp2;
		temp1=head1;
		temp2=head2;
		while(temp1!=null)
		{
			Node buffer;
			buffer=temp1.next;
			temp1.next=temp2;
			temp2.random=temp1;
			temp1=buffer;
			temp2=temp2.next;
		}
		temp2=head2;
		while(temp2!=null)
		{
			temp2.random=temp2.random.random.next;
			temp2=temp2.next;
		}
		return head2;
	}
	public static void randomPrint(Node node)
	{
		Node temp=node;
		//System.out.print(temp.data+"->");
		while(temp!=null)
		{
			System.out.print(temp.random.data+"->");
			temp=temp.next;
		}
	}
	public static Node nthNodeFromEnd(Node node,int key)
	{
		Node temp=node;
		int count=0;
		while(temp!=null)
		{
			temp=temp.next;
			count++;
		}
		int finalCount=count-key+1;
		temp=node;
		count=0;
		while(count!=finalCount-1)
		{
			temp=temp.next;
			count++;
		}
		return temp;
	}
	public static Node reverseKLinkedList(Node node,int k)
	{
	//write it by yourself. you have got enough hints.
		Node prev,curr,next;
		curr=node;
		prev=next=null;
		int count=0;
		while(count!=k&&curr!=null)
		{
			count++;
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		//attach the reverse linked list with the original one
		//Below two lines are the best one to understand the recursion
		if(next!=null)
			node.next=reverseKLinkedList(next,k);
		return prev;
	}
	public static int intersectionNode(Node head1,Node head2)
	{
		int a=findLength(head1);
		int b=findLength(head2);
		if(a>b)
		{
			int diff=a-b;
			int count=0;
			Node temp=head1;
			while(count<diff)
			{
				temp=temp.next;
				count++;
			}
			head1=temp;
		}
		else
		{
			int diff=b-a;
			int count=0;
			Node temp=head2;
			while(count<diff)
			{
				temp=temp.next;
				count++;
			}
			head2=temp;
		}
		while(head1!=null&&head2!=null)
		{
			head1=head1.next;
			head2=head2.next;
			if(head1==head2)
				return head1.data;
		}
		return 0;
	}
	public static int findLength(Node node)
	{
		Node temp;
		temp=node;int length=0;
		while(temp!=null)
		{
			temp=temp.next;
			length++;
			
		}
		return length;
	}
	public static Node insertSorted(Node node,int data)
	{
		if(data<node.data)
		{
			Node temp=new Node(data);
			temp.next=node;
			node=temp;
			return node;
		}
		
		Node temp=node;
		while(data>temp.next.data)
			temp=temp.next;
		Node temp1=new Node(data);
		Node buffer=temp.next;
		temp.next=temp1;
		temp1.next=buffer;
		return node;
	}
	public static Node flattenLinkedList(Node node)
	{
		//Node temp=node;
		if(node==null||node.next==null)
			return node;
		node.next=flattenLinkedList(node.next);
		node=merge(node,node.next);
		return node;
		
	}
	public static Node segregateEvenOdd(Node node)
	{
		//Very good example where we are assigning new list without increasing space complexity as we are not creating
		//any new nodes.
		Node evenlist,oddlist,even,odd;
		evenlist=oddlist=even=odd=null;
		Node temp=node;
		if(temp.data%2==0)
		{
			evenlist=temp;
			even=evenlist;
		}
		if(temp.data%2!=0)
		{
			oddlist=temp;
			odd=oddlist;
		}
		temp=temp.next;
		while(temp!=null)
		{
			if(temp.data%2==0)
			{
				if(even==null)
				{
					evenlist=temp;
					even=evenlist;
				}
				else
				{
				even.next=temp;
				even=even.next;
				}
			}
			if(temp.data%2!=0)
			{
				if(odd==null)
				{
					oddlist=temp;
					odd=oddlist;
				}
				else
				{
				odd.next=temp;
				odd=odd.next;
				}
			}
			temp=temp.next;
		}
		even.next=oddlist;
		odd.next=null;
		return evenlist;
	}
	public static Node rearrangeLL(Node node)
	{
		Node node2=node;
		Node buffer1,buffer2;
		buffer1=node;
		buffer2=node;
		Node prev=null;
		while(buffer2!=null&&buffer2.next!=null)
		{
			prev=buffer1;
			buffer1=buffer1.next;
			buffer2=buffer2.next.next;
			
		}
		prev.next=null;
		Node mid=buffer1;
		mid=reverse(mid);
		Node temp1=node2;
		Node temp2=mid;
		Node curr=temp1;
		 prev=null;
		while(curr!=null)
		{
			prev=curr;
			buffer1=temp1.next;
			buffer2=temp2.next;
			if(curr.data==temp1.data)
			{
				curr.next=temp2;
				curr.next.next=null;
			}
			else
			{
				curr.next=temp1;
				curr.next.next=null;
			}
			int check=temp1.data;
			temp1=buffer1;
			temp2=buffer2;
			if(curr.data==check)
			{
				curr=temp2;
			}
			else
			{
				curr=temp1;
			}
		}
		if(temp1==null)
			prev.next=temp2;
		if(temp2==null)
			prev.next=temp1;
		return node2;
	}
	public static void main(String args[])
	{
		/*Node head=null;
		while(true) 
		{
		System.out.println("Insert press 1,delete press 2,print 3");
		int a=sc.nextInt();
		if(a==1)
			head=insert(head);
		else if(a==2)
			head=delete(head);
		else if(a==3)
		{
			print(head);
			System.out.println();
		}
		else
			System.out.println("Invalid Input");
		
		}*/
		Node head1=null;
		//Node head2=null;
		while(true)
		{
			System.out.println("Insert elements for the first array");
			System.out.println("1.Insert 2.End");
			int a;
			a=sc.nextInt();
			if(a==1)
				head1=insert(head1);
			else
				break;
		}
		
	/*	while(true)
		{
			System.out.println("Insert elements for the second array");
			System.out.println("1.Insert 2.End");
			int a;
			a=sc.nextInt();
			if(a==1)
				head2=insert(head2);
			else
				break;
		}
		/*print(head1);
		System.out.println();
		print(head2);
		Node mergedHead=mergeSortedLists(head1,head2);
		System.out.println();
		print(mergedHead);
		if(palindromeCheck(head1)==true)
		{
			System.out.println("The linked list is palindrome");
		}
		else
			System.out.println("The linked list is not pallindrome");*/
		//Node reversed=reverse(head1);
		//print(reversed);
		//Node sortedList=mergeSort(head1);
		//print(sortedList);
		//Node sum_list=sumOfLinkedList(head1,head2);
		//print(sum_list);
		//head2=clone(head1);
		//print(head2);
		
		   /* Node head = new Node(3);
	        head.next = new Node(4);
	        head.next.next = new Node(5);
	        head.next.next.next = new Node(6);
	        head.next.next.next.next = new Node(7);

	        // 3 random points to 5
	        head.random = head.next.next;

	        // 5 random points to 3
	        head.next.random = head;

	        // 5 and 6 random points to 7
	        head.next.next.random = head.next.next.next.next;
	        head.next.next.next.random = head.next.next.next.next;

	        // 7 random points to 4
	        head.next.next.next.next.random = head.next;
	        print(head);
	        System.out.println();
	        randomPrint(head);
	        System.out.println();
	        Node head2=clone(head);
	        print(head2);
	        System.out.println();
	        randomPrint(head2);*/
		//System.out.println("Enter the node position from the end that you want to get printed");
		//int key=sc.nextInt();
		//Node node= nthNodeFromEnd(head1,key);
		//System.out.println(node.data+" ");
		/*print(head1);
		System.out.println();
		System.out.println("Enter the value of k that is the size of the group");
		int k=sc.nextInt();
		Node reversedLL=reverseKLinkedList(head1,k);
		print(reversedLL);*/
		/*Node temp=head2;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=head1.next.next.next;
		int data=intersectionNode(head1,head2);
		System.out.println(data);*/
	        
	       /* head1.next.next.next.child=new Node(20);
	        head1.next.next.next.child.child=new Node(30);
	        head1.next.next.next.next.child=new Node(22);
	        head1.next.next.next.next.child.child=new Node(50);
	        head1.next.next.next.next.next.child=new Node(35);
	        head1.next.next.next.next.next.child.child=new Node(40);
	        head1.next.next.next.next.next.child.child.child=new Node(45);
	        head1=flattenLinkedList(head1);
	        print(head1);*/
		//head1=segregateEvenOdd(head1);
		head1=rearrangeLL(head1);
		print(head1);
		
	}

}
