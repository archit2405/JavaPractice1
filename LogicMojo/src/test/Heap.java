////Not completed yet because of problem in heapify operations
package test;
import java.util.*;
public class Heap {
	public static Scanner sc=new Scanner(System.in);
	public static  void heapSort(int[]arr)
	{
		int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
	}
	}
        public static void heapify(int arr[], int n, int i)
        {
        	int largest = i; // Initialize largest as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (l < n && arr[l] > arr[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r] > arr[largest])
                largest = r;

            // If largest is not root
            if (largest != i) {
            	int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(arr, n, largest);
            }
        }
        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
	public static void swap(int[]array,int index1,int index2)
	{
		int temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	public static void maxHeapify(int[]array,int index)
	{
		int i=index;
		while(true)
		{
			if(array[i]>array[(i-1)/2])
			{
				swap(array,i,(i-1)/2);
				i=(i-1)/2;
			}
			else
				break;
		}
	}
	public static void minHeapify(int[]array,int index)
	{
		int i=index;
		while(true)
		{
			if(array[i]<array[(i-1)/2])
			{
				swap(array,i,(i-1)/2);
				i=(i-1)/2;
			}
			else
				break;
		}
	}
	public static void insertMaxHeap(int[]array)
	{
		System.out.println("enter the element to inserted");
		int element=sc.nextInt();
		int count=0;
		while(array[count]!=0)
		{
			count++;
		}
		if(count==0)
			array[count]=element;
		else if(element<array[(count-1)/2])
			array[count]=element;
		else
		{
			array[count]=element;
			maxHeapify(array,count);
		}
	}
	public static void insertMinHeap(int[]array)
	{
		System.out.println("enter the element to inserted");
		int element=sc.nextInt();
		int count=0;
		while(array[count]!=0)
		{
			count++;
		}
		if(count==0)
			array[count]=element;
		else if(element>array[(count-1)/2])
			array[count]=element;
		else
		{
			array[count]=element;
			minHeapify(array,count);
		}
	}
	public static void main(String args[])
	{
		int[]array1=new int[20];
		int[]array2=new int[20];
		System.out.println("1:min heap,2:max heap,3.exit");
		int type=sc.nextInt();
		while(true)
		{
		
		if(type==3)
			break;
		System.out.println("1:Insert,2.end");
		int operation=sc.nextInt();
		if(operation==2)
			break;
		if(type==1&&operation==1)
		{
			insertMinHeap(array1);
		}
		if(type==2&&operation==1)
		{
			insertMaxHeap(array2);
		}
		}
		for(int i=0;array1[i]!=0;i++)
		{
			System.out.print(array1[i]+" ");
		}
		for(int i=0;array2[i]!=0;i++)
		{
			System.out.print(array2[i]+" ");
		}
		System.out.println();
		System.out.println("do you want to sort the heap");
		String str=sc.next();
		if(str.equals("yes"))
		{
			int length=0;
			int i=0;
			while(array1[i]!=0)
			{
				length++;
				i++;
			}
			int[]array3=new int[length];
			for(int j=0;j<length;j++)
			{
				array3[j]=array1[j];
			}
			heapSort(array3);
			printArray(array3);
	}
	}
	
}
