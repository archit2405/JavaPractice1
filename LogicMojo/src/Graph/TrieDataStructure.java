package Graph;
import java.util.*;
public class TrieDataStructure {
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
	public static void main(String args[])
	{
		int n;
		System.out.println("Enter the number of strings");
		n=sc.nextInt();
		for(int i=0;i<n+1;i++)
		{
			String str=sc.nextLine();
			insertInTrie(root,str,0);
		}
		
	}

}
