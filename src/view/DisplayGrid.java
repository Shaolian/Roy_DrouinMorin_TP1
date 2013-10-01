package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class DisplayGrid extends JPanel
{
	
	private HashMap<MapPosition, JLabel> displayGrid;
	private int sizeX;
	private int sizeY;
	private ActionListener actionListener;
	
	public DisplayGrid(ActionListener _actionListener)
	{
		sizeX = 6;
		sizeY = 6;
		actionListener = _actionListener;
		setupPanel();
		populateDisplayGrid();
	}
	
	public DisplayGrid(int _sizeX, int _sizeY, ActionListener _actionListener)
	{
		if (_sizeX <= 0 || _sizeY <= 0)
		{
			throw new IllegalArgumentException(
					"The size passed in constructor equal or below 0.");
		}
		
		displayGrid = new HashMap<MapPosition, JLabel>();
		sizeX = _sizeX;
		sizeY = _sizeY;
		actionListener = _actionListener;
		setupPanel();
		populateDisplayGrid();
	}
	
	public JLabel getFromGrid(int x, int y)
	{
		if (x < 0 || x > sizeX)
		{
			throw new ArrayIndexOutOfBoundsException(
					"DisplayGrid map x coordinates were out of bounds.");
		}
		else if (y < 0 || y > sizeY)
		{
			throw new ArrayIndexOutOfBoundsException(
					"DisplayGrid map y coordinates were out of bounds.");
		}
		
		return displayGrid.get(new MapPosition(x, y));
	}
	
	private void setupPanel()
	{
		// TODO set all parameters for JPanel
		// Layout
		this.setLayout(new GridLayout(sizeX, sizeY));
	}
	
	private void populateDisplayGrid()
	{
		for (int y = 0; y < sizeY; y++)
		{
			for (int x = 0; x < sizeX + 1; x++)
			{
				if (y == 0)
				{
					// TODO set all parameters for JButton
					JButton toSet = new JButton();
					toSet.addActionListener(actionListener);
					
					String actionCommand;
					actionCommand = x + "," + y;
					toSet.setActionCommand(actionCommand);
					
					this.add(toSet);
				}
				else
				{
					JLabel toSet = new JLabel();
					this.add(toSet);
					displayGrid.put(new MapPosition(x, y), toSet);
				}
			}
		}
	}
	
	private class MapPosition
	{
		public int x;
		public int y;
		
		public MapPosition(final int _x, final int _y)
		{
			x = _x;
			y = _y;
		}
	}
}
