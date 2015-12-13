package lines;



import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Screen extends JPanel implements KeyListener, MouseListener {
	int iWidth,iHeight, changex, changey,mousex,mousey, x, y;
	boolean movement = false;
	
	Lines l;
	public Screen() {
		setSize(1800,1000);
		setPreferredSize(new Dimension(1800,1000));
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		 l = new Lines();
	}
	
	public static void main(String args[]){
		Screen s = new Screen();
		JFrame f = new JFrame();
		f.setResizable(true);
		f.add(s);
		f.pack();
		f.setTitle("ball roller");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	public void paint(Graphics g){
		iWidth = getWidth();
		iHeight = getHeight();
		g.setColor(Color.white);
		g.fillRect(0, 0, iWidth, iHeight);
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		mousex =(int) b.getX();
		mousey = (int) b.getY();
		
		
		x = mousex + changex;
		y = mousey + changey;
		g.setColor(Color.BLACK);
		g.drawOval(x-5,y-5,10,10);
		l.paint(g,this);
		g.dispose();
		repaint();
		try{
			Thread.sleep(17 );
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		l.createLine(x, y);
		changex=e.getX() -  mousex;
	    changey=e.getY() - mousey;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		changex=e.getX() -  mousex;
	    changey=e.getY() - mousey;
	    
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();

		if(c == KeyEvent.VK_SPACE)
		{
			if (movement == true){
			movement = false;
			}else{
				movement = true;
			}
		}
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}