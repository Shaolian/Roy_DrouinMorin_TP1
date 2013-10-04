package controller;

import java.awt.EventQueue;

import model.Grid;
import view.GameView;

public class GameController {
	private GameView gameView;
	private Grid grid;
	private int columns;
	private int rows;
	private int v;

	public GameController(int _rows, int _columns, int _nbAlign) {
		
		columns = _columns;
		rows = _rows;
		v = _nbAlign;
		
		grid = new Grid(columns, rows, v);
		startGameView();
	}
	
	public GameController() {
		grid = new Grid();
		columns = Grid.DEFAULT_COLUMN;
		rows = Grid.DEFAULT_ROW;
		v = Grid.DEFAULT_NUMBER_TO_ALIGN;
		
		
		startGameView();
	}
	
	private GameController getController()
	{
		return this;
	}
	
	private void startGameView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameView = new GameView(columns, rows);
					gameView.setGameController(getController());
					grid.addWatcher(gameView);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void placeToken(int _column)
	{
		grid.placeToken( _column + 1);
	}
	
	// TODO Win game reset
	public void newGame()
	{
		grid.reset();
		gameView.resetDisplayGrid(columns, rows);
	}
	
	// TODO Show about box
	public void giveUp()
	{
		grid.notifyOfGameEnd();
	}
}
