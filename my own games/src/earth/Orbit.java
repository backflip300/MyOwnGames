package earth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Orbit extends JPanel implements KeyListener {
	private int total = 1000,wait = 1000, NumCreated = 0, waittime = 0;
	
	 
	private Meteors mi[] = new Meteors[total];
	// private Mun mu;
	private Moon m;
	private Scorer s;
	// private Minmus min;
	private int PlanetChooser = 1;

	public Orbit() {
		setSize(1000, 1000);
		setPreferredSize(new Dimension(1000, 1000));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		m = new Moon(500, 500);
		s = new Scorer();
		// mu = new Mun(500, 500);

		// min = new Minmus(500, 500);

	}

	public void paint(Graphics g) {
		
		if (s.getLives() >= 0){
		wait -= 10;
		if (wait < waittime && NumCreated  < total) {

			int coor[] = Fire.coordinates();
			mi[NumCreated] = new Meteors(coor[0], coor[1]);
			wait = waittime;
			NumCreated++;
			waittime += 10;
			wait = 1000;   
		}

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.YELLOW);
		g.fillOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
		g.drawString(String.valueOf(s.getScore()), 500, 200);

		g.setColor(Color.RED);
		switch(s.getLives()){
			case 1 : 
				g.fillOval(10, 100, 50, 50);
				break;
			case 2:
				g.fillOval(10, 100, 50, 50);
				g.fillOval(10, 150, 50, 50);
				break;
			case 3:
				g.fillOval(10, 100, 50, 50);
				g.fillOval(10, 150, 50, 50);
				g.fillOval(10, 200, 50,  50);
				break;
				
		}
		m.draw(g);
		// mu.draw(g);
		for (int i = 0; i < NumCreated ; i++) {
			mi[i].draw(g,m,s);
		}
		}
		
		g.dispose();
		repaint();

		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		Orbit game = new Orbit();
		JFrame f = new JFrame();
		f.add(new JLabel(new ImageIcon("Libraries/Pictures/heart.png")));
		f.setResizable(false);
		f.add(game);
		f.pack();
		// f.setBackground(Color.black); // doesn't work
		f.setTitle("Orbit test");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		/*
		 * if (c == KeyEvent.VK_1) { PlanetChooser = 1; } if (c ==
		 * KeyEvent.VK_2) { PlanetChooser = 2; } if (c == KeyEvent.VK_3) {
		 * PlanetChooser = 3; }
		 */
		if (c == KeyEvent.VK_W) {
			switch (PlanetChooser) {
			case 1:
				if (m.getV() < 1) {
					m.setV(m.getV() + 0.1);
				}
			case 2:
				/*
				 * mu.setV(mu.getV() + 0.1); case 3: min.setV(min.getV() + 0.1);
				 */
			}
		}
		if (c == KeyEvent.VK_S) {
			switch (PlanetChooser) {
			case 1:
				if (m.getV() > -3) {
					m.setV(m.getV() - 0.1);
				}
				/*
				 * case 2: mu.setV(mu.getV() - 0.1);
				 * 
				 * case 3: min.setV(min.getV() - 0.1);
				 */
			}

		}
		if (c == KeyEvent.VK_A) {
			switch (PlanetChooser) {
			case 1:
				m.setR(m.getR() - 1);
				/*
				 * case 2: mu.setR(mu.getR() - 1); case 3: min.setR(min.getR() -
				 * 1);
				 */
			}
		}
		if (c == KeyEvent.VK_D) {
			switch (PlanetChooser) {
			case 1:
				m.setR(m.getR() + 1);
				/*
				 * case 2: mu.setR(mu.getR() +1);
				 * 
				 * case 3: min.setR(min.getR() +1);
				 */
			}
		}
		if (c == KeyEvent.VK_P) {
			// min.setR(156);
			// min.setR(20);
			m.setR(456);
			m.setV(98);
			// mu.setR(301);
			// mu.setV(-12);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
