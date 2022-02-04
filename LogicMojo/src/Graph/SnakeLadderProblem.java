package Graph;//do it by using BFS(BFS is a logic. It is not only related to graph)
import java.util.*;
public class SnakeLadderProblem 
{
	public static Scanner sc=new Scanner(System.in);
	public static boolean[]visited=new boolean[30];
	
	public static class myclass
	{
		int position;
		int dicethrow;
		public myclass(int position,int dicethrow)
		{
			this.position=position;
			this.dicethrow=dicethrow;
		}
	}
	
	
	public static boolean isValid(int position)
	{
		if(position>=0 && position <=29)
		{
			return true;
		}
		else
			return false;
	}
	public static int calculateMinimumDiceThrow(int[]board,Queue<myclass>queue)
	{
		while(queue.isEmpty()!=true)
		{
			myclass flag=queue.remove();
			if(flag.position==29)
			{
				return flag.dicethrow;
			}
			if(isValid(flag.position+1)&&visited[flag.position+1]==false)
			{
				if(board[flag.position+1]!=-1)
				{
					int value=board[flag.position+1];
					queue.add(new myclass(value,flag.dicethrow+1));
					visited[value]=true;
				}
				else
				{
				queue.add(new myclass(flag.position+1,flag.dicethrow+1));
				visited[flag.position+1]=true;
				}
			}
			if(isValid(flag.position+2)&&visited[flag.position+2]==false)
			{
				if(board[flag.position+2]!=-1)
				{
					int value=board[flag.position+2];
					queue.add(new myclass(value,flag.dicethrow+1));
					visited[value]=true;
				}
				else
				{
				queue.add(new myclass(flag.position+2,flag.dicethrow+1));
				visited[flag.position+2]=true;
				}
			}
			if(isValid(flag.position+3)&&visited[flag.position+3]==false)
			{
				if(board[flag.position+3]!=-1)
				{
					int value=board[flag.position+3];
					queue.add(new myclass(value,flag.dicethrow+1));
					visited[value]=true;
				}
				else
				{
				queue.add(new myclass(flag.position+3,flag.dicethrow+1));
				visited[flag.position+3]=true;
				}
			}
			if(isValid(flag.position+4)&&visited[flag.position+4]==false)
			{
				if(board[flag.position+4]!=-1)
				{
					int value=board[flag.position+4];
					queue.add(new myclass(value,flag.dicethrow+1));
					visited[value]=true;
				}
				else
				{
				queue.add(new myclass(flag.position+4,flag.dicethrow+1));
				visited[flag.position+4]=true;
				}
			}
			if(isValid(flag.position+5)&& visited[flag.position+5]==false)
			{
				if(board[flag.position+5]!=-1)
				{
					int value=board[flag.position+5];
					queue.add(new myclass(value,flag.dicethrow+1));
					visited[value]=true;
				}
				else
				{
				queue.add(new myclass(flag.position+5,flag.dicethrow+1));
				visited[flag.position+5]=true;
				}
			}
			if(isValid(flag.position+6)&&visited[flag.position+6]==false)
			{
				if(board[flag.position+6]!=-1)
				{
					int value=board[flag.position+6];
					queue.add(new myclass(value,flag.dicethrow+1));
					visited[value]=true;
				}
				else
				{
				queue.add(new myclass(flag.position+6,flag.dicethrow+1));
				visited[flag.position+6]=true;
				}
			}
			
		}
		return 0;
	}
	
	public static void main(String args[])
	{
		int N = 30; 
        int board[] = new int[N]; 
        for (int i = 0; i < N; i++) 
            board[i] = -1; 
        //Ladders 
        board[2] = 21; 
        board[4] = 7; 
        board[10] = 25; 
        board[19] = 28; 
  
        //Snakes 
        board[26] = 0; 
        board[20] = 8; 
        board[16] = 3; 
        board[18] = 6; 
        
        myclass cell=new myclass(0,0);
        Queue<myclass>queue=new LinkedList<>();
        queue.add(cell);
        visited[0]=true;
        
        int result=calculateMinimumDiceThrow(board,queue);
        System.out.println(result);
	}
}
