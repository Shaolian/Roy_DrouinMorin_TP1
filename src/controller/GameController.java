package controller;

import java.awt.EventQueue;

import view.Frame;
import model.Grid;

public class GameController {
	private Frame frame;
	private Grid grid;
	
	public void GameController()
	{
		//frame = new Frame();
		grid = new Grid();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
