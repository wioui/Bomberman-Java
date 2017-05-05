import java.awt.*;

public class Bombes {
	
	private int x;
	private int y;
	private double explosiontime;
	private float range;
	
	
	public Bombes(int x2, int y2, double explosiontime, float range) {
		x = x2;
		y = y2;
		this.explosiontime = explosiontime;
		this.range = range;
	}
	
	public void Poser(Map Laby){
		Laby.setLaby(this.x,this.y,3);
	}
	
	

	
}
