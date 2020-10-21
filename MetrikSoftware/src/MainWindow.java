import java.awt.BorderLayout;

import javax.swing.*;

public class MainWindow extends JFrame{
	private int _x;
	private int _y;
	private int _color;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem rot;
	private JMenuItem gruen;
	private JMenuItem blau;
	private JMenuItem closeItem;
	
	public MainWindow(int windowSizeX, int windowSizeY, int color) {
		this._x = windowSizeX;
		this._y = windowSizeY;
		this._color = color;
		
		//Titel und Groesse Fenster
		setTitle("Programm für Softwaretechnik");	
		setSize(_x, _y);
		
		menuBar = new JMenuBar();
		 
        fileMenu = new JMenu("Hintergrund");
 
        rot = new JMenuItem("Rot");
        gruen = new JMenuItem("Gruen");
        blau = new JMenuItem("Blau");
        closeItem = new JMenuItem("Schließen");

 
        fileMenu.add(rot);
        fileMenu.add(gruen);
        fileMenu.add(blau);
        fileMenu.add(closeItem);

        menuBar.add(fileMenu);
        
        this.add(menuBar, BorderLayout.NORTH);
		
		add(new DrawObject(_x/*-100*/, _y/*-100*/, _color));	//Canvas Groessenanpassung wegen Menubar
		
		rot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                _color = 1;
                setVisible(false);
                dispose();
                MainWindow mw = new MainWindow(windowSizeX, windowSizeY, _color);
        		mw.openWindow();
            }
        });
        
        gruen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                _color = 2;
                setVisible(false);
                dispose();
                MainWindow mw = new MainWindow(windowSizeX, windowSizeY, _color);
        		mw.openWindow();
            }
        });
        
        blau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                _color = 3;
                setVisible(false);
                dispose();
                MainWindow mw = new MainWindow(windowSizeX, windowSizeY, _color);
        		mw.openWindow();
            }
        });
        
        closeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });
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
