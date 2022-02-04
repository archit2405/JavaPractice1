package Graph;
import java.util.*;

import Graph.TrieDataStructure.trie;
public class LongestCommonPrefix {
	public static Scanner sc=new Scanner(System.in);
	
	
	public static class trie
	{
		boolean isEnd;
		HashMap<Character,trie>trieMap;
		public trie()
		{
			isEnd=false;
			trieMap=new HashMap<Character,trie>();
		}
	}
	public static int flag=0;
	public static trie root=new trie();
	
	public static void insertInTrie(trie node,String str,int index)
	{
		if(str.length()==index)
		{
			node.isEnd=true;
			return;
		}
		else
		{
			char c=str.charAt(index);
			if(flag==0)
			{
				flag=1;
				trie child=new trie();
				node.trieMap.put(c,child);
				node=node.trieMap.get(c);
				insertInTrie(node,str,index+1);
			}
			else
			{
				if	(node.trieMap.containsKey(c))
				{
					node=node.trieMap.get(c);
					insertInTrie(node,str,index+1);
				}
				else
				{
					trie child=new trie();
					node.trieMap.put(c,child);
					node=node.trieMap.get(c);
					insertInTrie(node,str,index+1);
				}
			}
		}
	}
	
	public static void  LongestCommonPrefix(trie node)
	{
		HashMap<Character,trie>map=node.trieMap;
		if(map.size()>1)
			return;
		else
		{
			for(Map.Entry<Character,trie>m:map.entrySet())
			{
				System.out.print(m.getKey());
				node=node.trieMap.get(m.getKey());
				LongestCommonPrefix(node);
			}
		}
	}
	public static void main(String args[])
	{
		int n;
		System.out.println("Enter the no of words");
		n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++)
		{
			insertInTrie(root,sc.nextLine(),0);
		}
		LongestCommonPrefix(root);
	}
}
