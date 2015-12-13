package tst;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class Node {
	boolean end = false;
	char value;
	int loKid, hiKid, equalKid;

	public Node(char value) {
		this.value = value;
		loKid = -1;
		hiKid = -1;
		equalKid = -1;
		
	}

	public int[] compare(char toCompare) {

		int[] toReturn = new int[2];
		if ((int) toCompare < (int) value) {
			toReturn[0] = -1;
			toReturn[1] = loKid;

		} else if ((int) toCompare > (int) value) {
			toReturn[0] = +1;
			toReturn[1] = hiKid;

		} else {

			toReturn[0] = 0;
			toReturn[1] = equalKid;

		}
		return toReturn;
	}

	public int getEqualKid() {
		return equalKid;
	}

	public int getHiKid() {
		return hiKid;
	}

	public int getLoKid() {
		return loKid;
	}

	public char getValue() {
		return value;
	}

	public void setEqualKid(int equalKid) {
		this.equalKid = equalKid;
	}

	public void setHiKid(int hiKid) {
		this.hiKid = hiKid;
	}

	public void setLoKid(int loKid) {
		this.loKid = loKid;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	
}
