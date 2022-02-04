package Graph;
import java.util.*;
public class AlienDictionary {
	public static Scanner sc=new Scanner(System.in);
	
	public static HashMap<Character,ArrayList<Character>>graph=new HashMap<Character,ArrayList<Character>>();
	public static HashMap<Character,Integer>iomap=new HashMap<Character,Integer>();
	
	public static void generateInorderTrackingmap()
	{
		
		for(Map.Entry<Character,ArrayList<Character>>m:graph.entrySet())
		{
			ArrayList<Character>list=graph.get(m.getKey());
			for(int i=0;i<list.size();i++)
			{
				if(iomap.containsKey(list.get(i)))
				{
					int flag=iomap.get(list.get(i));
					flag++;
					iomap.put(list.get(i),flag);
				}
				else
					iomap.put(list.get(i),1);
			}
		}
	}
	
	public static void topologicalSorting()
	{
		while(iomap.isEmpty()==false)
		{
		int min=Integer.MAX_VALUE;
		char minKey='a';
		for(Map.Entry<Character,Integer>m:iomap.entrySet())
		{
			if(m.getValue()<min)
			{
				min=m.getValue();
				minKey=m.getKey();
			}
		}
		System.out.println(minKey);
		iomap.remove(minKey);
		if(graph.containsKey(minKey))
		{
		ArrayList<Character>list=graph.get(minKey);
		for(int i=0;i<list.size();i++)
		{
			char flag1=list.get(i);
			int flag2=iomap.get(flag1);
			flag2--;
			iomap.put(flag1,flag2);
		}
		}
		}
		
	}
	
	public static void addEdge(char c,char d)
	{
		if(graph.get(c)==null)
		{
			ArrayList<Character>list=new ArrayList<Character>();
			list.add(d);
			graph.put(c,list);
		}
		else
		{
			ArrayList<Character>list=graph.get(c);
			list.add(d);
			graph.put(c, list);
		}
	}
	
	public static void findAlphabeticalOrder(String[] str)
	{
		
		for(int i=0;i<str.length-1;i++)
		{
			String word1,word2;
			word1=str[i];
			word2=str[i+1];
			for(int j=0;j<Math.min(word1.length(),word2.length());j++)
			{
				if(word1.charAt(j)!=word2.charAt(j))
				{
					addEdge(word1.charAt(j),word2.charAt(j));
					break;
				}
			}
		}
	}
	public static void main(String args[])
	{
		int n;
		System.out.println("Enter the number of words");
		n=sc.nextInt();
		String[] str=new String[n+1];
		for(int i=0;i<=n;i++)
		{
			str[i]=sc.nextLine();
		}
		findAlphabeticalOrder(str);
		/*for(Map.Entry<Character,ArrayList<Character>>m:graph.entrySet())
		{
			System.out.print(m.getKey()+"  ");
			ArrayList<Character>list=graph.get(m.getKey());
			for(int i=0;i<list.size();i++)
			{
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}*/
		for(Map.Entry<Character,ArrayList<Character>>m:graph.entrySet())
		{
			iomap.put(m.getKey(),0);
		}
		generateInorderTrackingmap();
		topologicalSorting();
	}

}
