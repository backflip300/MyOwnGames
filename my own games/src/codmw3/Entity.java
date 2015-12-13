package codmw3;

public abstract class Entity{
	protected int x,y,bulletplace;
	protected double orientation = 90;
	//protected boolean removed;
public Entity(int x, int y,int bulletplace) {
	this.x = x;
	this.y = y;
	this.bulletplace = bulletplace;
}

public int getX() {
	return x;
}
public int getY() {
	return y;
}
public void setOrientation(double orientation) {
	this.orientation = orientation;
}
public double getOrientation() {
	return orientation;
}
}
