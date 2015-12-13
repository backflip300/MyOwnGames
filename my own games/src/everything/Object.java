package everything;

public abstract class Object {

	
	protected double x;
	protected double y;
	protected double radius;
	protected static double mass;
	protected double velocity;
	protected double direction;

	
	public Object(double x, double y,double radius, double mass) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.mass = mass;
		velocity = 0;
		direction = 0;
	}
	
}
