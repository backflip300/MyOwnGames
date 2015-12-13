package earth;



public abstract class Objects {
	
	
	protected static int x;
	protected static int y;
	protected int w;
	protected int h;
	protected double v,a,r; 
	protected boolean removed = false;
	
	@SuppressWarnings("static-access")
	public Objects(int x, int y){
		this.x = x;
		this.y = y;
		
	}

	
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public void setR(double r) {
		this.r = r;
	}
	public void setV(double v) {
		this.v = v;
	}
	public double getV() {
		return v;
	}
	public  double getR() {
		return r;
	}
	
}
