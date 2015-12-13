package everything;

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


import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;




@SuppressWarnings("serial")
public class Main extends JPanel implements KeyListener, MouseListener {
	
	

	private int iWidth, iHeight, iChangex, changey, iMousex, iMousey, iTruex,
	iTruey;
	Physics physics = new Physics();
	int i = 0;
	Ball p1 = new Ball(100, 300, 30, 0);
	Ball p2 = new Ball(300, 500, 30, 0);
	Ball ball = new Ball(600, 550, 30, 0);
	
	
	ArrayList<Ball> Balls = new ArrayList<Ball>(); 
	
	boolean move = false;
	
	public Main() {
		setSize(1000, 1000);
		setPreferredSize(new Dimension(1000, 1000));
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		Balls.add(ball);
		Balls.add(p1);
		Balls.add(p2);
		
		
	}

	// looping section which redraws frame
	public void paint(Graphics g) {
		Random Rand = new Random();
		iWidth = getWidth();
		iHeight = getHeight();
		g.setColor(Color.darkGray);
		g.clearRect(0, 0, iWidth, iHeight);
		reallign();
		g.setColor(Color.RED);
		//Balls.add(new Ball(Rand.nextInt(900)+50, Rand.nextInt(900)+50, Rand.nextInt(50)+1, 0));
		for (i = 0; i < Balls.size(); i++){
			g.setColor(Color.blue);
			Balls.get(i).run(this, g);
		}
		for (i = 0; i < Balls.size(); i++){
			
			Balls.get(i).move();
		}
		g.drawOval(iTruex - 25, iTruey - 25, 50, 50);
//		g.dispose();
//		
		repaint();
		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reallign(){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		iMousex = (int) b.getX();
		iMousey = (int) b.getY();
		iTruex = iMousex + iChangex;
		iTruey = iMousey + changey;
	}

	// Runs on startup, creates JFrame move to paint.
	public static void main(String args[]) {
		Main cheese = new Main();
		JFrame f = new JFrame();
		f.setResizable(true);
		f.add(cheese);
		f.pack(); // f.setBackground(Color.black); // doesn't work
		f.setTitle("physics engine");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	
	
	public void mouseClicked(MouseEvent e) {
		iChangex = e.getX() - iMousex;
		changey = e.getY() - iMousey;
		
	}

	// mouse actions
	@Override
	public void mouseEntered(MouseEvent e) {
		iChangex = e.getX() - iMousex;
		changey = e.getY() - iMousey;
		
	}

	// mouse actions
	@Override
	public void mouseExited(MouseEvent e) {
		iChangex = e.getX() - iMousex;
		changey = e.getY() - iMousey;
		

	}

	// mouse actions
	@Override
	public void mousePressed(MouseEvent e) {

	}

	// mouse actions
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// key actions
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
			if (k == KeyEvent.VK_SPACE){
				if(move == true){
				move = false;
				}else{
					move = true;
				}
			}
	}

	// key actions
	@Override
	public void keyReleased(KeyEvent e) {

	}
	// key actions
	@Override
	public void keyTyped(KeyEvent e) {

	}
}
