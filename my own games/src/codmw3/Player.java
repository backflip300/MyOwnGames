package codmw3;

//import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {
	private int radius = 10, dx = 0, dy = 0, speed = 3,  i = -1,health = 100, bullets = 1000;
	private boolean set = false, shoot = false, fwd = false, bkwd = false,
			tleft = false, tright = false;
	private Fire f[] = new Fire[1000];

	public Player(int x, int y, int bulletplace) {
		super(x, y, bulletplace);

	}

	public void draw(Graphics g, Map m) {
		
		this.move();
		if (shoot == true) {
			if (set == true){
				bullets--;
				i++;
				System.out.println(i);
				f[i] = new Fire(x, y, orientation);
				set = false;
				
			}
		}
		
		for (int b = 0; b <= i; b++){
		f[b].draw(g,m);
		}
		if(i >= 1){
		
		}
		g.setColor(Color.BLACK);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
		g.setColor(Color.RED);
		g.drawRect(x - 30, y, 10,-health/3);
		
		g.drawString(Integer.toString(bullets), bulletplace, 100);
		//health--;
		if (orientation >= 360) {
			orientation -= 360;
		}
		int y2 = (int) (10 * Math.sin(Math.toRadians(orientation)));
		int x2 = (int) (10 * Math.cos(Math.toRadians(orientation)));
		if (x > m.width-radius){
			x = m.width - radius;
		}
		if (y > m.height-radius){
			y = m.height - radius;
		}
		if (x < 0 + radius){
			x = radius;
		}
		if (y < 0 + radius){
			y = radius;
		}
		
		g.setColor(Color.BLUE);
		g.drawLine(x, y, x + x2, y + y2);
		g.drawLine(x + 1, y + 1, x + x2 + 1, y + y2 + 1);
		g.drawLine(x - 1, y - 1, x + x2 - 1, y + y2 - 1);

	}

	public void move() {
		if (tright == true) {
			orientation += 5;
		}
		if (tleft == true) {
			orientation -= 5;
		}
		if (fwd == true) {
			dx = (int) (speed * Math.cos(Math.toRadians(orientation)));
			dy = (int) (speed * Math.sin(Math.toRadians(orientation)));

		}
		if (bkwd == true) {
			dx = (int) -(speed * Math.cos(Math.toRadians(orientation)));
			dy = (int) -(speed * Math.sin(Math.toRadians(orientation)));
		}
		x += dx;
		y += dy;
	}

	public void setBkwd(boolean bkwd) {
		this.bkwd = bkwd;
	}

	public void setFwd(boolean fwd) {
		this.fwd = fwd;
	}

	public boolean isfwd() {
		return fwd;
	}

	public boolean isbkwd() {
		return bkwd;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void settright(boolean tright) {
		this.tright = tright;
	}

	public boolean istright() {
		return tright;
	}

	public void settleft(boolean tleft) {
		this.tleft = tleft;
	}

	public boolean istleft() {
		return tleft;
	}

	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	public void setSet(boolean set) {
		this.set = set;
	}

	public int getRadius() {
		return radius;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return health;
	}
}
