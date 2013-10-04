package main;

import controller.GameController;

public class Main {

	public static void main(String[] args) {
		if (args.length == 3)
		{
			int row = 0;
			int column = 0;
			int victory = 0;
			boolean good = true;
			
			try
			{
				row = Integer.parseInt(args[0]);
				column = Integer.parseInt(args[1]);
				victory = Integer.parseInt(args[2]);
			}
			catch(NumberFormatException e)
			{
				good = false;
			}
			
			
			if (row < victory || column < victory)
			{
				good = false;
			}
			
			if (good)
			{
				@SuppressWarnings("unused")
				GameController controller = new GameController(row, column, victory);
			}
			else
			{
				@SuppressWarnings("unused")
				GameController controller = new GameController();
			}

		}
		else
		{
			@SuppressWarnings("unused")
			GameController controller = new GameController();
		}
	
	}
	
}
