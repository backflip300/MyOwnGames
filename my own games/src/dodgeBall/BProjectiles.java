package dodgeBall;


import java.awt.Color;
import java.awt.Graphics;




  
public class BProjectiles {	
	private int f = 0;
	private int x = -200,y = -100;
	private double dx = -10;
	private int radius = 20;
	
	public BProjectiles () {

		}
	
	public void update(MainClass mc, Players P) {
		x = (int) (x + dx);
		System.out.println(mc.de1);
		if (mc.keyleft == 1 || mc.de2 == true){
			if ( f == mc.NUMproj){
				f = 0;
			}
			
			if(mc.bp[f].x < 0){
			mc.bp[f].x = mc.b.getX();
			
			mc.bp[f].y = mc.b.getY();
			f += 1;
			mc.keyleft = 0;
			}
		}		
		checkForCollision(P, mc);
	}
	
	
	private void checkForCollision(Players P, MainClass mc) {
		int playerX = mc.a.getX();
		int playerY = mc.a.getY();
		int playerR = mc.a.getRadius();
		//System.out.println(playerX);
		int a = x - playerX;
		int bb = y - playerY;
		int collide = radius + playerR;
		// dist between object 
		double c = Math.sqrt((double) (a*a) + (double) (bb*bb)) ;
		
		if (c < collide){
			mc.a.setGamestate(mc.a.getGamestate() + 1);
			//System.out.print(mc.a.getGamestate());
			x = -200;
			y = -100;
		}
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x - radius, y - radius, radius*2, radius*2);
		
	}
}
