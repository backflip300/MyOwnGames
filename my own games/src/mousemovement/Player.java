package mousemovement;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int cx,cy,cradius;
	private double x, y, radius = 90;
	private double moveangle, movex, movey, endx,endy;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g, Building B) {
		move(B);
		g.setColor(Color.GREEN);
		cx = (int)x;
		cy = (int)y;
		cradius = (int)radius;
		g.fillOval(cx - cradius, cy - cradius, cradius * 2, cradius * 2);

	}

	private void move(Building B) {
		if (B.clicked == true) {
			movex = B.x  - x;
			endx = B.x;
			endy = B.y;
			//System.out.println(B.x +" - " + x + " = " + movex);
			movey = B.y - y;
			System.out.println(B.y +" - " + y + " = " + movey);
			B.clicked = false;

			/*
			 * movex = x - B.x; movey = y - B.y;
			 * 
			 * moveangle = Math.atan(movey/movex); System.out.println(movex +
			 * "\t" + movey + "\t" + moveangle); } x += 10*Math.cos(moveangle);
			 * y += 10*Math.sin(moveangle);
			 */
		}
		x += movex/1000;
		y += movey/1000;
		if (movex < 0 && x < endx ){
			movex = 0;
		}else if (movex > 0 && x > endx ){
			movex = 0;
		}
		if (movey < 0 && y < endy ){
			movey = 0;
		}else if (movey > 0 && y > endy ){
			movey = 0;
		}
			
			
		
		
	}
}
