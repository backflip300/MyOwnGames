package everything;

import java.awt.Graphics;

public class Player extends Object {

	public Player(double x, double y, double radius, double mass) {
		super(x, y, radius, mass);
		// TODO Auto-generated constructor stub
	}

	public void run(Graphics g, Main m) {
		DoPhyiscs();
		PlayerAdd();
		move();
		Draw(g);
	}

	private void Draw(Graphics g) {

		g.drawOval((int)( x - radius), (int) (y - radius), (int) radius * 2,
				(int) radius * 2);

	}

	private void move() {
		// TODO Auto-generated method stub

	}

	private void PlayerAdd() {
		// TODO Auto-generated method stub

	}

	private void DoPhyiscs() {
		// TODO Auto-generated method stub

	}
}
