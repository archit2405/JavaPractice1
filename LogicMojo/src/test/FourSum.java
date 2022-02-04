package test;
import java.util.*;
public class FourSum {
	public static Scanner sc=new Scanner(System.in);
	public static class point
	{
		int x;
		int y;
		point(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String args[])
	{
		int n;
		System.out.println("Enter the length of the array");
		n=sc.nextInt();
		int[] array=new int[n];
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
		}
		System.out.println("enter the sum ");
		int sum;
		sum=sc.nextInt();
		HashMap<Integer,ArrayList<point>>map=new HashMap<Integer,ArrayList<point>>();
		for(int i=0;i<array.length;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				int value=sum-(array[i]+array[j]);
				if(map.containsKey(value))
				{
					for(point m:map.get(value))
					{
						int x=m.x;
						int y=m.y;
						if(x!=i && y!=i && x!=j && y!=j)
						{
							System.out.println("The four values are"+" "+i+" "+j+" "+x+" "+y );
							System.exit(0);
						}
					}
				}
				map.put(array[i]+array[j],new ArrayList<point>());
				map.get(array[i]+array[j]).add(new point(i,j));
			}
		}
		
	}
	
	
	
}
