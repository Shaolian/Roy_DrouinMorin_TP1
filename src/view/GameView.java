package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.GameController;

public class GameView implements IWatcher
{
	
	private JFrame frmConnect;
	private DisplayGrid displayGrid;
	private GameController controller;
	
	private ActionListener buttonListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent arg0)
		{
			gridButtonPressed(arg0.getActionCommand());
		}
	};
	private JLabel lblPlayerindicator;
	
	/**
	 * Create the application.
	 */
	public GameView(int _columns, int _rows)
	{
		
		displayGrid = new DisplayGrid(_columns, _rows, buttonListener);
		initialize();
	}
	
	public void setGameController(GameController _controller)
	{
		controller = _controller;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmConnect = new JFrame();
		frmConnect.setTitle("Connect 4");
		frmConnect.setBounds(100, 100, 800, 600);
		frmConnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmConnect.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmGiveUp = new JMenuItem("Give Up");
		mntmGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.giveUp();
			}
		});
		mnGame.add(mntmGiveUp);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frmConnect, "Made by : \n François Drouin Morin \n      & \n Jonathan Roy");
			}
		});
		mnAbout.add(mntmAbout);
		
		JPanel mainPanel = new JPanel();
		frmConnect.getContentPane().add(mainPanel, BorderLayout.CENTER);
		SpringLayout sl_mainPanel = new SpringLayout();
		sl_mainPanel.putConstraint(SpringLayout.NORTH, displayGrid, 45, SpringLayout.NORTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.WEST, displayGrid, 10, SpringLayout.WEST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, displayGrid, -10, SpringLayout.SOUTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, displayGrid, -10, SpringLayout.EAST, mainPanel);
		mainPanel.setLayout(sl_mainPanel);
		
		JPanel panel = new JPanel();
		sl_mainPanel.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, displayGrid);
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, displayGrid);
		sl_mainPanel.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, displayGrid);
		mainPanel.add(panel);
		
		lblPlayerindicator = new JLabel("playerIndicator");
		panel.add(lblPlayerindicator);
		mainPanel.add(displayGrid);
		lblPlayerindicator.setText("Player 1 (blue) starts.");
		
		frmConnect.setVisible(true);
	}
	
	private void gridButtonPressed(String _actionCommand)
	{
		//Appeler controlleur
		controller.placeToken(Integer.parseInt(_actionCommand));
	}
	
	public void gridModelChanged(int player, int _row, int _column)
	{
		if (player == 1)
		{
			JLabel toChange = displayGrid.getFromGrid(_row, _column);
			
			if (toChange == null)
			{
				throw new NullPointerException ("La valeur de retour de la Map est nulle encore!");
			}
			toChange.setBackground(Color.blue);
			
			lblPlayerindicator.setText("It's player 2's turn (red)");
		}
		else
		{
			displayGrid.getFromGrid(_row, _column).setBackground(Color.red);
			
			lblPlayerindicator.setText("It's player 1's turn (blue)");
		}
	}
	
	public void resetDisplayGrid(int _columns, int _rows)
	{
		for(int i = 0; i < _columns; i++ )
		{
			for(int k = 0; k < _rows; k++)
			{
				displayGrid.getFromGrid(i, k).setBackground(Color.gray);
			}
		}
		
	}

	@Override
	public void gameEnd(int winner)
	{
		// TODO Auto-generated method stub
		if (winner != 0)
		{
			JOptionPane.showMessageDialog(frmConnect, "Game ends, player " + winner + " wins!");
		}
		else
		{
			JOptionPane.showMessageDialog(frmConnect, "Game ends, it's a draw!");
		}
		
		int dialogResult = JOptionPane.showConfirmDialog(frmConnect, "Do you want to have your revenge?", "New Game?", JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION)
		{
			controller.newGame();
			lblPlayerindicator.setText("Player 1 (blue) starts.");
		}
		else
		{
			WindowEvent wev = new WindowEvent(frmConnect, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
		}
	}
}
