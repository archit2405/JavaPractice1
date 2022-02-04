package Graph;//Very good problem
import java.util.*;
public class isTree 
{
	public static Scanner sc=new Scanner(System.in);
	
	
	public static int nodes;
	public static HashMap<Integer,ArrayList<Integer>>graph=new HashMap<Integer,ArrayList<Integer>>();
	public static boolean[]visited;
	
	public static void arraydeclare(int n)
	{
		visited=new boolean[n];
	}
	
	public static boolean isCycle(int vertex,int parent)
	{
		visited[vertex]=true;
		ArrayList<Integer>list=graph.get(vertex);
		for(int i=0;i<list.size();i++)
		{
			if(visited[list.get(i)]==false)
			{
				if(isCycle(list.get(i),vertex))
					return true;
			}
			else if(list.get(i)!=parent)
				return true;
		}
		return false;
			
	}
	public static boolean isConnected(int vertex)
	{
		for(int i=0;i<nodes;i++)
		{
			visited[i]=false;
		}
		isConnectedCore(vertex);
		int flag=0;
		for(int i=0;i<nodes;i++)
		{
			if(visited[i]==false)
			{
				flag=1;
				break;	
			}	
		}
		if(flag==0)
			return true;
		else
			return false;
	}
	public static void isConnectedCore(int vertex)
	{
		if(visited[vertex]==true)
			return;
		visited[vertex]=true;
		ArrayList<Integer>list=graph.get(vertex);
		for(int i=0;i<list.size();i++)
		{
			if(visited[list.get(i)]!=true)
			{
				isConnectedCore(list.get(i));
			}
		}
	}
	
	public static boolean isTree()
	{
		if(!isCycle(0,-1))
		{
			if(isConnected(0))
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public static void main(String args[])
	{
		//prepare adjacency list first
		System.out.println("enter the number of nodes");
		nodes=sc.nextInt();
		arraydeclare(nodes);
		int n;
		System.out.println("Enter the number of edges");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			int a;
			int b;
			System.out.println("Enter the one end");
			a=sc.nextInt();
			System.out.println("Enter the second end");
			b=sc.nextInt();
			if(graph.containsKey(a))
			{
				ArrayList<Integer>list=graph.get(a);
				list.add(b);
				graph.put(a, list);
			}
			else
			{
				ArrayList<Integer>list=new ArrayList<Integer>();
				list.add(b);
				graph.put(a, list);
			}
			if(graph.containsKey(b))
			{
				ArrayList<Integer>list=graph.get(b);
				list.add(a);
				graph.put(b, list);
			}
			else
			{
				ArrayList<Integer>list=new ArrayList<Integer>();
				list.add(a);
				graph.put(b, list);
			}
		}
		//boolean[]visited=new boolean[4];
		System.out.println(graph);
		//System.out.println(isCycle(0,-1));
		
		//isConnected(0);
		System.out.println(isTree());
		
	}

}
