package dodgeBall;


import java.awt.Color;
import java.awt.Graphics;

public class Players {
	//most of these are self explanitory
	private int x = 100;
	private int y = 50;
	private double gravity = 15;
	//private double dx = 0;
	private double dy = 0;
	private double energyloss = 0.65;
	private double dt = .2;
//	private double gamedy = -75;
	private int radius = 20;
	// 0 = still playing 1 = you won// well, not any more
	private  int gamestate = 0;

	public Players(int i, int j) {
		x = i;
		y = j;
	}


	public Players() {
	}

	
	public void update(MainClass mc){
		//energy loss on bounce
	if(y > mc.getHeight() - radius - 1){
		y = mc.getHeight() - radius -1;
		dy *= energyloss;
		dy = - dy;
	}else{
		//velocity formula
		dy = dy + gravity*dt;
		//position formula
		y += dy*dt + .5*gravity*dt*dt;
	}
	/* sideways movement not currently used
	if (dx > 0){
		dx -= 0.05;
	}	else if (dx < 0){
		dx += 0.05;
	}
	*/
	if (y - radius < 0){
		dy = 10;
		y = radius;
		
	}

}
	public int getGamestate() {
		return gamestate;
	}
	
	public void setGamestate(int gamestate) {
		this.gamestate = gamestate;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getRadius() {
		return radius;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x - radius, y - radius, radius*2, radius*2);
		
	}
	public void moveRight() {
		x += 5;
		
	}


	public void moveLeft() {
		x -= 5;	
	}
	public void moveUp() {
		dy = -60;	
	}
}
