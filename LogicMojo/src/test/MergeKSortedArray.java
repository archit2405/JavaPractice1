package test;
import java.util.*;
public class MergeKSortedArray {
	public static Scanner sc=new Scanner(System.in);
	public static int n=3;
	public static class heapNode
	{
		int x;
		int y;
		int value;
		private heapNode(int x,int y,int value)
		{
			this.x=x;
			this.y=y;
			this.value=value;
		}
	}
	public static void swap(heapNode[]array,int index1,int index2)
	{
		heapNode temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	//public static int  i1,j1;
	//public static int i2,j2;
	//public static int i3,j3;
	public static heapNode[] bucket=new heapNode[n];
	public static void mergeKsortedArrays(int[][]s,int m,int[]resultArray)
	{
		int  i1,j1;
		int i2,j2;
		int i3,j3;
		int k=0;
		i1=0;j1=0;
		i2=1;j2=0;
		i3=2;j3=0;
		bucket[0]=new heapNode(i1,j1,s[i1][j1]);
		bucket[1]=new heapNode(i2,j2,s[i2][j2]);
		bucket[2]=new heapNode(i3,j3,s[i3][j3]);
		while(bucket[0]!=null && bucket[1]!=null && bucket[2]!=null)
		{
		if(bucket[0].value>bucket[1].value||bucket[0].value>bucket[2].value)
		{
			if(bucket[1].value<bucket[2].value)
				swap(bucket,0,1);
			else
				swap(bucket,0,2);
		}
		swap(bucket,0,2);
		resultArray[k++]=bucket[2].value;
		bucket[2].y++;
		int check=bucket[2].y;
		if(check<m)
		{
		bucket[2]=new heapNode(bucket[2].x,bucket[2].y,s[bucket[2].x][bucket[2].y]);
		}
		else if(bucket[1].y<m-1)
		{
			bucket[1].y++;
			bucket[2]=new heapNode(bucket[1].x,bucket[1].y,s[bucket[1].x][bucket[1].y]);
		}
		else if(bucket[0].y<m-1)
		{
			bucket[0].y++;
			bucket[2]=new heapNode(bucket[0].x,bucket[0].y,s[bucket[0].x][bucket[0].y]);
		}
		else
			bucket[2].value=-111;
		if(bucket[2].value==-111)
		{//System.out.println(bucket[0].value+" ye"+ bucket[1].value);
			if(bucket[0].value<bucket[1].value)
			{
				resultArray[k++]=bucket[0].value;
				resultArray[k++]=bucket[1].value;
				bucket[0]=null;
				bucket[1]=null;
			}
			else
			{

				resultArray[k++]=bucket[1].value;
				resultArray[k++]=bucket[0].value;
				bucket[0]=null;
				bucket[1]=null;
			}
		}
	}
	}
	public static void main(String args[])
	{
		System.out.println("number of arrays is fixed at 3");
		//n=sc.nextInt();
		System.out.println("Enter the length of each array");
		int m;
		m=sc.nextInt();
		int[][] sortedArrays=new int[3][m];
		
		for(int i=0;i<3;i++)
		{
			System.out.println("Enter the " +(i+1)+"th "+"sorted array");
			for(int j=0;j<m;j++)
				sortedArrays[i][j]=sc.nextInt();
		}
		int[]resultArray=new int[3*m];
		mergeKsortedArrays(sortedArrays,m,resultArray);
		for(int i=0;i<resultArray.length;i++)
			System.out.println(resultArray[i]);
	}

}
