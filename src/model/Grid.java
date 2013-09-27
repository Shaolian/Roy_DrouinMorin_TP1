package model;

public class Grid {
	private int[][] gameGrid; 
	
	private static final int DEFAULT_ROW = 6;
	private static final int DEFAULT_COLUMN = 6;
	private static final int DEFAULT_NUMBER_TO_ALIGN = 6;
	private static final int PLAYER_1 = 1;
	private static final int PLAYER_2 = 2;
	private static final int EMPTY = 0;
	
	private int row;
	private int column;
	private int nbToAlign;
	
	public Grid(int _row, int _column, int _nbToAlign)
	{
		row = _row;
		column = _column;
		nbToAlign = _nbToAlign;
		
		gameGrid = new int[row][column];
	}
	
	public Grid ()
	{
		row = DEFAULT_ROW;
		column = DEFAULT_COLUMN;
		nbToAlign = DEFAULT_NUMBER_TO_ALIGN;
		
		gameGrid = new int[row][column];
	}
	
	public void placeToken(int _player, int _column)
	{
		for (int i = 0; i <= row; i ++)
		{
			if (i == row || gameGrid[i + 1][_column] != EMPTY)
			{
				gameGrid[i][_column] = _player;
			}
		}
	}
	
}
