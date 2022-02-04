package test;
import java.util.*;
public class ReverseWordInString
{
	public static Scanner sc=new Scanner(System.in);
	
	public static void swap(char[]array,int index1,int index2)
	{
		char temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	
	public static void reverse(char[] array,int begin ,int end)
	{
		while(begin<end)
		{
			swap(array,begin,end);
			begin++;
			end--;
		}
	}
	
	public static void reverseWordInString(char[]array)
	{
		int i=0;
		while(i<array.length)
		{
			int begin=i;
			int end;
			int j=begin;
			while(array[j]!=' ')
			{
				j++;
			}
			end=j;
			reverse(array,begin,end);
			i=end+1;
		}
		reverse(array,0,array.length-1);
	}
	public static String toString(char[]array)
	{
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<array.length;i++)
		{
			sb.append(array[i]);
		}
		return sb.toString();
	}
	
	public static void main(String args[]) 
	{
	String str;
	System.out.println("Enter the string");
	str=sc.nextLine();
	char[] array=str.toCharArray();
	reverseWordInString(array);
	String result=toString(array);
	System.out.println(result);
	
}
}
