package Graph;
import java.util.*;
public class GraphImplementation {
	public static Scanner sc=new Scanner(System.in);
	
	public static boolean isStronglyConnected(HashMap<Integer,ArrayList<Integer>>map,int n)
	{
		for(HashMap.Entry<Integer,ArrayList<Integer>> m:map.entrySet())
		{
			boolean[]visited=new boolean[n];
			visited[m.getKey()]=true;
			depthFirstSearch(m.getKey(),visited,map);
			for(int i=0;i<n;i++)
			{
				if(visited[i]==false)
					return false;
			}
		}
		return true;
	}
	
	public static boolean isCyclePresent(int vertex,boolean[]visited,int parent,HashMap<Integer,ArrayList<Integer>>map)
	{
		visited[vertex]=true;
		ArrayList<Integer>list=map.get(vertex);
		for(int i=0;i<list.size();i++)
		{
			if(visited[list.get(i)]==false)
			{
				if(isCyclePresent(list.get(i),visited,vertex,map)==true)
					return true;
				else
					return false;
			}
			else if(visited[list.get(i)]==true)
			{
				if(list.get(i)!=parent)
					return true;
			}
		}
		return false;
	}
	public static void depthFirstSearch(int vertex,boolean[]visited,HashMap<Integer,ArrayList<Integer>>map)
	{
		visited[vertex]=true;
		System.out.println(vertex);
		ArrayList<Integer>list=map.get(vertex);
		for(int i=0;i<list.size();i++)
		{
			if(visited[list.get(i)]==false)
			{
				depthFirstSearch(list.get(i),visited,map);
			}
		}
	}
	
	public static void print(HashMap<Integer,ArrayList<Integer>>map)
	{
		for(HashMap.Entry m:map.entrySet())
		{
			ArrayList<Integer>list=map.get(m.getKey());
			System.out.print(m.getKey()+"->");
			for(int i=0;i<list.size();i++)
			{
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
		
	}
	public static void main(String args[])
	{
		/*HashMap<Integer,ArrayList<Integer>>map=new HashMap<Integer,ArrayList<Integer>>();
		System.out.println("Enter the number of vertex");
		int n=sc.nextInt();
		System.out.println("enter the vertexes");
		for(int i=0;i<n;i++)
		{
			map.put(sc.nextInt(),new ArrayList<>());
		}
		while(true)
		{
			System.out.println("1.update 2.exit");
			int option=sc.nextInt();
			if(option==1)
			{
				System.out.println("Enter the vertex of which adjacency list needs to be updated");
				int vertex=sc.nextInt();
				if(map.containsKey(vertex))
				{
				ArrayList<Integer>list=map.get(vertex);
				while(true)
				{
					System.out.println("1.update the vertex 2.No update required");
					int ok=sc.nextInt();
					if(ok==1)
					{
						System.out.println("Enter the vertex to be updated to the list of"+vertex);
						int node=sc.nextInt();
						System.out.println("Enter the type of edge");
						System.out.println("1.Undirected 2. directed");
						int type=sc.nextInt();
						if(map.containsKey(node))
						{
							if(type==2)
							{
								list.add(node);
								map.put(vertex,list);
							}
							if(type==1)
							{
								list.add(node);
								map.put(vertex,list);
								ArrayList<Integer>list2=map.get(node);
								list2.add(vertex);
								map.put(node, list2);
							}
						}
					}
					else
						break;
				}
				}
				else
					System.out.println("The key is not present in the graph");
			}
			if(option==2)
				break;
		}
		boolean[]visited=new boolean[n];
		for(int i=0;i<visited.length;i++)
		{
			visited[i]=false;
		}
		//depthFirstSearch(0,visited,map);
		for(int i=0;i<visited.length;i++)
		{
			visited[i]=false;
		}
		
		//System.out.println(isCyclePresent(0,visited,-1,map));
		
		//System.out.println(isStronglyConnected(map,n));*/
		
		
		
	}

}
