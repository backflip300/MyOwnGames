package dodgeBall;


import java.awt.Color;
import java.awt.Graphics;



  
public class AProjectiles {		
	private int x = 1000,y = -100;
	private double dx = 10;
	private int radius = 20;
	private int f = 0;
	
	public AProjectiles () {

		}
	
	public void update(MainClass mc, Players P) {
		
		x = (int) (x + dx);
		if (mc.keyd == 1 || mc.ed == 2 ){
			
			if ( f == mc.NUMproj){
				f = 0;
			}
			
			if (mc.ap[f] . x  > 800 ){
			mc.ap[f].x = mc.a.getX();
			
			mc.ap[f].y = mc.a.getY();
			f += 1;
			mc.keyd = 0;
			}
			
		}		
		checkForCollision(P, mc);
	}
	
	private void checkForCollision(Players P, MainClass mc) {
		int playerX = mc.b.getX();
		int playerY = mc.b.getY();
		int playerR = mc.b.getRadius();
		//System.out.println(playerX);
		int a = x - playerX;
		int bb = y - playerY;
		int collide = radius + playerR;
		// dist between object 
		double c = Math.sqrt((double) (a*a) + (double) (bb*bb)) ;
		
		if (c < collide){
			mc.b.setGamestate(mc.b.getGamestate() + 1);
			//System.out.print(mc.b.getGamestate());
			x = 1000;
			y = -100;
		}
	}
	public void paint(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillOval(x - radius, y - radius, radius*2, radius*2);
		
	}
}
