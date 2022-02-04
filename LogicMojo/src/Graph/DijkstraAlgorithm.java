package Graph;//Not Completed
import java.util.*;
public class DijkstraAlgorithm {
	public static Scanner sc=new Scanner(System.in);
	
	public static class myclass
	{
		int vertex;
		int weight;
		public myclass(int vertex,int weight)
		{
			this.vertex=vertex;
			this.weight=weight;
		}
		
	}
	public static class myclass2
	{
		int prev;
		int dist;
		myclass2(int prev,int dist)
		{
			this.prev=prev;
			this.dist=dist;
		}
	}
	
	public static HashMap<Integer,myclass2> minDistanceFromSource(HashMap<Integer,ArrayList<myclass>>map,int source)
	{
		HashMap<Integer,myclass2>resultMap=new HashMap<Integer,myclass2>();
		for(Map.Entry<Integer,ArrayList<myclass>>m:map.entrySet())
		{
			resultMap.put(m.getKey(),new myclass2(0,Integer.MAX_VALUE));
		}
		Map<Integer,Integer>sortedMap=new TreeMap<Integer,Integer>();
		ArrayList<myclass>list=map.get(source);
		for(int i=0;i<list.size();i++)
		{
			myclass flag=list.get(i);
			resultMap.put(flag.vertex,new myclass2(source,flag.weight));
			//Here we are putting vertex and weight in reverse order to ge the tmap sorted according to weight as key.
			sortedMap.put(flag.weight,flag.vertex);
		}
		for(Map.Entry<Integer,Integer>m:sortedMap.entrySet())
		{
			int a,b;
			a=m.getKey();
			b=m.getValue();
			sortedMap.remove(a);
			ArrayList<myclass>list1=map.get(b);
			for(int j=0;j<list1.size();j++)
			{
				myclass flag1=list1.get(j);
				myclass2 flag2=resultMap.get(flag1.vertex);
				if(flag2.dist>(a+flag1.weight))
				{
					resultMap.put(flag1.vertex,new myclass2(b,a+flag1.weight));
					sortedMap.put(flag1.vertex,a+flag1.weight);
				}
			
			}
		}
		return resultMap;
		
	}
	public static void main(String args[])
	{
		HashMap<Integer,ArrayList<myclass>>map=new HashMap<Integer,ArrayList<myclass>>();
		System.out.println("Enter the number of vertex");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the vertex");
			int vertex=sc.nextInt();
			System.out.println("Enter the no of edges");
			int j=sc.nextInt();
			ArrayList<myclass>list=new ArrayList<myclass>();
			for(int k=0;k<j;k++)
			{
				System.out.println("Enter the connected vertex and weight of the edge");
				myclass flag=new myclass(sc.nextInt(),sc.nextInt());
				list.add(flag);
			}
			map.put(vertex, list);
		}
		System.out.println("Enter the source vertex");
		int source=sc.nextInt();
		HashMap<Integer,myclass2> result=minDistanceFromSource(map,source);
		for(Map.Entry<Integer,myclass2>m:result.entrySet())
		{
			System.out.print(m.getKey()+" "+" ");
			myclass2 flag=m.getValue();
			System.out.println(flag.prev+" ");
			System.out.println(flag.dist);
			System.out.println();
		}
	}
	
	
	
	
	
}