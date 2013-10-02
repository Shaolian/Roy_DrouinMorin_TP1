package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GameView
{
	
	private JFrame frmConnect;
	private DisplayGrid displayGrid;
	private ActionListener buttonListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent arg0)
		{
			System.out.println(arg0.getActionCommand());
		}
	};
	
	/**
	 * Create the application.
	 */
	public GameView(int rows, int columns)
	{
		//TODO Adjust to be able to receive size in parameter
		displayGrid = new DisplayGrid(rows, columns, buttonListener);
		initialize();
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
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnGame.add(mntmNewGame);
		
		JMenuItem mntmGiveUp = new JMenuItem("Give Up");
		mnGame.add(mntmGiveUp);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JPanel mainPanel = new JPanel();
		frmConnect.getContentPane().add(mainPanel, BorderLayout.CENTER);
		SpringLayout sl_mainPanel = new SpringLayout();
		mainPanel.setLayout(sl_mainPanel);
		
		JPanel ButtonContainer = new JPanel();
		sl_mainPanel.putConstraint(SpringLayout.WEST, ButtonContainer, 10, SpringLayout.WEST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, ButtonContainer, -10, SpringLayout.SOUTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, ButtonContainer, -10, SpringLayout.EAST, mainPanel);
		mainPanel.add(ButtonContainer);
		
		sl_mainPanel.putConstraint(SpringLayout.NORTH, displayGrid, 10, SpringLayout.NORTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, displayGrid, -6, SpringLayout.NORTH, ButtonContainer);
		sl_mainPanel.putConstraint(SpringLayout.WEST, displayGrid, 10, SpringLayout.WEST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, displayGrid, -10, SpringLayout.EAST, mainPanel);
		mainPanel.add(displayGrid);
		
		frmConnect.setVisible(true);
	}
}
