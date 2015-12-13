package lines;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Lines {
	private int startx = 0, starty = 0, endx = 0, endy = 0, tempx = 0,
			tempy = 0;
	private boolean creating = false;

	ArrayList<Integer> line = new ArrayList<Integer>();
	ArrayList<Integer> dy = new ArrayList<Integer>();

	public Lines() {

	}

	@SuppressWarnings("unchecked")
	public void paint(Graphics g, Screen S) {
		g.setColor(Color.BLACK);
		g.drawLine(startx, starty, endx, endy);
		if (S.movement == true) {
			movelines();
		}

		for (int i = 0; i < (line.size() / 4); i++) {
			g.drawLine((int) line.get(4 * i), (int) line.get(4 * i + 1),
					(int) line.get(4 * i + 2), (int) line.get(4 * i + 3));
		}
	}

	public void createLine(int x, int y) {
		tempx = x;
		tempy = y;
		if (creating == false) {
			startx = tempx;
			starty = tempy;
			endx = tempx;
			endy = tempy;
			creating = true;
		} else {
			endx = tempx;
			endy = tempy;
			creating = false;
			makePermanent();
		}
	}

	@SuppressWarnings("unchecked")
	public void makePermanent() {
		line.add(startx);
		line.add(starty);
		line.add(endx);
		line.add(endy);
		for (int i = 0; i < 4; i++) {
			dy.add(1);
		}

	}

	public void movelines() {
		for (int i = 0; i < (line.size() / 4); i++) {
			line.set(4 * i + 1, line.get(4 * i + 1) + dy.get(4 * i + 1));
			line.set(4 * i + 3, line.get(4 * i + 3) + dy.get(4 * i + 3));
			if (line.get(4 * i + 1) > 1000) {
				dy.set(4 * i + 1, (int) (((-Math.abs(dy.get(4 * i + 1)) - 1))));
				// dy.set(4*i+3, (int) (0.8*((-Math.abs(dy.get(4*i+3)))-2)));
			}

			if (line.get(4 * i + 3) > 1000) {
				dy.set(4 * i + 3, (int) (((-Math.abs(dy.get(4 * i + 3))) - 1)));
			}

		}
		gravity();
	}

	public void gravity() {
		for (int i = 0; i < dy.size(); i++) {
			dy.set(i, dy.get(i) + 1);
		}
	}

}
