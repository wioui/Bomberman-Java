
public class GameControl {

	private int UP;
	private int DOWN;
	private int LEFT;
	private int RIGHT;
	private int ACTION;
	
	public int getUP() {
		return UP;
	}

	public void setUP(int uP) {
		UP = uP;
	}

	public int getDOWN() {
		return DOWN;
	}

	public void setDOWN(int dOWN) {
		DOWN = dOWN;
	}

	public int getLEFT() {
		return LEFT;
	}

	public void setLEFT(int lEFT) {
		LEFT = lEFT;
	}

	public int getRIGHT() {
		return RIGHT;
	}

	public void setRIGHT(int rIGHT) {
		RIGHT = rIGHT;
	}

	public int getACTION() {
		return ACTION;
	}

	public void setACTION(int aCTION) {
		ACTION = aCTION;
	}

	public GameControl(int uP, int dOWN, int lEFT, int rIGHT, int aCTION) {
		super();
		UP = uP;
		DOWN = dOWN;
		LEFT = lEFT;
		RIGHT = rIGHT;
		ACTION = aCTION;
	}
	
	
	
	
}
