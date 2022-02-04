package test;
import java.util.*;
public class NumberToWord {
	public static Scanner sc=new Scanner(System.in);
	
		public static void numberToWord(int number,HashMap<Integer,String>map1,HashMap<Integer,String>map2,HashMap<Integer,String>map3)
		{
			int temp=number;
			int count=0;
			int[] remainder=new int[4];
			while(temp!=0)
			{
				temp=temp/10;
				count++;
			}
			int i=3;
			int trick=3-count;
			while(i>trick)
			{
				remainder[i]=number%10;
				number=number/10;
				i--;
			}
			if(remainder[0]!=0)
			{
			
				System.out.print(map1.get(remainder[0])+" "+"Thousand"+" ");
			}
			if(remainder[1]!=0)
			{
				System.out.print(map1.get(remainder[1])+" " +"Hundred"+" ");
			}
			if(remainder[2]!=0 && remainder[2]>1)
			{
				System.out.print(map2.get(remainder[2])+" ");
				if(remainder[3]!=0)
				{
					System.out.print(map1.get(remainder[3])+" ");
				}
			}
			if(remainder[2]==1)
			{
				int num=remainder[2]*10+remainder[3];
				System.out.print(map3.get(num));
			}
		}
		public static void main(String args[])
		{
			HashMap<Integer,String>map1=new HashMap<Integer,String>();
			HashMap<Integer,String>map2=new HashMap<Integer,String>();
			HashMap<Integer,String>map3=new HashMap<Integer,String>();
			
			map1.put(1,"one");
			map1.put(2,"two");
			map1.put(3,"three");
			map1.put(4,"four");
			map1.put(5,"five");
			map1.put(6,"six");
			map1.put(7,"seven");
			map1.put(8,"eight");
			map1.put(9,"nine");
			
			map2.put(2,"twenty");
			map2.put(3,"thirty");
			map2.put(4,"forty");
			map2.put(5,"fifty");
			map2.put(6,"sixty");
			map2.put(7,"seventy");
			map2.put(8,"eightty");
			map2.put(9,"ninety");
			
			map3.put(10, "ten");
			map3.put(11,"eleven");
			map3.put(12,"twelve");
			map3.put(13,"thirteen");
			map3.put(14,"fourteen");
			map3.put(15,"fifteen");
			map3.put(16,"sixteen");
			map3.put(17,"seventeen");
			map3.put(18,"eighteen");
			map3.put(19,"nineteen");
			
			System.out.println("Enter the number");
			int number=sc.nextInt();
			numberToWord(number,map1,map2,map3);
			
		}
	
}
