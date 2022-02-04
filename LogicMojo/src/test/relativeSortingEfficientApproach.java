//Best code I ever did
package test;
import java.util.*;
public class relativeSortingEfficientApproach {
	public static Scanner sc=new Scanner(System.in);
	
	public static void relativeSort(int[] array1,int[] array2,TreeMap<Integer,Integer>learn)
	{
		for(int i=0;i<array1.length;i++)
		{
			int item=array1[i];
			if(!learn.containsKey(item))
			{
				learn.put(item,1);
			}
			else
			{	int temp= learn.get(item);
				learn.put(item,temp+1);
			}
		}
		int k=0;
		for(int i=0;i<array2.length;i++)
		{
			if(learn.containsKey(array2[i]))
			{
			int count=learn.get(array2[i]);
			int j=0;
			while(j<count)
			{
				array1[k++]=array2[i];
				j++;
			}
			learn.remove(array2[i]);
			}
		}
		for(Map.Entry<Integer,Integer>iterator:learn.entrySet())
		{
			int temp=iterator.getValue();
			int j=0;
			while(j<temp)
			{
				array1[k++]=iterator.getKey();
				j++;
			}
		}
	}
	
	public static void main(String args[])
	{
		System.out.println("Enter the length of the array");
		int n=sc.nextInt();
		int[] array1=new int[n];
		System.out.println("Enteer the length of the relative array");
		int m=sc.nextInt();
		int[] array2=new int[m];
		TreeMap<Integer,Integer>learn=new TreeMap<Integer,Integer>();
		System.out.println("Enter the elements of the first array");
		for(int i=0;i<array1.length;i++)
		{
			array1[i]=sc.nextInt();
		}
		System.out.println("Enter the elements of second array");
		for(int i=0;i<array2.length;i++)
		{
			array2[i]=sc.nextInt();
		}
		relativeSort(array1,array2,learn);
		for(int i=0;i<array1.length;i++)
		{
			System.out.print(array1[i]+" ");
		}
	}
}
