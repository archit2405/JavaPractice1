package test;
import java.util.*;
public class CalculatePowerEfficiently {
	public static Scanner sc=new Scanner(System.in);
	public static int calculatePow(int n,int p)
	{
		if(p==1)
			return n;
		int temp=p/2;
		int result;
		if(p%2==0)
		{
			 result=calculatePow(n,temp)*calculatePow(n,temp);
		}
		else
		{
			 result=n*calculatePow(n,temp)*calculatePow(n,temp);
		}
		return result;
	}
	public static void main(String args[])
	{
		System.out.println("Enter the number whose power is to be calculated");
		int n=sc.nextInt();
		System.out.println("Enter the power");
		int p=sc.nextInt();
		System.out.println(calculatePow(n,p));
	}
}
