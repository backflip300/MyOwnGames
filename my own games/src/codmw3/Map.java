package codmw3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel implements KeyListener {

	Player p1;
	Player p2;
	int height,width;
	public Map() {

		setSize(1000, 1000);
		setPreferredSize(new Dimension(1000, 1000));
		setFocusable(true);
		p1 = new Player(100,500,100);
		p2 = new Player(900,500,900);
		// p2 = new Player((getWidth()/7)*6,getHeight()/2);
		addKeyListener(this);
	}

	public void paint(Graphics g) {
	
		width = getWidth();
		height = getHeight();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		if(p1.getHealth() <= 0){
			g.setColor(Color.RED);
			g.drawString("right player wins", width/2, height/2);			
		}else 	if(p2.getHealth() <= 0){
			g.setColor(Color.RED);
			g.drawString("left player wins", width/2, height/2);
		
		}else{
		p1.draw(g, this);
		p2.draw(g, this );
		g.setColor(Color.RED);
	
		g.dispose();
		repaint();
		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public static void main(String args[]) {
		Map cheese = new Map();
		JFrame f = new JFrame();
		f.setResizable(true);
		f.add(cheese);
		f.pack();
		// f.setBackground(Color.black); // doesn't work
		f.setTitle("hosptial");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_D) {
			if (p1.istleft() == false && p1.istright() == false) {
				p1.settright(true);
			} else {
				p1.settright(false);
				p1.settleft(false);
			}
		}
		if (k == KeyEvent.VK_A) {
			if (p1.istleft() == false && p1.istright() == false) {
				p1.settleft(true);
			} else {
				p1.settright(false);
				p1.settleft(false);
			}

		}
		if (k == KeyEvent.VK_W) {

			if (p1.isbkwd() == false && p1.isfwd() == false) {
				p1.setFwd(true);
			} else {
				p1.setFwd(false);
				p1.setBkwd(false);
				p1.setDx(0);
				p1.setDy(0);
			}

		}
		if (k == KeyEvent.VK_S) {

			if (p1.isbkwd() == false && p1.isfwd() == false) {
				p1.setBkwd(true);
			} else {
				System.out.println("else worked");
				p1.setFwd(false);
				p1.setBkwd(false);
				p1.setDx(0);
				p1.setDy(0);
			}
			
			
		}
		if (k == KeyEvent.VK_SPACE){
			p1.setShoot(true);
			p1.setSet(true);
			
		}
		if (k == KeyEvent.VK_RIGHT) {
			if (p2.istleft() == false && p2.istright() == false) {
				p2.settright(true);
			} else {
				p2.settright(false);
				p2.settleft(false);
			}
		}
		if (k == KeyEvent.VK_LEFT) {
			if (p2.istleft() == false && p2.istright() == false) {
				p2.settleft(true);
			} else {
				p2.settright(false);
				p2.settleft(false);
			}

		}
		if (k == KeyEvent.VK_UP) {

			if (p2.isbkwd() == false && p2.isfwd() == false) {
				p2.setFwd(true);
			} else {
				p2.setFwd(false);
				p2.setBkwd(false);
				p2.setDx(0);
				p2.setDy(0);
			}

		}
		if (k == KeyEvent.VK_DOWN) {

			if (p2.isbkwd() == false && p2.isfwd() == false) {
				p2.setBkwd(true);
			} else {
				System.out.println("else worked");
				p2.setFwd(false);
				p2.setBkwd(false);
				p2.setDx(0);
				p2.setDy(0);
			}
			
			
		}
		if (k == KeyEvent.VK_ENTER){
			p2.setShoot(true);
			p2.setSet(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
}
