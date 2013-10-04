package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class DisplayGrid extends JPanel
{
	private static final long serialVersionUID = 1L;
	private HashMap<MapPosition, JLabel> displayGrid;
	private int numberOfColumns;
	private int numberOfRows;
	private ActionListener actionListener;
	
	public DisplayGrid(int _numberOfColumns, int _numberOfRows, ActionListener _actionListener)
	{
		if (_numberOfColumns <= 0 || _numberOfRows <= 0)
		{
			throw new IllegalArgumentException(
					"The size passed in constructor equal or below 0.");
		}
		
		displayGrid = new HashMap<MapPosition, JLabel>();
		numberOfColumns = _numberOfColumns;
		numberOfRows = _numberOfRows;
		actionListener = _actionListener;
		setupPanel();
		populateDisplayGrid();
	}
	
	public JLabel getFromGrid(int _column, int _row)
	{
		if (_column < 0 || _column > numberOfColumns)
		{
			throw new ArrayIndexOutOfBoundsException(
					"DisplayGrid map column coordinates were out of bounds.");
		}
		else if (_row < 0 || _row > numberOfRows)
		{
			throw new ArrayIndexOutOfBoundsException(
					"DisplayGrid map row coordinates were out of bounds.");
		}
		
		return displayGrid.get(new MapPosition(_column, _row));
	}
	
	private void setupPanel()
	{
		this.setLayout(new GridLayout(numberOfRows + 1, numberOfColumns));
	}
	
	private void populateDisplayGrid()
	{
		for (Integer column = 0; column < numberOfColumns; column ++){
			JButton toSet = new JButton();
			toSet.addActionListener(actionListener);
			
			String actionCommand;
			actionCommand = column.toString();
			toSet.setActionCommand(actionCommand);
			
			this.add(toSet);
		}
		
		for (Integer row = 0; row < numberOfRows; row++)
		{
			for (Integer column = 0; column < numberOfColumns; column++)
			{
				
				JLabel toSet = new JLabel();
				toSet.setBackground(Color.gray);
				toSet.setBorder(BorderFactory.createLineBorder(Color.white));
				toSet.setOpaque(true);
				
				this.add(toSet);
				displayGrid.put(new MapPosition(column, row), toSet);
				
			}
		}
	}
}
