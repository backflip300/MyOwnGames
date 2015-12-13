package earth;

public class Scorer {

		private int score,lives;
	public Scorer() {
		lives = 3;
		score = 0;
	}
	public int getLives() {
		return lives;
	}
	public int getScore() {
		return score;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
