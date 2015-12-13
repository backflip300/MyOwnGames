package earth;



import java.awt.Color;
import java.awt.Graphics;

public class Moon extends Objects {
	
	
	
	public Moon(int x, int y) {
		super(x,y);
		w = 25; h = 25;v = 0.2;r = 100;
	}

	public void draw(Graphics g){
		this.move();
		g.setColor(Color.ORANGE);
		g.fillOval(x-w, y-h, w*2, h*2);
	}
	
	public void move(){
		
		a += v * 0.17;
		x = (int) (500 + r*Math.cos(a));
		y = (int) (500 + r*Math.sin(a));
	}
}
