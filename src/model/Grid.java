package model;

public class Grid {
	public int[][] gameGrid; 
	
	private static final int DEFAULT_ROW = 6;
	private static final int DEFAULT_COLUMN = 7;
	private static final int DEFAULT_NUMBER_TO_ALIGN = 4;
	private static final int PLAYER_1 = 1;
	private static final int PLAYER_2 = 2;
	private static final int EMPTY = 0;
	private static final int NOBODY = 0;
	
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
	
	public boolean placeToken(int _player, int _column)
	{
		if(checkIfValidColumn(_column) == true)
		{
			for (int i = 0; i < row; i ++)
			{
				if (i == row - 1)
				{
					gameGrid[i][_column - 1] = _player;
					return true;
				}
				else if (gameGrid[i + 1][_column - 1] != EMPTY)
				{
					gameGrid[i][_column - 1] = _player;
					return true;
				}
			}
			
		}
		return false;
	}
	
	private boolean checkIfValidColumn(int _column)
	{
		boolean valid = true;
		
		if (_column > column)
		{
			valid = false;
		}
		else if (gameGrid[0][_column - 1] != EMPTY)
		{
			valid = false;
		}
		
		return valid;
				
	}
	
	private int checkForAWinner()
	{
		int winner = 0;
		
		lookAtPlayer(PLAYER_1);
		lookAtPlayer(PLAYER_2);
		
		return winner;
	}
	
	private int lookAtPlayer(int _player)
	{
		for (int k = 0; k < 6; k++)
		{
			for (int i = 0; i < 7; i++)
			{
				if (gameGrid[k][i] == _player)
				{
					
				}
			}
		}
		
		return 0;
	}
	
	private boolean checkUp(int _row, int _column, int _player)
	{
		boolean keepGoing = true;
		int nbAligned = 0;
		
		while (keepGoing == true && nbAligned < nbToAlign)
		{
			if (_row - nbAligned < 0)
			{
				keepGoing = false;
			}
		}
		
		return keepGoing;
	}
	
}
