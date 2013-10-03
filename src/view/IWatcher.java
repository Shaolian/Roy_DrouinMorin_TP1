package view;

public interface IWatcher
{
	public void gridModelChanged(int player, int _x, int _y);
	public void gameEnd(int winner);
}
