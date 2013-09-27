package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.GridLayout;

public class GameView {

	public JFrame frmConnect;

	/**
	 * Create the application.
	 */
	public GameView()  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnect = new JFrame();
		frmConnect.setTitle("Connect 4");
		frmConnect.setBounds(100, 100, 800, 600);
		frmConnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmConnect.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JPanel mainPanel = new JPanel();
		frmConnect.getContentPane().add(mainPanel, BorderLayout.SOUTH);
		
		JPanel gridContainer = new JPanel();
		mainPanel.add(gridContainer);
		gridContainer.setLayout(new GridLayout(7, 6, 0, 0));
		
		JPanel ButtonContainer = new JPanel();
		mainPanel.add(ButtonContainer);
		frmConnect.setVisible(true);
	}

	// TODO Procedural generation of game grid
	private JPanel populateGameGrid (int _rows, int _columns)
	{
		throw new UnsupportedOperationException();
		
	}
}
