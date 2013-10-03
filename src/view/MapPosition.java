package view;

import java.lang.Object;

public class MapPosition
{
	public int x;
	public int y;
	
	public MapPosition(final int _x, final int _y)
	{
		x = _x;
		y = _y;
	}
	
	// TODO Override hashCode
	
	// TODO Override equals
	
	public boolean equals(Object _input)
	{
		if (_input instanceof MapPosition)
		{
			MapPosition input = (MapPosition) _input;
			return input.x == x && input.y == y; 
		}
		else
		{
			return false;
		}
	}
	
	public int hashCode()
	{
		int output = 1;
		
		output = output * 37 + x;
		output = output * 37 + y;
		
		return output;
	}
}

