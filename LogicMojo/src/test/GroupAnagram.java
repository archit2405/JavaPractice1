package test;
import java.util.*;
public class GroupAnagram {
	public static void groupAnagrams(String[]array)
	{
		HashMap<String,ArrayList<String>>map=new HashMap<String,ArrayList<String>>();
		for(int i=0;i<array.length;i++)
		{
			int[]ascii=new int[256];
			int j=0;
			while(j<array[i].length())
			{
				ascii[array[i].charAt(j)]++;
				j++;
			}
			String str=Arrays.toString(ascii);
			if(map.containsKey(str))
			{
				map.get(str).add(array[i]);
			}
			else
			{
				map.put(str,new ArrayList<String>());
				map.get(str).add(array[i]);
				
			}
			
		}
		for(Map.Entry<String,ArrayList<String>>entry:map.entrySet())
		{
			System.out.println(entry.getValue());
		}

	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of strings that is to be checked for anagrams");
		int n=sc.nextInt();
		String[]array=new String[n];
		for(int i=0;i<n;i++)
		{
			array[i]=sc.next();
		}
		groupAnagrams(array);
	}

}
