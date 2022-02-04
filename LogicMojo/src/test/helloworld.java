package test;
import java.util.*;
public class helloworld
{
	public static class nodelevel
	{
		int data;
		int level;
		nodelevel(int data,int level)
		{
			this.data=data;
			this.level=level;
		}
	}
	public static void main(String args[])
	{
		HashMap<Integer,nodelevel>map=new HashMap<Integer,nodelevel>();
		nodelevel obj=new nodelevel(1,0);
		nodelevel obj1=new nodelevel(2,1);
		nodelevel obj2=new nodelevel(3,2);
		map.put(1, obj);
		map.put(2, obj1);
		map.put(3,obj2);
		map.get(3).level=10;
		for(Map.Entry<Integer,nodelevel>entry:map.entrySet())
{
			 System.out.println("Key = " + entry.getKey() +
                     ", Value = " + entry.getValue().level);
}
		
		
		
		
		
		
	}
}