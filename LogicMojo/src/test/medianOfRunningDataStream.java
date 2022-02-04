//Not completed yet because of problem in heapify operations
package test;
import java.util.*;
public class medianOfRunningDataStream {
	public static Scanner sc=new Scanner(System.in);
	public static int countMinheap=-1;
	public static int countMaxheap=-1;
	public static void swap(int[]array,int index1,int index2)
	{
		int temp;
		temp=array[index2];
		array[index2]=array[index1];
		array[index1]=temp;
	}
	public static void maxHeapify(int[]maxHeap,int index)
	{
		int length=maxHeap.length-1;
		if(index<length/2)
		{
			if(maxHeap[index]<maxHeap[(2*index)+1] || maxHeap[index]<maxHeap[(2*index)+2])
			{
				int i;
				if(maxHeap[(2*index)+1]>maxHeap[(2*index)+2])
					i=maxHeap[(2*index)+1];
				else
					i=maxHeap[(2*index)+2];
				swap(maxHeap,index,i);
				index++;
				maxHeapify(maxHeap,index);
			}
		}
	}
	public static void minHeapify(int[]minHeap,int index)
	{
		int length=minHeap.length-1;
		if(index<length/2)
		{
			if(minHeap[index]>minHeap[(2*index)+1] || minHeap[index]>minHeap[(2*index)+2])
			{
				int i;
				if(minHeap[(2*index)+1]<minHeap[(2*index)+2])
					i=minHeap[(2*index)+1];
				else
					i=minHeap[(2*index)+2];
				swap(minHeap,index,i);
				index++;
				maxHeapify(minHeap,index);
			}
		}
	}
	public static int removeRootMinHeap(int[]minHeap)
	{
		swap(minHeap,countMinheap,0);
		int temp=minHeap[countMinheap--];
		minHeapify(minHeap,0);
		return temp;
	}
	public static int removeRootMaxHeap(int[]maxHeap)
	{
		swap(maxHeap,countMaxheap,0);
		int temp=maxHeap[countMaxheap--];
		maxHeapify(maxHeap,0);
		return temp;
	}
	
	public static void insert(int[]minHeap,int[]maxHeap)
	{
		int item;
		System.out.println("Enter the element");
		item=sc.nextInt();
		if(countMinheap==-1 && countMaxheap==-1)
		{
			System.out.println("As the heaps are empty enter second element too");
			int item2=sc.nextInt();
			if(item>item2)
			{
				countMinheap++;
				minHeap[countMinheap]=item;
				countMaxheap++;
				maxHeap[countMaxheap]=item2;
			}
			else
			{
				countMaxheap++;
				maxHeap[countMaxheap]=item;
				
				countMinheap++;
				minHeap[countMinheap]=item2;
				
			}
			
		}
		else
		{
			if(item>maxHeap[0])
			{
				minHeap[++countMinheap]=item;
				minHeapify(minHeap,0);
			}
			
			else
			{
				maxHeap[++countMaxheap]=item;
				maxHeapify(maxHeap,0);
			}
		}
		if(Math.abs(countMaxheap-countMinheap)>1)
		{
			if(countMaxheap>countMinheap)
			{
				int temp=removeRootMaxHeap(maxHeap);
				minHeap[++countMinheap]=temp;
				minHeapify(minHeap,0);
			}
			else
			{
				int temp=removeRootMinHeap(minHeap);
				maxHeap[++countMaxheap]=temp;
				maxHeapify(maxHeap,0);
			}
		}
			
	}
	public static void getMedian(int[]minHeap,int[]maxHeap)
	{
		if(countMaxheap==countMinheap)
		{
			int result=(minHeap[0]+maxHeap[0])/2;
			System.out.println(result);
		}
		else
		{
			int result;
			if(countMinheap>countMaxheap)
				result=minHeap[0];
			else
				result=maxHeap[0];
			System.out.println(result);
		}
	}
	public static void main(String args[])
	{
		System.out.println("Enter the size of the data stream");
		int n=sc.nextInt();
		int[]minHeap=new int[n];
		int[]maxHeap=new int[n];
		while(true)
		{
			System.out.println("1.To insert 2.To get median 3. To exit");
			int i=sc.nextInt();
			if(i==1)
				insert(minHeap,maxHeap);
			if(i==2)
				getMedian(minHeap,maxHeap);
			if(i==3)
				System.exit(0);
		}
	}

}
