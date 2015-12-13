package earth;

import java.awt.Color;
import java.awt.Graphics;

public class Mun extends Objects {
	

	
	public Mun(int x, int y) {
		super(x,y);
		w = 10; h = 10;v = 0.5;r = 150;
		
	}

	public void draw(Graphics g){
		this.move();
		g.setColor(Color.BLUE);
		g.fillOval(x-w, y-h, w*2, h*2);
	}
	

	private void move(){
		
		a += v * 0.17;
		x = (int) (Moon.getX() +  r*Math.cos(a));
		y = (int) (Moon.getY() +  r*Math.sin(a));
	}
}