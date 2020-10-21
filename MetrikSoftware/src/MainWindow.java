import javax.swing.*;

public class MainWindow extends JFrame{
	private int _x;
	private int _y;
	private int _color;
	
	public MainWindow(int windowSizeX, int windowSizeY, int color) {
		this._x = windowSizeX;
		this._y = windowSizeY;
		this._color = color;
		
		//Titel und Groesse Fenster
		setTitle("Programm für Softwaretechnik");	
		setSize(_x, _y);
		
		add(new DrawObject(_x/*-100*/, _y/*-100*/, _color));	//Canvas Groessenanpassung wegen Menubar
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public void openWindow() {
		setVisible(true);
	}
	
}
