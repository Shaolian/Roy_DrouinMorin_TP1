package controller;

import java.awt.EventQueue;

import model.Grid;
import view.GameView;

public class GameController {
	private GameView gameView;
	private Grid grid;
	private int x;
	private int y;

	public GameController() {
		grid = new Grid();
		x = 6;
		y = 6;
				
		startGameView();
	}

	private void startGameView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameView = new GameView(x, y);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
