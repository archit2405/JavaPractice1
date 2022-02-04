//Not completed
//Problem in assigning value in binary search maintaining the sorted array
package test;
import java.util.*;
public class relativeSortingNaiveApproach {
	
	public static Scanner sc=new Scanner(System.in);
	
	public static class Node
	{
		int value;
		boolean checked;
		public  Node(int value)
		{
			this.value=value;
			this.checked=false;
		}
	}
	
	public static int binarySearchCustomized(Node[]array,int low,int high,int key)
	{
	
		int result=-1;
		if(low<=high)
		{
			int mid=(low+high)/2;
			if(array[mid].value==key && array[mid].checked==false)
			{
				array[mid].checked=true;
				return mid;
			}
			else if(key>=array[mid].value)
			{
				 result=binarySearchCustomized(array,mid+1,high,key);
			}
			else
			{
				result=binarySearchCustomized(array,low,mid-1,key);
			}
				
		}
		return result;
	}
	
	public static int[] merge(int[]extra,int low,int mid,int high)
	{
		int[]buffer=new int[high-low+1];
		int  i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=high)
		{
			if(extra[i]<=extra[j])
				buffer[k++]=extra[i++];
			else
				buffer[k++]=extra[j++];	
		}
		if(i>mid)
		{
			while(j<=high)
			{
			buffer[k++]=extra[j++];
			}
		}
		if(j>high)
		{
			while(i<=mid) 
			{
				buffer[k++]=extra[i++];
			}
				
		}
		k=0;
		int index=low;
		while(index<=high)
		{
			extra[index++]=buffer[k++];
		}
		return extra;
		
	}
	
	public static void mergeSort(int[]extra,int low,int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			mergeSort(extra,low,mid);
			mergeSort(extra,mid+1,high);
			extra=merge(extra,low,mid,high);
		}
	}
	
	public static void main(String args[])
	{
		System.out.println("Enter the length of the first array");
		int n=sc.nextInt();
		int[] array1=new int[n];
		System.out.println("Enter the length of the second array");
		int m=sc.nextInt();
		int[] array2=new int[m];
		System.out.println("Enter the elements of the first array");
		for(int i=0;i<n;i++)
			array1[i]=sc.nextInt();
		System.out.println("Enter the elements of the second array");
		for(int i=0;i<m;i++)
		{
			array2[i]=sc.nextInt();
		}
		int[] extra=new int[n];
		for(int i=0;i<n;i++)
			extra[i]=array1[i];
		mergeSort(extra,0,extra.length-1);
		Node[] extra2=new Node[n];
		for(int i=0;i<n;i++)
			extra2[i]=new Node(extra[i]);
		
		int k=0;
		for(int i=0;i<array2.length;i++)
		{
			int key=array2[i];
			int index=0;
			while(true)
			{
			index=binarySearchCustomized(extra2,0,extra2.length-1,key);
			if(index==-1)
				break;
			array1[k++]=extra2[index].value;
			
			}
		}		
		for(int i=0;i<extra2.length;i++)
		{
			if(extra2[i].checked==false)
			{
				array1[k++]=extra2[i].value;
			}
		}
		for(int i=0;i<array1.length;i++)
		{
			System.out.print(array1[i]+" ");
		}
		
	}
}
