import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

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
	private Label statusLabel;
	private Panel controlPanel;
	private static String objektGroeﬂe;
	
	public MainWindow(int windowSizeX, int windowSizeY, int color) {
		this._x = windowSizeX;
		this._y = windowSizeY;
		this._color = color;
		
		//Titel und Groesse Fenster
		setTitle("Programm f¸r Softwaretechnik");	
		setSize(_x, _y);
		
		
		//MenuBar anlegen und mit Aktionen fuellen
		menuBar = new JMenuBar();
		 
        fileMenu = new JMenu("Hintergrund");
 
        rot = new JMenuItem("Rot");
        gruen = new JMenuItem("Gruen");
        blau = new JMenuItem("Blau");
        closeItem = new JMenuItem("Schlieﬂen");

 
        fileMenu.add(rot);
        fileMenu.add(gruen);
        fileMenu.add(blau);
        fileMenu.add(closeItem);

        menuBar.add(fileMenu);
        
        //Dialogfeld fuer Durchmesser anlegen
        setLayout(new FlowLayout());
		
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(600,100);
		 
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		
		add(controlPanel);
		
		Label frage = new Label("Wie Groﬂ soll der Kreis werden?: ", Label.CENTER);
		final TextField antwortText = new TextField(6);
		Button antwortButton = new Button("senden");
		
		antwortButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String data = antwortText.getText();
				statusLabel.setText(data);
				objektGroeﬂe = statusLabel.getText();
			 }
		});
		
		controlPanel.add(frage);
		controlPanel.add(antwortText);
		controlPanel.add(antwortButton);
        
		//Position der MenuBar
        this.add(menuBar, BorderLayout.NORTH);
		
        //Canvas Groessenanpassung wegen Menubar
		add(new DrawObject(_x/*-100*/, _y/*-100*/, _color));	
		
		
		//ActionListener fuer die Menubar hinzufuegen
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
	
	public static String getObjektGroeﬂe() {
		if (objektGroeﬂe == null) {
			return objektGroeﬂe = "50";
		}else {
			return objektGroeﬂe;
		}	
	}
	
	public void openWindow() {
		setVisible(true);
	}
	
}
