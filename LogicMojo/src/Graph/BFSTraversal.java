package Graph;
import java.util.*;
public class BFSTraversal {
	public static Scanner sc=new Scanner(System.in);
	public static HashMap<Integer,ArrayList<Integer>>graph=new HashMap<Integer,ArrayList<Integer>>();
	public static HashMap<Integer,Integer>isVisited=new HashMap<Integer,Integer>();
	
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
			graph.put(b,list);
		}
	}
	
	public static void BFSTraversal(int source)
	{
		Queue<Integer>queue=new LinkedList<Integer>();
		queue.add(source);
		isVisited.put(source,1);
		while(queue.isEmpty()==false)
		{
			int flag=queue.remove();
			ArrayList<Integer>list=graph.get(flag);
			for(int i=0;i<list.size();i++)
			{
				if(isVisited.get(list.get(i))==0)
				{
					queue.add(list.get(i));
					isVisited.put(list.get(i),1);
				}
			}
			
			
			System.out.println(flag);
		}
		
	}
	
		public static void main(String args[])
		{
			int n;
			System.out.println("Enter the number of edges");
			n=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				System.out.println("enter the edge");
				addEdge(sc.nextInt(),sc.nextInt());
			}
			for(Map.Entry<Integer,ArrayList<Integer>>m:graph.entrySet())
			{
				isVisited.put(m.getKey(),0);
			}
			System.out.println("Enter the source vertex");
			int source=sc.nextInt();
			BFSTraversal(source);
			System.out.println(graph);
		}
}
