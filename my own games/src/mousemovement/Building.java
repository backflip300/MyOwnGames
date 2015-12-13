package mousemovement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;






@SuppressWarnings("serial")
public class Building extends JPanel implements KeyListener, MouseListener  {
	 int iWidth,iHeight, changex, changey,mousex,mousey, x, y;
	boolean clicked = false;
	private Player p;
	public  Building() {
		
		setSize(1000, 1000);
		setPreferredSize(new Dimension(1000, 1000));
		p = new Player(getWidth()/4, getHeight()/2);
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		// min = new Minmus(500, 500);
		
	}

	
	public static void main(String args[]){
		Building game = new Building();
		JFrame f = new JFrame();
		//f.add(new JLabel(new ImageIcon("Libraries/Pictures/heart.png")));
		f.setResizable(false);
		f.add(game);
		f.pack();
		f.setLocationRelativeTo(null);
		// f.setBackground(Color.black); // doesn't work
		f.setTitle("Orbit test");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void paint(Graphics g){
		iWidth = getWidth();
		iHeight = getHeight(); 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, iWidth, iHeight);
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		p.draw(g,this);
		mousex = (int) b.getX();
		mousey = (int) b.getY();
		g.setColor(Color.RED);
		x = mousex + changex;
		y = mousey + changey;
		g.drawOval(x-5, y-5, 10, 10	);
				g.dispose();
		repaint();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		  
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		 changex=e.getX() -  mousex;
		    changey=e.getY() - mousey;
		    System.out.println(changex+","+changey);
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		clicked = true;
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return super.getX();
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return super.getY();
	}
}
   