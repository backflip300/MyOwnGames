package codmw3;

import java.awt.Color;
import java.awt.Graphics;

public class Fire {
	
	private int x,y,speed = 20,dx,dy,radius = 2;
	private double angle;
	private boolean Bounce = true;
	
public Fire(int x, int y,double angle) {
	this.x =x;
	this.y =y;
	this.angle = angle;
	//System.out.println("output");
}

public void draw(Graphics g,Map m){
	radius++;
	//System.out.println("output");
	g.setColor(Color.RED);
	if (Bounce == true){
		if (x > m.getWidth()-radius){
			angle = (270 -angle)*2;
			Bounce = false;
		}
		else if (y > m.getHeight()-radius){
			angle = (360 - angle);
			Bounce = false;
		}
		else if (x < 0 + radius){
			
			angle = 90 + (90 - angle);
			Bounce = false;
		}
		else if (y < 0 + radius){
			
			angle = (360 - angle);
			Bounce = false;
		}
	}
	g.fillOval(x-radius, y-radius, radius*2, radius*2);
	dx = (int) (speed * Math.cos(Math.toRadians(angle)));
	dy = (int) (speed * Math.sin(Math.toRadians(angle)));
	//System.out.println(x);
	System.out.println(angle);
	
	x += dx;
	y += dy;
	collide(m);
	
}
private void collide(Map m) {
	int playerX = m.p1.getX();
	int playerY = m.p1.getY();
	int playerR = m.p1.getRadius();
	//System.out.println(playerX);
	int a = x - playerX;
	int bb = y - playerY;
	int collide = radius + playerR;
	// dist between object 
	double c = Math.sqrt((double) (a*a) + (double) (bb*bb)) ;
	
	if (c < collide){
		m.p1.setHealth(m.p1.getHealth()-20);
	}
	 playerX = m.p2.getX();
	 playerY = m.p2.getY();
	 playerR = m.p2.getRadius();
	//System.out.println(playerX);
	 a = x - playerX;
	 bb = y - playerY;
	collide = radius + playerR;
	// dist between object 
	 c = Math.sqrt((double) (a*a) + (double) (bb*bb)) ;
	
	if (c < collide){
		m.p2.setHealth(m.p2.getHealth()-20);
	}
}


public int getDx() {
	return dx;
}
public int getX() {
	return x;
}
}
