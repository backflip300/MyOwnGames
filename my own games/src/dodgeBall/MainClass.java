package dodgeBall;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainClass extends Applet implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	boolean de1 = false;
	boolean de2 = false;
	int ed = 0;
	Players b;
	Players a;
	int NUMproj = 100; // max # of projectiles per player ( no more than 50
						// needed, may cause lag if excessive.
	AProjectiles ap[] = new AProjectiles[NUMproj];
	BProjectiles bp[] = new BProjectiles[NUMproj];
	int keyd;
	int keyleft;
	int gs = 0;
	int ws = 10; // score needed to win
	private Image i;
	private Graphics doubleG;
	
	public MainClass() {
		// TODO Auto-generated constructor stub
	}
	public void  init() {

		setSize(800, 600);
		setBackground(Color.YELLOW);
		addKeyListener(this);
	}

	@Override
	public void start() {
		for (int i = 0; i < ap.length; i++) {
			ap[i] = new AProjectiles();
		}
		for (int i = 0; i < bp.length; i++) {
			bp[i] = new BProjectiles();
		}
		a = new Players();
		b = new Players(700, 100);
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		;
		while (a.getGamestate() < ws && b.getGamestate() < ws) {
			a.update(this);
			b.update(this);
			for (int i = 0; i < ap.length; i++) {
				ap[i].update(this, a);
			}
			for (int i = 0; i < bp.length; i++) {
				bp[i].update(this, a);
			}

			// finding if game is still playing or one
			gs = b.getGamestate() + a.getGamestate();
			// meh, for testing purposes
			// System.out.println(keyd);
			keyd = 0;
			keyleft = 0;
			// painty paint
			repaint();
			// limit the FPS
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(Graphics g) {
		// double buffers OP

		if (i == null) {
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}

		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);

		doubleG.setColor(getForeground());
		paint(doubleG);

		g.drawImage(i, 0, 0, this);
	}

	// Ms paint hardmode
	public void paint(Graphics g) {
		String ponescore = String.valueOf(b.getGamestate());
		String ptwoscore = String.valueOf(a.getGamestate());
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString(ponescore, 200, 200);
		g.drawString(ptwoscore, 600, 200);

		if (a.getGamestate() < ws && b.getGamestate() < ws) {
			a.paint(g);
			b.paint(g);
			for (int i = 0; i < ap.length; i++) {
				ap[i].paint(g);
			}
			for (int i = 0; i < bp.length; i++) {
				bp[i].paint(g);
			}

		} else {
			g.fillRect(0, 0, getWidth(), getHeight());
			if (a.getGamestate() < ws) {
				g.setColor(Color.WHITE);
				g.drawString("Left Player Wins", getWidth() / 2 - 20,
						getHeight() / 3);
			} else {
				g.setColor(Color.WHITE);
				g.drawString("Right Player Wins", getWidth() / 2 - 20,
						getHeight() / 3);
			}
		}
	}

	// key reading
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			b.moveUp();
			break;
		case KeyEvent.VK_W:
			a.moveUp();
			break;
		case KeyEvent.VK_D:
			keyd = 1;
			break;
		case KeyEvent.VK_LEFT:
			keyleft = 1;
			break;
		case KeyEvent.VK_Q:
			ed = 1;
			break;
		case KeyEvent.VK_A:
			if (ed == 1) {
				ed = 2;
			}
			break;
		case KeyEvent.VK_RIGHT:
			de2 = false;
			if (de1 == false) {
				de1 = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (de1 == true) {
				de2 = true;
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}