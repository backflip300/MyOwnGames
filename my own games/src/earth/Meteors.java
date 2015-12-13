package earth;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Meteors {

	private int dx, dy, x, y, radius, speed;

	public Meteors(int x, int y) {
		speed = 200;
		this.x = x;
		this.y = y;
		Random r = new Random();
		radius = r.nextInt(25) + 7;
		dx = (int) (475 - x) / speed;
		dy = (int) (475 - y) / speed;
	}

	public void draw(Graphics g, Moon m, Scorer s) {

		x = x + dx;
		y = y + dy;
		//System.out.println(x);
		g.setColor(Color.WHITE);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
		checkForCollision(s);
		checkForBoom(m, s);
	}

	private void checkForCollision(Scorer s) {
		int playerX = 500;
		int playerY = 500;
		int playerR = 50;
		// System.out.println(playerX);
		int a = x - playerX;
		int bb = y - playerY;
		int collide = radius + playerR;
		// dist between object
		double c = Math.sqrt((double) (a * a) + (double) (bb * bb));

		if (c < collide) {
			x = 1000;
			y = 1000;
			s.setLives(s.getLives() - 1);
			System.out.println(s.getLives());
		}
	}

	private void checkForBoom(Moon m, Scorer s) {
		@SuppressWarnings("static-access")
		int playerX1 = m.getX();
		@SuppressWarnings("static-access")
		int playerY1 = m.getY();
		int playerR1 = m.getW();
		// System.out.println(playerX);
		int a1 = x - playerX1;
		int bb1 = y - playerY1;
		int collide1 = radius + playerR1;
		// dist between object
		double c1 = Math.sqrt((double) (a1 * a1) + (double) (bb1 * bb1));

		if (c1 < collide1) {
			x = -200;
			y = -100;
			s.setScore(s.getScore() + 1);
			//System.out.println(s.getScore());
		}
	}
}
