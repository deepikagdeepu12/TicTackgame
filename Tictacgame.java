package Javatictacgame;

import java.util.Random;
import java.util.Scanner;

class Tictac{
	
	static char[][] board;
	
	
	public Tictac()
	{
	   board= new char[3][3];
	   iniboard();
	}
	
	void iniboard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j] =' ';
			}
		}
	}
	static void disp()
	{
		System.out.println("------------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j] + " | ");
  
			}
			System.out.println();
			System.out.println("------------------");
		}
		
	}
	
	static void placemark(int row,int colum,char mark)
	{
		if(row>=0 && row<=2 && colum>=0 && colum<=2)
		{
			board[row][colum]=mark;
		}
		else
		{
			System.out.println("invalid positions");
		}
	}

static boolean checkclomwin()
{
	for(int j=0;j<=2;j++)
	{
		if(board[0][j]!=' '&&board[0][j]==board[1][j] && board[1][j]==board[2][j])
		{
			return true;
		}
	}
	return false;
}

static boolean checkrowwin(){
	for(int i=0;i<=2;i++)
	{
		if(board[i][0]!=' ' && board[i][0]==board[i][1]&& board[i][1]== board[i][2])
		{
			return true;
		}
	}
	return false; 
}

static boolean checkDiagnal()

{
	if(board[0][0] !=' ' && board[0][0]==board[1][1]&& board[1][1]== board[2][2]
			|| board[0][2]!=' ' && board[0][2]==board[1][1]&& board[1][1]== board[2][0] )
	{
		return true;
	}

return false; 
	
}

static boolean checkDraw()
{
	for(int i=0;i<=2;i++)
	{
		for(int j=0;j<=2;j++)
		{
			if(board[i][j] == ' ')
			{
				return  false;
			}
		}
	}
	return true;
}


}


abstract class Player
{
	String name;
	char mark;
abstract void makemove();

boolean isValid(int row,int col)
{
	
	if(row>=0 && row<=2 && col>=0 && col<=2)
	{
		if(Tictac.board[row][col]!= ' ')
		{
			return true;
		}
	}
	return false;
}
	
}
class Human extends Player
{
	

Human(String name,char mark)
{
	this.name=name;
	this.mark=mark;
}

 void makemove()
{
	Scanner scan=new Scanner(System.in);
	int row;
	int col;
	do 
	{
	System.out.println("Enter the row and colum ");
	 row=scan.nextInt();
	 col=scan.nextInt();
	}while(isValid(row,col));
	
	Tictac.placemark(row, col, mark);
	
	
	
	
}


}




class AIPlayer extends Player
{
	


AIPlayer(String name,char mark)
{
	this.name=name;
	this.mark=mark;
}

 void makemove()
{
	Scanner scan=new Scanner(System.in);
	int row;
	int col;
	do 
	{

      Random r  = new Random();
      row = r.nextInt(3);
      col=r.nextInt(3);
	}while(isValid(row,col));
	
	Tictac.placemark(row, col, mark);
	
	
	
	
}


}

public class Tictacgame {
	
	public static void main(String[] args) {
		
		Tictac t=new Tictac();
		
		Human p1=new Human("bob" ,'X');
		AIPlayer p2= new AIPlayer("deepu",'O');
		
		Player cp;
		cp = p1;
		
	
	while(true)
	{
	
	System.out.println(cp.name + "turn");
	cp.makemove();
	Tictac.disp();
	
	if(Tictac.checkclomwin() || Tictac.checkDiagnal()
			|| Tictac.checkrowwin())
	{
		System.out.println(cp.name + " has won");
		break;
	}
	else if(Tictac.checkDraw())
	{
		System.out.println("Game is Draw");
		break;
	}
	else
	{
		if(cp == p1)
		{
			cp = p2;
		}
		else
		{
			cp = p1;
		}
	}
	}
	
	
	}

}









