import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DrawObject extends Canvas implements MouseListener{
	
	private Float _x, _y;
	private int _sizeX = 0;
	private int _sizeY = 0;
	private int _counter;
	
	
	
	public DrawObject(int sizeX, int sizeY, int color) {
		this._sizeX = sizeX;
		this._sizeY = sizeY;
		
		_x = _y = (float) 0;
		_counter = 0;
		
		setSize(_sizeX, _sizeY);
		
		setBackground(Color.pink);
		
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		
		if(_x == 0 && _y == 0) return;
		
		//grafisches Objekt anlegen mit Strichstaerke
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3.0F));
		
		Graphics2D rec = (Graphics2D) g;
		rec.setStroke(new BasicStroke(3.0F));
		
		Ellipse2D ellipse2D = new Ellipse2D.Float(_x, _y, 50, 50);
		Rectangle2D rectangle2D = new Rectangle2D.Float(_x, _y, 50, 50);
		
//		g2d.draw(ellipse2D);
		rec.draw(rectangle2D);
		
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
		_y = (float) e.getY();
		
		//male etwas
		paint(getGraphics());
		_counter++;
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
