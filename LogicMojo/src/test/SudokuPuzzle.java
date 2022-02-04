package test;
import java.util.*;
public class SudokuPuzzle
{
	public static Scanner sc=new Scanner(System.in);
	public static int[][]row=new int[10][10];
	public static int[][]column=new int[10][10];
	public static int[][]cell=new int[10][10];
	public static int[][]sudoku={{9,8,6,3,0,0,2,4,1},
            {7,3,4,1,2,8,6,9,5},
            {1,2,5,4,9,6,7,3,8},
            {3,1,0,9,6,0,0,0,0},
            {4,0,0,0,8,5,3,0,0},
            {0,9,0,0,0,0,0,0,7},
            {8,0,0,5,0,0,0,0,0},
            {0,0,0,0,1,9,0,7,4},
            {0,4,0,0,0,0,9,5,0}};
	
	public static void buildRow()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				row[i][j]=0;
			}
		}
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(sudoku[i][j]!=0)
				{
				row[i][sudoku[i][j]]=1;
				}
				
					
			}
		}
		
	}
	public static void buildColumn()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				column[i][j]=0;
			}
		}
		for(int j=0;j<9;j++)
		{
			for(int i=0;i<9;i++)
			{
				if(sudoku[i][j]!=0)
				{
				column[j][sudoku[i][j]]=1;
				}
				
			}
		}
		
	}
	public static void buildCell()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				cell[i][j]=0;
			}
		}
		int count=0;
		int row1,row2,col1,col2;
		row1=0;
		row2=2;
		col1=0;
		col2=2;
		int counter=0;
		while(counter<=2)
		{
		int i=row1;
		//int j=col1;
		while(i<=row2)
		{
			int j=col1;
			while(j<=col2)
			{
				if(sudoku[i][j]!=0)
					
				{
					cell[count][sudoku[i][j]]=1;
				}
				
				j++;
			}
			i++;
		}
		col1+=3;
		col2+=3;
		count++;
		if(count==9)
			break;
		counter++;
		if(counter==3)
		{
			row1+=3;
			row2+=3;
			counter=0;
			col1=0;
			col2=2;
		}
			}
	}
	
	public static class box
	{
		int x;
		int y;
		public box(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	public static box findVacantCell()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(sudoku[i][j]==0)
				{
					box temp=new box(i,j);
					return temp;
				}
			}
		}
		return null;
	}
	public static boolean isValid(int[][]sudoku,int x,int y,int data)
	{
		if(row[x][data]==1)
			return false;
		if(column[y][data]==1)
			return false;
		int cellrow=0;
		if(x>=0 && x<=2)
		{
			if(y>=0 && y<=2)
				cellrow=0;
			if(y>=3 && y<=5)
				cellrow=1;
			if(y>=6 && y<=8)
				cellrow=2;
		}
		if(x>=3 && x<=5)
		{
			if(y>=0 && y<=2)
				cellrow=3;
			if(y>=3 && y<=5)
				cellrow=4;
			if(y>=6 && y<=8)
				cellrow=5;
		}
		if(x>=6 && x<=8)
		{
			if(y>=0 && y<=2)
				cellrow=6;
			if(y>=3 && y<=5)
				cellrow=7;
			if(y>=6 && y<=8)
				cellrow=8;
		}
		if(cell[cellrow][data]==1)
			return false;
		return true;
		
	}
	public static boolean solveSudoku()
	{
		box cell=findVacantCell();
		if(cell==null)
		{
			return true;
		}
		int x=cell.x;
		int y=cell.y;
		/*if(x==-1 || y==-1)
		{
			return true;
		}*/
		for(int i=1;i<=9;i++)
		{
			if(isValid(sudoku,x,y,i)==true)
			{
				sudoku[x][y]=i;
				buildRow();
				buildColumn();
				buildCell();
				if(solveSudoku()==true)
					return true;
				sudoku[x][y]=0;
				buildRow();
				buildColumn();
				buildCell();
			}
			
		}
		return false;
	}
	public static void main(String args[])
	{
		
		//int[][]sudoku=new int[9][9];
		/*sudoku[0][1]=7;
		sudoku[1][1]=6;
		sudoku[2][0]=2;
		sudoku[0][4]=2;
		sudoku[2][3]=8;
		sudoku[0][7]=4;
		sudoku[0][8]=6;
		sudoku[1][6]=8;
		sudoku[1][7]=9;
		sudoku[2][6]=7;
		sudoku[2][7]=1;
		sudoku[2][8]=5;
		sudoku[3][1]=8;
		sudoku[3][2]=4;
		sudoku[4][0]=7;
		sudoku[4][1]=1;
		sudoku[3][4]=9;
		sudoku[3][5]=7;
		sudoku[5][3]=1;
		sudoku[5][4]=3;
		sudoku[4][7]=5;
		sudoku[4][8]=9;
		sudoku[5][6]=4;
		sudoku[5][7]=8;
		sudoku[6][0]=6;
		sudoku[6][1]=9;
		sudoku[6][2]=7;
		sudoku[7][1]=5;
		sudoku[7][2]=8;
		sudoku[8][0]=4;
		sudoku[8][1]=3;
		sudoku[6][5]=2;
		sudoku[8][4]=8;
		sudoku[6][8]=8;
	    sudoku[7][7]=6;
		sudoku[8][7]=7;*/
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();System.out.println();
		buildRow();
		buildColumn();
		buildCell();
		boolean flag=solveSudoku();
		/*for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(row[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();System.out.println();
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(column[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();System.out.println();
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(cell[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();System.out.println();*/
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();System.out.println();
	}

}
