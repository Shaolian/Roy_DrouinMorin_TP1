package main;

import java.util.EnumMap;

import controller.GameController;
import model.Grid;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		if (args.length == 3)
		{
			GameController controller = new GameController(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2])); 
		}
		else
		{
			GameController controller = new GameController(6,7,4);
		}
	}
	
	private static void printGrid(Grid g)
	{
		for (int k = 0; k < 6; k++)
		{
			for (int i = 0; i < 7; i++)
			{
				System.out.print(g.gameGrid[k][i]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
	}
	/**
	@Deprecated
	private static void gridTest()
	{
		Grid g = new Grid();
		printGrid(g);
		
		makeMove(1, 4, g);
		makeMove(1, 4, g);
		makeMove(1, 4, g);
		makeMove(1, 3, g);
		makeMove(1, 3, g);
		makeMove(1, 2, g);
		makeMove(2, 1, g);
		makeMove(2, 2, g);
		makeMove(2, 3, g);
		makeMove(2, 4, g);
		
		
		
		
	}
	
	private static void makeMove(int _player, int _column, Grid _g)
	{
		if(_g.placeToken(_player, _column))
		{
			printGrid(_g);
		}
		else
		{
			System.out.println("invalid move");
		}
	}
	*/
}
