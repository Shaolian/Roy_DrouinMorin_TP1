package model;

import java.util.ArrayList;
import view.IWatcher;

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
	private ArrayList<IWatcher> watchers;
	private int currentPlayer;
	
	public Grid(int _column, int _row,  int _nbToAlign)
	{
		row = _row;
		column = _column;
		nbToAlign = _nbToAlign;
		watchers = new ArrayList<IWatcher>();
		currentPlayer = 1;
		
		gameGrid = new int[row][column];
	}
	
	public Grid ()
	{
		row = DEFAULT_ROW;
		column = DEFAULT_COLUMN;
		nbToAlign = DEFAULT_NUMBER_TO_ALIGN;
		
		gameGrid = new int[row][column];
	}
	
	public boolean placeToken(int _column)
	{
		if(checkIfValidColumn(_column) == true)
		{
			int win;
			for (int i = 0; i < row; i ++)
			{
				if (i == row - 1)
				{
					gameGrid[i][_column - 1] = currentPlayer;
					win = checkForAWinner();
					
					notifyOfGameChange(i, _column);
					
					if (win != 0)
					{
						System.out.println("Palyer " + win + " wins!");
						//notifyOfGameChange(i, _column);
						notifyOfGameEnd();
					}
					return true;
				}
				else if (gameGrid[i + 1][_column - 1] != EMPTY)
				{
					gameGrid[i][_column - 1] = currentPlayer;
					win = checkForAWinner();
					
					notifyOfGameChange(i, _column);
					
					if (win != 0)
					{
						System.out.println("Palyer " + win + " wins!");
						//notifyOfGameChange(i, _column);
						notifyOfGameEnd();
					}
					//toggleCurrentPlayer();
					return true;
				}
			}
			
		}
		return false;
	}
	
	public void addWatcher (IWatcher _watcher)
	{
		watchers.add(_watcher);
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
	
	private void toggleCurrentPlayer()
	{
		if (currentPlayer == 1)
		{
			currentPlayer = 2;
		}
		else
		{
			currentPlayer = 1;
		}
	}
	
	private int checkForAWinner()
	{
		int winner = 0;
		
		if (lookAtPlayer(PLAYER_1) != 0)
		{
			winner = PLAYER_1;
		}
		
		if (lookAtPlayer(PLAYER_2) != 0)
		{
			winner = PLAYER_2;
		}
		
		return winner;
	}
	
	private int lookAtPlayer(int _player)
	{
		for (int k = 0; k < column; k++)
		{
			for (int i = 0; i < row; i++)
			{
				if (gameGrid[i][k] == _player)
				{
					if (checkUp(i, k, _player) == true)
					{
						return _player;
					}
					else if (checkUpRight(i, k, _player) == true)
					{
						return _player;
					}
					else if (checkRight(i, k, _player) == true)
					{
						return _player;
					}
					else if (checkDownRight(i, k, _player) == true)
					{
						return _player;
					}
					
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
			else if (gameGrid[_row - nbAligned][_column] != _player)
			{
				keepGoing = false;
			}
			
			nbAligned = nbAligned + 1;
		}
		
		return keepGoing;
	}
	
	private boolean checkUpRight(int _row, int _column, int _player)
	{
		boolean keepGoing = true;
		int nbAligned = 0;

		while (keepGoing == true && nbAligned < nbToAlign)
		{
			if (_row - nbAligned < 0 || _column + nbAligned >= column)
			{
				keepGoing = false;
				
			}
			else if (gameGrid[_row - nbAligned][_column + nbAligned] != _player)
			{
				keepGoing = false;
			}
			
			nbAligned = nbAligned + 1;
		}
		
		return keepGoing;
	}
	
	private boolean checkRight(int _row, int _column, int _player)
	{
		boolean keepGoing = true;
		int nbAligned = 0;
		while (keepGoing == true && nbAligned < nbToAlign)
		{
			if (_column + nbAligned >= column)
			{
				keepGoing = false;
				
			}
			else if (gameGrid[_row][_column + nbAligned] != _player)
			{
				keepGoing = false;
			}
			
			nbAligned = nbAligned + 1;
		}
		
		return keepGoing;
	}
	
	private boolean checkDownRight(int _row, int _column, int _player)
	{
		boolean keepGoing = true;
		int nbAligned = 0;
		while (keepGoing == true && nbAligned < nbToAlign)
		{
			if (_row + nbAligned >= row || _column + nbAligned >= column)
			{
				keepGoing = false;
				
			}
			else if (gameGrid[_row + nbAligned][_column + nbAligned] != _player)
			{
				keepGoing = false;
			}
			
			nbAligned = nbAligned + 1;
		}
		
		return keepGoing;
	}
	
	private void notifyOfGameChange(int _row, int _column)
	{
		for (IWatcher w : watchers)
		{
			w.gridModelChanged(currentPlayer, _column - 1, _row);
			toggleCurrentPlayer();
		}
	}

	private void notifyOfGameEnd()
	{
		toggleCurrentPlayer();
		// TODO Auto-generated method stub
		for (IWatcher w : watchers)
		{
			w.gameEnd(currentPlayer);
		}
		
	}
	
}
