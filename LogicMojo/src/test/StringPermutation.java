package test;
import java.util.*;
public class StringPermutation {
	public static Scanner sc=new Scanner(System.in);
	public static void swap(char[] array,int index1,int index2)
	{
		char temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	public static void permuteString(char[] array,int start,int end)
	{
		if(start==end)
		{
			for(int i=0;i<array.length;i++)
			{
				System.out.print(array[i]);
			}
			System.out.println();
		}
		else
		{
			for(int index=start;index<=end;index++)
			{
				swap(array,index,start);
				permuteString(array,start+1,end);
				swap(array,index,start);
			}
		}
	}
	public static void main(String args[])
	{
		String str;
		System.out.println("enter the string to be permuted");
		str=sc.nextLine();
		char[] array=str.toCharArray();
		permuteString(array,0,array.length-1);
	}
}
