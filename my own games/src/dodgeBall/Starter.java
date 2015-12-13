package dodgeBall;

public class Starter {
	
	static MainClass a;
	public static void main(String args[]){
		MainClass a = new MainClass();
		a.init();
		a.start();
		a.run();
		a.update(null);
		a.paint(null);
	}
}
