package test;
import java.util.*;
public class tree
{
	public static class Node
	{
		int data;
		Node left,right,next;
		Node(int data)
		{
			this.data=data;
			right=left=next=null;
		}
	}
	public static Node root=null;
	public static Node insertInTree(int data,Node node)
	{
		if(node==null)
		{
			return new Node(data);
		}
		if(node.data>data)
		{
			node.left=insertInTree(data,node.left);
		}
		else if(node.data<data)
		{
			node.right=insertInTree(data,node.right);
		}
		else
			return node;
		return node;
	}
	static int diameter=0;
	static int maxdiameter=0;
	public static int getDiameter(Node node)
	{
		if(node==null)
			return 0;
		int left_height=getDiameter(node.left);
		int right_height=getDiameter(node.right);
		diameter=left_height+right_height+1;
		if(diameter>maxdiameter)
			maxdiameter=diameter;
		return 1+Math.max(left_height, right_height);
	}
	public static void inOrder(Node node)
	{
		if(node!=null)
		{
			inOrder(node.left);
			System.out.print(node.data+" ");
			inOrder(node.right);
		}
	}
	public static class List
	{
		int size,min,max;
		boolean isBST;
		List(int size,int min,int max,boolean isBST)
		{
			this.size=size;
			this.min=min;
			this.max=max;
			this.isBST=isBST;
		}
	}
	public static List largestBST(Node node)
	{
		if(node==null)
		{
			return(new List(0,Integer.MAX_VALUE,Integer.MIN_VALUE,true));
		}
		if(node.left==null&&node.right==null)
		{
			return(new List(1,node.data,node.data,true));
		}
		
		List left=largestBST(node.left);
		List right=largestBST(node.right);
		
		List ret=new List((1+right.size+left.size),0,0,false);
		if(left.isBST==false)
		{
			ret.size=right.size;
		}
		if(right.isBST==false)
		{
			ret.size=left.size;
		}
		
		if(left.isBST && right.isBST && left.max<node.data && right.min>node.data)
		{
			ret.isBST=true;
			ret.min=Math.min(left.min,node.data);
			ret.max=Math.max(right.max,node.data);
			
			return ret;
			
		}
		return ret;
	}
	static int printedLevel=0;
	public static void printLeftView(Node node,int level)
	{
		if(node==null)
			return;
		if(level>printedLevel)
		{
			System.out.println(node.data);
			printedLevel=level;
		}
		printLeftView(node.left,level+1);
		printLeftView(node.right,level+1);
	}
	public static void printRightView(Node node,int level)
	{
		if(node==null)
			return;
		if(level>printedLevel)
		{
			System.out.println(node.data);
			printedLevel=level;
		}
		printRightView(node.right,level+1);
		printRightView(node.left,level+1);
	}
	public static int findDepth(Node node,int data,int level)
	{
		if(node==null)
			return 0;
		if(node.data==data)
		{
			return level;
		}
		int left,right;
		left=findDepth(node.left,data,level+1);
		if(left!=0)
			return left;
		right= findDepth(node.right,data,level+1);
        if(right!=0)
			return right;
		return 0;
	}
	public static Node findParent(Node node,int data)
	{
		if(node.data==data)
			return node;
		if(node.left==null&&node.right==null)
			return null;
		if(node.left!=null)
			if(node.left.data==data)
				return node;
		if(node.right!=null)
			if(node.right.data==data)
				return node;
		Node left,right;
		left=findParent(node.left,data);
		if(left!=null)
			return left;
		right=findParent(node.right,data);
		if(right!=null)
			return right;
		return null;
	}
	public static void levelOrderTraversal(Node node)
	{
		Queue<Node>Binarytree=new LinkedList<>();
		Binarytree.add(node);
		while(!Binarytree.isEmpty())
		{
			Node temp=Binarytree.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				Binarytree.add(temp.left);
			if(temp.right!=null)
				Binarytree.add(temp.right);
			
		}
	}
	public static void reverseLevelOrderTraversal(Node node)
	{
		Queue<Node>queue=new LinkedList<>();
		Stack<Node>stack=new Stack();
		queue.add(node);
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			stack.add(temp);
			if(temp.right!=null)
				queue.add(temp.right);
			if(temp.left!=null)
				queue.add(temp.left);
		}
		System.out.println();
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().data+" ");
		}
	}
	public static void iterativePreOrder(Node node)
	{
		Stack<Node>stack=new Stack<>();
		stack.push(node);
		System.out.println();
		while(!stack.isEmpty())
		{
			Node temp=stack.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left!=null)
				stack.push(temp.left);
		}
	}
	public static void verticalSum(Node node,int distance,HashMap<Integer,Integer>map)
	{
		if(node==null)
			return;
		if(!map.containsKey(distance))
		{
			map.put(distance,node.data);
		}
		else
		{
			int a=map.get(distance);
			map.replace(distance,a+node.data);
		}
		verticalSum(node.left,distance-1,map);
		verticalSum(node.right,distance+1,map);
		
	}
	static int maximumSumOfPath=0;
	public static void maximumSumPath(Node node,int sum)
	{
		if(node==null)
			return;
		sum=sum+node.data;
		if(sum>maximumSumOfPath)
			maximumSumOfPath=sum;
		maximumSumPath(node.left,sum);
		maximumSumPath(node.right,sum);
	}
	public static void spiralOrder(Node node,Stack<Node>stack1,Stack<Node>stack2)
	{
		if(node==null)
			System.out.println("The tree is empty");
		stack1.push(node);
		while(!stack1.isEmpty()||!stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				Node temp=stack1.pop();
				if(temp.right!=null)
					stack2.push(temp.right);
				if(temp.left!=null)
					stack2.push(temp.left);
				System.out.print(temp.data+" ");
			}
			while(!stack2.isEmpty())
			{
				Node temp=stack2.pop();
				if(temp.left!=null)
				{
					stack1.push(temp.left);
				}
				if(temp.right!=null)
				{
					stack1.push(temp.right);
				}
				System.out.print(temp.data+" ");
			}
		}
	}
	public static void iterativeInorder(Node node,Stack<Node>stack)
	{
		stack.push(node);
		while(!stack.isEmpty())
		{
			while(node.left!=null)
			{
				node=node.left;
				stack.push(node);
			}
			Node temp=stack.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
			{
				node=temp.right;
				stack.push(node);
			}
			
		}
	}
	public static int index=-1;
	public static int[]preOrder=new int[100];
	public static void serialize(Node node,int[]preOrder)
	{
		if(node==null)
		{
			preOrder[++index]=-1;
			return;
		}
		else
			preOrder[++index]=node.data;
		serialize(node.left, preOrder);
		serialize(node.right,preOrder);
	}
	public static int point=-1;
	public static Node Deserialize(Node node)
	{
		point++;
		if(preOrder[point]==-1)
			return null;
		else
		{
			Node temp=new Node(preOrder[point]);
			temp.left=Deserialize(temp.left);
			temp.right=Deserialize(temp.right);
			return temp;
			
		}
	}
	public static int result;
	public static int maximumAnyPathSum(Node node)
	{
		if(node==null)
			return 0;
		if(node.left==null&&node.right==null)
			return node.data;
		int left=maximumAnyPathSum(node.left);
		int right=maximumAnyPathSum(node.right);
		int max_value=Math.max(Math.max(left, right)+node.data,node.data);
		int max_top=Math.max(max_value,node.data+right+left);
		result=Math.max(max_value, max_top);
		return max_value;
	}
	public static int leftRightSum(Node node)
	{
		if(node==null)
			return 0;
		int left,right;
		left=leftRightSum(node.left);
		right=leftRightSum(node.right);
		int result=left+right+node.data;
		node.data=left+right;
		return result;
	}
	public static void connectLevelNodes(Node node)
	{
		if(node==null)
			return;
		else if(node.right==null&&node.left==null)
		{
			return;
		}
		else if(node.left!=null&&node.right!=null)
		{
			node.left.next=node.right;
			node.right.next=nextAvailableNode(node);
		}
		else
		{
			if(node.left!=null)
			{
				if(node.next!=null)
					node.left.next=nextAvailableNode(node);
			}
			if(node.right!=null)
			{
				if(node.next!=null)
					node.right.next=nextAvailableNode(node);
			}
		}
		connectLevelNodes(node.right);
		connectLevelNodes(node.left);
			
		}
	public static Node nextAvailableNode(Node node)
	{
		if(node.next!=null)
		{
			if(node.next.left!=null)
				return node.next.left;
			if(node.next.right!=null)
			return node.next.right;
			if(node.next.left==null&&node.next.right==null)
			{
			if(node.next.next!=null)
				return nextAvailableNode(node.next);
			else
				return null;
			}
		}
		return  null;
	}
	public static Node findNode(Node node,int key)
	{
		if(node==null)
			return  null;
		if(node.data==key)
			return node;
		Node left,right;
		left=findNode(node.left,key);
		right=findNode(node.right,key);
		if(left!=null)
			return left;
		else
			return right;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		root=new Node(10);
		root.left=new Node(2);
		root.right=new Node(15);
		root.left.left=new Node(-4);
		root.left.left.left=new Node(28);
		root.left.left.right=new Node(-22);
		root.left.right=new Node(-6);
		//root.right.left=new Node(45);
		root.right.right=new Node(-25);
		root.right.right.left=new Node(3);
		root.right.right.right=new Node(4);
		//List result=largestBST(root);
		//System.out.println(result.size);
		//printLeftView(root,1);
		//printRightView(root,1);
		/*System.out.println("Enter the two nodes that is to be checked for cousins");
		int data1,data2;
		data1=sc.nextInt();
		data2=sc.nextInt();
		int depth1,depth2;
		Node parent1,parent2;
		depth1=findDepth(root,data1,0);
		depth2=findDepth(root,data2,0);
		parent1=findParent(root,data1);
		parent2=findParent(root,data2);
		if((depth1==depth2)&&(parent1.data!=parent2.data))
			System.out.println("Yes the nodes are cousins");
		else
			System.out.println("The nodes are not cousins");*/
		//levelOrderTraversal(root);
		//reverseLevelOrderTraversal(root);
		//iterativePreOrder(root);
		//HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
		//verticalSum(root,0,map);
		//System.out.println(map);
		//maximumSumPath(root,0);
		//System.out.println(maximumSumOfPath);
		//Stack<Node>stack1=new Stack<>();
		//Stack<Node>stack2=new Stack<>();
		//spiralOrder(root,stack1,stack2);
		//Stack<Node>stack=new Stack<Node>();
		//iterativeInorder(root,stack);
		//int[]preOrder=new int[100];
		//serialize(root,preOrder);
		//Node root2=null;
		//root2=Deserialize(root2);
		//iterativeInorder(root2,stack);
		//int a=maximumAnyPathSum(root);
		//System.out.println(result);
		//int a=leftRightSum(root);
		//iterativeInorder(root,stack);
		//connectLevelNodes(root);
		//System.out.println(root.right.right.left.next.data);
		//System.out.println("Enter the key whose right node is to be found");
		//int key;
		//key=sc.nextInt();
		//Node node=findNode(root,key);
		//System.out.println(node.next.data);
		
		
	}
	
	
	

}
