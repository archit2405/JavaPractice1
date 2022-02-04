package Graph;
import java.util.*;
public class FindingPathInDirectedAcyclicGraph {
	public static Scanner sc=new Scanner(System.in);
	public static HashMap<Integer,ArrayList<Integer>>graph=new HashMap<Integer,ArrayList<Integer>>();
	public static HashMap<Integer,ArrayList<Integer>>resultMap=new HashMap<Integer,ArrayList<Integer>>();
	public static HashMap<Integer,Integer>visited=new HashMap<Integer,Integer>();
	public static int flag=0;
	public static int source,dest;
	public static ArrayList<Integer>printedPath=new ArrayList<Integer>();
	public static void addEdge(int a,int b)
	{
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
			graph.put(a,list);
		}
	}
	public static void removeEdge(int a,int b)
	{
		ArrayList<Integer>list=graph.get(a);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i)==b)
			{
				list.remove(i);
				break;
			}
		}
		graph.put(a, list);
	}
	
	public static void findPaths(int a)
	{
		visited.put(a,1);
		ArrayList<Integer>list=graph.get(a);
		if(list==null)
			return;
		System.out.print(a+" ");
		printedPath.add(a);
		if(a==dest)
			return ;
		for(int i=0;i<list.size();i++)
		{
			if(visited.get(list.get(i))==0)
			{
				findPaths(list.get(i));
			}
			else
				return;
		}
	}
	
		
			public static void main(String args[])
			{
				System.out.println("Enter the  number of edges");
				int n=sc.nextInt();
				for(int i=0;i<n;i++)
				{
					System.out.println("Enter the edge");
					addEdge(sc.nextInt(),sc.nextInt());
				}
				System.out.println("Enter the source vertex");
				 source=sc.nextInt();
				System.out.println("enter the destination vertex");
				 dest=sc.nextInt();
				for(Map.Entry<Integer,ArrayList<Integer>>m:graph.entrySet())
				{
					visited.put(m.getKey(),0);
				}
				findPaths(source);
				
			}
}
