package controller;

import java.awt.EventQueue;
import java.util.ArrayList;

import view.IWatcher;
import model.Grid;
import view.GameView;

public class GameController {
	private GameView gameView;
	private Grid grid;
	private int columns;
	private int rows;
	private int v;

	public GameController() {
		
		columns = 5;
		rows = 10;
		v = 4;
		
		//newGame();
		grid = new Grid(columns, rows, v);
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
		grid = new Grid(columns, rows, v);
		gameView.resetDisplayGrid(columns, rows);
	}
	
	// TODO Show about box
	public void showAbout()
	{
		
	}
}
