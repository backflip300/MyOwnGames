package everything;

import java.util.ArrayList;

public class Physics {
	ArrayList<Vector>  Vectors = new ArrayList<Vector>();
	Vector Gravity,collision;
	boolean reflection = false;
	public Physics() {
		
	}

	public void Collide(int ball1,int ball2,Main m) {
		double cHorizontal = m.Balls.get(ball1).velocity * Math.cos(m.Balls.get(ball2).direction);
		double cVertical = m.Balls.get(ball1).velocity * Math.sin(m.Balls.get(ball2).direction); 
		double hitangle = Math.atan((m.Balls.get(ball1).y - m.Balls.get(ball2).y) / (m.Balls.get(ball1).x - m.Balls.get(ball2).x));
		
	}

	public void Gravity() {

	}
	
	public double walls(Main m, Ball b) {
		double nDirection = b.direction;
		if ((int) b.y > m.getHeight() - b.radius) {
			reflection = true;
		}
		if ((int) b.y < b.radius) {
			reflection = true;
			
		}
		if ((int) b.x > m.getWidth() - b.radius || (int) b.x < b.radius) {
			nDirection = Math.PI - nDirection;
		}

		return nDirection;
	}

	public double[] Earth(double velocity, double direction) {
		Gravity = new Vector(0.9, Math.PI/2);
		Vector Ke = new Vector(velocity, direction);
		
		Vector Reflector = new Vector(2*(velocity*Math.sin(direction))+0.9 , -Math.PI/2);
		Vectors.add(Gravity);
		Vectors.add(Ke);
		
		if (reflection == true){
			Vectors.add(Reflector);
			reflection = false;
		}
		double rVertical = 0;
		double rHorizontal = 0;
		for (int i = 0; i < Vectors.size();i++){
			rVertical += Vectors.get(i).velocity * Math.sin(Vectors.get(i).direction);
			
			rHorizontal += (Vectors.get(i).velocity * Math.cos(Vectors.get(i).direction));
			
		}
		Vectors.clear();
		
		velocity = Math.sqrt(rVertical * rVertical + rHorizontal * rHorizontal);
		direction = Math.atan(rVertical / rHorizontal);
		if (rHorizontal < 0) {
			direction = direction - Math.PI;

		}

		return new double[] { velocity, direction };
	}
}
