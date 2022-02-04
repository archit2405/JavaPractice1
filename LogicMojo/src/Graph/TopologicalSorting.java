package Graph;
import java.util.*;
public class TopologicalSorting {
	public static Scanner sc=new Scanner(System.in);
	
	
	public static HashMap<Integer,Integer> calculateIndegree(HashMap<Integer,ArrayList<Integer>>map1)
	{
		HashMap<Integer,Integer>map2=new HashMap<Integer,Integer>();
		for(Map.Entry<Integer,ArrayList<Integer>> m:map1.entrySet())
		{
			map2.put(m.getKey(),0);
		}
		for(Map.Entry<Integer,ArrayList<Integer>>m:map1.entrySet())
		{
			ArrayList<Integer>list=map1.get(m.getKey());
			for(int i=0;i<list.size();i++)
			{
				int flag1=list.get(i);
				int flag=map2.get(flag1);
				map2.put(list.get(i),flag+1);
			}
		}
		return map2;
	}
	public static void topologicalSort(HashMap<Integer,ArrayList<Integer>>map1)
	{
		int size=map1.size();
		for(int i=0;i<size;i++)
		{
		HashMap<Integer,Integer>map2=calculateIndegree(map1);
		int minimum=Integer.MAX_VALUE;
		int minKey=0;
				for(Map.Entry<Integer,Integer> m:map2.entrySet())
				{
			if(m.getValue()<minimum)
			{
				minimum=m.getValue();
				minKey=m.getKey();
			}
				}
				System.out.println(minKey);
				map1.remove(minKey);
		}
	}
	public static void main(String args[])
	{
		HashMap<Integer,ArrayList<Integer>>map=new HashMap<Integer,ArrayList<Integer>>();
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
		topologicalSort(map);
	}
	
}
