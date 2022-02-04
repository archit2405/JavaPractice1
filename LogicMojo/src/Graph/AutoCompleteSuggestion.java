package Graph;
import java.util.*;
public class AutoCompleteSuggestion {
public static Scanner sc=new Scanner(System.in);
	
	public static class trie
	{
		boolean isEnd;
		HashMap<Character,trie>triemap;
		public trie()
		{
			isEnd=false;
			triemap=new HashMap<Character,trie>();
		}
	}
	
	public static int flag=0;
	
	
	public static trie root=new trie();
	
	public static void insertTrie(trie mytrie,String str,int index)
	{
		if(index==str.length())
		{
			mytrie.isEnd=true;
			return;
		}
			
		
		char c=str.charAt(index);
		if(flag==0)
		{
			flag=1;
			trie child=new trie();
			mytrie.triemap.put(c,child);
			mytrie=mytrie.triemap.get(c);
			insertTrie(mytrie,str,index+1);
		}
		else
		{
			if(mytrie.triemap.containsKey(c))
			{
				mytrie=mytrie.triemap.get(c);
				insertTrie(mytrie,str,index+1);
			}
			else
			{
				trie child=new trie();
				mytrie.triemap.put(c, child);
				mytrie=mytrie.triemap.get(c);
				insertTrie(mytrie,str,index+1);
			}
		}
	}
	public static trie findNode(trie node,String prefix,int index)
	{
		if(index==prefix.length())
		{
			return node;
		}
		node=node.triemap.get(prefix.charAt(index));
		trie node1=findNode(node,prefix,index+1);
		return node1;
		
		
	}
	
	public static void printTrie(trie node,String prefix)
	{
		if(node.isEnd==false)
		{
			Set<Character> str=node.triemap.keySet();
			for(char ch : str)
			{
				//System.out.print(prefix);
				System.out.print(ch);
				printTrie(node.triemap.get(ch),prefix);
				
			}
		}
		else
		{
			System.out.println();
			System.out.print(prefix);
			return;
		}
	}
	
	
	public static void main(String[] args) 
	{
		int n;
		System.out.println("Enter the number of strings that is to be put in trie");
		n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the "+i+"th string");
			String flag=sc.nextLine();
			insertTrie(root,flag,0);
		}
		//Taking input for the prefix for generating suggestion
		System.out.println("Enter the prefix");
		String prefix=sc.nextLine();
		trie node=findNode(root,prefix,0);
		System.out.print(prefix);
		printTrie(node,prefix);
	}
	
}
