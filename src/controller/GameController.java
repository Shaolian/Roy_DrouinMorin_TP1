package controller;

import java.awt.EventQueue;

import model.Grid;
import view.GameView;

public class GameController {
	private GameView gameView;
	private Grid grid;

	public GameController() {
		grid = new Grid();
		startGameView();
	}

	private void startGameView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameView = new GameView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
