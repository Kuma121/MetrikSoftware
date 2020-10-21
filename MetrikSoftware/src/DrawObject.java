import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class DrawObject extends Canvas implements MouseListener{
	
	private Float _x, _y;
	private int _sizeX = 0;
	private int _sizeY = 0;
	private int linex, liney;
	private int _counter;
	
	private String text = "Koordinaten";
	private int linex1 = -1;
	private int liney1 = -1;
	private int linex2 = -1;
	private int liney2 = -1;
	
	private String diameter;
	private String entfernung = "Entfernung:";
	private double _coordx1 =-1;
	private double _coordy1 =-1;
	private double _coordx2 =-1;
	private double _coordy2 =-1;

	
	
	
	public DrawObject(int sizeX, int sizeY, int color) {
		this._sizeX = sizeX;
		this._sizeY = sizeY;
		this.diameter = MainWindow.getObjektGroeﬂe();
		
		_x = _y = (float) 0;
		_counter = 0;
		
		setSize(_sizeX, _sizeY);
		
		//Hintergrundauswahl
		if (color == 1)
			setBackground(Color.red);
		else if (color == 2)
			setBackground(Color.green);
		else if (color == 3)
			setBackground(Color.blue);
		else if (color < 1 || color > 3)
			setBackground(Color.pink);
		
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		
		if(_x == 0 && _y == 0) return;
		
		//Diameter festlegen
		diameter = MainWindow.getObjektGroeﬂe();
		float diameter1 = Float.parseFloat(diameter);
		
		//grafisches Objekt anlegen mit Strichstaerke
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3.0F));
		
		Graphics2D rec = (Graphics2D) g;
		rec.setStroke(new BasicStroke(3.0F));
		
		Ellipse2D ellipse2D = new Ellipse2D.Float(_x, _y, diameter1, diameter1);
		Rectangle2D rectangle2D = new Rectangle2D.Float(_x, _y, diameter1, diameter1);
		
		g2d.draw(ellipse2D);
//		rec.draw(rectangle2D);
				
		//Linienzeichnung auf Mittelpunkt setzen nach zweitem gemalten Objekt
		//Koordinaten bei 1. und 2. Klick speichern + Distanzberech
		if (_counter == 0) {
			linex1 = linex;
			_coordx1 = _x;
			liney1 = liney;
			_coordy1 = _y;
		}
		else if (_counter == 1) {
			linex2 = linex;
			_coordx2 = _x;
			liney2 = liney;
			_coordy2 = _y;
			entfernung = "Entfernung: "+calculateDistanceBetweenPointsWithPoint2D(_coordx1, _coordy1, _coordx2, _coordy2);
			g2d.drawString(entfernung, 10, 15);
			_coordx1 = _coordy1 = _coordx2 = _coordy2 = -1;
			g2d.drawLine(linex1+(int)diameter1/2, liney1+(int)diameter1/2, linex2+(int)diameter1/2, liney2+(int)diameter1/2);
		}
		
		//Koordinatenposition
		if(_y < 20) {
			g2d.drawString(text, _x-20, _y+65);
		} else {
			g2d.drawString(text, _x-20, _y-10);
		}
		
		//nach zwei Formen Canvas leeren
		if(_counter > 1) {
			g2d.clearRect(0, 0, _sizeX, _sizeY);
			rec.clearRect(0, 0, _sizeX, _sizeY);
			
			_counter = -1;
		}
	}
	
	@Override
	//wenn Maus geklickt wird
	public void mouseClicked(MouseEvent e) {
		_x = (float) e.getX();
		linex = e.getX();
		_y = (float) e.getY();
		liney = e.getY();
		text = "Koordinaten: x: "+_x+" y: "+_y;
		
		//male etwas
		paint(getGraphics());
		_counter++;
	}
	
	//methode Distanzberech g2d :
	public double calculateDistanceBetweenPointsWithPoint2D(double x1, double y1, double x2, double y2) {

    return Point2D.distance(x1, y1, x2, y2);
}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
