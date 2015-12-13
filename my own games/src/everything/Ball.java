package everything;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Object {

	public Ball(double x, double y, double radius, double mass) {
		super(x, y, radius, mass);
		velocity = 20;
		direction = -1;
		
	}

	public void run(Main m, Graphics g) {
		CheckCollision(m, g);
		DoPhysics(m);
		

		draw(g);
	}

	private void CheckCollision(Main m, Graphics g) {
		double rad, newx, newy;
		//System.out.println(m.Balls.size());
		for (int ii = 0; ii < m.Balls.size(); ii++) {
			rad = m.Balls.get(ii).radius;
			newx = m.Balls.get(ii).x;
			newy = m.Balls.get(ii).y;
			
			if (radius + rad >= Math.sqrt((x - newx) * (x - newx) +  (y - newy)	* (y - newy)) && 0 != Math.sqrt((x - newx) * (x - newx) +  (y - newy)	* (y - newy))) {
				g.setColor(Color.YELLOW);
				m.physics.Collide(m.i,ii, m);
			} 
		}
	}

	private void DoPhysics(Main m) {
		direction = m.physics.walls(m, this);
		double value[] = m.physics.Earth(velocity, direction);
		velocity = value[0];
		direction = value[1];
		if (direction > 2 * Math.PI) {
			direction -= 2 * Math.PI;

		}

	}

	public void move() {
		// System.out.print(Math.sin(direction));
		// System.out.print(Math.cos(direction));
		y += velocity * Math.sin(direction);
		/*
		 * if (Math.abs(direction) > Math.PI/2){ dir = -1; }else{ dir = 1; }
		 */
		x += velocity * Math.cos(direction);

	}

	private void draw(Graphics g) {
		g.fillOval((int) (x - radius), (int) (y - radius), (int) radius * 2,
				(int) radius * 2);

	}
}
