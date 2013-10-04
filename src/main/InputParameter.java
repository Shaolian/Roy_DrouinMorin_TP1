package main;

public enum InputParameter {
	ROWS(0),
	COLUMNS(1),
	VICTORY(2),
	HELP(3);
	
	private int index;
	
	InputParameter (int _index)
	{
		index = _index;
	}
}
