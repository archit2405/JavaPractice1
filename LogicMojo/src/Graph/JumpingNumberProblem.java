//Jumping number is the number with all the digits differing by only 1.Lovely implementation of BFS.
package Graph;
import java.util.*;
public class JumpingNumberProblem {
	public static Scanner sc=new Scanner(System.in);
	public static void printJumpingNumbers(int n)
	{
		Queue<Integer>queue=new LinkedList<>();
		//all the single digits numbers are considered as Jumping Numbers
		for(int i=1;i<=9;i++)
		{
			queue.add(i);
		}
		while(queue.isEmpty()==false)
		{
			int flag=queue.remove();
			System.out.println(flag);
			int lastdigit=flag%10;
			if(lastdigit!=0 && lastdigit!=9)
			{
			int input1=(flag*10)+(lastdigit+1);
			int input2=(flag*10)+(lastdigit-1);
			if(input1<n)
			{
				queue.add(input1);
			}
			if(input2<n)
			{
				queue.add(input2);
			}
			}
			else if(lastdigit==9)
			{
				int input2=(flag*10)+(lastdigit-1);
				if(input2<n)
				{
					queue.add(input2);
				}
			}
			else
			{
				int input1=(flag*10)+(lastdigit+1);
				if(input1<n)
				{
					queue.add(input1);
				}
			}
				
		}
	}
	public static void main(String[] args)
	{
		//print all the jumping numbers less than the given input
		int n;
		System.out.println("Enter the number");
		n=sc.nextInt();
		printJumpingNumbers(n);
		

	}

}
