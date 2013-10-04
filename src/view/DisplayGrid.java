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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<MapPosition, JLabel> displayGrid;
	private int numberOfColumns;
	private int numberOfRows;
	private ActionListener actionListener;
	
	public DisplayGrid(ActionListener _actionListener)
	{
		numberOfColumns = 6;
		numberOfRows = 6;
		actionListener = _actionListener;
		setupPanel();
		populateDisplayGrid();
	}
	
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
	
	/**
	 * Method that returns a label from the play grid.
	 * @param _column The column in which the label is.
	 * @param _row The row in which the label is.
	 * @return Queried label from HashMap.
	 * @throws ArrayindexOutOfBoundsException
	 *  			When given coordinates that are out of the bounds of the grid 
	 * 				(above the limit or below zero.)
	 */
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
		// TODO set all parameters for JPanel
		// Layout
		this.setLayout(new GridLayout(numberOfRows + 1, numberOfColumns));
	}
	
	private void populateDisplayGrid()
	{
		for (Integer column = 0; column < numberOfColumns; column ++){
			// TODO set all parameters for JButton
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
