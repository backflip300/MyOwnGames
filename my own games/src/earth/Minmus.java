package earth;

import java.awt.Color;
import java.awt.Graphics;

public class Minmus extends Objects {
	

	
	private double a;
	
	
	public Minmus(int x, int y) {
		super(x,y);
		w = 6; h = 6;v = 1;r = 20;
	}

	public void draw(Graphics g){
		this.move();
		g.setColor(Color.RED);
		g.fillOval(x, y, w, h);
	}
	

	public void move(){
		
		a += v * 0.17;
		x = (int) (Mun.getX() + 2.5 +  r*Math.cos(a));
		y = (int) (Mun.getY() + 2.5 +  r*Math.sin(a));
	}
}